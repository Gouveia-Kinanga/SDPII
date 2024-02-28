package edu.ucan.Transacaoancaria.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.ucan.Transacaoancaria.service.TransacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@Api(value = "Transacao", description = "RestController do Transacao", tags = {"Transacao"})
public class TransacaoController {
    
    final TransacaoService transacaoService;
    @Autowired
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }
    
    @PostMapping
    @ApiOperation(value = "ENDPOINT PARA EFECTUAR A TRANSFERÊNCIA BANCÁRIAS")
    public ResponseEntity<?> transacaoContas(@RequestParam  Integer numContaCliente, @RequestParam  Integer numContaBeneficiario, @RequestParam  double valor, @RequestParam  boolean iguais) throws JsonProcessingException {
        this.transacaoService.realizarOpercao(numContaCliente,numContaBeneficiario,valor, iguais);
        
        return  ResponseEntity.ok("Transacao efectuada com sucesso ");
    }
}
