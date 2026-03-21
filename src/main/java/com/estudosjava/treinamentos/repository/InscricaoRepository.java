package com.estudosjava.treinamentos.repository;

import com.estudosjava.treinamentos.domain.Inscricao;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    long countByTurmaIdAndStatus(Long turmaId, com.estudosjava.treinamentos.domain.StatusRegistro status);
    Optional<Inscricao> findByUsuarioIdAndTurmaId(Long usuarioId, Long turmaId);
}
