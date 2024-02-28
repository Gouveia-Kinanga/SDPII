package edu.ucan.Transacaoancaria.client.response;

import lombok.Data;

@Data
public class ClienteResponse
{
    private Integer numero_conta;
    private String agencia;
    private double valor_conta;
    
}
