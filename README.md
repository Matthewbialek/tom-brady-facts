# Welcome to Tom Brady Facts
This is the start of an application I am developing to play around with the twilio API. I will be documenting this process on my blog! 

Tech Stack:

- Java 8
- Spring Boot 2
- Mysql 
- Docker
- Swagger
- Hibernate ORM

## Getting Started

### Setting up enviroment

- Set up Docker : https://docs.docker.com/get-started/
- Set up maven: https://maven.apache.org
- Java set up 

### Setting up Project

[Secrets File](src/main/resource/secrets.properties)
You must configure this file with your values which can be found on twillio

[Application Property File](src/main/resource/application.properties)
This is the standard application file for Spring Boot and you should edit it

[Docker Compose File](src/main/resource/docker-compose.yml)
Configure the passwords and ports

### Running the project 
mvn clean install package 
docker-compose up 

This will build a new version of the docker image for the application, and the second command will start the services.
Make sure to edit the file to fit your needs

### View Swagger
Once the compose file is all set up you can connect to : http://localhost:8080/swagger-ui.html#
This allows you to all the calls in application. 

Once a user is signed up they will recieve their welcome message to Tom Brady Facts. They will recieve 1 message a day at NOON UTC
