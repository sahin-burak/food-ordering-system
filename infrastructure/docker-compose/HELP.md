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

- Access [Kafka Manager](http://localhost:9000)
- Go to *Cluster* menu and select *Add Cluster* option
- Create a new cluster named *food-ordering-system-cluster* with the cluster zookeeper host *zookeeper:2180*