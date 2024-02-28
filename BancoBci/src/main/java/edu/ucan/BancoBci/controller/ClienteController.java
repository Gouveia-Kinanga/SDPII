package edu.ucan.BancoBci.controller;

import edu.ucan.BancoBci.entities.ClienteEntity;
import edu.ucan.BancoBci.service.ClienteService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Controller
@RequestMapping("api/v1/cliente")
@Api(description = "CLIENTE", tags = "CLIENTE")
public class ClienteController {
    final ClienteService clienteService;


    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> listarCliente()
    {
        return ResponseEntity.ok(this.clienteService.listarCliente());
    }
    @PostMapping
    public ResponseEntity<?> salvarCliente(@RequestParam UUID idPessoa, @RequestParam UUID idContacots)
    {
        this.clienteService.salvarCliente(idPessoa, idContacots);
        return  ResponseEntity.ok("Cliente salvo com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable UUID idCliente)
    {
        this.clienteService.eliminarCliente(idCliente);
        return  ResponseEntity.ok("Entidade eliminada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID idCliente, @RequestParam(required = false) UUID idPessoa, @RequestParam(required = false) UUID idContactos)
    {
        this.clienteService.atualizarCliente(idCliente,idPessoa,idContactos);
        return  ResponseEntity.ok("Entidade atualizada com sucesso");
    }
}
