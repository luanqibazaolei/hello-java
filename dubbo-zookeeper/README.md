
pom.xml
```xml
<!--        dubbo-spring-boot-->
        <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo-spring-boot-starter</artifactId>
            <version>2.7.3</version>
        </dependency>

        <!--zookeeper的客户端依赖-->
        <!-- https://mvnrepository.com/artifact/com.github.sgroschupf/zkclient -->
        <dependency>
            <groupId>com.github.sgroschupf</groupId>
            <artifactId>zkclient</artifactId>
            <version>0.1</version>
        </dependency>

        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-framework</artifactId>
            <version>2.12.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-recipes</artifactId>
            <version>2.12.0</version>
        </dependency>

        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.7.0</version>
            <exclusions>
                <exclusion>
                    <groupId>org.slf4j</groupId>
                    <artifactId>slf4j-log4j12</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
```

```properties
server.port=8081
# app名字
spring.application.name=provider
# 服务名字
dubbo.application.name=dubbo_provider
dubbo.registry.protocol=zookeeper
dubbo.registry.address=zookeeper://127.0.0.1:2181
# 元数据地址
dubbo.metadata-report.address=zookeeper://127.0.0.1:2181
dubbo.protocol.name=dubbo
dubbo.protocol.port=20880
# 扫描要部署的服务
dubbo.scan.base-packages=com.shen.provider.server

#dubbo.protocol.serialization=kryo
```

```properties
server.port=8082
spring.application.name=customer
dubbo.application.name=dubbo_customer
# 暴露 zookeeper
dubbo.registry.protocol=zookeeper
dubbo.registry.address=zookeeper://127.0.0.1:2181

#dubbo.protocol.serialization=kryo
```