package edu.ucan.Transacaoancaria.service;

import edu.ucan.Transacaoancaria.model.HistoricoTransacaoEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface HistoricoTransacaoService
{

    void SalvarHistorico(String nomeCliente, Integer numContaCliente, String nomeBeneficiario,
                         Integer numContaBeneficiario, double valorTransferido,
                         String transferenciaTipo );

    List<HistoricoTransacaoEntity> findAll();

   List<HistoricoTransacaoEntity>  pesquisarPeloNumConta(Integer numConta);

}
