package edu.ucan.BancoBic.service.impl;

import edu.ucan.BancoBic.entities.*;
import edu.ucan.BancoBic.repository.EnderecoRepository;
import edu.ucan.BancoBic.service.EnderecoService;
import edu.ucan.BancoBic.service.LocalidadeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    final EnderecoRepository enderecoRepository;
    final LocalidadeService localidadeService;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository, LocalidadeService localidadeService) {
        this.enderecoRepository = enderecoRepository;
        this.localidadeService = localidadeService;
    }

    @Override
    public List<EnderecoEntity> listarEndereco() {

        return enderecoRepository.findAll();
    }

    @Override
    public void salvar(String bairro, String rua, UUID idLocalidade) {

        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setRua(rua);
        enderecoEntity.setBairro(bairro);
        if (idLocalidade != null)
        {
          LocalidadeEntity localidadeEntity = localidadeService.buscarPorIdLocalidade(idLocalidade);
          enderecoEntity.setLocalidade(localidadeEntity);
        }
        enderecoRepository.save(enderecoEntity);

    }

    @Override
    public void eliminarEndereco(UUID id) {
        Optional<EnderecoEntity> enderecoEntity = enderecoRepository.findById(id);
        if(!enderecoEntity.isPresent())
            new Exception("Id nao encontrado");
        enderecoRepository.deleteById(id);

    }

    @Override
    public EnderecoEntity buscarPorIdEndereco(UUID k) {
        Optional<EnderecoEntity> enderecoEntity = enderecoRepository.findById(k);
        if (!enderecoEntity.isPresent())
            new  Exception("Id nao encontrado");
        return enderecoEntity.get();
    }

    @Override
    public void atualizarEndereco(UUID k, String bairro, String rua, UUID idLocalidade) {
        EnderecoEntity enderecoEntity = this.buscarPorIdEndereco(k);
        LocalidadeEntity localidadeEntity = this.localidadeService.buscarPorIdLocalidade(idLocalidade);
        Optional.ofNullable(bairro).ifPresent(enderecoEntity::setBairro);
        Optional.ofNullable(rua).ifPresent(enderecoEntity::setRua);
        Optional.ofNullable(localidadeEntity).ifPresent(enderecoEntity::setLocalidade);
        enderecoRepository.save(enderecoEntity);

    }
}
