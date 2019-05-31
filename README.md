BPrestaurant Client Management System

BPrestaurantCMS is a RESTful web service for client management of a restaurant business which accepts some well defined endpoints and hit the database performing specific CRUD operations and other functions. It has been made using Maven and the endpoints are designed in Spring Boot framework. The unit test cases of the endpoints are implemented using JUnit.

List of endpoints:

•	http:/www.localhost:8080/BPrestaurantCMS/clients/add 

This endpoint adds a new client to the database. It accepts a client object in the HTTP request body of a rest client (Ex. postman) in JSON format and uses HTTP post mapping to map to a controller.
Ex:
{
"name":"abc xyz",
"mobile":9876543210,
"email":"pqr@mno.com",
"paymentMethod":"CASH/DEBIT CARD/CREDIT CARD",
"date"="dd-mm-yyyy",
"billAmount"=1000
}


•	http:/www.localhost:8080/BPrestaurantCMS/clients

This endpoint fetches all the clients from the database and sends them back to the rest client or browser as HTTP response body in JSON array format. It uses HTTP get mapping to map to a controller.


•	http:/www.localhost:8080/BPrestaurantCMS/clients/name/{name}

This endpoint fetches all the clients from the database with the same name as that of the parameter {name} and sends them back to the rest client or browser as HTTP response body in JSON array format. It uses HTTP get mapping to map to a controller. The parameter {name} is of type string

•	http:/www.localhost:8080/BPrestaurantCMS/clients/email/{email}

This endpoint fetches all the clients from the database with the same email id as that of the parameter {email} and sends them back to the rest client or browser as HTTP response body in JSON array format. It uses HTTP get mapping to map to a controller. The parameter {email} is of type string.

•	http:/www.localhost:8080/BPrestaurantCMS/clients/paymentMethod/{paymentMethod}

This endpoint fetches all the clients from the database with the same payment method as that of the parameter {paymentMethod} and sends them back to the rest client or browser as HTTP response body in JSON array format. It uses HTTP get mapping to map to a controller. The parameter {paymentMethod} is of type string.


•	http:/www.localhost:8080/BPrestaurantCMS/clients/mobile/{mobile}

This endpoint fetches all the clients from the database with the same mobile number as that of the parameter {mobile} and sends them back to the rest client or browser as HTTP response body in JSON array format. It uses HTTP get mapping to map to a controller. The parameter {mobile} is of type long.


•	http:/www.localhost:8080/BPrestaurantCMS/clients/date/{date}

This endpoint fetches all the clients from the database who visited the restaurant on the same date as that of the parameter {date} and sends them back to the rest client or browser as HTTP response body in JSON array format. It uses HTTP get mapping to map to a controller. The parameter {date} is of type string.


•	http:/www.localhost:8080/BPrestaurantCMS/clients/sendOffer
 
This endpoint sends an offer email to all the distinct clients. It accepts the offer message in plain text format in HTTP request body of the rest client (Ex. Postman). It uses HTTP post mapping to map to a controller.


Note: Test these endpoints with un-secured http (http) because secured http (https) may throw SSL exceptions. Also, this application has been developed and tested on Windows machine and expected to run on any Windows machine.
Instructions to run this application in your system:

•	Requirements: Spring Tool Suite 4, Postman, MySQL server/XAMPP
•	Steps:

o	Download this repository.

o	Copy and paste api-endpoints folder to your Spring Tool Suite workspace folder. Open STS and import this project.

o	Resolve all the maven dependencies by updating this project.

o	Establish a connection to the MySql server.

o	Update the properties of this project in the src>main>resources>application.properties file according to your configuration.

o	Run this application as a spring boot application.

o	Also, to test the endpoints, launch it as JUnit test. For this select, api-endpoints(2) as the test configuration. 

o	For manual testing, use a rest client such as Postman.
