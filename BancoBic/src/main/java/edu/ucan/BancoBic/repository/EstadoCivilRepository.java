package edu.ucan.BancoBic.repository;

import edu.ucan.BancoBic.entities.EstadoCivilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EstadoCivilRepository extends JpaRepository<EstadoCivilEntity, UUID> {
    EstadoCivilEntity findEstadoCivilEntityByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);


}
