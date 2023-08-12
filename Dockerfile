FROM maven:latest AS MAVEN_BUILD
COPY ./ ./
RUN mvn clean package

FROM openjdk:17-alpine as builder
COPY --from=MAVEN_BUILD target/*.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:17-alpine
EXPOSE 8080
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]