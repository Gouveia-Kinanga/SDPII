package edu.ucan.Transacaoancaria.repository;

import edu.ucan.Transacaoancaria.model.HistoricoTransacaoEntity;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface HistoricoTransacaoRepository extends JpaRepository<HistoricoTransacaoEntity, UUID> {

    @Query("select hist from HistoricoTransacaoEntity hist where hist.numContaCliente= :numero_conta")
   List<HistoricoTransacaoEntity>  findByNumeroConta(@Param("numero_conta") Integer numContaCliente);

}