FROM openjdk:8
    EXPOSE 8091
    ADD /target/area-service-docker.jar area-service-docker.jar
    ENTRYPOINT ["java","-jar","/area-service-docker.jar"]