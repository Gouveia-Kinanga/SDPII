package edu.ucan.BancoBic.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class EnderecoDto {
    private UUID idEndereco;
    private String bairro;
    private String rua;
    private LocalidadeDto localidade;
}
