package edu.ucan.BancoBic.service.impl;

import edu.ucan.BancoBic.entities.*;
import edu.ucan.BancoBic.repository.AgenciaBancariaRepository;
import edu.ucan.BancoBic.repository.ClienteRepository;
import edu.ucan.BancoBic.repository.ContaBancariaRepository;
import edu.ucan.BancoBic.repository.TipoContaRepository;
import edu.ucan.BancoBic.service.ContaBancariaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ContaBancariaServiceImpl implements ContaBancariaService {
    final ContaBancariaRepository contaBancariaRepository;
    final ClienteRepository clienteRepository;
    final AgenciaBancariaRepository agenciaBancariaRepository;
    final TipoContaRepository tipoContaRepository;


    public ContaBancariaServiceImpl(ContaBancariaRepository contaBancariaRepository, ClienteRepository clienteRepository, AgenciaBancariaRepository agenciaBancariaRepository, TipoContaRepository tipoContaRepository) {
        this.contaBancariaRepository = contaBancariaRepository;
        this.clienteRepository = clienteRepository;
        this.agenciaBancariaRepository = agenciaBancariaRepository;
        this.tipoContaRepository = tipoContaRepository;
    }

    @Override
    public List<ContaBancariaEntity> listarContaBancaria() {
        return contaBancariaRepository.findAll();
    }

    @Override
    public void salvar(Integer numero,String iban, UUID cliente, UUID agenciaBancaria, UUID tipoConta, Double saldo) {

        ContaBancariaEntity contaBancariaEntity = new ContaBancariaEntity();
        contaBancariaEntity.setSaldoConta(saldo);
        contaBancariaEntity.setNumeroConta(numero);
        contaBancariaEntity.setIban(iban);

        Optional<ClienteEntity> clienteEntity= this.clienteRepository.findById(cliente);
        contaBancariaEntity.setCliente(clienteEntity.get());

        Optional<AgenciaBancariaEntity> agenciaBancariaEntity= this.agenciaBancariaRepository.findById(agenciaBancaria);
        contaBancariaEntity.setAgenciaBancaria(agenciaBancariaEntity.get());

        Optional<TipoContaEntity> tipoContaEntity= this.tipoContaRepository.findById(tipoConta);
        contaBancariaEntity.setTipoConta(tipoContaEntity.get());

        contaBancariaRepository.save(contaBancariaEntity);

    }

    @Override
    public void eliminarContaBancaria(UUID id) {
        Optional<ContaBancariaEntity> contaBancariaEntity = contaBancariaRepository.findById(id);
        if(!contaBancariaEntity.isPresent())
            new Exception("Id nao encontrado");
        contaBancariaRepository.deleteById(id);

    }

    @Override
    public ContaBancariaEntity buscarPorIdContaBancaria(UUID k) {
        Optional<ContaBancariaEntity> contaBancariaEntity = contaBancariaRepository.findById(k);
        if (!contaBancariaEntity.isPresent())
            new  Exception("Id nao encontrado");
        return contaBancariaEntity.get();
    }

    @Override
    public void atualizarContaBancaria(UUID k, Integer numero,String iban, UUID cliente, UUID agenciaBancaria, UUID tipoConta, Double saldo) {

    }

    @Override
    public ContaBancariaEntity buscarContaPeloIdCliente(UUID k) {
        ContaBancariaEntity contaBancariaEntity = contaBancariaRepository.findByContaBancariaIdCliente(k);
        if (contaBancariaEntity == null)
            new  Exception("Id nao encontrado");
        return contaBancariaEntity;
    }

    @Override
    public Optional<ContaBancariaEntity> buscarContaBancariaPeloNumConta(Integer numConta) {
        Optional<ContaBancariaEntity> contaBancariaEntity = Optional.ofNullable(contaBancariaRepository.findByContaBancariaNumConta(numConta));
        if (contaBancariaEntity.get() != null)
            new  RuntimeException("O numero de Conta ja se encontra registrada");
        return  null;

    }


    @Override
    public Optional<ContaBancariaEntity> buscarContaBancariaPeloNumContaCliente(Integer numConta) {
        Optional<ContaBancariaEntity> contaBancariaEntity = Optional.ofNullable(contaBancariaRepository.findByContaBancariaNumConta(numConta));
        if (contaBancariaEntity.get() == null)
            new  RuntimeException("O numero de Conta nao se encontra registrada");
        return Optional.of(contaBancariaEntity.get());

    }

}
