val kMapperVersion: String = "1.0.0"

plugins {
    application
    kotlin("jvm") version "1.9.0"
    id("com.google.devtools.ksp") version "1.9.20-1.0.13" // /for kmapper
    kotlin("plugin.jpa") version "1.9.0"
    kotlin("plugin.allopen") version "1.9.0" // https://spring.io/guides/tutorials/spring-boot-kotlin/
}

allOpen {
    // https://spring.io/guides/tutorials/spring-boot-kotlin/
    // Persistence with JPA
    annotation("jakarta.persistence.Entity")
}

group = "io.github.s0nicyouth"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

version = "1.0"

application {
    mainClass.set("com.syouth.kmapper.testload.MainKt")
}

// https://kotlinlang.org/docs/ksp-quickstart.html#make-ide-aware-of-generated-code
// for kMapper and openApiGenerator
kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
    sourceSets.test {
        kotlin.srcDir("build/generated/ksp/test/kotlin")
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("jakarta.persistence:jakarta.persistence-api:+")
    implementation("io.github.s0nicyouth:processor_annotations:$kMapperVersion")
    implementation("io.github.s0nicyouth:converters:$kMapperVersion")
    ksp("io.github.s0nicyouth:processor:$kMapperVersion")
}
