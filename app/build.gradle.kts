plugins {
    id("java")
    application
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "hexlet.code.App"
        )
    }
}

repositories {
    mavenCentral()
}

application {
    mainClass = "hexlet.code.App"
}

dependencies {
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.2")
    implementation("org.projectlombok:lombok:1.18.34")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}