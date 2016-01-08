FROM java:8
ADD wallenius-gcp-0.1-SNAPSHOT-jar-with-dependencies.jar app.jar
ENTRYPOINT ["java","-jar","-Dorg.slf4j.simpleLogger.log.com.google.cloud.wallenius.wallenius.gcp=debug", "/app.jar"]