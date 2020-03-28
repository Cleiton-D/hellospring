FROM openjdk:11.0.6-slim as builder

COPY . .
RUN ./mvnw package
ARG JAR_FILE=target/*.jar

FROM openjdk:11.0.6-slim
COPY --from=builder ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]