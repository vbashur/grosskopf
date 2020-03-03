
# Guardian
Main application gateway that serves security, manages user permissions and acts as a gateway for the microservices that provide functionality 

## Running the Application

Import the project to the IDE of your choosing as a Maven project.

Run the application using `mvn spring-boot:run` or by running the `Application` class directly from your IDE.

Open http://localhost:8011/ in your browser.

To register the user: POST http://localhost:8011/register
HEADER
Content-Type: application/json
BODY
````
{ 
    "username" : "user2",
    "password" : "user2",
}
````


To get the token for default user: POST http://localhost:8011/authenticate
HEADER
Content-Type: application/json
BODY
````
{ 
    "username" : "user1",
    "password" : "user1",
}
````

To use the token

GET 
http://localhost:8011/status
set custom header: 
````
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1ODI1MTIwNTMsImlhdCI6MTU4MjQ5NDA1M30.31h2VvzXxHyXqIqbkuu7DbvBwraEPnWCKIhQJsVD0gQNP0XTq3uYDOZmBMiioT_0FYbP0IOD3D5A9OmXFt_bIA 
````


