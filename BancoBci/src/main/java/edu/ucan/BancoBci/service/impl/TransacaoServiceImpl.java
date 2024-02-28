package edu.ucan.BancoBci.service.impl;

import edu.ucan.BancoBci.dtos.EndPointDto;
import edu.ucan.BancoBci.dtos.PegarNomeClienteDto;
import edu.ucan.BancoBci.entities.*;
import edu.ucan.BancoBci.repository.ContaBancariaRepository;
import edu.ucan.BancoBci.repository.TransacaoRepository;
import edu.ucan.BancoBci.service.ClienteService;
import edu.ucan.BancoBci.service.ContaBancariaService;
import edu.ucan.BancoBci.service.PessoaService;
import edu.ucan.BancoBci.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransacaoServiceImpl implements TransacaoService {

    final TransacaoRepository transacaoRepository;
    final PessoaService pessoaService;
    final ClienteService clienteService;
    final ContaBancariaService contaBancariaService;
    final RestTemplate restTemplate;
    final ContaBancariaRepository contaBancariaRepository;



    private static final String TOPIC = "transferencia_bancaria";

    @Autowired
    private KafkaTemplate<String, TransacaoEntity> kafkaTemplate;





    @Override
    public List<TransacaoEntity> listarTransacao() {

        return transacaoRepository.findAll();
    }

    @Override
    public void salvar( Integer numeroContaCliente, Integer  numeroContaBeneficiario, Double valorTransferir, String descricao) {
        TransacaoEntity transacaoEntity = new TransacaoEntity();
        double valor = 0.0;

        Optional<ContaBancariaEntity> contaBancariaCliente = this.contaBancariaService.buscarContaBancariaPeloNumContaCliente(numeroContaCliente);
        Optional<ContaBancariaEntity> contabeneficiario =this.contaBancariaService.buscarContaBancariaPeloNumContaCliente(numeroContaBeneficiario);
        if (contaBancariaCliente.get().getSaldoConta() < valorTransferir)
            new RuntimeException("saldo insuficiente !! ");
        else
        {
            valor = contaBancariaCliente.get().getSaldoConta() - valorTransferir;

            //add conta para verificar - testar com usuarios local

            if (equals(contaBancariaCliente.get(),contabeneficiario.get()) == true)
            {
                new RuntimeException("conta bancarias iguais ");

            }
            contaBancariaCliente.get().setSaldoConta(valor);
            contaBancariaCliente.get().setOperacao("debito");
            double saldoBeneficiario=contabeneficiario.get().getSaldoConta() + valorTransferir;
            contabeneficiario.get().setSaldoConta(saldoBeneficiario);
            contabeneficiario.get().setOperacao("credito");
            transacaoEntity.setContaBancariaCliente(contaBancariaCliente.get());
            transacaoEntity.setIdBeneficiario(contabeneficiario.get().getCliente().getIdCliente());
            transacaoEntity.setNomeBeneficiario(contabeneficiario.get().getCliente().getPessoa().getNome());
            transacaoEntity.setNumeroContaBeneficiario(contabeneficiario.get().getNumeroConta());
            transacaoEntity.setIbanBeneficiario(contabeneficiario.get().getIban());
            transacaoEntity.setMontante(valorTransferir); //update do çontante do cliente
            transacaoEntity.setDataHoraTransacao(LocalDateTime.now());
            transacaoEntity.setDataExecucao(LocalDate.now());
            transacaoEntity.setDescricao(descricao);
//            transacaoEntity.setTipoTransacao(null);
            transacaoRepository.save(transacaoEntity);
          //  kafkaTemplate.send(TOPIC,transacaoEntity);
        }
    }

    private boolean equals(ContaBancariaEntity contaBancariaCliente, ContaBancariaEntity contabeneficiario) {
        if (contaBancariaCliente == contabeneficiario)
            return  true;
        return false;
    }

    @Override
    public void eliminarTransacao(UUID id) {
        Optional<TransacaoEntity> transacaoEntity = transacaoRepository.findById(id);
        if (!transacaoEntity.isPresent())
            new  Exception("Id nao encontrado");
        transacaoRepository.deleteById(id);

    }

    @Override
    public TransacaoEntity buscarPorIdTransacao(UUID k) {
        Optional<TransacaoEntity> transacaoEntity = transacaoRepository.findById(k);
        if (!transacaoEntity.isPresent())
            new  Exception("Id nao encontrado");
        return transacaoEntity.get();
    }

    @Override
    public EndPointDto Endpoint (Integer numConta)
    {
        EndPointDto endPointDto = new EndPointDto();
        Optional<ContaBancariaEntity> contaBancariaCliente = this.contaBancariaService.buscarContaBancariaPeloNumContaCliente(numConta);
        endPointDto.setNumero_conta(contaBancariaCliente.get().getNumeroConta());
        endPointDto.setValor_conta(contaBancariaCliente.get().getSaldoConta());
        endPointDto.setAgencia(contaBancariaCliente.get().getAgenciaBancaria().getDescricao());

        return endPointDto;
    }

//actyalizar o saldo da conta
    public void actualizaConta(Integer numConta, Double valor_conta)
    {
        Optional<ContaBancariaEntity> contaBancariaCliente = this.contaBancariaService.buscarContaBancariaPeloNumContaCliente(numConta);
        contaBancariaCliente.get().setSaldoConta(valor_conta);
        this.contaBancariaRepository.save(contaBancariaCliente.get());
    }

    @Override
    public PegarNomeClienteDto pegaNomebynumConta(Integer numConta) {

        Optional<ContaBancariaEntity> contaBancariaCliente = this.contaBancariaService.buscarContaBancariaPeloNumContaCliente(numConta);
        PegarNomeClienteDto pegarNomeClienteDto = new PegarNomeClienteDto();
        pegarNomeClienteDto.setNomeCliente(contaBancariaCliente.get().getCliente().getPessoa().getNome());
        return pegarNomeClienteDto;


    }


//    @KafkaListener(topics = "transferencia_bancaria", groupId = "transferencia-group")
//    public void listenToCodeDecodeKafkaTopic(String messageReceived) {
//        System.out.println("Message received is " + messageReceived);
//    }

}
