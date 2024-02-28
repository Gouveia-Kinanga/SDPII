package edu.ucan.BancoBic.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class EstadoCivilDto {
    private UUID idEstadoCivil;
    private String descricao;
}
