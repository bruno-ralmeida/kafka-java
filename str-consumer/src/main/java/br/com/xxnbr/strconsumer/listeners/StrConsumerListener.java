package br.com.xxnbr.strconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import br.com.xxnbr.strconsumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {

  @SneakyThrows
  @StrConsumerCustomListener(groupId = "group-1")
  public void listenerPartition0(String message) {

    log.info("CUSTOM LISTENER ::: MESSAGE = {}", message);
    throw new IllegalArgumentException("ERROR...");
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
