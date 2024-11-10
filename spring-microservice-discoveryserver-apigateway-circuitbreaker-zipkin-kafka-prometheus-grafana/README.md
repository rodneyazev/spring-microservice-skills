<p align="center">
  <img src="https://i.imgur.com/Lxfk9IE.png" width="400" alt="Spring Boot Logo" />
</p>

## Description

Spring Microservice - Spring Microservice - Discovery Server Security + API Gateway Security + Circuit Breaker

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

## Circuit Break - Test Case

Health Check: http://localhost:8081/actuator/health

Main circuit break url: http://localhost:8081/actuator

<i>Check Inventory and Order console exceptions.</i>

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


## Eureka Server / Service

Endpoint: http://localhost:8761/

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

Now we can access API's via API Gateway url:

api-service-endpoint:

http://localhost:8080/{api-service-endpoint}


<pre>
    <b>Product</b>:     /api/product
    <b>Order</b>:       /api/order
    <b>Inventory</b>:   No implemented via API Gateway
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

    or

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


GET http://localhost:{random-port}/api/inventory

	http://localhost:{random-port}/api/inventory?skucode=iphone_15
	http://localhost:{random-port}/api/inventory?skucode=iphone_15&skucode=iphone_15_black

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