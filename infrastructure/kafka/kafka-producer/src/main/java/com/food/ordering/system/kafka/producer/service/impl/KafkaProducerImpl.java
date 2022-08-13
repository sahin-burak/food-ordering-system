package com.food.ordering.system.kafka.producer.service.impl;

import com.food.ordering.system.kafka.producer.exception.KafkaProducerException;
import com.food.ordering.system.kafka.producer.service.KafkaProducer;
import java.io.Serializable;
import javax.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducerImpl<K extends Serializable, V extends SpecificRecordBase>
    implements KafkaProducer<K, V> {

  private final KafkaTemplate<K, V> kafkaTemplate;

  @Override
  public void send(
      String topicName, K key, V message, ListenableFutureCallback<SendResult<K, V>> callback) {

    log.info("Sending message={} to topic={}", message, topicName);
    try {
      ListenableFuture<SendResult<K, V>> kafkaResultFuture =
          kafkaTemplate.send(topicName, key, message);
      kafkaResultFuture.addCallback(callback);
    } catch (KafkaException e) {
      String msg = String.format("Error on kafka producer with key: %s, message: %s", key, message);
      log.error(msg + " and exception {}", e.getMessage(), e);
      throw new KafkaProducerException(msg);
    }
  }

  @PreDestroy
  public void close() {
    if (kafkaTemplate != null) {
      log.info("Closing kafka producer");
      kafkaTemplate.destroy();
    }
  }
}
