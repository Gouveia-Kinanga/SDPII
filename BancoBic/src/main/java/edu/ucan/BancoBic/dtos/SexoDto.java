package edu.ucan.BancoBic.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class SexoDto {
    private UUID idSexo;
    private String descricao;
}
