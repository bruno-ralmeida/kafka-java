package br.com.xxnbr.jsonconsumer.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
public class Payment implements Serializable {

    private Long id;
    private Long userId;
    private String cardNumber;

}
