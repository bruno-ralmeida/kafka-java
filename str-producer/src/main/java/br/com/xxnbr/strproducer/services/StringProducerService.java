package br.com.xxnbr.strproducer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class StringProducerService {

  @Autowired
  private KafkaTemplate<String, String> template;

  @Value("${kafka.topic-name}")
  private String topicName;

  public void sendMessage(String message) {
    template.send(topicName, message).addCallback(
        success -> {
          log.info("SUCCESS -- MESSAGE = {}", message);
          log.info("PARTITION {}, OFFSET{} ",
              success.getRecordMetadata().partition(),
              success.getRecordMetadata().offset());
        },
        error -> log.error("ERROR"));
    ;
  }

}
