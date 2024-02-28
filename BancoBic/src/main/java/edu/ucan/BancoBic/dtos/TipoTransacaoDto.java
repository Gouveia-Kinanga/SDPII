package edu.ucan.BancoBic.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class TipoTransacaoDto {
    private UUID idTipoTransacao;
    private String descricao;
}
