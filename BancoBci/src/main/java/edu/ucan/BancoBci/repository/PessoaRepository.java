package edu.ucan.BancoBci.repository;

import edu.ucan.BancoBci.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, UUID> {
    @Query("select p from PessoaEntity p where p.nif =:nif")
    PessoaEntity findBybuscarPorNif(@Param("nif") String nif);
}
