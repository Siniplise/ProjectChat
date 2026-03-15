plugins {
    id("java")
}

group = "net.siniplise"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.aliyun.com/repository/public") // 阿里云公共库
    maven("https://maven.aliyun.com/repository/google") // 阿里云 Google 库
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.alibaba.fastjson2:fastjson2:2.0.53")
    implementation("org.tinylog:tinylog-api:2.6.2")
    implementation("org.tinylog:tinylog-impl:2.6.2")
}

tasks.test {
    useJUnitPlatform()
}