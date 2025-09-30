TECH STACK USED

Java 17+
Spring Boot 3.x
Spring Data JPA
MySQL 8
Lombok
Postman (for testing)

SETUP INSTRUCTION
======================================================================
STEP 1: Clone the repository OR Download Zip file

STEP 2:  Create the database manually in MySQL:

CREATE DATABASE leavemanagement;

STEP 3: Update src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/leavemanagement

spring.datasource.username=root

spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

STEP 4: RUN THE PROJECT 

The application will start at: http://localhost:8080


Employee APIs
==============
Method	 Endpoint	         Description

POST	   /employees       	Add new employee

GET	     /employees	        Get all employees

GET	     /employees/{id}	  Get employee by ID

PUT    	 /employees/{id}	  Update employee

DELETE	 /employees/{id}	  Delete employee


Leave APIs
======================
Method	  Endpoint    	                                   Description

POST	    /leaves	                                        Create leave request

GET     	/leaves	                                        Get all leave requests

GET	      /leaves/{id}	                                  Get leave by ID

GET	      /leaves/employee/{employeeId}             	    Get all leaves by employee

PUT	     /leaves/{id}/status?status=APPROVED/REJECTED	    Update leave status

EXAMPLE
==========================
CREATE EMPLOYEE

POST  http://localhost:8080/employees 

Content-Type: json

{

"name": "Akshay Kumar",

"email": "akshay@gmail.com",

"department": "IT"

}

CREATE LEAVE REQUEST
==============================
POST  http://localhost:8080/leaves

Content-Type: json

{
  
  "employee": { "id": 1 },
  
  "startDate": "2025-10-01",
  
  "endDate": "2025-10-05",
  
  "reason": "Family Vacation"
  
}

APPROVE LEAVE REQUEST
=========================
PUT  http://localhost:8080/leaves/1/status?status=APPROVED



