FROM openjdk:8
EXPOSE 8099
ADD /target/user-covid-service.jar user-covid-service.jar
ENTRYPOINT ["java","-jar","user-covid-service.jar"]