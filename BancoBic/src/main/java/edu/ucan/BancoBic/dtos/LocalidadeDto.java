package edu.ucan.BancoBic.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class LocalidadeDto {
    private UUID idLocalidade;
    private String descricao;
    private LocalidadeDto localidadePai;



}
