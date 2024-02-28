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
@Table(name = "tb_tipo_transacao")

public class TipoTransacaoEntity {
    @Id
    @GeneratedValue
    private UUID idtipoTransacao;

    @Column(name = "descricao", nullable = false)
    private String descricao;

}
