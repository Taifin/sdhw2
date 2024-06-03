plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "cub.taifin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("cub.taifin:cli-commands:1.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    archiveFileName.set("find.jar")
    from(source.asPath)
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}