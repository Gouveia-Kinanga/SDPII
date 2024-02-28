package edu.ucan.BancoBci.repository;

import edu.ucan.BancoBci.entities.EstadoCivilEntity;
import edu.ucan.BancoBci.entities.SexoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface EstadoCivilRepository extends JpaRepository<EstadoCivilEntity, UUID> {
    EstadoCivilEntity findEstadoCivilEntityByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);


}
