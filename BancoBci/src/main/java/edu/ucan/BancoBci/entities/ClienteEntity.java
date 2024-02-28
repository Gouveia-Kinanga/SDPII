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
@Table(name = "tb_cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue

    private UUID idCliente;

    @ManyToOne(optional = true)
    @JoinColumn(name = "fkPessoa", nullable =true)
    private PessoaEntity pessoa;

    @ManyToOne(optional = true)
    @JoinColumn(name = "fkContacto", nullable =true)
    private ContactosEntity contactos;



}
