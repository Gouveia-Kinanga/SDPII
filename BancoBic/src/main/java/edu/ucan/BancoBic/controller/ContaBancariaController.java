package edu.ucan.BancoBic.controller;

import edu.ucan.BancoBic.entities.ContaBancariaEntity;
import edu.ucan.BancoBic.service.ContaBancariaService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Controller
@RequestMapping("api/v1/conta")
@Api(description = "CONTA BANCARIA", tags = "CONTA BANCARIA")
public class ContaBancariaController {
    final ContaBancariaService contaBancariaService;

    public ContaBancariaController(ContaBancariaService contaBancariaService) {
        this.contaBancariaService = contaBancariaService;
    }

    @GetMapping
    public ResponseEntity<List<ContaBancariaEntity>> listar()
    {
        return org.springframework.http.ResponseEntity.ok(this.contaBancariaService.listarContaBancaria());
    }
    @PostMapping
    public ResponseEntity<?> salvar(@RequestParam Integer numero, @RequestParam  String iban,@RequestParam UUID cliente,@RequestParam UUID agenciaBancaria,@RequestParam UUID tipoConta, Double saldo)
    {
        this.contaBancariaService.salvar(numero,iban, cliente, agenciaBancaria, tipoConta, saldo);
        return  org.springframework.http.ResponseEntity.ok("Conta Bancaria salvo com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID idContaBancaria, @RequestParam Integer numero, @RequestParam String iban, @RequestParam(required = false) UUID idCliente, @RequestParam(required = false) UUID idAgenciaBancaria, @RequestParam(required = false) UUID idTipoConta, @RequestParam Double saldo)
    {
        this.contaBancariaService.atualizarContaBancaria(idContaBancaria,numero,iban,idCliente, idAgenciaBancaria,idTipoConta,saldo);
        return  ResponseEntity.ok("Entidade atualizada com sucesso");
    }
}
