
## RESTful API

The API provides the following interfaces

### Statistics

Request: GET http://localhost:8080/statistics
Response:
Body: {
    "sum": 2.5,
    "avg": 2.5,
    "max": 2.5,
    "min": 2.5,
    "count": 1
}

### Transaction 

Request: POST http://localhost:8080/transactions
Body: {
"amount": 2.5,
"timestamp": 1517147933
}

Response:
Empty Body:
Code:
201 - in case of success
204 - if transaction is older than 60 seconds

### Get Time in Seconds
Request: GET http://localhost:8080/currentTimeInSeconds
Response:
1517147933 //Current Time in seconds.


## How to test it
Checkout project from git: 
HTTPS: https://github.com/anuj-kumar-pundir/N26-anuj.git
SSH: git@github.com:anuj-kumar-pundir/N26-anuj.git

Run command 'mvn spring-boot:run'
Hit Above mentioned api's either using curl command or tool like postman etc.

To access H2 Database, Hit url: http://localhost:8080/h2 . H2 console will open. Add following details in console and hit connect button.

driver class: org.h2.Driver
jdbc url: jdbc:h2:file:~/testdb
username: sa
password: <empty>

Table Name: Transcation
