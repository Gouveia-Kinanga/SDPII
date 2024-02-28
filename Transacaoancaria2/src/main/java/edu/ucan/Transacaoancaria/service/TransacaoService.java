package edu.ucan.Transacaoancaria.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface TransacaoService {
    
    void realizarOpercao(Integer numContaCliente, Integer numContaBeneficiario, double valor,boolean isAgenciaIgual) throws JsonProcessingException;
}
