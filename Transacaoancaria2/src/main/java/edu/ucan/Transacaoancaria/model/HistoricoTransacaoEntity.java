package edu.ucan.Transacaoancaria.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_historico_transacao")
public class HistoricoTransacaoEntity
{
    @Id
    @GeneratedValue
    private UUID idHistorico;
    private String nomeCliente;
    private Integer numContaCliente;
    private String nomeBeneficiario;
    private Integer numContaBeneficiario;
    private double valorTransferido;
    private LocalDateTime dataTransacao;
    private String transferenciaTipo;

}
