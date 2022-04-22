To start the server for Wellnet, please follow these steps:

1. Install SpringToolSuite (STS)
2. Clone this repository onto your computer
3. Import an existing Maven project within STS
4. Select the cloned repository from your local system
5. Run the file in STS as a Spring Boot App

To access the database:
1. Run the app in STS
2. Open a browser and navigate to http://localhost:8081/wellnet/h2-console
3. Enter this into the console:  
     Saved Settings: Generic H2 (Embedded)  
     Setting Name: Generic H2 (Embedded)  
     Driver Class: org.h2.Driver  
     JDBC URL: jdbc:h2:file:./p3data  
     User Name: sa  
     Password: password  

To dockerize application:
1.go to pom.xml and write <finalName>user-covid-service</finalName> for jar filename (optional)
2.In the application.yml under the h2:console: add:
	settings:
        web-allow-others: true
3. Create Dockerfile:
	FROM openjdk:8
	EXPOSE 8099
	ADD /target/user-covid-service.jar user-covid-service.jar
	ENTRYPOINT ["java","-jar","user-covid-service.jar"]
4.Get the jar file by write click the application and run with maven build then in the Goals: blank type clean package.
5. Create a Docker image file:
	docker build -t user-covid-service .
6. check the created image by using:
	 docker images
7. Push this image to Docker by using:
	docker run -p 8099:8099 -t user-covid-service


