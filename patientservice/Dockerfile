FROM openjdk:8
EXPOSE 8095
ADD /target/patientservice-0.0.1-SNAPSHOT.jar user-patient-service.jar
ENTRYPOINT ["java","-jar","user-patient-service.jar"]