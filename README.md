### Getting Started with Posting Microservice System
## what to do
In this module We will create posting microservice system and deploy it using Docker.<br />
During this task we'll need to implement the next two services:
- User service
- Post service

And add interaction between them.

## Sub-task 1: Create services

1) User service is CRUD service for managing users. It should use persistent storage for storing users

**Service definition should be next:**
<table>
    <tr>
        <td><b>GET /greeting</b></td>
        <td colspan="5"><b>Simple API for testing purpose</b></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Response</b></td>
        <td><i>Body</i></td>
        <td><i>Description</i></td>
        <td colspan="3"><i>Code</i></td>
    </tr>
    <tr>
        <td>"Hello, k8s!"</td>
        <td></td>
        <td colspan="3">200 – OK<br />
                        500 – Internal server error occurred.<br />
        </td>
    </tr>
    <tr>
        <td><b>POST /users</b></td>
        <td colspan="5"><b>Uploads a new user</b></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Request</b></td>
        <td><i>Parameter</i></td>
        <td><i>Description</i></td>
        <td><i>Restriction</i></td>
        <td><i>Body example</i></td>
        <td><i>Description</i></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td>{<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"username": "some-username"<br />
            }<br />
        </td>
        <td>Username of user to be created</td>
    </tr>
    <tr>
        <td rowspan="2"><b>Response</b></td>
        <td><i>Body</i></td>
        <td><i>Description</i></td>
        <td colspan="3"><i>Code</i></td>
    </tr>
    <tr>
        <td>{
            &nbsp;&nbsp;&nbsp;&nbsp;"id": 123,<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"username": "some-username",<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"amountOfPosts": 0<br />
            }
        </td>
        <td>Long id – ID of created user<br />
            String username – username of created user<br />
            String amount – amount of posts for the user<br /></td>
        <td colspan="3">200 – OK<br />
                        400 – Validation error or request body is an invalid<br />
                        500 – Internal server error occurred.<br />
        </td>
    </tr>
    <tr>
        <td><b>GET /users/{id}</b></td>
        <td colspan="5"><b>Gets user’s data</b></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Request</b></td>
        <td><i>Parameter</i></td>
        <td><i>Description</i></td>
        <td><i>Restriction</i></td>
        <td><i>Body example</i></td>
        <td><i>Description</i></td>
    </tr>
    <tr>
        <td>Long id</td>
        <td>Id of user to get</td>
        <td>Id of existing user</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Response</b></td>
        <td><i>Body</i></td>
        <td><i>Description</i></td>
        <td colspan="3"><i>Code</i></td>
    </tr>
    <tr>
        <td>{
            &nbsp;&nbsp;&nbsp;&nbsp;"id": 123,<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"username": "some-username",<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"amountOfPosts": 0<br />
            }
        </td>
        <td>Long id – ID of created user<br />
            String username – username of created user<br />
            String amount – amount of posts for the user<br /></td>
        <td colspan="3">200 – OK<br />
                        404 – User doesn’t exist with given id<br />
                        500 – Internal server error occurred.<br />
        </td>
    </tr>
    <tr>
        <td><b>DELETE /users/{id}</b></td>
        <td colspan="5"><b>Delete a user</b></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Request</b></td>
        <td><i>Parameter</i></td>
        <td><i>Description</i></td>
        <td><i>Restriction</i></td>
        <td><i>Body example</i></td>
        <td><i>Description</i></td>
    </tr>
    <tr>
        <td>Long id</td>
        <td>Id of user to delete</td>
        <td>Id of existing user</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Response</b></td>
        <td><i>Body</i></td>
        <td><i>Description</i></td>
        <td colspan="3"><i>Code</i></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td colspan="3">200 – OK<br />
                        404 – Not Found<br />
                        500 – Internal server error occurred.<br />
        </td>
    </tr>
    <tr>
        <td><b>PUT /users/{id}</b></td>
        <td colspan="5"><b>Update user’s data</b></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Request</b></td>
        <td><i>Parameter</i></td>
        <td><i>Description</i></td>
        <td><i>Restriction</i></td>
        <td><i>Body example</i></td>
        <td><i>Description</i></td>
    </tr>
    <tr>
        <td>Long id</td>
        <td>Id of user to update</td>
        <td>Id of existing user</td>
        <td>{<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"username": "some-other-username"<br />
            }<br /></td>
        <td>String username – new username for the user</td>
    </tr>
    <tr>
        <td rowspan="2"><b>Response</b></td>
        <td><i>Body</i></td>
        <td><i>Description</i></td>
        <td colspan="3"><i>Code</i></td>
    </tr>
    <tr>
        <td>{
            &nbsp;&nbsp;&nbsp;&nbsp;"id": 123,<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"username": "some-username",<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"amountOfPosts": 0<br />
            }</td>
        <td></td>
        <td colspan="3">200 – OK<br />
                        400 – Validation error or request body is an invalid<br />
                        404 – User doesn’t exist with given id<br />
                        500 – Internal server error occurred.<br />
        </td>
    </tr>
</table>

2) Post service is CRUD service for managing posts. It should use persistent storage for storing posts

