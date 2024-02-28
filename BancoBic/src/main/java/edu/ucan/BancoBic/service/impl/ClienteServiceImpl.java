package edu.ucan.BancoBic.service.impl;

import edu.ucan.BancoBic.entities.*;
import edu.ucan.BancoBic.repository.ClienteRepository;
import edu.ucan.BancoBic.service.ClienteService;
import edu.ucan.BancoBic.service.ContactosService;
import edu.ucan.BancoBic.service.PessoaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ClienteServiceImpl implements ClienteService {
    final ClienteRepository clienteRepository;
    final ContactosService contactosService;
    final PessoaService pessoaService;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ContactosService contactosService, PessoaService pessoaService) {
        this.clienteRepository = clienteRepository;
        this.contactosService = contactosService;
        this.pessoaService = pessoaService;
    }

    @Override
    public List<ClienteEntity> listarCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public void salvarCliente(UUID pessoa, UUID contacto) {
        ClienteEntity clienteEntity = new ClienteEntity();

        PessoaEntity pessoaEntity= this.pessoaService.buscarPorIdPessoa(pessoa);
        clienteEntity.setPessoa(pessoaEntity);

        ContactosEntity  contactosEntity = this.contactosService.buscarPorIdContactos(contacto);
        clienteEntity.setContactos(contactosEntity);

        clienteRepository.save(clienteEntity);
    }

    @Override
    public void eliminarCliente(UUID id) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);
        if(!clienteEntity.isPresent())
            new Exception("Id nao encontrado");
        clienteRepository.deleteById(id);

    }

    @Override
    public ClienteEntity buscarPorIdCliente(UUID k) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(k);
        if (!clienteEntity.isPresent())
            new  Exception("Id nao encontrado");
        return clienteEntity.get();
    }

    @Override
    public void atualizarCliente(UUID k, UUID idPessoa, UUID idContactos) {
        ClienteEntity clienteEntity = this.buscarPorIdCliente(k);
        PessoaEntity pessoaEntity = this.pessoaService.buscarPorIdPessoa(idPessoa);
        ContactosEntity contactosEntity = this.contactosService.buscarPorIdContactos(idContactos);
        Optional.ofNullable(pessoaEntity).ifPresent(clienteEntity::setPessoa);
        Optional.ofNullable(contactosEntity).ifPresent(clienteEntity::setContactos);
        clienteRepository.save(clienteEntity);
    }

    @Override
    public ClienteEntity buscarPeloIdPessoa(UUID k) {
        ClienteEntity clienteEntity = clienteRepository.findByClienteIdPessoa(k);
        if (clienteEntity != null)
            new  Exception("Id nao encontrado");
        return clienteEntity;


    }
}
