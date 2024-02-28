package edu.ucan.Transacaoancaria.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucan.Transacaoancaria.client.response.ClienteResponse;
import edu.ucan.Transacaoancaria.client.response.PegarNomeResponse;
import edu.ucan.Transacaoancaria.client.service.ClientServiceImpl;
import edu.ucan.Transacaoancaria.model.Transacao;
import edu.ucan.Transacaoancaria.repository.TransacaoRepository;
import edu.ucan.Transacaoancaria.service.HistoricoTransacaoService;
import edu.ucan.Transacaoancaria.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransacaoServiceImpl implements TransacaoService
{

    final TransacaoRepository transacaoRepository;
    final ClientServiceImpl clientService;
    final KafkaTemplate<String, Transacao> kafkaTemplate;
    final HistoricoTransacaoService historicoTransacaoService;

    
    private static final String TOPIC = "meu-topico";
    @Autowired
    public TransacaoServiceImpl(TransacaoRepository transacaoRepository, ClientServiceImpl clientService, KafkaTemplate<String, Transacao> kafkaTemplate, HistoricoTransacaoService historicoTransacaoService) {
        this.transacaoRepository = transacaoRepository;
        this.clientService = clientService;
        this.kafkaTemplate = kafkaTemplate;
        this.historicoTransacaoService = historicoTransacaoService;

    }

    @Override
    public void realizarOpercao(Integer numContaCliente, Integer numContaBeneficiario, double valor, boolean isAgenciaIgual) throws JsonProcessingException {
        
        Transacao transacao = new Transacao();
        PegarNomeResponse pegarNomeCliente = this.clientService.findbyName(numContaCliente);
        PegarNomeResponse pegarNomeBeneficiario = this.clientService.findbyName(numContaBeneficiario);


        if(isAgenciaIgual==true)
        {
            ClienteResponse clienteIgual = this.clientService.findbyCliente(numContaCliente);
            ClienteResponse clienteIgual2 = this.clientService.findbyCliente(numContaBeneficiario);

            if (clienteIgual.getValor_conta() < valor)
            {
                new Exception("Saldo Insuficiente");
            } else {
                if (clienteIgual.getNumero_conta() != clienteIgual2.getNumero_conta())
                {
                    transacao.setEnviar_banco(clienteIgual.getAgencia());
                    transacao.setReceber_banco(clienteIgual2.getAgencia());
                    transacao.setMontante(valor);
                    transacao.setNumContaCliente(clienteIgual.getNumero_conta());
                    transacao.setNumContaBeneficiario(clienteIgual2.getNumero_conta());
                    transacao.setDataTransacao(LocalDateTime.now());
                    double valores =clienteIgual.getValor_conta();
                    double clienteIgualDesconto= (clienteIgual.getValor_conta()-valor);
                    this.clientService.atualizarSaldoCliente(numContaCliente,clienteIgualDesconto) ;
                    double valob=clienteIgual2.getValor_conta();
                    double clienteIgual2Acrescimo=clienteIgual2.getValor_conta()+valor;
                    double elsa = clienteIgual2Acrescimo;
                    this.clientService.atualizarSaldoCliente(numContaBeneficiario,clienteIgual2Acrescimo) ;
                    this.transacaoRepository.save(transacao);
                    this.historicoTransacaoService.SalvarHistorico(pegarNomeCliente.getNomeCliente(), clienteIgual.getNumero_conta(), pegarNomeBeneficiario.getNomeCliente(), clienteIgual2.getNumero_conta(), valor, "DEBITO/CREDITO");

                }
                else {
                    new Exception("Contas  Identicas ");
                }
            }
        }else
        {

            ClienteResponse cliente = this.clientService.findbyCliente(numContaCliente);

            ClienteResponse beneficiario = this.clientService.findbyBeneficiario(numContaBeneficiario);
            if (cliente.getValor_conta() < valor)
            {
                new Exception("Saldo Insuficiente");
            } else {
                if (cliente.getNumero_conta() != beneficiario.getNumero_conta())
                {
                    transacao.setEnviar_banco(cliente.getAgencia());
                    transacao.setReceber_banco(beneficiario.getAgencia());
                    transacao.setMontante(valor);
                    transacao.setNumContaCliente(cliente.getNumero_conta());
                    transacao.setNumContaBeneficiario(beneficiario.getNumero_conta());
                    transacao.setDataTransacao(LocalDateTime.now());
                    double valores =cliente.getValor_conta();
                    double clienteDesconto= (cliente.getValor_conta()-valor);
                    this.clientService.atualizarSaldoCliente(numContaCliente,clienteDesconto) ;
                    double valob=beneficiario.getValor_conta();
                    double beneficiarioAcrescimo=beneficiario.getValor_conta()+valor;
                    double elsa = beneficiarioAcrescimo;
                    this.clientService.atualizarSaldoBeneficiario(numContaBeneficiario,beneficiarioAcrescimo);
                    this.transacaoRepository.save(transacao);
                    this.historicoTransacaoService.SalvarHistorico(null, cliente.getNumero_conta(), null, beneficiario.getNumero_conta(), valor, "DEBITO/CREDITO");

                    //enviarMensagem(transacao);
                } else {
                    new Exception("Contas  Identicas ");
                }
            }

        }

        
    }
    
    public void enviarMensagem(Transacao transacao) throws JsonProcessingException {
        // Serializar o objeto Produto para JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String mensagem = objectMapper.writeValueAsString(transacao);
        // Enviar a mensagem JSON
        kafkaTemplate.send(TOPIC, transacao);
        System.out.println("Mensagem enviada: " + mensagem);
    }
}
