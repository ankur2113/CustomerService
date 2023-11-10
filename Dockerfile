FROM openjdk:17
EXPOSE 9092
ADD target/CustomerService-0.0.1-SNAPSHOT.jar customerservice.jar
ENTRYPOINT ["java","-jar","/customerservice.jar"]