package edu.ucan.BancoBic.service.impl;

import edu.ucan.BancoBic.entities.TipoContaEntity;
import edu.ucan.BancoBic.repository.TipoContaRepository;
import edu.ucan.BancoBic.service.TipoContaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoContaServiceImpl implements TipoContaService
{
    final TipoContaRepository tipoContaRepository;


    public TipoContaServiceImpl(TipoContaRepository tipoContaRepository) {
        this.tipoContaRepository = tipoContaRepository;
    }
    @Override
    public List<TipoContaEntity> listarTipoConta() {

        return tipoContaRepository.findAll();
    }

    @Override
    public TipoContaEntity salvar(String descricao) {
        TipoContaEntity tipoContaEntity = new TipoContaEntity();
        if(tipoContaRepository.findTipoContaEntitiesByDescricaoContainingIgnoreCase(descricao) != null)
        {
            return null ;
        }
        tipoContaEntity.setDescricao(descricao);
        tipoContaEntity = tipoContaRepository.save(tipoContaEntity);
        return  tipoContaEntity;

    }

    @Override
    public void eliminarTipoConta(UUID id) {

        Optional<TipoContaEntity> tipoContaEntity = tipoContaRepository.findById(id);
        if(!tipoContaEntity.isPresent())
            new Exception("Id nao encontrado");
        tipoContaRepository.deleteById(id);

    }

    @Override
    public TipoContaEntity buscarPorIdTipoConta(UUID k) {
        Optional<TipoContaEntity> tipoContaEntity = tipoContaRepository.findById(k);
        if (!tipoContaEntity.isPresent())
            new  Exception("Id nao encontrado");
        return tipoContaEntity.get();

    }

    @Override
    public void atualizarTipoConta(UUID k, String descricso) {

        TipoContaEntity tipoContaEntity = this.buscarPorIdTipoConta(k);
        Optional.ofNullable(descricso).ifPresent(tipoContaEntity::setDescricao);
        tipoContaRepository.save(tipoContaEntity);

    }


}
