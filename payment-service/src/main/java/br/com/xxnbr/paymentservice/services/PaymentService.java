package br.com.xxnbr.paymentservice.services;

import br.com.xxnbr.paymentservice.models.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}

