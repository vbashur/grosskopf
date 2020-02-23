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

