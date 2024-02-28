package edu.ucan.BancoBic.repository;

import edu.ucan.BancoBic.entities.TipoContaEntity;
import edu.ucan.BancoBic.entities.TipoTransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TipoTransacaoRepository extends JpaRepository<TipoTransacaoEntity, UUID> {
    //@Query("select l from TipoTransacaoEntity l where l.descricao =:descricao ")
    //<TipoTransacaoEntity> findByTipoTransacaoEntityDescricao(@Param("descricao") String descricao);
    TipoContaEntity findTipoTransacaoEntitiesByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);

}
