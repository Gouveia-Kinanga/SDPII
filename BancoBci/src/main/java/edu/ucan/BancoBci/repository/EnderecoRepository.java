package edu.ucan.BancoBci.repository;

import edu.ucan.BancoBci.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, UUID> {
}
