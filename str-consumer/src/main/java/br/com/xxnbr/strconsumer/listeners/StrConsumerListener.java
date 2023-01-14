package br.com.xxnbr.strconsumer.listeners;

import org.springframework.stereotype.Component;

import br.com.xxnbr.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {

  @StrConsumerCustomListener(groupId = "group-1")
  public void listenerPartition0(String message) {
    log.info("PARTITION 0 ::: MESSAGE = {}", message);
  }

  @StrConsumerCustomListener(groupId = "group-1")

  public void listenerPartition1(String message) {
    log.info("PARTITION 1 ::: MESSAGE = {}", message);
  }

  @StrConsumerCustomListener(groupId = "group-2")
  public void listenerLog(String message) {
    log.info("LOG ::: MESSAGE = {}", message);
  }
}
