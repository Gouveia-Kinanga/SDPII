package edu.ucan.BancoBci.service.impl;

import edu.ucan.BancoBci.entities.*;
import edu.ucan.BancoBci.repository.PessoaRepository;
import edu.ucan.BancoBci.service.EnderecoService;
import edu.ucan.BancoBci.service.EstadoCivilService;
import edu.ucan.BancoBci.service.PessoaService;
import edu.ucan.BancoBci.service.SexoService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.time.LocalDate;
@Service
public class PessoaServiceImpl implements PessoaService {

    final SexoService sexoService;
    final EnderecoService enderecoService;
    final EstadoCivilService estadoCivilService;
    final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(SexoService sexoService, EnderecoService enderecoService, EstadoCivilService estadoCivilService, PessoaRepository pessoaRepository) {
        this.sexoService = sexoService;
        this.enderecoService = enderecoService;
        this.estadoCivilService = estadoCivilService;
        this.pessoaRepository = pessoaRepository;
    }


    @Override
    public List<PessoaEntity> listarPessoa() {

        return pessoaRepository.findAll();
    }

    @Override
    public void salvar(String nome, String nif, Date dataNascimento, UUID idSexo, UUID idEstadoCivil, UUID idEndereco) {

        PessoaEntity pessoaEntity = new PessoaEntity();
        if (buscarPorNif(nif) == null){
        pessoaEntity.setNome(nome);
        pessoaEntity.setDataNascimento(dataNascimento);

        EstadoCivilEntity estadoCivilEntity = this.estadoCivilService.buscarPorIdEstadoCivil(idEstadoCivil);
        pessoaEntity.setEstadoCivil(estadoCivilEntity);

        SexoEntity sexoEntity = this.sexoService.buscarPorIdSexo(idSexo);
        pessoaEntity.setSexo(sexoEntity);

        EnderecoEntity enderecoEntity = this.enderecoService.buscarPorIdEndereco(idEndereco);
        pessoaEntity.setEndereco(enderecoEntity);

        pessoaEntity.setNif(nif);

        pessoaRepository.save(pessoaEntity);}
    }

    @Override
    public void eliminarPessoa(UUID id) {
        Optional<PessoaEntity> pessoaEntity = pessoaRepository.findById(id);
        if(!pessoaEntity.isPresent())
            new Exception("Id nao encontrado");
        pessoaRepository.deleteById(id);

    }

    @Override
    public PessoaEntity buscarPorIdPessoa(UUID k) {
        Optional<PessoaEntity> pessoaEntity = pessoaRepository.findById(k);
        if (!pessoaEntity.isPresent())
            new  Exception("Id nao encontrado");
        return pessoaEntity.get();
    }

    @Override
    public void atualizarPessao(UUID k, String nome,String nif,Date dataNascimento,UUID idSexo, UUID idEstadoCivil, UUID idEndereco) {
        PessoaEntity pessoaEntity = this.buscarPorIdPessoa(k);
        SexoEntity sexoEntity = this.sexoService.buscarPorIdSexo(idSexo);
        EstadoCivilEntity estadoCivil = this.estadoCivilService.buscarPorIdEstadoCivil(idEstadoCivil);
        EnderecoEntity enderecoEntity = this.enderecoService.buscarPorIdEndereco(idEndereco);
        Optional.ofNullable(nome).ifPresent(pessoaEntity::setNome);
        Optional.ofNullable(dataNascimento).ifPresent(pessoaEntity::setDataNascimento);
        Optional.ofNullable(estadoCivil).ifPresent(pessoaEntity::setEstadoCivil);
        Optional.ofNullable(sexoEntity).ifPresent(pessoaEntity::setSexo);
        Optional.ofNullable(enderecoEntity).ifPresent(pessoaEntity::setEndereco);
        Optional.ofNullable(nif).ifPresent(pessoaEntity::setNif);
        pessoaRepository.save(pessoaEntity);

    }

    @Override
    public PessoaEntity buscarPorNif(String nif) {

        PessoaEntity pessoaEntity = pessoaRepository.findBybuscarPorNif(nif);
        if (pessoaEntity!=null)
            new  Exception("NIF existente");
        return null;
    }
}
