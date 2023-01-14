package br.com.xxnbr.paymentservice.services.impl;

import br.com.xxnbr.paymentservice.models.Payment;
import br.com.xxnbr.paymentservice.services.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT_SERVICE_IMPL ::: RECEBI O PAGAMENTO {}", payment.toString());
    }
}
