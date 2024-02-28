package edu.ucan.BancoBci.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class TipoTransacaoDto {
    private UUID idTipoTransacao;
    private String descricao;
}
