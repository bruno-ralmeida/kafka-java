package br.com.xxnbr.paymentservice.dtos;

import lombok.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    @DecimalMin("1")
    private Long userId;
    @NotBlank
    private String cardNumber;
}
