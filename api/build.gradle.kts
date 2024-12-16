plugins {
    id("com.google.cloud.tools.jib")
}

dependencies {
    // 모듈 의존성 추가
    api(project(":domain"))

    // web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    // security
    implementation("org.springframework.boot:spring-boot-starter-security")

    // validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // spring doc(register of doc)
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

    // jasypt
    implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5")

    // Java JWT 라이브러리
    implementation("io.jsonwebtoken:jjwt:0.9.1")

    // XML 문서의 Java 객체 간 매핑 자동화
    implementation("javax.xml.bind:jaxb-api:2.3.1")

    // tsid
    implementation("io.hypersistence:hypersistence-utils-hibernate-60:3.7.3")
}
