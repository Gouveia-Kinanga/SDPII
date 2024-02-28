package edu.ucan.BancoBci.repository;

import edu.ucan.BancoBci.entities.ContactosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ContactosRepository extends JpaRepository<ContactosEntity, UUID> {
}
