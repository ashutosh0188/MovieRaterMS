# MovieRaterMS
This projects is a Movie Rating Application which has been designed in micro services architecture using Spring Cloud technologies.
The technology stack that has been used is given following:

1. Spring Cloud Starter Netflix Eureka Server
This is an open source library from Netflix Eureka for discovering and registering all running service information with itself. This is also known as service discovery. And act as Microservice design pattern i.e. Service discovery design pattern. Any SpringBoot application that has an annotation @EnableEurekaServer at application class. Then that application will act as service discover server.

2. Spring Cloud Starter Netflix Eureka Client
This is an open source library from Netflix Eureka for enabling any running service as eureka client. So that when they are up they can register themselves with eureka server i.e. discovery server. Any SpringBoot application that has an annotation @EnableEurekaClient at application class. Then that application will act as eureka client and has inbuilt functionality to call discovery server and register themselves with information like name, port etc. So when one microservice needs to call another microservice they can directly call service discovery service by their http://host:port/desiredMicroserviceName/api-endpoint-path. Eureka server will automatically pick the right microservice using desiredMicroserviceName. This eureka client has also the ability to manage client side load balancing using annotation @LoadBalanced. It uses round robin mechanism in case one microservice has multiple running instances.

3. Spring Clound Starter Netflix Hystrix
This is an open source library from Hystrix. This is used to implement Circuit Breaker design pattern that powers the microservices fault tollerance and resillence. Any SpringBoot application that has an annotation @EnableCircuitBreaker at application class and @HystrixCommand over desired endpoint which can be failed during microservices call. Then Hystrix will automatically trips the circuit i.e. stop calling that particular microservice which is slow or failing on the basis of some pre-configured hystrix property. And automatically resumes calling services. This also has hystrix dashboard that can be acheived using @EnableHystrixDashboard over application class. This dashboard shows all the running microservice calling, success rate, threshold, failures etc. 

