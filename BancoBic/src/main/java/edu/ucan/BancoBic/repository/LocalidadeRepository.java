package edu.ucan.BancoBic.repository;

import edu.ucan.BancoBic.entities.LocalidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface LocalidadeRepository extends JpaRepository<LocalidadeEntity, UUID> {


    List<LocalidadeEntity> findLocalidadeEntityByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);

}
