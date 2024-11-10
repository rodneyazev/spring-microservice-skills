<p align="center">
  <img src="https://i.imgur.com/Lxfk9IE.png" width="400" alt="Spring Boot Logo" />
</p>

## Description

Spring Microservice - Discovery Server Security + API Gateway Security + Circuit Breaker + Zipkin + Kafka + Prometheus + Grafana + PostgreSQL + MongoDB

<i>Discovery Server or Discovery Service implements communication between API's.</i>

<i>API Gateway Service implements Load Balance and One-Single-Endpoint for multiple API endpoints.</i>

## What is Distributed Tracing

Distributed Tracing helps to track and monitor the request from start to finish.

What is Span ID: it shows the number of trips / jump the request does inside our system (it has a unique ID for the whole request).

<i>E.g.: API Gateway (Span 1) -> Order Service (Span 2) -> Inventory Service (Span 3)</i>

 It helps, for example, detect if we have a performance issue.

## What is Circuit Break

WebClient has Asynchronus communication, sometimes the ordering service may try to communicate with the inventory service and not get a response (slowness, unavailability).

For example, problems that affect database performance can affect communication between APIs (resilience issue).

To fix this, Circuit Break saves states to troubleshoot WebClient Async by checking whether the inventory service is available.

<i>Resilience4j library.</i>

## Docker

### Network

```bash
# Containers Docker Network Creation

docker network create my-network
```

### Containers

```bash
# Directory: docker-development-environment

docker compose up -d
```

## Build packages

```bash
# From root folder

.\mvnw clean package -DskipTests -f .
```

## Dockerize Build

```bash
# discovery-server

docker build --tag order-service:latest .\order-service\

docker compose -f .\order-service\docker-compose.yml up -d
```

```bash
# api-gateway

docker build --tag api-gateway:latest .\api-gateway\

docker compose -f .\api-gateway\docker-compose.yml up -d
```

```bash
# inventory-service

docker build --tag inventory-service:latest .\inventory-service\

docker compose -f .\inventory-service\docker-compose.yml up -d
```

```bash
# product-service

docker build --tag product-service:latest .\product-service\

docker compose -f .\product-service\docker-compose.yml up -d
```

```bash
# notification-service

docker build --tag notification-service:latest .\notification-service\

docker compose -f .\notification-service\docker-compose.yml up -d
```

```bash
# order-service

docker build --tag order-service:latest .\order-service\

docker compose -f .\order-service\docker-compose.yml up -d
```

## Eureka Server / Service Acess

Local Project: http://localhost:8761/

Dockerize Project: http://localhost:8080/eureka/web

```bash
username: eureka
password: eureka
```

## Zipkin

Zipkin: http://localhost:9411/

## Kafdrop

Kafdrop: http://localhost:9091/

## Keycloak

Keycloak: http://localhost:8090/

```bash
username: admin
password: admin
```

## Token Request URL

<i>Curl, Postman, Insomnia, etc.</i>

### Local:

http://localhost:8090/realms/sprint-boot-microservices/protocol/openid-connect/token

### Dockerize:

http://localhost:8080/realms/sprint-boot-microservices/protocol/openid-connect/token


<i>Keycloak > Realm settings > OpenID Endpoint Configuration > "token_endpoint"</i>

<hr>

### Create a new realm

<p align="center">
  <img src="https://i.imgur.com/J6XGxXq.png" width="500" alt="Keycloak" />
</p>

<p align="center">
  <img src="https://i.imgur.com/KELT6HJ.png" width="500" alt="Keycloak" />
</p>

<p align="center">
  <img src="https://i.imgur.com/RCn494F.png" width="500" alt="Keycloak" />
</p>

### Copy and save client secret

<p align="center">
  <img src="https://i.imgur.com/PBrKY3d.png" width="500" alt="Keycloak" />
</p>

### Open OpenID Endpoint Configuration link

<p align="center">
  <img src="https://i.imgur.com/5glpzLy.png" width="500" alt="Keycloak" />
</p>

### Copy and save issuer and token endpoint

<p align="center">
  <img src="https://i.imgur.com/PWMgkVJ.png" width="500" alt="Keycloak" />
</p>

### Insomnia

<p align="center">
  <img src="https://i.imgur.com/3vuYSqO.png" width="500" alt="Keycloak" />
</p>

<p align="center">
  <img src="https://i.imgur.com/xtEMOI8.png" width="500" alt="Keycloak" />
</p>

## API Gateway

Main endpoint:

http://localhost:8080/{api-service-endpoint}

<pre>
    <b>Product</b>:           /api/product
    <b>Order</b>:             /api/order
    <b>Inventory</b>:         /api/inventory
    <b>Discovery Server</b>:  /eureka/web
</pre>


## Endpoints

```bash

# - product-service

GET http://localhost:8080/api/product

POST http://localhost:8080/api/product

    {
        "name":"iphone 15",
        "description":"iphone 15",
        "price":1200
    }




# - order-service (depends_on: inventory-service)

P.S.: iphone_15_black drops java.lang.IllegalArgumentException message:
      "Product is not in stock, please try again later"


POST http://localhost:8080/api/order

    {
        "orderLineItemsDtoList": [
            {
                "skucode":"iphone_15",
                "price": 1200,
                "quantity": 1
            }
        ]
    }

    OR

    {
        "orderLineItemsDtoList": [
            {
                "skucode":"iphone_15",
                "price": 1200,
                "quantity": 1
            },
                {
                "skucode":"iphone_15_black",
                "price": 1200,
                "quantity": 1
            }
        ]
    }




# - inventory-service

P.S.:   Not implemented via API Gateway (access via API Endpoint, only)


GET http://localhost:8080/api/inventory

	http://localhost:8080/api/inventory?skucode=iphone_15
	http://localhost:8080/api/inventory?skucode=iphone_15&skucode=iphone_15_black

```

## Prometheus

Prometheus: http://localhost:9090/

Main endpoint: http://localhost:8080/actuator

<p align="center">
  <img src="https://i.imgur.com/kTHRBm4.png" width="600" alt="Prometheus" />
</p>

<p align="center">
  <img src="https://i.imgur.com/Wwj6zfm.png width="400" alt="Prometheus" />
</p>

## Grafana

Grafana: http://localhost:3000/

```bash
username: grafana
password: grafana
```

### Create Dashboard
- Add Visualization
- Add Prometheus Data Source
- Add Prometheus Server URL: http://host.docker.internal:9090
- Save and Test (<b>Explore view</b> link)

### Access application endpoint to produce Grafana data view

```bash
P.S.: You also can import "Grafana_Dashboard.json" dashboard.
```

<p align="center">
  <img src="https://i.imgur.com/6ItmOnR.png" width="600" alt="Grafana" />
</p>

<p align="center">
  <img src="https://i.imgur.com/u3VZVJA.png" width="600" alt="Grafana" />
</p>

<p align="center">
  <img src="https://i.imgur.com/l1jHBHd.png" width="600" alt="Grafana" />
</p>

<p align="center">
  <img src="https://i.imgur.com/vCyvszz.png" width="600" alt="Grafana" />
</p>

<p align="center">
  <img src="https://i.imgur.com/XAciFH2.png" width="600" alt="Grafana" />
</p>

<p align="center">
  <img src="https://i.imgur.com/ExFTlgx.png" width="600" alt="Grafana" />
</p>