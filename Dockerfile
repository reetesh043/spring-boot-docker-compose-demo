FROM openjdk:17-jdk-slim
LABEL authors="reeteshkumar"
WORKDIR /app
VOLUME /tmp
COPY target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]