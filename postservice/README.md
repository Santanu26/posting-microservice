### Getting Started with Post-Service
This is a brief guide to help you get started with the Post-Service project, including building the service, creating a Docker image, and running the service in a container.
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
`docker build -t post-service:1.0.0 .`
## Running the Service in a Container
1. Run the following command to create a Docker network:
   `docker network create post-network`

2. Run the following command to run the post-service container:
   `docker run -p 9091:8081 --name post-service --net post-network -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=qwerty -e MYSQL_PORT=3306 post-service`
3. Test the service by sending a GET request to http://localhost:9091/greeting:
