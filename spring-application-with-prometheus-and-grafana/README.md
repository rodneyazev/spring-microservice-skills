<p align="center">
  <img src="https://i.imgur.com/Lxfk9IE.png" width="400" alt="Spring Boot Logo" />
</p>

## Description

Spring Application With Prometheus and Grafana

## Docker

### Network creation

```bash
docker network create my-network
```

### Docker build

```bash
docker build --tag my-spring-app .
```

### Docker run

```bash
docker run --name my-spring-app -p "8080:8080" my-spring-app
```

### Docker creation

```bash
# For Prometheus and Grafana
# docker-development-environment folder

docker-compose up -d

or

docker-compose -f <docker-filename> up -d
```

# Manual QA / Validation

Endpoint: http://localhost:8080/

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
P.S.: You also can import "Spring Boot Statistics Dashboard.json" dashboard.
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
