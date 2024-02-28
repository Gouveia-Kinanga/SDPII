package edu.ucan.BancoBic.service.impl;

import edu.ucan.BancoBic.entities.EstadoCivilEntity;
import edu.ucan.BancoBic.repository.EstadoCivilRepository;
import edu.ucan.BancoBic.service.EstadoCivilService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class EstadoCivilServiceImpl implements EstadoCivilService {

    final EstadoCivilRepository estadoCivilRepository;

    public EstadoCivilServiceImpl(EstadoCivilRepository estadoCivilRepository) {
        this.estadoCivilRepository = estadoCivilRepository;
    }

    @Override
    public List<EstadoCivilEntity> listarEstadoCivil() {

        return estadoCivilRepository.findAll();
    }

    @Override
    public EstadoCivilEntity salvar(String descricao) {
        EstadoCivilEntity estadoCivilEntity = new EstadoCivilEntity();
        if(estadoCivilRepository.findEstadoCivilEntityByDescricaoContainingIgnoreCase(descricao) != null)
        {
            return null ;
        }
        estadoCivilEntity.setDescricao(descricao);
        estadoCivilEntity = this.estadoCivilRepository.save(estadoCivilEntity);
        return  estadoCivilEntity;


    }

    @Override
    public void eliminarEstadoCivil(UUID id) {
        Optional<EstadoCivilEntity> estadoCivilEntity = estadoCivilRepository.findById(id);
        if(!estadoCivilEntity.isPresent())
            new Exception("Estado Civil  nao encontrado");
        estadoCivilRepository.deleteById(id);

    }

    @Override
    public EstadoCivilEntity buscarPorIdEstadoCivil(UUID k) {

        Optional<EstadoCivilEntity> estadoCivilEntity = estadoCivilRepository.findById(k);
        if (!estadoCivilEntity.isPresent())
            new  Exception("Id nao encontrado");
        return estadoCivilEntity.get();

    }

    @Override
    public void atualizarEstadoCivil(UUID k, String descricao) {
        EstadoCivilEntity estadoCivilEntity = this.buscarPorIdEstadoCivil(k);
        Optional.ofNullable(descricao).ifPresent(estadoCivilEntity::setDescricao);
        estadoCivilRepository.save(estadoCivilEntity);

    }
}
