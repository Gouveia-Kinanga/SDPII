package edu.ucan.BancoBic.repository;

import edu.ucan.BancoBic.entities.AgenciaBancariaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AgenciaBancariaRepository extends JpaRepository<AgenciaBancariaEntity, UUID> {
   // @Query("select l from AgenciaBancariaEntity l where l.descricao =:descricao ")
    //Optional<AgenciaBancariaEntity> findByAgenciaBancariaEntityDescricao(@Param("descricao") String descricao);
    AgenciaBancariaEntity findAgenciaBancariaEntityByDescricaoContainingIgnoreCase( @Param("descricao") String descricao);

}
