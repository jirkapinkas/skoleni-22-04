Build JAR souboru:

        mvn clean package

Build Docker image:

        mvn spring-boot:build-image

Run Docker container:

        docker run --rm -it -p 8080:8080 eshopweb:0.0.1-SNAPSHOT

Nebo Build Docker image:

- JIB Maven Plugin
- Custom Dockerfile