**Service definition should be next:**
<table>
    <tr>
        <td><b>GET /greeting</b></td>
        <td colspan="5"><b>Simple API for testing purpose</b></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Response</b></td>
        <td><i>Body</i></td>
        <td><i>Description</i></td>
        <td colspan="3"><i>Code</i></td>
    </tr>
    <tr>
        <td>"Hello, k8s!"</td>
        <td></td>
        <td colspan="3">200 – OK<br />
                        500 – Internal server error occurred.<br />
        </td>
    </tr>
    <tr>
        <td><b>POST /posts</b></td>
        <td colspan="5"><b>Uploads a new post</b></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Request</b></td>
        <td><i>Parameter</i></td>
        <td><i>Description</i></td>
        <td><i>Restriction</i></td>
        <td><i>Body example</i></td>
        <td><i>Description</i></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td>{<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"authorId": 123,<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"text": "Hi friends, I recently watched amazing movie at the cinema"<br />
            }</td>
        <td>Data of post from specified user</td>
    </tr>
    <tr>
        <td rowspan="2"><b>Response</b></td>
        <td><i>Body</i></td>
        <td><i>Description</i></td>
        <td colspan="3"><i>Code</i></td>
    </tr>
    <tr>
        <td>{<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"id": 12,<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"authorId": 123,<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"text": "Hi friends, I recently watched amazing movie at the cinema",<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"postedAt": "28-09-2022"<br />
            }
        </td>
        <td>Long id – ID of created post<br />
            Long authorId – ID of a user who created a post<br />
            String text – text of the post<br />
            Date postedAt – date when the post was created<br /></td>
        <td colspan="3">200 – OK<br />
                        400 – Validation error or request body is an invalid<br />
                        500 – Internal server error occurred.<br />
        </td>
    </tr>
    <tr>
        <td><b>GET /posts/{id}</b></td>
        <td colspan="5"><b>Gets post’s data</b></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Request</b></td>
        <td><i>Parameter</i></td>
        <td><i>Description</i></td>
        <td><i>Restriction</i></td>
        <td><i>Body example</i></td>
        <td><i>Description</i></td>
    </tr>
    <tr>
        <td>Long id</td>
        <td>Id of post to get</td>
        <td>Id of existing post</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Response</b></td>
        <td><i>Body</i></td>
        <td><i>Description</i></td>
        <td colspan="3"><i>Code</i></td>
    </tr>
    <tr>
        <td>{
            &nbsp;&nbsp;&nbsp;&nbsp;"id": 12,<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"authorId": 123,<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"text": "Hi friends, I recently watched amazing movie at the cinema",<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"postedAt": "28-09-2022"<br />
            }
        </td>
        <td>Long id – ID of a post<br />
            Long authorId – ID of a user who created a post<br />
            String text – text of the post<br />
            Date postedAt – date when the post was created<br />
       </td>
        <td colspan="3">200 – OK<br />
                        404 – Post doesn’t exist with given id<br />
                        500 – Internal server error occurred.<br />
        </td>
    </tr>
    <tr>
        <td><b>DELETE /posts/{id}</b></td>
        <td colspan="5"><b>Delete a post</b></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Request</b></td>
        <td><i>Parameter</i></td>
        <td><i>Description</i></td>
        <td><i>Restriction</i></td>
        <td><i>Body example</i></td>
        <td><i>Description</i></td>
    </tr>
    <tr>
        <td>Long id</td>
        <td>Id of post to delete</td>
        <td>Id of existing post</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Response</b></td>
        <td><i>Body</i></td>
        <td><i>Description</i></td>
        <td colspan="3"><i>Code</i></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td colspan="3">200 – OK<br />
                        404 – Not Found<br />
                        500 – Internal server error occurred.<br />
        </td>
    </tr>
    <tr>
        <td><b>PUT /posts/{id}</b></td>
        <td colspan="5"><b>Update posts’s data</b></td>
    </tr>
    <tr>
        <td rowspan="2"><b>Request</b></td>
        <td><i>Parameter</i></td>
        <td><i>Description</i></td>
        <td><i>Restriction</i></td>
        <td><i>Body example</i></td>
        <td><i>Description</i></td>
    </tr>
    <tr>
        <td>Long id</td>
        <td>Id of post to update</td>
        <td>Id of existing post</td>
        <td>{<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"text": "Hi friends, I changed the topic of my post"<br />
            }</td>
        <td>Text of post to be updated</td>
    </tr>
    <tr>
        <td rowspan="2"><b>Response</b></td>
        <td><i>Body</i></td>
        <td><i>Description</i></td>
        <td colspan="3"><i>Code</i></td>
    </tr>
    <tr>
        <td>{<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"id": 12,<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"authorId": 123,<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"text": "Hi friends, I changed the topic of my post; note t",<br />
            &nbsp;&nbsp;&nbsp;&nbsp;"postedAt": "02-10-2022"<br />
            }</td>
        <td>Long id – ID of updated post<br />
            Long authorId – ID of a user who created a post<br />
            String text – text of the post<br />
            Date postedAt – date when the post was updated<br /></td>
        <td colspan="3">200 – OK<br />
                        400 – Validation error or request body is an invalid<br />
                        404 – Post doesn’t exist with given id<br />
                        500 – Internal server error occurred.<br />
        </td>
    </tr>
</table>

## Sub-task 2: Service interaction
When a new post is created or deleted, `numberOfPosts` for user should be changed. We should implement a call from post service to user service.

## Sub-task 3: Containerization
1) Create Dockerfiles to package your applications as docker images.
2) Push these local images to the own public registries in  https://hub.docker.com/. Specify version of your container (f.e. 1.0.0).
3) Create a docker-compose file that would run all containers for your microservice application. Add init scripts for the database to run when container starts up. Once you have a compose file, you can create and start your application containers with a single command: `docker-compose up`.

_Note_: Set Database url, username and password via environment variables for your database and application containers.


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
