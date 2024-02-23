# one-piece-lab

## Kafka instructions

### Start Zookeeper and Kafka

We use the `docker-compose` to start the Zookeeper and Kafka.
To do this, execute the following command:

```dtd
docker-compose up -d
```

Check if the containers are running:

```dtd
docker ps
```

Check if both services are running:

```dtd
nc -zv localhost 29092 # Kafka's broker port
nc -zv localhost 2181 # Zookeeper's client port
```
