# Spring Microservices

> Example of a microservice architecture using Spring Cloud

## Overview

The architecture is composed by four services:

- `discovery-service`: Service Discovery Server created with **Eureka**
- `api-gateway`: API Gateway created with **Zuul** that uses the `discovery-service` to send the requests to the services. It uses **Ribbon** as Load Balancer
- `article-service`: Simple REST service created with **Spring Boot** to use as an example
- `author-service`: Simple REST service created with **Spring Boot** to use as an example

The services: `api-gateway`, `article-service` and `author-service` are already configured with **Hystrix (latency and fault tolerance library)** and are providing a **stream** that you can use to monitor with a **Hystrix/Turbine** dashboard. You can check the **Hystrix Stream** accessing the service URL with `/hystrix.stream` (example: `http://localhost:8765/hystrix.stream`)

## How to use

To test this architecture you will need to have: **JDK 8+**, **Docker** and **Maven** installed

- Clone this repo and enter it

- Run the `start.sh` script, it will use **Maven** to build the `.jar` file for each service and then use Docker to build the containers with the `.jar` files

In the default configuration you will have:

- **Discovery Service** running on port `8761`, access `http://localhost:8761` to see the dashboard
- **API Gateway** running on port `8765`, you will send the requests to this service
- **Two Article Services** running on ports: `8080` and `9080`
- **Two Author Services** running on ports: `8081` and `9081`

After running the containers, head to `http://localhost:8761` to make sure that the four services (two **article** and two **author**) are registered in the **Discovery Service**, when they're all registered you can test the application with `curl` making requests to the endpoints below:

- `curl http://localhost:8765/api/articles`
- `curl http://localhost:8765/api/articles/id`
- `curl http://localhost:8765/api/articles/author/id`
- `curl http://localhost:8765/api/authors`
- `curl http://localhost:8765/api/authors/id`

## Contributing

Bug reports and pull requests are welcome on GitHub at [https://github.com/WendellAdriel/spring-microservices](https://github.com/WendellAdriel/spring-microservices). This project is intended to be a safe, welcoming space for collaboration.

## License

This project is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).
