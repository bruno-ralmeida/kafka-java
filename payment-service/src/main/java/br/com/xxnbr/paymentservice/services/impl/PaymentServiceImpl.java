package br.com.xxnbr.paymentservice.services.impl;

import br.com.xxnbr.paymentservice.models.Payment;
import br.com.xxnbr.paymentservice.services.PaymentService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("RECEBI O PAGAMENTO {}", payment.toString());

        Thread.sleep(1000);

        log.info("ENVIANDO PAGAMENTO...");

        kafkaTemplate.send("payment-topic", payment);
    }
}
