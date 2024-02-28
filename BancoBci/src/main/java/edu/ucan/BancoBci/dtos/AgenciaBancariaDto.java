package edu.ucan.BancoBci.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class AgenciaBancariaDto {
    private UUID idAgenciaBancaria;
    private String descricao;
    private EnderecoDto endereco;
}
