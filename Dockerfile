FROM openjdk:11
EXPOSE 8080
ADD ./target/university-management-service-0.0.1-SNAPSHOT.jar ./university-management-service.jar
ENTRYPOINT ["java","-jar","university-management-service.jar"]
