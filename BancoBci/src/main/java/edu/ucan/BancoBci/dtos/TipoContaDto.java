package edu.ucan.BancoBci.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class TipoContaDto {
    private UUID idTipoConta;
    private String descricao;
}
