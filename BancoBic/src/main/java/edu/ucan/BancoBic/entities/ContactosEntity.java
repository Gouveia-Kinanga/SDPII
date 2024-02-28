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
@Table(name = "tb_contacto")
public class ContactosEntity {

    @Id
    @GeneratedValue
    private UUID idcontctos;

    @Column(name = "telefone1", nullable = false)
    private String telefone1;

    @Column(name = "telefone2", nullable = false)
    private String telefone2;

    @Column(name = "email", nullable = false)
    private String email;

}
