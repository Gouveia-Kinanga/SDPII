package edu.ucan.BancoBic.service;

import edu.ucan.BancoBic.entities.ContactosEntity;

import java.util.List;
import java.util.UUID;

public interface ContactosService {

    public List<ContactosEntity> listarContactos();
    public void  salvar( String telefone1,String telefone2,String email );

    public  void eliminarContactos(UUID id);

    public ContactosEntity buscarPorIdContactos(UUID k);

    public void atualizarContactos(UUID k, String telefone1,String telefone2,String email  );
}
