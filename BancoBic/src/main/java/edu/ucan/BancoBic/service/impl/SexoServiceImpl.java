package edu.ucan.BancoBic.service.impl;

import edu.ucan.BancoBic.entities.SexoEntity;
import edu.ucan.BancoBic.repository.SexoRepository;
import edu.ucan.BancoBic.service.SexoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SexoServiceImpl implements SexoService {
final SexoRepository sexoRepository;

    public SexoServiceImpl(SexoRepository sexoRepository) {

        this.sexoRepository = sexoRepository;
    }

    @Override
    public List<SexoEntity> listarSexo() {

        return sexoRepository.findAll();
    }

    @Override
    public SexoEntity salvar(String descricao) {
        SexoEntity sexoEntity = new SexoEntity();
        if(sexoRepository.findSexoEntitiesByDescricaoContainingIgnoreCase(descricao) != null)
        {
            return null ;
        }
        sexoEntity.setDescricao(descricao);
        sexoEntity = sexoRepository.save(sexoEntity);
        return  sexoEntity;
    }

    @Override
    public void eliminarSexo(UUID id) {
        Optional<SexoEntity> sexoEntity = sexoRepository.findById(id);
        if(!sexoEntity.isPresent())
            new Exception("Id nao encontrado");
        sexoRepository.deleteById(id);
    }

    @Override
    public SexoEntity buscarPorIdSexo(UUID k) {
        Optional<SexoEntity> sexoEntity = sexoRepository.findById(k);
        if (!sexoEntity.isPresent())
            new  Exception("Id nao encontrado");
        return sexoEntity.get();

    }

    @Override
    public void atualizarSexo(UUID k, String descricao) {
        SexoEntity sexoEntity = this.buscarPorIdSexo(k);
       Optional.ofNullable(descricao).ifPresent(sexoEntity::setDescricao);
        sexoRepository.save(sexoEntity);

    }
}
