package br.com.xxnbr.strconsumer.config;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.RecordInterceptor;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class StringConsumerConfig {

  @Autowired
  private KafkaProperties properties;

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
    var configs = new HashMap<String, Object>();

    configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
    configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

    return new DefaultKafkaConsumerFactory<>(configs);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> strContainerFactory(
      ConsumerFactory<String, String> consumerFactory) {
    var factory = new ConcurrentKafkaListenerContainerFactory<String, String>();

    factory.setConsumerFactory(consumerFactory);

    return factory;
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> validMessageContainerFactory(
      ConsumerFactory<String, String> consumerFactory) {
    var factory = new ConcurrentKafkaListenerContainerFactory<String, String>();

    factory.setConsumerFactory(consumerFactory);
    factory.setRecordInterceptor(validMessage());

    return factory;
  }

  private RecordInterceptor<String, String> validMessage() {
    return record -> {
      if (record.value().toLowerCase().contains("test")) {
        log.info("TEST MESSAGE");
        return record;
      }
      return record;
    };
  }

}
