# webprogramming
웹프응용

## gradle 코드
plugins {
   id 'org.springframework.boot' version '2.5.7'
   id 'io.spring.dependency-management' version '1.0.11.RELEASE'
   id 'java'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

configurations {
   compileOnly {
      extendsFrom annotationProcessor
   }
}

repositories {
   mavenCentral()
}

dependencies {
   implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
   implementation 'org.springframework.boot:spring-boot-starter-web'
   implementation 'org.springframework.boot:spring-boot-starter-security'
   
   compileOnly 'org.projectlombok:lombok'
   runtimeOnly 'com.h2database:h2'
   annotationProcessor 'org.projectlombok:lombok'
   testImplementation 'org.springframework.boot:spring-boot-starter-test'

   // https://mvnrepository.com/artifact/com.google.guava/guava
   implementation group: 'com.google.guava', name: 'guava', version: '28.1-jre'
   
   // https://mvnrepository.com/artifact/org.projectlombok/lombok
   //compileOnly group: 'org.projectlombok', name: 'lombok', version: '1.18.22'
   
   //JWT 관련 라이브러리
   implementation group: 'io.jsonwebtoken', name: 'jjwt', version: '0.9.1'
   
}

tasks.named('test') {
   useJUnitPlatform()
}
