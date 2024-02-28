package edu.ucan.BancoBic.service;

import edu.ucan.BancoBic.entities.EnderecoEntity;

import java.util.List;
import java.util.UUID;

public interface EnderecoService {

    public List<EnderecoEntity> listarEndereco();
    public void  salvar(String bairro, String rua, UUID idLocalidade);

    public  void eliminarEndereco(UUID id);

    public EnderecoEntity buscarPorIdEndereco(UUID k);

    public void atualizarEndereco(UUID k, String bairro, String rua, UUID idLocalidade );
}
