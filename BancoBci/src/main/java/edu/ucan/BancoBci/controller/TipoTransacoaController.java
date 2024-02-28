package edu.ucan.BancoBci.controller;

import edu.ucan.BancoBci.entities.TipoTransacaoEntity;
import edu.ucan.BancoBci.service.TipoTransacaoService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("api/v1/tipo_transacao")
@Api(description = "TIPO TRANSACAO", tags = "TIPO TRANSACAO")
public class TipoTransacoaController {
   final TipoTransacaoService tipoTransacaoService;


    public TipoTransacoaController(TipoTransacaoService tipoTransacaoService) {
        this.tipoTransacaoService = tipoTransacaoService;
    }
    @GetMapping
    public  ResponseEntity<List<TipoTransacaoEntity>> listar()
    {
        return ResponseEntity.ok(this.tipoTransacaoService.listarTipoTransacao());
        //return org.springframework.http.ResponseEntity.ok(this.tipoTransacaoService.listarTipoTransacao());
    }
    @PostMapping
    public ResponseEntity<?> salvar(@RequestParam String  descricao)
    {
        this.tipoTransacaoService.salvar(descricao);
        return  org.springframework.http.ResponseEntity.ok("Tipo Transacao salvo com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable UUID idTipoTransacao)
    {
        this.tipoTransacaoService.eliminarTipoTransacao(idTipoTransacao);
        return  ResponseEntity.ok("Entidade eliminada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID idTipoTransacao, @RequestParam  String descricao )
    {
        this.tipoTransacaoService.atualizarTipoTransacao(idTipoTransacao,descricao);
        return  ResponseEntity.ok("Entidade atualizada com sucesso");
    }
}
