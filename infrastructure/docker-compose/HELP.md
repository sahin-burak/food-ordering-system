## Zookeeper

```
docker-compose -f common.yml -f zookeeper.yml up
echo ruok | nc localhost 2181
```

## Kafka

```
docker-compose -f common.yml -f kafka_cluster.yml up
```

## Kafka Manager

Access to [Kafka Manager](http://localhost:9000)