# Microservices

## Spring cloud

![Architecture](https://user-images.githubusercontent.com/40702606/144061535-7a42e85b-59d6-4f7f-9c35-18a48b49e6de.png)

> Module Manager : Maven Parent Module(Maven multi module)

## Inter Process Communication (IPC)

> I use [openFeign](https://spring.io/projects/spring-cloud-openfeign) instead of since it
> is deprecated`RestTemplate` for Remote Procedure Calls (RPC)
> ### Module:Client will contain all the RPC with openFeign
> To use client --> add it to the pom.xml

## Service discovery

![eureka](https://miro.medium.com/v2/resize:fit:1100/format:webp/1*4F7jh6PNf5CDK6pN4H9UHw.jpeg)

> The process of automatically detecting devices and services on a network
> For starter I used [Eureka Service Discovery](https://spring.io/projects/spring-cloud-netflix)
> * Microservice will need to register as Clients
> * The make a request to Eureka server to discover the available server and the server will look up
> * The server returns the correct location and the client will connect
    > The downside is that in case the server is down then there is going to be a downtown
    > The server will be an `independent standalone service`(polyglottic)
    > Server is running on `http://localhost:8761/`

## Load-Balancer

> To have eureka client use service discover, the need to use a load balancer or a gateway

## Distributed Tracing with Actuator and Zipkin

> Add the zipkin image to ur compose file if you don't have it install locally
> By adding Actuator and Zipkin dependency it will automatically fire up a zipkin dashboard

## AMQP (Advance Message Queue Protocol)
> I used `RabbitMQ` as a message broker for the starter but will be moved to `Kafka`.
> ![RabbitMQ](https://sipodsoftware.com/wp-content/uploads/2023/04/2.jpg)

## How I setup `RabbitMQ` for the first time
> `RabbitMQConfig`
>  - `AmqpTemplate`
>  - `SimpleRabbitListenerContainerFactory`
>  - `Jackson2JsonMessageConverter`
> 
> `RabbitMQMessageProducer` with a publish method that takes a payload,exchange and routingKey
> `NotificationConfig`
> - `TopicExchange`
> - `Queue`
> - `Binding`
> 
> `NotificationConsumer` with a consumer method that takes `NotifactionRequest`

## Dockerizing and Containerization
