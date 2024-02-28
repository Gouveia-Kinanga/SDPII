package edu.ucan.BancoBci.controller;

import edu.ucan.BancoBci.dtos.EndPointDto;
import edu.ucan.BancoBci.dtos.PegarNomeClienteDto;
import edu.ucan.BancoBci.entities.TransacaoEntity;
import edu.ucan.BancoBci.service.TransacaoService;
import io.swagger.annotations.Api;
import net.bytebuddy.asm.Advice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("api/v1/transacao")
@Api(description = "TRANSACAO", tags = "TRANSACAO")
public class TransacaController {
    final TransacaoService transacaoService;

    public TransacaController(TransacaoService transacaoService) {

        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<List<TransacaoEntity>> listar() {
        return  ResponseEntity.ok(this.transacaoService.listarTransacao());
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestParam Integer nuCotaCliente,@RequestParam  Integer nuContaBeneficiario,@RequestParam  Double valorTransferir, @RequestParam String descricao)
    {
        this.transacaoService.salvar(nuCotaCliente, nuContaBeneficiario, valorTransferir, descricao);
        return ResponseEntity.ok("Transacao salvo com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable UUID idTransacao)
    {
        this.transacaoService.eliminarTransacao(idTransacao);
        return  ResponseEntity.ok("Entidade eliminada com sucesso");
    }

    //ENDPOINT
    @GetMapping("/dados")
    public ResponseEntity<?> Endpoint(@RequestParam Integer numConta)
    {
        EndPointDto endPointDto = this.transacaoService.Endpoint(numConta);
        return ResponseEntity.ok(endPointDto);
    }

    @GetMapping("/actualizar_saldo_Conta")
    public ResponseEntity<?> actualizarconta (@RequestParam Integer numConta, @RequestParam Double valor_conta)
    {
          this.transacaoService.actualizaConta(numConta,valor_conta);
        return  ResponseEntity.ok("Saldo da Conta Actualizada com sucesso");
    }


    @GetMapping("/pegar_nome")
    public ResponseEntity<?> PegarByNome(@RequestParam Integer numConta)
    {
        PegarNomeClienteDto pegarNomeClienteDto = this.transacaoService.pegaNomebynumConta(numConta);
        return ResponseEntity.ok(pegarNomeClienteDto);
    }
}
