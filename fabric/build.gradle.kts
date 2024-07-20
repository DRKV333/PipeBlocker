plugins {
    id("java")
}

java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    maven {
        name = "Fabric"
        url = uri("https://maven.fabricmc.net/")
    }
}

dependencies {
    compileOnly("net.fabricmc:fabric-loader:0.14.21")
    embed(project(":common"))
}

repositories {
    mavenCentral()
}

// Put the version from gradle into fabric.mod.json
tasks.processResources.configure {
    inputs.property("version", project.version)

    filesMatching("fabric.mod.json") {
        expand(mapOf("version" to project.version))
    }
}

tasks.named<Jar>("jar") {
    archiveBaseName.set("pipeblocker-fabric")
}