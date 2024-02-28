package edu.ucan.BancoBci.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ContactosDto {
    private UUID idContactos;
    private String telefone1;
    private String telefone2;
    private String email;
}
