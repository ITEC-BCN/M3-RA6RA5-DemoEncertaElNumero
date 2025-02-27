plugins {
    kotlin("jvm") version "1.9.23"
    id("org.openjfx.javafxplugin") version "0.0.8"
}

javafx {
    modules("javafx.controls", "javafx.fxml")
}

group = "itb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(20)
}