package edu.ucan.BancoBic.controller;

import edu.ucan.BancoBic.entities.EstadoCivilEntity;
import edu.ucan.BancoBic.service.EstadoCivilService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("api/v1/estado_civil")
@Api(description = "ESTADO CIVIL ", tags = "ESTADO CIVIL")
public class EstadoCivilController {
    final EstadoCivilService estadoCivilService;

    public EstadoCivilController(EstadoCivilService estadoCivilService) {
        this.estadoCivilService = estadoCivilService;
    }
    @GetMapping
    public  ResponseEntity<List<EstadoCivilEntity>> listar()
    {
        return org.springframework.http.ResponseEntity.ok(this.estadoCivilService.listarEstadoCivil());
    }
    @PostMapping
    public ResponseEntity<?> salvar(@RequestParam String  descricao)
    {

        /*
        this.estadoCivilService.salvar(descricao);
        return  org.springframework.http.ResponseEntity.ok("Estado civil salvo com sucesso");
        */

        EstadoCivilEntity estadoCivil = this.estadoCivilService.salvar(descricao);
        if ( estadoCivil == null)
            return  ResponseEntity.ok("Estado Civil ja existe");
        return  new ResponseEntity<EstadoCivilEntity>(estadoCivil,  HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable UUID idEstadoCivil)
    {
        this.estadoCivilService.eliminarEstadoCivil(idEstadoCivil);
        return  ResponseEntity.ok("Entidade eliminada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID idEstadoCivil,@RequestParam  String descricao )
    {
        this.estadoCivilService.atualizarEstadoCivil(idEstadoCivil,descricao);
        return  ResponseEntity.ok("Entidade atualizada com sucesso");
    }
}
