# grosskopf
The very first repo for Grosspkopf projects

Why so serious?

To check if JWT works type 
http://localhost:8080/auth/login?username=admin&password=admin in request URL and 
set the following header Content-Type:application/json;charset=UTF-8

To obtain token
GET
http://localhost:8080/auth/oauth/token?grant_type=password&username=admin&password=admin
With authentication header: maingateway:<empty password>

Guardian proj: https://hellokoding.com/hello-single-sign-on-sso-with-json-web-token-jwt-spring-boot/
https://dzone.com/articles/spring-boot-security-json-web-tokenjwt-hello-world
https://blog.softtek.com/en/token-based-api-authentication-with-spring-and-jwt
https://www.callicoder.com/spring-boot-spring-security-jwt-mysql-react-app-part-4/

## Authentication
run guardian application

run presentier application

input `user1 user1` credentials into the form available at http://localhost:8012/


To get the token: POST http://localhost:8080/authenticate
HEADER
Content-Type: application/json
BODY
{ 
    "username" : "javainuse",
    "password" : "password",
}


To check authorization: GET http://localhost:8080/status
set custom header: Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1ODI1MTIwNTMsImlhdCI6MTU4MjQ5NDA1M30.31h2VvzXxHyXqIqbkuu7DbvBwraEPnWCKIhQJsVD0gQNP0XTq3uYDOZmBMiioT_0FYbP0IOD3D5A9OmXFt_bIA 
 

