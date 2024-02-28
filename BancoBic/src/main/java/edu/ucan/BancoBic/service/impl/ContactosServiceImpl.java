package edu.ucan.BancoBic.service.impl;

import edu.ucan.BancoBic.entities.ContactosEntity;
import edu.ucan.BancoBic.repository.ContactosRepository;
import edu.ucan.BancoBic.service.ContactosService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ContactosServiceImpl implements ContactosService {
    final ContactosRepository contactosRepository;

    public ContactosServiceImpl(ContactosRepository contactosRepository) {
        this.contactosRepository = contactosRepository;
    }

    @Override
    public List<ContactosEntity> listarContactos() {
        return contactosRepository.findAll();
    }

    @Override
    public void salvar(String telefone1,String telefone2,String email ) {

        ContactosEntity contactosEntity = new ContactosEntity();
        contactosEntity.setTelefone1(telefone1);
        contactosEntity.setTelefone2(telefone2);
        contactosEntity.setEmail(email);
        contactosRepository.save(contactosEntity);

    }

    @Override
    public void eliminarContactos(UUID id) {
        Optional<ContactosEntity> contactosEntity = contactosRepository.findById(id);
        if(!contactosEntity.isPresent())
            new Exception("Id nao encontrado");
        contactosRepository.deleteById(id);

    }

    @Override
    public ContactosEntity buscarPorIdContactos(UUID k) {
        Optional<ContactosEntity> contactosEntity = contactosRepository.findById(k);
        if(!contactosEntity.isPresent())
            new Exception("Id nao encontrado");
        return contactosEntity.get();
    }

    @Override
    public void atualizarContactos(UUID k, String telefone1,String telefone2,String email ) {
        ContactosEntity contactosEntity = this.buscarPorIdContactos(k);
        Optional.ofNullable(telefone1).ifPresent(contactosEntity::setTelefone1);
        Optional.ofNullable(telefone2).ifPresent(contactosEntity::setTelefone2);
        Optional.ofNullable(email).ifPresent(contactosEntity::setEmail);
        contactosRepository.save(contactosEntity);

    }
}
