package edu.ucan.BancoBic.repository;

import edu.ucan.BancoBic.entities.ContaBancariaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancariaEntity, UUID> {

    @Query("select cb from ContaBancariaEntity cb where cb.cliente.idCliente=: idCliente")
    ContaBancariaEntity findByContaBancariaIdCliente(@Param("idCliente") UUID idCliente);

    @Query("select cb from ContaBancariaEntity cb where cb.numeroConta=:numeroConta")
    ContaBancariaEntity findByContaBancariaNumConta(@Param("numeroConta") Integer numeroConta);
}
