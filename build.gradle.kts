plugins {
    alias(libs.plugins.shadow)
    `maven-publish`
    java
}

group = "net.llvg"
version = property("version") as String
base.archivesName = "LegacyMixinWrapper"

val shade by configurations.registering {
    isCanBeConsumed = false
}

java {
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
}

@Suppress("UnstableApiUsage")
dependencies {
    shade("com.google.guava:guava:33.4.8-jre")
    shade(libs.mixin.fabric) {
        exclude(group = "com.google.guava")
        exclude(group = "com.google.code.gson")
    }
    shade(libs.mixin.extras.common)
}

tasks {
    jar {
        enabled = false
        finalizedBy(shadowJar)
    }
    shadowJar {
        archiveClassifier = ""
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        configurations = listOf(shade.get())
        exclude("META-INF/*.SF", "META-INF/*.RSA")
        exclude("**/module-info.class")
        exclude("META-INF/LICENSE")
        exclude("META-INF/README")
        exclude("META-INF/maven/**")
        exclude("META-INF/versions/**")
        relocate("com.google", "libs.com.google")
    }
}

publishing {
    repositories {
        mavenLocal()
    }
    
    publications {
        register<MavenPublication>("maven") {
            artifact(tasks["shadowJar"])
            suppressAllPomMetadataWarnings()
        }
    }
}