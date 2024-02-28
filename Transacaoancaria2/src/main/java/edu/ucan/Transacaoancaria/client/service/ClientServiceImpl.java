package edu.ucan.Transacaoancaria.client.service;

import edu.ucan.Transacaoancaria.client.response.ClienteResponse;
import edu.ucan.Transacaoancaria.client.response.PegarNomeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl {
    
    private final RestTemplate restTemplate;
   
   //"http://localhost:8081/api/v1/transacao/dados?numConta=99999999"
    public ClienteResponse findbyCliente(Integer numConta)
    {
        try {
            
            HttpEntity<String> httpEntity = new HttpEntity<>(null);
            ResponseEntity<ClienteResponse> responseEntity = restTemplate.exchange("http://localhost:8081/api/v1/transacao/dados?numConta="+numConta, HttpMethod.GET, httpEntity, ClienteResponse.class);
            if (responseEntity.getBody() == null) {
                throw new Exception();
            }
            return responseEntity.getBody();
        } catch (Exception e) {
            
            throw new RuntimeException("numero de conta nao existe");
        }
    }
    
    public void atualizarSaldoCliente(Integer numConta, double saldo)
    {
        try {
            
            HttpEntity<String> httpEntity = new HttpEntity<>(null);
            ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8081/api/v1/transacao/actualizar_saldo_Conta?numConta="+numConta+"&valor_conta="+saldo, HttpMethod.GET, httpEntity, String.class);
            if (responseEntity.getBody() == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            
            throw new RuntimeException("numero de conta nao existe");
        }
    }
    
    
    public void atualizarSaldoBeneficiario(Integer numConta, double saldo)
    {
        try {
            
            HttpEntity<String> httpEntity = new HttpEntity<>(null);
            ResponseEntity<String> responseEntity = restTemplate.exchange("http://172.20.10.2:8080/api/v1/transacao/atualizar-saldo?numConta="+numConta+"&saldoTotal="+saldo, HttpMethod.GET, httpEntity, String.class);
            if (responseEntity.getBody() == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            
            throw new RuntimeException("numero de conta nao existe");
        }
    }
    
    
    public ClienteResponse findbyBeneficiario(Integer numConta)
    {
        try {
            
            HttpEntity<String> httpEntity = new HttpEntity<>(null);
            ResponseEntity<ClienteResponse> responseEntity = restTemplate.exchange("http://172.20.10.2:8080/api/v1/transacao/dados?numConta="+numConta, HttpMethod.GET, httpEntity, ClienteResponse.class);
            if (responseEntity.getBody() == null) {
                throw new Exception();
            }
            return responseEntity.getBody();
        } catch (Exception e) {
            
            throw new RuntimeException("numero de conta nao existe");
        }
    }

    public PegarNomeResponse findbyName(Integer numConta)
    {
        try {

            HttpEntity<String> httpEntity = new HttpEntity<>(null);
            ResponseEntity<PegarNomeResponse> responseEntity = restTemplate.exchange("http://localhost:8081/api/v1/transacao/pegar_nome?numConta="+numConta, HttpMethod.GET, httpEntity, PegarNomeResponse.class);
            if (responseEntity.getBody() == null) {
                throw new Exception();
            }
            return responseEntity.getBody();
        } catch (Exception e) {

            throw new RuntimeException("numero de conta nao existe");
        }
    }


    public PegarNomeResponse findbyNameBeneficiario(Integer numConta)
    {
        try {

            HttpEntity<String> httpEntity = new HttpEntity<>(null);
            ResponseEntity<PegarNomeResponse> responseEntity = restTemplate.exchange("http://localhost:8080/api/v1/transacao/pegar_nome?numConta="+numConta, HttpMethod.GET, httpEntity, PegarNomeResponse.class);
            if (responseEntity.getBody() == null) {
                throw new Exception();
            }
            return responseEntity.getBody();
        } catch (Exception e) {

            throw new RuntimeException("numero de conta nao existe");
        }
    }



}
