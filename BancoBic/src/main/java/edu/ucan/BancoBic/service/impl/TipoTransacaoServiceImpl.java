package edu.ucan.BancoBic.service.impl;

import edu.ucan.BancoBic.entities.TipoTransacaoEntity;
import edu.ucan.BancoBic.repository.TipoTransacaoRepository;
import edu.ucan.BancoBic.service.TipoTransacaoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoTransacaoServiceImpl implements TipoTransacaoService {

    final TipoTransacaoRepository tipoTransacaoRepository;

    public TipoTransacaoServiceImpl(TipoTransacaoRepository tipoTransacaoRepository) {
        this.tipoTransacaoRepository = tipoTransacaoRepository;
    }

    @Override
    public List<TipoTransacaoEntity> listarTipoTransacao() {
        return tipoTransacaoRepository.findAll();
    }

    @Override
    public TipoTransacaoEntity salvar(String descricao) {
        TipoTransacaoEntity tipoTransacaoEntity = new TipoTransacaoEntity();
        if(tipoTransacaoRepository.findTipoTransacaoEntitiesByDescricaoContainingIgnoreCase(descricao) != null)
        {
            return null ;
        }
        tipoTransacaoEntity.setDescricao(descricao);
        tipoTransacaoEntity = tipoTransacaoRepository.save(tipoTransacaoEntity);
        return  tipoTransacaoEntity;
    }

    @Override
    public void eliminarTipoTransacao(UUID id) {
        Optional<TipoTransacaoEntity> tipoTransacaoEntity = tipoTransacaoRepository.findById(id);
        if(!tipoTransacaoEntity.isPresent())
            new Exception("Id nao encontrado");
        tipoTransacaoRepository.deleteById(id);

    }

    @Override
    public TipoTransacaoEntity buscarPorIdTipoTransacao(UUID k) {
        Optional<TipoTransacaoEntity> tipoTransacaoEntity = tipoTransacaoRepository.findById(k);
        if (!tipoTransacaoEntity.isPresent())
            new  Exception("Id nao encontrado");
        return tipoTransacaoEntity.get();
    }

    @Override
    public void atualizarTipoTransacao(UUID k, String descricao) {

        TipoTransacaoEntity tipoTransacaoEntity = this.buscarPorIdTipoTransacao(k);
        Optional.ofNullable(descricao).ifPresent(tipoTransacaoEntity::setDescricao);
        tipoTransacaoRepository.save(tipoTransacaoEntity);

    }
}
