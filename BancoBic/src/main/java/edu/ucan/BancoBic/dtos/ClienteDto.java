package edu.ucan.BancoBic.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ClienteDto
{
    private UUID idCliente;
    private PessoaDto pessoa;
    private ContactosDto contactos;
}
