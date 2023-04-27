### Getting Started with Posting Microservice System
This is a brief guide to help you get started with the Posting Microservice System, including building the service, creating a Docker image, and running the service in a container.
## Prerequisites:
1. Java
2. Maven
3. Docker
## Run the docker-compose.yaml file:

1. Pull these docker images from the public registries in  https://hub.docker.com/.
i) https://hub.docker.com/r/santanubarua/post-service
ii) https://hub.docker.com/r/santanubarua/user-service
2. Run the docker-compose file `docker-compose up`.

_Note_: Set Database url, username and password via environment variables for database and application containers.
