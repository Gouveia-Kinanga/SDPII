package edu.ucan.BancoBic.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_Pessoa")
public class PessoaEntity {

    @Id
    @GeneratedValue
    private UUID idPessoa;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = true)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dataNascimento;

    @Column(name = "nif", nullable = false)
    private String nif;

    @ManyToOne(optional = true)
    @JoinColumn(name = "fk_estado_civil", nullable =false)
    private EstadoCivilEntity estadoCivil;

    @ManyToOne(optional = true)
    @JoinColumn(name = "fk_sexo", nullable =false)
    private SexoEntity sexo;

    @ManyToOne(optional = true)
    @JoinColumn(name = "fk_endereco", nullable = false)
    private EnderecoEntity endereco;

}
