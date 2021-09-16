FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
ADD jumia-app/jumia-project-0.0.1-SNAPSHOT.jar app.jar
ADD jumia-app/sample.db sample.db
ENTRYPOINT ["java","-jar","/app.jar"]
