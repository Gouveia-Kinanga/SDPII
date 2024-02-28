package edu.ucan.Transacaoancaria.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Transacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enviar_banco;
    private String receber_banco;
    private Integer numContaBeneficiario;
    private Integer numContaCliente;
    private double montante;
    private LocalDateTime dataTransacao;
    
}
