Create Dockerfile:
    FROM openjdk:8
    EXPOSE 8097
    ADD /target/user-diagnosis-service.jar user-diagnosis-service.jar
    ENTRYPOINT ["java","-jar","user-diagnosis-service.jar"]