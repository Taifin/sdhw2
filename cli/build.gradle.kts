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
    implementation("org.reflections:reflections:0.10.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("cub.taifin.MainKt")
}

tasks.run.configure {
    standardInput = System.`in`
}