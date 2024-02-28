package edu.ucan.Transacaoancaria.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import edu.ucan.Transacaoancaria.model.HistoricoTransacaoEntity;
import edu.ucan.Transacaoancaria.service.HistoricoTransacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico")
@Api(value = "Historico", description = "RestController do Historico", tags = {"Historico"})
public class HistoricoController {

    final HistoricoTransacaoService historicoTransacaoService;
    @Autowired
    public HistoricoController(HistoricoTransacaoService historicoTransacaoService) {
        this.historicoTransacaoService = historicoTransacaoService;
    }

    @GetMapping(value = "/listarHistorico", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HistoricoTransacaoEntity>> listarHistorico()
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.historicoTransacaoService.findAll());
    }

    @GetMapping(value = "/buscarHistoricoPorNumeroConta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HistoricoTransacaoEntity>> listarHistoricoCliente(@RequestParam Integer numConta)
    {
        List<HistoricoTransacaoEntity>  historicoTransacaoEntityList= this.historicoTransacaoService.pesquisarPeloNumConta(numConta);
        return ResponseEntity.status(HttpStatus.OK).body(historicoTransacaoEntityList);
    }

}
