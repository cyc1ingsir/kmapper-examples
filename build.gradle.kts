import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//val kMapperVersion: String = "1.2.1-SNAPSHOT"
val kMapperVersion: String = "1.2.0"

plugins {
    application
    kotlin("jvm") version "2.1.20-Beta2"
    id("com.google.devtools.ksp") version "2.1.20-Beta2-1.0.29" // /for kmapper
    kotlin("plugin.jpa") version "2.1.20-Beta2"
    kotlin("plugin.allopen") version "2.1.20-Beta2" // https://spring.io/guides/tutorials/spring-boot-kotlin/
}

allOpen {
    // https://spring.io/guides/tutorials/spring-boot-kotlin/
    // Persistence with JPA
    annotation("jakarta.persistence.Entity")
}

group = "io.github.s0nicyouth"
version = "0.0.1-SNAPSHOT"

tasks.withType<KotlinCompile> {
    compilerOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
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
    jvmToolchain(21)
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("jakarta.persistence:jakarta.persistence-api:+")
    implementation("io.github.s0nicyouth:processor_annotations:$kMapperVersion")
    implementation("io.github.s0nicyouth:converters:$kMapperVersion")
    ksp("io.github.s0nicyouth:processor:$kMapperVersion")
}
