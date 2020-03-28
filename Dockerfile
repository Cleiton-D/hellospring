FROM openjdk:8-jdk-alpine as builder

COPY . .
RUN ./mvnw package
ARG JAR_FILE=target/*.jar

FROM openjdk:8-jdk-alpine
RUN cd target
RUN ls
RUN cd ..

RUN echo "${JAR_FILE}"
COPY --from=builder ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]