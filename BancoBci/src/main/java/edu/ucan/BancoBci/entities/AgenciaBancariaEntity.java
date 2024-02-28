package edu.ucan.BancoBci.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_agencia_bancaria")
public class AgenciaBancariaEntity {
    @Id
    @GeneratedValue
    private UUID idagenciaBancaria;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne(optional = true)
    @JoinColumn(name = "fkEndereco", nullable = true)
    private EnderecoEntity endereco;





}
