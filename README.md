# RSCEditor

游戏内可视化构造 RSC 物品、机器、配方、研究等，服主免写配置文件，装上即用的自定义编辑器。

[RSCEditor](https://github.com/balugaq/RSCEditor) 是 [RykenSlimeCustomizer](https://github.com/SlimefunReloadingProject/RykenSlimeCustomizer)（RSC）的**游戏内编辑器**：不需要手写 YAML 配置，进服摆下对应的「构造器」机器，按 GUI 提示一步步填参数，就能生成 RSC 附属所需的物品、机器、配方、研究等定义。

> ⚠️ **不建议装入生产环境**：本插件会注册大量粘液物品占位符，且面向服主开发附属的场景设计。

## 功能一览

装上后，Slimefun 指南会出现「RSC 编辑器」分类，内含：

- **构造器（编辑器机器）**：物品、机器、简单机器、配方机器、模板配方机器、强配方机器、工作台机器、多方块、发电机、太阳能发电机、材料生成器、电容、装备、食物、生物掉落、自然资源（GEO）、物品组、配方类型、研究等约 20 种构造器
- **配方配置器 / 组合器**：机器配方、模板机器配方、强配方机器配方、多方块配方的配置与组合
- **占位符物品**：物品组、配方类型、群系、音效、彩虹、放射性、能量组件类型等 RSC 配置中需要的占位符
- **容器**：1x9 至 6x9 空容器、装备部分容器、自定义彩虹容器、GEO 供应容器、物品流容器、菜单容器
- **工具**：菜单复制器等

## 前置

| 插件 | 说明 |
| --- | --- |
| [Slimefun4](https://github.com/SlimefunGuguProject/Slimefun4) | 硬前置 |
| [GuizhanLibPlugin](https://github.com/ybw0014/GuizhanLibPlugin) | 硬前置，本地化与更新支持 |
| [RykenSlimeCustomizer](https://github.com/SlimefunReloadingProject/RykenSlimeCustomizer) | 硬前置，编辑产物面向 RSC |

需要 **Java 21+** 与 Paper 系服务端（api-version 1.18+）。

## 安装

1. 安装上表全部前置插件；
2. 将 `RSCEditor-<版本>.jar` 放入 `plugins/` 目录；
3. 重启服务器。

## 命令

| 命令 | 别名 | 说明 |
| --- | --- | --- |
| `/rsceditor reload` | `/rsce reload` | 重载本插件（注销并重新注册全部物品与分类） |

## 配置

| 配置项 | 默认值 | 说明 |
| --- | --- | --- |
| `auto-update` | `true` | 构建版（`Build` 前缀版本号）自动从 GitHub 更新 |
| `debug` | `false` | 调试日志 |

## 构建

```bash
./gradlew clean build
```

产物在 `build/libs/RSCEditor-<版本>.jar`。要求本机 JDK 21+（`options.release = 21` 锁定字节码版本）。

## 兼容性

CI 通过 [test-compatibility workflow](.github/workflows/test-compatibility.yml) 在 Paper `1.20.1` 与最新版本上做启动冒烟测试。

## 反馈

问题请提交到 [Issues](https://github.com/balugaq/RSCEditor/issues)。

## 许可

详见 [LICENSE](LICENSE)。
