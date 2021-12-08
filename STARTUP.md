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
