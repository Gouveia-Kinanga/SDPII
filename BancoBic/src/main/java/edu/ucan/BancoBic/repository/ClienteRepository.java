package edu.ucan.BancoBic.repository;

import edu.ucan.BancoBic.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {
    @Query("select c from ClienteEntity c where c.pessoa.idPessoa =:idPessoa")
    ClienteEntity findByClienteIdPessoa(@Param("idPessoa") UUID idPessoa);
}
