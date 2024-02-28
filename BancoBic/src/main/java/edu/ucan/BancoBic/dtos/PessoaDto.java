package edu.ucan.BancoBic.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PessoaDto {
    private UUID idPessoa;
    private String nome;
    private String nif;
    private LocalDate dataNascimento;
    private EstadoCivilDto estadoCivil;
    private SexoDto sexo;
    private EnderecoDto endereco;



}
