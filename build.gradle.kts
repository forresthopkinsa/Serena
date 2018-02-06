import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.2.21"

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlinModule("gradle-plugin", kotlin_version))
    }
}

group = "com.forresthopkinsa"
version = "0.1-SNAPSHOT"

apply {
    plugin("kotlin")
}

val kotlin_version: String by extra

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compile(kotlinModule("stdlib-jdk8", kotlin_version))
    compile("com.squareup.okhttp3", "okhttp", "3.9.1")
    compile("com.google.code.gson", "gson", "2.8.2")
    compile("io.github.config4k", "config4k", "0.3.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}