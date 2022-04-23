FROM openjdk:8
    EXPOSE 8094
    ADD /target/room-service-docker.jar room-service-docker.jar
    ENTRYPOINT ["java","-jar","/room-service-docker.jar"]