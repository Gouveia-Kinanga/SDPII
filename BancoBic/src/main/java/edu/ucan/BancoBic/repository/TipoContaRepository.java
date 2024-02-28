package edu.ucan.BancoBic.repository;

import edu.ucan.BancoBic.entities.TipoContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TipoContaRepository extends JpaRepository<TipoContaEntity, UUID> {
    //@Query("select l from TipoContaEntity l where l.descricao =:descricao ")
    //Optional<TipoContaEntity> findByTipoContaEntityDescricao(@Param("descricao") String descricao);
    TipoContaEntity findTipoContaEntitiesByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);

}
