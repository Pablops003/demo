FROM eclipse-temurin:24.0.1_9-jre-ubi9-minimal
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]