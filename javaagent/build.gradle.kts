plugins {
    id("java")
}

java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-core:2.0-beta9")!!
    implementation("org.apache.logging.log4j:log4j-api:2.0-beta9")!!

    embed(project(":common"))
}

repositories {
    mavenCentral()
}


tasks.named<Jar>("jar") {
    manifest {
        attributes["Premain-Class"] = "info.mmpa.pipeblocker.PipeBlockerAgent"
        attributes["Implementation-Title"] = "PipeBlocker Java Agent"
        attributes["Implementation-Version"] = rootProject.version
    }

    archiveBaseName.set("pipeblocker-javaagent")
}
