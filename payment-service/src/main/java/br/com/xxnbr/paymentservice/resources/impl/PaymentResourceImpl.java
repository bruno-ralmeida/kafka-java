package br.com.xxnbr.paymentservice.resources.impl;

import br.com.xxnbr.paymentservice.dtos.PaymentDTO;
import br.com.xxnbr.paymentservice.models.Payment;
import br.com.xxnbr.paymentservice.resources.PaymentResource;
import br.com.xxnbr.paymentservice.services.PaymentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Random;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {

    @Autowired
    private PaymentService service;

    @Override
    public ResponseEntity<Payment> payment( @Valid @RequestBody PaymentDTO paymentDTO) {
        var payment = new Payment();
        BeanUtils.copyProperties(paymentDTO,payment );
        payment.setId(new Random().nextLong(1, Long.MAX_VALUE));
        service.sendPayment(payment);
        return ResponseEntity.ok(payment);
    }
}
