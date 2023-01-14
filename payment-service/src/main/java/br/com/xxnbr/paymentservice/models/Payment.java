package br.com.xxnbr.paymentservice.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Setter
@Getter
public class Payment implements Serializable {

    private Long id;
    private Long userId;
    private String cardNumber;

}
