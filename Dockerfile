FROM openjdk:21

WORKDIR /app

COPY /target/FeeEase-0.0.1-SNAPSHOT.jar /app/FeeEase.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/FeeEase.jar"]