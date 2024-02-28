package edu.ucan.BancoBci.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class SexoDto {
    private UUID idSexo;
    private String descricao;
}
