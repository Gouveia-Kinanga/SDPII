package edu.ucan.BancoBic.controller;

import edu.ucan.BancoBic.entities.AgenciaBancariaEntity;
import edu.ucan.BancoBic.service.AgenciaBancariaService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Controller
@RequestMapping("api/v1/agencia")
@Api(description = "AGENCIA", tags = "AGENCIA")
public class AgenciaBancariaController {
    final AgenciaBancariaService agenciaBancariaService;

    public AgenciaBancariaController(AgenciaBancariaService agenciaBancariaService) {
        this.agenciaBancariaService = agenciaBancariaService;
    }

    @GetMapping("listar")
    public ResponseEntity<List<AgenciaBancariaEntity>> listarAgenciaBancaria()
    {
        return ResponseEntity.ok(this.agenciaBancariaService.listarAgenciaBancaria());
    }
    @PostMapping
    public ResponseEntity<?> salvarAgenciaBancaria(@RequestParam String  descricao, @RequestParam  UUID idEndereco)
    {
        //this.agenciaBancariaService.salvar(descricao, idEndereco);
        //return  ResponseEntity.ok("Agencia Bancaria salvo com sucesso");

        AgenciaBancariaEntity agenciaBancaria = this.agenciaBancariaService.salvar(descricao,idEndereco);
        if ( agenciaBancaria == null)
            return  ResponseEntity.ok("Entidade salva com sucesso");
        return  new ResponseEntity<AgenciaBancariaEntity>(agenciaBancaria,  HttpStatus.CREATED);
    }

    public ResponseEntity<?> atualizar(@PathVariable UUID idAgenciaBancaria, @RequestParam String descricao, @RequestParam(required = false) UUID idEndereco)
    {
        this.agenciaBancariaService.atualizarAgenciaBancaria(idAgenciaBancaria,descricao,idEndereco);
        return  ResponseEntity.ok("Entidade atualizada com sucesso");
    }
}
