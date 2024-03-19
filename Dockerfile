FROM eclipse-temurin:17-jdk-focal
VOLUME /tmp
ARG JAR_FILE=target/*.jar

# Create the directory structure and copy the jar file
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]