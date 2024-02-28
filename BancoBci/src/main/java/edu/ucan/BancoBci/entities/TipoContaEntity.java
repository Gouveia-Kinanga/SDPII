package edu.ucan.BancoBci.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_tipo_conta")
public class TipoContaEntity {
    @Id
    @GeneratedValue

    private UUID idtipoConta;

    @Column(name = "descricao", nullable = false)
    private String descricao;


}

