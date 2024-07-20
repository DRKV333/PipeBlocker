plugins {
    id("java")
}

// Set the toolchain version to decouple the Java we run Gradle with from the Java used to compile and run the mod
java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// include the filter from the root src folder
tasks.processResources.configure {
    from("${rootDir}/src/main/resources")
}

dependencies {
    compileOnly("org.apache.logging.log4j:log4j-api:2.0-beta9")
    compileOnly("org.apache.logging.log4j:log4j-core:2.0-beta9")
    testImplementation("org.apache.logging.log4j:log4j-api:2.0-beta9")
    testImplementation("org.apache.logging.log4j:log4j-core:2.0-beta9")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}