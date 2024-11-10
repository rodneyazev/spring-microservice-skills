<p align="center">
  <img src="https://i.imgur.com/Lxfk9IE.png" width="400" alt="Spring Boot Logo" />
</p>

## Description

Spring Microservice - Config Server + Discovery Server + API Gateway + Schools & Students API's + Zipkin

## Docker

### Network

```bash
# Containers Docker Network Creation

docker network create my-network
```

### Containers

```bash
docker-compose up -d

or

docker-compose -f <docker-filename> up -d
```

## - PostgreSQL

```bash
# PGAdmin (Local)
Use host.docker.internal or postgres instead of localhost
```

## Zipkin

Zipkin: http://localhost:9411/

## API Gateway

Now we can access API's via API Gateway url:

api-service-endpoint:

http://localhost:8222/{api-service-endpoint}


<pre>
    <b>Schools</b>:     /api/v1/schools
    <b>Students</b>:    /api/v1/students
</pre>

## Endpoints

```bash

# - schools

POST -> http://localhost:8222/api/v1/schools

    {
	"name":"My's School",
	"email":"{{$randomEmail}}"
    }



GET -> http://localhost:8222/api/v1/schools/with-students/{id}



# - students

POST -> http://localhost:8222/api/v1/students

{
	"firstname":"{{$randomFirstName}}",
	"lastname":"{{$randomLastName}}",
	"email":"{{$randomEmail}}",
	"schoolId": 1
}

```