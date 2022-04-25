FROM openjdk:8
EXPOSE 8097
ADD /target/diagnosisservice-0.0.1-SNAPSHOT.jar user-diagnosis-service.jar
ENTRYPOINT ["java","-jar","user-diagnosis-service.jar"]