package edu.ucan.BancoBci.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_transacao")
public class TransacaoEntity {
    @Id
    @GeneratedValue
    private UUID idTransacao;

    @Column(name = "montante", nullable = false)
    private double montante;

    @Column(name = "dataHoraTransacao", nullable = false)
    private LocalDateTime dataHoraTransacao;

    @Column(name = "dataExecucao", nullable = false)
    private LocalDate dataExecucao;

    @Column(name = "descricao", nullable = false)
    private String descricao;

//    @ManyToOne(optional = true)
//    @JoinColumn(name = "fkTipoTransacao", nullable = false)
//    private TipoTransacaoEntity tipoTransacao;
    private UUID idBeneficiario;
    private String nomeBeneficiario;
    private String ibanBeneficiario;
    private Integer numeroContaBeneficiario;
    @ManyToOne
    @JoinColumn(name = "beneficiario", nullable = false)
    private ContaBancariaEntity contaBancariaCliente;




}
