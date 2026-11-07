plugins {
    java
    alias(libs.plugins.shadow)
    alias(libs.plugins.run.paper)
}

group = "com.balugaq.rsceditor"
version = "48"

// 不用 toolchain：本机与 CI 的 JDK 版本不一致时 toolchain 解析易失败，
// release=21 已锁定字节码版本，两端都能编译出一致产物。
java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly(libs.paper.api)
    compileOnly(libs.slimefun4)
    compileOnly(libs.guizhan.lib.plugin)

    // 会被打进 shadowJar（对应 Maven 的 compile + shade）
    implementation(libs.more.persistent.data.types)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.release = 21
    }

    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version.toString())
        }
    }

    shadowJar {
        archiveBaseName.set("RSCEditor")
        archiveVersion.set(project.version.toString())
        archiveClassifier.set("")

        minimize()

        relocate("com.jeff_media.morepersistentdatatypes", "com.balugaq.rsceditor.libs.morepersistentdatatypes")

        exclude("META-INF/*")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        mergeServiceFiles()
    }

    build {
        dependsOn(shadowJar)
    }

    runServer {
        dependsOn(shadowJar)
        val run = file("run")
        runDirectory.set(run)

        doFirst {
            run.resolve("eula.txt").writeText("eula=true")

            val pl = run.resolve("plugins")
            pl.mkdirs()
            copy {
                from(projectDir.resolve("build/libs")) {
                    include("RSCEditor-${version}.jar")
                }
                into(pl)
            }
        }

        jvmArgs("-Dfile.encoding=UTF-8", "-Dsun.jnu.encoding=UTF-8")
        maxHeapSize = "4G"
        minecraftVersion("1.20.1")
    }
}

defaultTasks("clean", "build")
