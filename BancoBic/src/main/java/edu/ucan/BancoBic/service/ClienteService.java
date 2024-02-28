package edu.ucan.BancoBic.service;

import edu.ucan.BancoBic.entities.ClienteEntity;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

    public List<ClienteEntity> listarCliente();
    public void  salvarCliente(UUID pessoa, UUID contactos );

    public  void eliminarCliente(UUID id);

    public ClienteEntity buscarPorIdCliente(UUID k);

    public void atualizarCliente(UUID k, UUID pessoa, UUID contactos );

    public ClienteEntity buscarPeloIdPessoa(UUID k);
}
