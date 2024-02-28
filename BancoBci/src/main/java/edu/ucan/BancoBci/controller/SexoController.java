package edu.ucan.BancoBci.controller;

import edu.ucan.BancoBci.entities.SexoEntity;
import edu.ucan.BancoBci.service.SexoService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/v1/sexo")
@Api(description = "SEXO", tags = "SEXO")
public class SexoController {

    final SexoService sexoService;

    public SexoController(SexoService sexoService)
    {

        this.sexoService = sexoService;
    }

    @GetMapping
    public ResponseEntity<List<SexoEntity>> listar()
    {

        return ResponseEntity.ok(this.sexoService.listarSexo());
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestParam String  descricao)
    {
        SexoEntity sexo = this.sexoService.salvar(descricao);
       if ( sexo == null)
            return  ResponseEntity.ok("Entidade ja existe");
        return  new ResponseEntity<SexoEntity>(sexo,  HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable UUID idSexo)
    {
        this.sexoService.eliminarSexo(idSexo);
        return  ResponseEntity.ok("Entidade eliminada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID idSexo,@RequestParam  String descricao )
    {
        this.sexoService.atualizarSexo(idSexo,descricao);
        return  ResponseEntity.ok("Entidade atualizada com sucesso");
    }
}
