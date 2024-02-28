package edu.ucan.BancoBic.repository;

import edu.ucan.BancoBic.entities.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface TransacaoRepository extends JpaRepository<TransacaoEntity, UUID> {
    @Query("select l from TransacaoEntity l where l.descricao =:descricao ")
    Optional<TransacaoEntity> findByTransacaoEntityEntityDescricao(@Param("descricao") String descricao);

}
