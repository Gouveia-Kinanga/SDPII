package edu.ucan.BancoBic.controller;

import edu.ucan.BancoBic.entities.EnderecoEntity;
import edu.ucan.BancoBic.service.EnderecoService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Controller
@RequestMapping("api/v1/endereco")
@Api(description = "ENDERECO", tags = "ENDERECO")
public class EnderecoController {
    final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }
    @GetMapping
    public ResponseEntity<List<EnderecoEntity>> listar()
    {
        return org.springframework.http.ResponseEntity.ok(this.enderecoService.listarEndereco());
    }
    @PostMapping
    public ResponseEntity<?> salvar(@RequestParam(required = false) String bairro, @RequestParam(required = false)  String rua, @RequestParam(required = false)  UUID idLocalidade)
    {
        this.enderecoService.salvar(bairro,bairro, idLocalidade);
        return  org.springframework.http.ResponseEntity.ok("Endereco salvo com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable UUID idEndereco)
    {
        this.enderecoService.eliminarEndereco(idEndereco);
        return  ResponseEntity.ok("Entidade eliminada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID idEndereco, @RequestParam String bairro, @RequestParam String rua, @RequestParam(required = false) UUID idLocalidade)
    {
        this.enderecoService.atualizarEndereco(idEndereco,bairro,rua,idLocalidade);
        return  ResponseEntity.ok("Entidade atualizada com sucesso");
    }

}
