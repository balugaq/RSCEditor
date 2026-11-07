# AGENTS.md — RSCEditor 操作宪章

## TL;DR（太长了不看）

1. RSCEditor 是 RykenSlimeCustomizer（RSC）的**游戏内编辑器**，通过 GUI 生成 RSC 配置所需的 Slimefun 物品占位符与编辑机器，**不修改** Slimefun 或原版既有机制。
2. 本插件会注册大量占位符物品，禁止在生产环境实例上做开发调试。
3. 所有物品注册集中在 `implementation/items/*Setup.java` 与 `implementation/items/*.java`，改物品先找 `MachineSetup` / `GroupSetup`。
4. 构建用 `./gradlew clean build`，Java 21（`options.release = 21`），产物 `build/libs/RSCEditor-<version>.jar`。
5. 禁止提交 git（提交权归主人）；禁止改 `.github/workflows` 里 chmod/matrix 等已验证配置，除非主人明确要求。
6. `plugin.yml` 的版本占位符是 `${version}`（Gradle processResources 注入），不要改回 `${project.version}`。

## 1. 项目身份与边界

- **插件名**：`RSCEditor`（Bukkit 插件名与 Gradle 工程名相同）
- **主类**：`com.balugaq.rsceditor.implementation.RSCEditor`，继承 `JavaPlugin` 并实现 `SlimefunAddon`
- **硬前置**：`Slimefun`、`GuizhanLibPlugin`、`RykenSlimefunCustomizer`（见 `plugin.yml` 的 `depend`）
- **api-version**：1.18；编译目标 Java 21
- **上游**：`SlimefunReloadingProject/RSCEditor`（本仓库为其 fork，`pull.yml` 自动同步 master）

### 1.1 代码包地图（改代码前先定位）

| 包 | 职责 |
| --- | --- |
| `implementation` | 主类 `RSCEditor`（onEnable 注册全部子系统、自动更新、reload） |
| `implementation.groups` | `RSCEItemGroups`（嵌套分类定义）、`GroupSetup`（分类注册入口） |
| `implementation.items` | 各类物品注册入口：`MachineSetup`、`TypeItems`、`RecipeTypeItems`、`ItemGroupItems`、`BiomeItems`、`SoundTypeItems`、`ToolSetup`、`AuthorSetup` |
| `implementation.items.machines` | 约 20 个「构造器/编辑器」机器（`ItemEditor`、`MachineEditor`、`ResearchEditor` 等） |
| `implementation.items.machines.builder` | 配方配置器/组合器（`MachineRecipeBuilder` 等） |
| `implementation.items.machines.container` | 各类容器机器（`EmptyContainerNx9`、`MenuContainer` 等） |
| `api.items` / `api.base` | 占位符物品基类（`TypeItem`、`RegisterItem` 等）与抽象容器 |
| `api.objects` | 编辑产物对象模型（`MenuMatrix`、`types/*`） |
| `core.command` | `RSCECommands`（`/rsceditor reload`） |
| `core.listeners` | `ItemEditListener`（编辑模式下用聊天输入解析物品 Lore 参数） |
| `core.managers` | `ConfigManager`（auto-update / debug） |
| `utils` | `SlimefunItemUtil`（注册/注销）、`PersistentUtil`、`YamlWriter`、`ReflectionUtil` 等 |
| `utils.datatypes` | 自定义 PersistentDataTypes（机器配方、模板配方、注册项等） |

## 2. 技术栈与项目结构（事实核对）

- 构建：Gradle Kotlin DSL + version catalog（`gradle/libs.versions.toml`），shadow 插件打包
- 运行时依赖（会 shade）：`com.jeff-media:MorePersistentDataTypes`（relocate 到 `com.balugaq.rsceditor.libs.morepersistentdatatypes`）
- provided 依赖：`paper-api 1.20.1`、`Slimefun4 2024.3`（JitPack）、`GuizhanLibPlugin 1.7.6`（Maven Central）、Lombok（annotationProcessor）
- 资源：`src/main/resources/plugin.yml`（`${version}` 占位）、`config.yml`

## 3. 决策树：当遇到 A 时，执行 B

### 3.1 新增/修改构造器或占位符物品

1. 物品定义与注册写在对应的 `*Setup` / `*Items` 类，用 `SlimefunItemUtil.registerItem(...)`；
2. 物品 ID 前缀统一 `RSC_EDITOR_`；
3. 新分类进 `RSCEItemGroups`（NestedItemGroup + SubItemGroup 结构），在 `GroupSetup.register()` 注册。

### 3.2 异常与注销

- `onDisable` 必须调用 `SlimefunItemUtil.unregisterAllItems()` 与 `unregisterItemGroups()`——新增机器无需手动注销，走统一入口；
- reload 即 `onDisable() + onEnable()`，改注册逻辑时保证幂等。

### 3.3 聊天编辑交互

- `ItemEditListener` 通过 `PlayerChatEvent` 在编辑模式下解析 `m(...)`、`p(...)` 等模式串；改参数格式时同步更新类顶部的 `Pattern` 常量。

### 3.4 依赖与构建

- 依赖版本只改 `gradle/libs.versions.toml`；升级第三方库前用 `javap` 验证代码实际调用的 API 签名仍存在（如 `GuizhanUpdater.start(...)`）；
- 禁止在 `gradle.properties` 写本机 `org.gradle.java.home` 绝对路径。

### 3.5 提交与推送

- **禁止自行 commit/push**，只把工作区留到可通过验收的状态并给出建议提交信息。

## 4. 红线（绝对禁止操作）

1. 禁止修改 git 历史或绕过主人提交；
2. 禁止把编辑器装入真实服务器测试对生产数据的影响；
3. 禁止改 `plugin.yml` 的 `depend` 清单而不同步 `test-compatibility.yml` 的依赖下载；
4. 禁止删除 `.github/workflows` 中 `chmod +x gradlew`；
5. 禁止把内部实现细节写进 README 面向服主的部分。

## 5. 质量规范

- 改完代码：`./gradlew clean build` 必须通过；
- 新增注册物品后，在 `MachineSetup` 等对应入口保持注册顺序与分组一致；
- 注释只写「为什么」，不复述代码。

## 6. 常用 Gradle 命令速查表

| 命令 | 用途 |
| --- | --- |
| `./gradlew clean build` | 构建 + shadowJar |
| `./gradlew runServer` | 本地起 1.20.1 测试服（自动写 eula、拷贝产物） |
| `./gradlew dependencies` | 查看依赖树 |

## 7. CI 验收

- `build.yml`：push/PR 到 master，JDK 21 构建；
- `release.yml`：tag 触发发布，版本号取自 `gradle.properties`；
- `test-compatibility.yml`：矩阵 `1.20.1,26.2`，下载 Slimefun4 / GuizhanLibPlugin / RykenSlimeCustomizer 后启动 Paper 冒烟测试。

## 8. 已知债务

- Slimefun4 仍为 2024.3（2025.1 已可用，升级需做 API 适配，待主人决策）；
- version `48` 为纯数字版本号，沿用上游惯例，未改。
