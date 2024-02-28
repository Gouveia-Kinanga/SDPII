package edu.ucan.BancoBci.controller;

import edu.ucan.BancoBci.entities.LocalidadeEntity;
import edu.ucan.BancoBci.service.LocalidadeService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Controller
@RequestMapping("api/v1/localidade")
@Api(description = "LOCALIDADE", tags = "LOCALIDADE")
public class LocalidadeController {
    final LocalidadeService localidadeService;

    public LocalidadeController(LocalidadeService localidadeService) {
        this.localidadeService = localidadeService;
    }

    @GetMapping
    public ResponseEntity<List<LocalidadeEntity>> listar() {
        return org.springframework.http.ResponseEntity.ok(this.localidadeService.listarLocalidade());
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestParam String descricao,@RequestParam(required = false) UUID idLocalidadePai) {
       if (this.localidadeService.salvar(descricao, idLocalidadePai) == null)
            return org.springframework.http.ResponseEntity.ok("Localidade salvo com sucesso");
        return org.springframework.http.ResponseEntity.ok("Localidade ja existe !");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable UUID idLocalidade)
    {
        this.localidadeService.eliminarLocalidade(idLocalidade);
        return  ResponseEntity.ok("Entidade eliminada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID idLocalidade,@RequestParam  String descricao, @RequestParam(required = false) UUID idLocalidadePai )
    {
        this.localidadeService.atualizarLocalidade(idLocalidade,descricao,idLocalidadePai);
        return  ResponseEntity.ok("Entidade atualizada com sucesso");
    }
}