package edu.ucan.BancoBic.repository;

import edu.ucan.BancoBic.entities.SexoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SexoRepository extends JpaRepository<SexoEntity, UUID> {
  
  SexoEntity findSexoEntitiesByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);
}
