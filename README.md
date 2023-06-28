# log4j2-demo


## Build
```
mvn clean package -DskipTests
```


## Run
```
java -jar -XX:TieredStopAtLevel=1 target/springApp.jar
```

## Test
```
curl -v -H 'Content-Type=application/json' http://localhost:8080/hello
```

## References
- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/#build-image)

