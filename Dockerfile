FROM openjdk:8
ADD target/tourguide_tripPricer-0.0.1-SNAPSHOT.jar tourguide_tripPricer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "/tourguide_tripPricer-0.0.1-SNAPSHOT.jar"]