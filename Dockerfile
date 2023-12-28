FROM eclipse-temurin:17

LABEL maintainer="johnchristopherilacad27@gmail.com"

WORKDIR /app

COPY target/blog-rest-api-0.0.1-SNAPSHOT.jar /app/springboot-blog-webservices.jar

ENTRYPOINT ["java", "-jar", "springboot-blog-webservices.jar"]