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
@Table(name = "tb_endereco")
public class EnderecoEntity
{
    @Id
    @GeneratedValue
    private UUID idEndereco;

    @Column(name = "bairro", nullable = true)
    private String bairro;

    @Column(name = "rua", nullable = true)
    private String rua;

    @ManyToOne(optional = true)
    @JoinColumn(name = "fkLocalidade", nullable =true)
    private LocalidadeEntity localidade;


}
