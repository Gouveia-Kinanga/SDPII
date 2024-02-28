package edu.ucan.BancoBic.service;


import edu.ucan.BancoBic.entities.PessoaEntity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface PessoaService {

    public List<PessoaEntity> listarPessoa();
    public void  salvar(String nome, String nif, Date dataNascimento, UUID sexo, UUID estadoCivil, UUID endereco);

    public  void eliminarPessoa(UUID id);

    public PessoaEntity buscarPorIdPessoa(UUID k);

    public void atualizarPessao(UUID k, String nome,String nif,Date dataNascimento,UUID sexo, UUID estadoCivil, UUID endereco);
    public PessoaEntity buscarPorNif(String nif);

}
