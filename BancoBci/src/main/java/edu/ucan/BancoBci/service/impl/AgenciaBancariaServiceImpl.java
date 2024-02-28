package edu.ucan.BancoBci.service.impl;

import edu.ucan.BancoBci.entities.*;
import edu.ucan.BancoBci.repository.AgenciaBancariaRepository;
import edu.ucan.BancoBci.repository.EnderecoRepository;
import edu.ucan.BancoBci.service.AgenciaBancariaService;
import edu.ucan.BancoBci.service.EnderecoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class AgenciaBancariaServiceImpl implements AgenciaBancariaService {
    final AgenciaBancariaRepository agenciaBancariaRepository;
    final EnderecoService enderecoService;

    public AgenciaBancariaServiceImpl(AgenciaBancariaRepository agenciaBancariaRepository, EnderecoRepository enderecoRepository, EnderecoService enderecoService) {
        this.agenciaBancariaRepository = agenciaBancariaRepository;
        this.enderecoService = enderecoService;
    }

    @Override
    public List<AgenciaBancariaEntity> listarAgenciaBancaria() {

        return agenciaBancariaRepository.findAll();
    }

    @Override
    public AgenciaBancariaEntity salvar(String descricao, UUID idEndereco) {
        AgenciaBancariaEntity agenciaBancariaEntity = new AgenciaBancariaEntity();
        if (agenciaBancariaRepository.findAgenciaBancariaEntityByDescricaoContainingIgnoreCase(descricao) == null)
        {
            agenciaBancariaEntity.setDescricao(descricao);
            EnderecoEntity enderecoEntity= enderecoService.buscarPorIdEndereco(idEndereco);
            agenciaBancariaEntity.setEndereco(enderecoEntity);
            agenciaBancariaRepository.save(agenciaBancariaEntity);
        }
        new  RuntimeException("Entidade ja existe");

        return agenciaBancariaEntity;
    }

    @Override
    public void eliminarAgenciaBancaria(UUID id) {
        Optional<AgenciaBancariaEntity> agenciaBancariaEntity = agenciaBancariaRepository.findById(id);
        if(!agenciaBancariaEntity.isPresent())
            new Exception("Id nao encontrado");
        agenciaBancariaRepository.deleteById(id);

    }

    @Override
    public AgenciaBancariaEntity buscarPorIdAgenciaBancaria(UUID k) {
        Optional<AgenciaBancariaEntity> agenciaBancariaEntity = agenciaBancariaRepository.findById(k);
        if (!agenciaBancariaEntity.isPresent())
            new  Exception("Id nao encontrado");
        return agenciaBancariaEntity.get();

    }

    @Override
    public void atualizarAgenciaBancaria(UUID k, String descricao, UUID idEndereco) {
        AgenciaBancariaEntity agenciaBancariaEntity = this.buscarPorIdAgenciaBancaria(k);
        EnderecoEntity enderecoEntity = this.enderecoService.buscarPorIdEndereco(idEndereco);
        Optional.ofNullable(descricao).ifPresent(agenciaBancariaEntity::setDescricao);
        Optional.ofNullable(enderecoEntity).ifPresent(agenciaBancariaEntity::setEndereco);

        agenciaBancariaRepository.save(agenciaBancariaEntity);

    }
}
