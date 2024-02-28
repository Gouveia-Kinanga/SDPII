package edu.ucan.BancoBic.service;

import edu.ucan.BancoBic.entities.ContaBancariaEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContaBancariaService {

    public List<ContaBancariaEntity> listarContaBancaria();
    public void  salvar(Integer numero,String iban, UUID cliente, UUID agenciaBancaria, UUID tipoConta, Double saldo );

    public  void eliminarContaBancaria(UUID id);

    public ContaBancariaEntity buscarPorIdContaBancaria(UUID k);

    public void atualizarContaBancaria(UUID k,Integer numero,String iban, UUID cliente, UUID agenciaBancaria, UUID tipoConta, Double saldo);

    public ContaBancariaEntity buscarContaPeloIdCliente(UUID k);
    Optional<ContaBancariaEntity> buscarContaBancariaPeloNumConta(Integer numConta);

    Optional<ContaBancariaEntity> buscarContaBancariaPeloNumContaCliente (Integer numConta);
}
