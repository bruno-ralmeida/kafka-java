package br.com.xxnbr.jsonconsumer.listeners;


import br.com.xxnbr.jsonconsumer.models.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraude(@Payload Payment payment) {
        log.info("PAGAMENTO RECEBIDO ::: {}", payment.toString());
        sleep(2000);
        log.info("VALIDANDO FRAUDE...");
        sleep(3000);
        log.info("COMPRA APROVADA");
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) {
        sleep(5000);
        log.info("GERANDO PDF DO PRODUTO DE ID:::  {}", payment.getId());

        sleep(2000);
        log.info("PDF GERADO COM SUCESSO");
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() {
        sleep(10000);
        log.info("ENVIANDO EMAIL DE CONFIRMAÇÃO...");
        sleep(3000);
        log.info("EMAIL ENVIADO");
    }
}
