import org.gradle.script.lang.kotlin.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	var kVersion: String by extra
	kVersion = "1.2.21"
	
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath(kotlin("gradle-plugin", kVersion))
	}
}

group = "com.forresthopkinsa"
version = "0.1-SNAPSHOT"

plugins {
	java
	application
}

apply {
	plugin("kotlin")
}

val kVersion: String by extra

application {
	mainClassName = "MainKt"
}

repositories {
	mavenCentral()
	jcenter()
	maven("https://jitpack.io")
}

dependencies {
	compile(kotlin("stdlib-jdk8", kVersion))
	compile("com.squareup.okhttp3", "okhttp", "3.9.1")
	compile("com.google.code.gson", "gson", "2.8.2")
	compile("io.github.config4k", "config4k", "0.3.2")
	compile("com.github.ralfstuckert.pdfbox-layout", "pdfbox2-layout", "1.0.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "1.8"
}