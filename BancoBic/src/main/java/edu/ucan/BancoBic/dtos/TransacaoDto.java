package edu.ucan.BancoBic.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TransacaoDto {
    private UUID idTransacao;
    private double montante;
    private String descricao;
    private ContaBancariaDto contaBancariaCliente;
    private TransacaoDto tipoTransacao;
    private UUID idBeneficiario;
    private String nomeBeneficiario;
    private String ibanBeneficiario;
    private Integer numeroContaBeneficiario;
    private LocalDateTime dataHoraTransacao;
    private LocalDate dataExecucao;
}
