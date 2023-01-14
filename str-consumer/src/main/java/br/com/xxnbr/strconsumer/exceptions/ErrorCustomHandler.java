package br.com.xxnbr.strconsumer.exceptions;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

  @Override
  public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
    log.error("HEADERS = {} \n MESSAGE = {} \n ERROR = {}",
        message.getHeaders(),
        message.getPayload(),
        exception.getMessage());
    return null;
  }

}
