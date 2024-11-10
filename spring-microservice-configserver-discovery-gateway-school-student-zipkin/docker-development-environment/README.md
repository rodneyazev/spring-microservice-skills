<p align="center">
  <img src="https://i.imgur.com/z6SRxKv.jpg" width="400" alt="Docker Logo" />
</p>

# About  containers

### Users and passwords

<em>Passwords that are not in the docker-compose.yml file will be in the .env files within the same directory.</em>

## - Docker

### Network creation

```bash
docker network create my-network
```

### Docker creation

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