FROM java:8 as builder

COPY . .
RUN ./mvnw package
ARG JAR_FILE=target/*.jar
RUN cd target && ls

RUN echo "${JAR_FILE}"

FROM java:8
COPY --from=builder ${JAR_FILE} app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]