package edu.ucan.Transacaoancaria.service.impl;

import edu.ucan.Transacaoancaria.model.HistoricoTransacaoEntity;
import edu.ucan.Transacaoancaria.repository.HistoricoTransacaoRepository;
import edu.ucan.Transacaoancaria.service.HistoricoTransacaoService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoricoTransacaoServiceImpl implements HistoricoTransacaoService {

    final HistoricoTransacaoRepository transacaoRepository;

    public HistoricoTransacaoServiceImpl(HistoricoTransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }


    @Override
    public void SalvarHistorico(String nomeCliente, Integer numContaCliente,
                                String nomeBeneficiario, Integer numContaBeneficiario,
                                double valorTransferido, String transferenciaTipo) {

        HistoricoTransacaoEntity historico = new HistoricoTransacaoEntity();

        historico.setNomeCliente(nomeCliente);
        historico.setNumContaCliente(numContaCliente);
        historico.setNomeBeneficiario(nomeBeneficiario);
        historico.setNumContaBeneficiario(numContaBeneficiario);
        historico.setValorTransferido(valorTransferido);
        historico.setTransferenciaTipo(transferenciaTipo);
        historico.setDataTransacao(LocalDateTime.now());
        this.transacaoRepository.save(historico);

    }

    @Override
    public List<HistoricoTransacaoEntity> findAll() {
        return transacaoRepository.findAll();
    }

    @Override
    public List<HistoricoTransacaoEntity>   pesquisarPeloNumConta(Integer numConta) {
        List<HistoricoTransacaoEntity> historicoTransacaoEntity = transacaoRepository.findByNumeroConta(numConta);

        return historicoTransacaoEntity;
    }
}
