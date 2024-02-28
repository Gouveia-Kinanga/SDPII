package edu.ucan.BancoBic.controller;

import edu.ucan.BancoBic.entities.TipoContaEntity;
import edu.ucan.BancoBic.service.TipoContaService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("api/v1/tipo_conta")
@Api(description = "TIPO CONTA", tags = "TIPO CONTA")

public class TipoContaController {
    final TipoContaService tipoContaService;

    public TipoContaController(TipoContaService tipoContaService) {

        this.tipoContaService = tipoContaService;
    }

    @GetMapping
    public ResponseEntity<List<TipoContaEntity>> listar()
    {

        return ResponseEntity.ok(this.tipoContaService.listarTipoConta());
    }

   // public ResponseEntity<List<TipoContaEntity>> listar()
    //{
      //  return org.springframework.http.ResponseEntity.ok(this.tipoContaService.listarTipoConta());
    //}
    @PostMapping
    public ResponseEntity<?> salvar(@RequestParam String  descricao)
    {
        TipoContaEntity tipConta = this.tipoContaService.salvar(descricao);
        if ( tipConta == null)
            return  ResponseEntity.ok("Entidade ja existe");
        return  new ResponseEntity<TipoContaEntity>(tipConta,  HttpStatus.CREATED);

        //this.tipoContaService.salvar(descricao);
        //return  org.springframework.http.ResponseEntity.ok("Tipo Conta salvo com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable UUID idTipoConta)
    {
        this.tipoContaService.eliminarTipoConta(idTipoConta);
        return  ResponseEntity.ok("Entidade eliminada com sucesso");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID idTipoConta,@RequestParam  String descricao )
    {
        this.tipoContaService.atualizarTipoConta(idTipoConta,descricao);
        return  ResponseEntity.ok("Entidade atualizada com sucesso");
    }
}
