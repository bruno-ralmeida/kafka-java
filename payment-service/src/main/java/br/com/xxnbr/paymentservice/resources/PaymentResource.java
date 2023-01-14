package br.com.xxnbr.paymentservice.resources;

import br.com.xxnbr.paymentservice.dtos.PaymentDTO;
import br.com.xxnbr.paymentservice.models.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentResource {

    @PostMapping
    ResponseEntity<Payment> payment(@RequestBody PaymentDTO payment);
}
