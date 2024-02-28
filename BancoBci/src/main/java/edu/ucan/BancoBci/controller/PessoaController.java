package edu.ucan.BancoBci.controller;

import edu.ucan.BancoBci.entities.PessoaEntity;
import edu.ucan.BancoBci.service.PessoaService;
import io.swagger.annotations.Api;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Controller
@RequestMapping("api/v1/pessoa")
@Api(description = "PESSOA", tags = "PESSOA")
public class PessoaController {
    final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaEntity>> listar()
    {
        return org.springframework.http.ResponseEntity.ok(this.pessoaService.listarPessoa());
    }
    @PostMapping
    public ResponseEntity<?> salvar(@RequestParam String nome, @RequestParam  String nif, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataNascimento, @RequestParam  UUID sexo, @RequestParam  UUID estadoCivil, @RequestParam  UUID endereco)
    {
        this.pessoaService.salvar(nome, nif, dataNascimento, sexo, estadoCivil, endereco);
        return  org.springframework.http.ResponseEntity.ok("Pessoa salvo com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable UUID idPessoa)
    {
        this.pessoaService.eliminarPessoa(idPessoa);
        return  ResponseEntity.ok("Entidade eliminada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID idPessoa, @RequestParam String nome, @RequestParam String nif, @RequestParam Date dataNascimento, @RequestParam(required = false) UUID sexo, @RequestParam(required = false) UUID estatadoCivil, @RequestParam(required = false) UUID endereco )
    {
        this.pessoaService.atualizarPessao(idPessoa,nome,nif,dataNascimento,sexo,estatadoCivil,endereco);
        return  ResponseEntity.ok("Entidade atualizada com sucesso");
    }
}
