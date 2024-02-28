package edu.ucan.BancoBic.controller;

import edu.ucan.BancoBic.entities.ContactosEntity;
import edu.ucan.BancoBic.service.ContactosService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("api/v1/contacto")
@Api(description = "CONTACTO", tags = "CONTACTO")
public class ContactosController {
    final ContactosService contactosService;

    public ContactosController(ContactosService contactosService) {
        this.contactosService = contactosService;
    }
    @GetMapping
    public ResponseEntity<List<ContactosEntity>> listar()
    {
        return org.springframework.http.ResponseEntity.ok(this.contactosService.listarContactos());
    }
    @PostMapping
    public ResponseEntity<?> salvar(@RequestParam String telefone1,String telefone2,String email)
    {
        this.contactosService.salvar(telefone1, telefone2, email);
        return  org.springframework.http.ResponseEntity.ok("Contactos salvo com sucesso");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable UUID idContacto)
    {
        this.contactosService.eliminarContactos(idContacto);
        return  ResponseEntity.ok("Entidade eliminada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID idContacto, @RequestParam String contacto1, @RequestParam String contacto2, @RequestParam String email)
    {
        this.contactosService.atualizarContactos(idContacto,contacto1,contacto2,email);
        return  ResponseEntity.ok("Entidade atualizada com sucesso");
    }
}
