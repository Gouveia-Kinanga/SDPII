package edu.ucan.BancoBci.service.impl;

import edu.ucan.BancoBci.entities.LocalidadeEntity;
import edu.ucan.BancoBci.repository.LocalidadeRepository;
import edu.ucan.BancoBci.service.LocalidadeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class LocalidadeServiceImpl implements LocalidadeService {

    final LocalidadeRepository localidadeRepository;

    public LocalidadeServiceImpl(LocalidadeRepository localidadeRepository) {
        this.localidadeRepository = localidadeRepository;
    }

    @Override
    public List<LocalidadeEntity> listarLocalidade() {
        return localidadeRepository.findAll();
    }

    @Override
    public LocalidadeEntity salvar(String descricao, UUID idLocalidadePai) {
        LocalidadeEntity localidadeEntity = new LocalidadeEntity();
        if ( buscarLocalidadePelaDescricao(descricao) == null)
        {
            localidadeEntity.setDescricao(descricao);
            if (idLocalidadePai != null)
            {
                LocalidadeEntity localidade_filho= this.buscarPorIdLocalidade(idLocalidadePai);
                localidadeEntity.setLocalidadePai(localidade_filho);
            }
           return  localidadeRepository.save(localidadeEntity);
        }
        return null;
    }

    @Override
    public void eliminarLocalidade(UUID id) {
        Optional<LocalidadeEntity> localidadeEntity = localidadeRepository.findById(id);
        if(!localidadeEntity.isPresent())
            new Exception("Id nao encontrado");
        localidadeRepository.deleteById(id);
    }

    @Override
    public LocalidadeEntity buscarPorIdLocalidade(UUID k) {
        Optional<LocalidadeEntity> localidadeEntity = localidadeRepository.findById(k);
        if (!localidadeEntity.isPresent())
            new  Exception("Id nao encontrado");
        return localidadeEntity.get();
    }

    @Override
    public void atualizarLocalidade(UUID k, String descricao, UUID idLocalidadePai ) {
        LocalidadeEntity localidadeEntity = this.buscarPorIdLocalidade(k);
        LocalidadeEntity localidadePai = this.buscarPorIdLocalidade(idLocalidadePai);
        Optional.ofNullable(descricao).ifPresent(localidadeEntity::setDescricao);
        Optional.ofNullable(localidadePai).ifPresent(localidadeEntity::setLocalidadePai);
        localidadeRepository.save(localidadeEntity);

    }

    @Override
    public LocalidadeEntity buscarLocalidadePelaDescricao(String descricao)
    {
        List<LocalidadeEntity> localidadeEntity =  localidadeRepository.findLocalidadeEntityByDescricaoContainingIgnoreCase(descricao);
        if (localidadeEntity.size() > 0)
            new  RuntimeException("Entidade ja se encontra registrada");
        return  null;
    }
}
