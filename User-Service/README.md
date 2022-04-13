# Main WellNet Team 2 Branch


## File Links

### [== ==> To WellNet Team 2 Folder](https://drive.google.com/drive/folders/1ai5agUhhjO6GZjeAszOKRuY71gWC153r)

### [== ==> Team 2 Mock Up](https://docs.google.com/presentation/d/1aT9RDicboaknPNBcyJ8UyubZlON5xWxbSHRST3ZMcTM/edit#slide=id.p)

# Backend

 WellNet
## File Links

[== ==> To Project 3 Main Google Folder](https://drive.google.com/drive/folders/16f57coD8B6iw2pkIC_ZK3sPFIaIlaBCm)

## Images

### Entity Relationship Diagram
![image](https://user-images.githubusercontent.com/69606065/142472217-562ffb56-8ff4-4917-b6b7-4a1304301eb9.png)

> [Back To Top](#main-wellnet-team-2-branch)
> [Back To Top](#backend)

### Use Case Diagram
![image](https://user-images.githubusercontent.com/69606065/142472470-b9a2004d-4fc1-4d2e-9f29-c23fdaf7eac1.png)


The server is made up of several main parts:  
  1. Controllers to handle incoming requests.  
  2. Services for the controllers to call to send and receive data  
  3. Repos for services to use to presist data in  the H2 database  
  4. Utility classes to be used anywhere throughout the server  
  5. A security package to validate incoming requests  

The server is not currently configured to send requests, but it can receive them.
These are the possible incomming requests divided by controllers (each request begins with a /wellnet):

## AreaController:

## BootstrapDB:

 /public/bootstrapDB/filler/one
- Get request fills the database with sample data

## Covid19Verification URIs:

 /covid:  
- Get request returns list of all covid verification forms.
- Post request adds or updates covid verification form.
- Put request replaces covid verification form. 

 /covid/{id}:  
- Get request returns covid verification form with id from url. 
- Delete request deletes covid verification form with id from url. 

 /covid/user/{userId}:  
- Get request returns covid verification form associated with the user given in url.

## DiagnosisFormController

/diagnosis/
- Get request will return all diagnosis forms
- Post request adds diagform in request body to DB
- Put request updates diagform in request body in DB

/diagnosis/patientId/{patientId}
- Get request returns all forms where patientId = patientId

/diagnosis/nurseId/{nurseId}
- Get request returns all forms where nurse.id = nurseId

/diagnosis/doctorId/{doctorId}
- Get request returns all forms where doctor.id = doctorId

/diagnosis/{id}
- Delete request deletes diagform where id = id

## PatientController
/patient
- get request returns all patients
- post request takes a patient obj and adds it to the database  

/patient/{id}
- get request returns the patient corresponding to the sent id

/patient/firstname/{firstName}
- get request returns all patients corresponding to the sent first name

/patient/firstname/{firstName}/{lastName}
- get request returns all patients corresponding to the sent first name and last name

/patient/firstname/{firstName}//{lastName}/{dob}
- get request returns all patients corresponding to the sent first name, last name and date obj

/patient/allergies
- get request returns all allergies
- post request creates a new allergy obj in the database

/patient/vaccinations
- get request returns all vaccinations
- post request creates a new vaccination obj in the database

/bloodtype/{name}
- get request returns the bloodtype obj specified in the name

/sex/{name}
- get request returns the sex obj specified in the name

/patient/allergies/{allergy}
- delete request deletes the specified allergy

/patient/vaccinations/{vaccine}
- delete request deletes the specified vaccination

/patient/resolved
- get request returns all patients that have a false resolution status on a diagnosis form

## registrationController

/public/registration
- post request adds the user object to the database

## RoomController

## userController
/user/updateprofile  
- put request changes a current user's profile information  

/user/{id}   (id is a string specific to the user logged in the client)  
- get request returns the user's user object

/user/doctorPatientMap/{firstName}/{lastName}
- get request returns the list of patients that the logged in doctor has already seen

## Additional Notes:
There are more functions in handlers that are not being used. Only used functions are logged here.  

Our unit tests are in src/test/java. We currently have 73% test coverage of the service layer. We're using eclEmma to calculate test coverage. You can install it by going to help in STS, going to the eclipse market place and installing it as a plugin. It will then show up when you right click a file as "Coverage As". 

