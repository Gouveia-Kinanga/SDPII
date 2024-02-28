package edu.ucan.BancoBic.service;

import edu.ucan.BancoBic.entities.AgenciaBancariaEntity;

import java.util.List;
import java.util.UUID;

public interface AgenciaBancariaService {

     List<AgenciaBancariaEntity> listarAgenciaBancaria();
     AgenciaBancariaEntity salvar(String descricao, UUID idEndereco );

      void eliminarAgenciaBancaria(UUID id);

     AgenciaBancariaEntity buscarPorIdAgenciaBancaria(UUID k);

    public void atualizarAgenciaBancaria(UUID k, String descricao, UUID idEndereco );
}
