package edu.ucan.BancoBci.repository;

import edu.ucan.BancoBci.entities.SexoEntity;
import edu.ucan.BancoBci.entities.TipoContaEntity;
import edu.ucan.BancoBci.entities.TipoTransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface TipoContaRepository extends JpaRepository<TipoContaEntity, UUID> {
    //@Query("select l from TipoContaEntity l where l.descricao =:descricao ")
    //Optional<TipoContaEntity> findByTipoContaEntityDescricao(@Param("descricao") String descricao);
    TipoContaEntity findTipoContaEntitiesByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);

}
