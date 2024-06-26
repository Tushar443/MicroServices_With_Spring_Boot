# MicroServices_With_Spring_Boot
MicroServices With Spring Boot

#### limits-service - 8080
#### weight-service - 8081
#### length-service - 8082
#### spring-cloud-config-server - 8888
#### currency-exchange-microservice - 8000
#### currency-conversion-microservice - 8080
#### nextflix-eureka-naming-server - 8761
#### API-gatway - 8765
#### zipkin-distributed-tracing-server - 9411



### Docker Commands
#### docker --version
#### docker run in28min/todo-rest-api-h2:1.0.0.RELEASE
#### docker run -p -5000:5000 in28min/todo-rest-api-h2:1.0.0.RELEASE
#### docker run -p 5000:5000 in28min/todo-rest-api-h2:1.0.0.RELEASE
#### docker run -p 5000:5000 -d in28min/todo-rest-api-h2:1.0.0.RELEASE
#### docker logs -f 8f290
#### docker run -p 5001:5000 -d in28min/todo-rest-api-h2:1.0.0.RELEASE
#### docker container ls
#### docker container ls -a
#### docker container stop 323e7
#### docker container stop 8f290
#### docker container ls -a
#### docker container ls
#### docker images
#### docker run -p 9411:9411 openzipkin/zipkin:2.23


### Currency Exchange Service
http://localhost:8000/currency-exchange/from/USD/to/INR

### Currency Conversion Service
http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10

### Eureka
http://localhost:8761

### API Gateway
http://localhost:8765/CURRENCY-EXCHANGE/currency-exchange/from/USD/to/INR
http://localhost:8765/CURRENCY-CONVERSION/currency-conversion/from/USD/to/INR/quantity/10

### After lower case
http://localhost:8765/currency-exchange/currency-exchange/from/USD/to/INR
http://localhost:8765/currency-conversion/currency-conversion/from/USD/to/INR/quantity/10

### After API gateway
http://localhost:8765/currency-exchange/from/USD/to/INR
http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10