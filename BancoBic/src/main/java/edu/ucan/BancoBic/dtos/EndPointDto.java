package edu.ucan.BancoBic.dtos;

import lombok.Data;

//agencia, numero de conta, valor total de conta;
@Data
public class EndPointDto {
    private Integer numero_conta;
    private String agencia;
    private double valor_conta;

}
