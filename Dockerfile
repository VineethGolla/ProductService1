FROM eclipse-temurin:21-jdk
COPY target/ProductService1-0.0.1-SNAPSHOT.jar productservice.jar
ENTRYPOINT ["java","-jar","productservice.jar"]
