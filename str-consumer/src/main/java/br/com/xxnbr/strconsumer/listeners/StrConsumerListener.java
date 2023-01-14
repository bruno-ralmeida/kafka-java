package br.com.xxnbr.strconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import br.com.xxnbr.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {

  @StrConsumerCustomListener(groupId = "group-1")
  public void listenerPartition0(String message) {
    log.info("CUSTOM LISTENER ::: MESSAGE = {}", message);
  }

  @StrConsumerCustomListener(groupId = "group-1")
  public void listenerPartition1(String message) {
    log.info("OTHER CUSTOM LISTENER ::: MESSAGE = {}", message);
  }

  @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
  public void listenerLog(String message) {
    log.info("LOG ::: MESSAGE = {}", message);
  }
}
