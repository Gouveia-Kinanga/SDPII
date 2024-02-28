package edu.ucan.Transacaoancaria.repository;

import edu.ucan.Transacaoancaria.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}