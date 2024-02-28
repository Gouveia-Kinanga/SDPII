package edu.ucan.BancoBic.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_sexo")
@DynamicInsert
@DynamicUpdate
public class SexoEntity {
    @Id
    @GeneratedValue
    private UUID idSexo;
    private String descricao;

}
