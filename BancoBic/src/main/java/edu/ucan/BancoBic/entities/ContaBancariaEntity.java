package edu.ucan.BancoBic.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name ="tb_conta_bancaria" )
public class ContaBancariaEntity {
    @Id
    @GeneratedValue
    private UUID idcontaBancaria;

    @Column(name = "numero_conta", nullable = false)
    private Integer numeroConta;

    @Column(name = "iban", nullable = false)
    private String iban;

    @Column(name = "operacao", nullable = true)
    private String operacao;

    @Column(name = "saldo_conta", nullable = false)
    private double saldoConta;

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "fk_agencia_bancaria")
    private AgenciaBancariaEntity agenciaBancaria;

    @ManyToOne
    @JoinColumn(name = "fk_tipo_conta")
    private TipoContaEntity tipoConta;


}
