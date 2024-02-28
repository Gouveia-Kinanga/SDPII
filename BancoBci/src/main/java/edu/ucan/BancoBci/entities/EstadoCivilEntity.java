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
@Table(name = "tb_estado_civil")
public class EstadoCivilEntity {

    @Id
    @GeneratedValue
    private UUID idestadoCivil;
    @Column(name = "descricao", nullable = false)
    private String descricao;


}
