package br.com.xxnbr.strconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {

  @KafkaListener(groupId = "group-1", topicPartitions = {
      @TopicPartition(topic = "str-topic", partitions = { "0" })
  }, containerFactory = "strContainerFactory")
  public void listenerPartition0(String message) {
    log.info("PARTITION 0 ::: MESSAGE = {}", message);
  }

  @KafkaListener(groupId = "group-1", topicPartitions = {
      @TopicPartition(topic = "str-topic", partitions = { "1" })
  }, containerFactory = "strContainerFactory")
  public void listenerPartition1(String message) {
    log.info("PARTITION 1 ::: MESSAGE = {}", message);
  }

  @KafkaListener(groupId = "group-2", topicPartitions = {
      @TopicPartition(topic = "str-topic", partitions = { "0", "1" })
  }, containerFactory = "strContainerFactory")
  public void listenerLog(String message) {
    log.info("LOG ::: MESSAGE = {}", message);
  }
}
