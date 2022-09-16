import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.3"
	id("io.spring.dependency-management") version "1.0.13.RELEASE"
//	id("org.jmailen.kotlinter") version "3.11.1" apply false
	id("eclipse")
	id("idea")
	id("java")

	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
}


group = "com.cesarsol"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}


dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.data:spring-data-redis")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.flywaydb:flyway-core")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
	implementation("org.springdoc:springdoc-openapi-ui:${property("openApiVersion")}")
	implementation("io.github.microutils:kotlin-logging:${property("kotlinLoggingVersion")}")
	implementation("redis.clients:jedis:${property("jedisVersion")}")

	runtimeOnly("org.postgresql:postgresql")
	runtimeOnly("com.h2database:h2:${property("h2Version")}")


	testImplementation("org.mockito:mockito-core")
	testImplementation("com.ninja-squad:springmockk:${property("springMockkVersion")}")
	testImplementation("org.springframework.cloud:spring-cloud-starter-contract-stub-runner")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("com.h2database:h2:${property("h2Version")}")
	testImplementation ("it.ozimov:embedded-redis:${property("embeddedRedisVersion")}")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

//kotlinter {
//	ignoreFailures = false
//	indentSize = 4
//	reporters = arrayOf("checkstyle", "plain")
//	experimentalRules = false
//	disabledRules = emptyArray()
//	fileBatchSize = 30
//}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
//	dependsOn("formatKotlin")
}

tasks.withType<Test> {
	useJUnitPlatform()
//	dependsOn("formatKotlin")
}
