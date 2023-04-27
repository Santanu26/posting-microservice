### Getting Started with User-Service
This is a brief guide to help you get started with the User-Service project, including building the service, creating a Docker image, and running the service in a container.
## Prerequisites:
1. Java
2. Maven
3. Docker
## Building the service:
1. Clone the repository.
2. In the project root directory, run the following command to build the service jar:
        `mvn clean install`
## Building a Docker Image
In the project root directory, run the following command to build a Docker image:
`docker build -t user-service:1.0.0 .`
## Running the Service in a Container
1. Run the following command to create a Docker network:
   `docker network create user-network`

2. Run the following command to run the user-service container:
   `docker run -p 9090:8080 --name user-service --net user-network -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=qwerty -e MYSQL_PORT=3306 user-service`
3. Test the service by sending a GET request to http://localhost:9090/greeting:
