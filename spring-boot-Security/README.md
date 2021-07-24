- Spring Security是一个功能强大且高度可定制的身份验证和访问控制框架。提供了完善的认证机制和方法级的授权功能。

  - pom.xml
    ```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
    ```


- spring 5.0 后WebMvcConfigurerAdapter被废弃，取代的方法有两种：

  - ①implements WebMvcConfigurer（官方推荐）

  - ②extends WebMvcConfigurationSupport