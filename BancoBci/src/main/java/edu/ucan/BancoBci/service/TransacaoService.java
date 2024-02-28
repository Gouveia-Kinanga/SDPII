package edu.ucan.BancoBci.service;

import edu.ucan.BancoBci.dtos.EndPointDto;
import edu.ucan.BancoBci.dtos.PegarNomeClienteDto;
import edu.ucan.BancoBci.entities.TransacaoEntity;

import java.util.List;
import java.util.UUID;

public interface TransacaoService {
     List<TransacaoEntity> listarTransacao();
     void  salvar(Integer numeroContaCliente, Integer  numeroContaBeneficiario, Double valorTransferir, String descricao);
      void eliminarTransacao(UUID id);
     TransacaoEntity buscarPorIdTransacao(UUID k) ;
    EndPointDto Endpoint (Integer numConta);

   void actualizaConta(Integer numConta, Double Valor_conta);

   PegarNomeClienteDto pegaNomebynumConta(Integer numConta);



}

