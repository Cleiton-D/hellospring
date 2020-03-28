FROM openjdk:8-jdk-alpine as builder

COPY . .
RUN ./mvnw package
ARG JAR_FILE=target/*.jar
RUN cd target && ls

RUN echo "${JAR_FILE}"

FROM openjdk:8-jdk-alpine
COPY --from=builder ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]