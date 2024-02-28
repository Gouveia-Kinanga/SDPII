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
@Table(name = "tb_localidade")
public class LocalidadeEntity {

    @Id
    @GeneratedValue
    private UUID idLocalidade;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne(optional = true)
    @JoinColumn(name = "fk_localidade_pai", nullable =true)
    private LocalidadeEntity localidadePai;

}
