package edu.ucan.BancoBic.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ContaBancariaDto {
    private UUID contaBancaria;
    private double saldoConta;
    private Integer numeroConta;
    private String iban;
    private ClienteDto cliente;
    private AgenciaBancariaDto agenciaBancaria;
    private TipoContaDto tipoConta;
}
