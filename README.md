This micro-service has the sole responsibility to act as API Gateway. All traffic will pass through this centralised point in the architecture. In other words, all requests from the front end will pass through the API Gateway and will be routed by it to the final micro-services.
This allows, for example, authentication via JWT to be centralised in a single component and not replicated in the others.


Technologies used:
* Spring Boot 3.3.3 with Java 17
* Spring Security with JWT
* Spring Cloud Eureka Client
* Spring Data JPA
* MySQL database connection
* Lombok
* Docker
