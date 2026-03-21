package com.estudosjava.treinamentos.repository;

import com.estudosjava.treinamentos.domain.Turma;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    Optional<Turma> findByCodigo(String codigo);
    List<Turma> findByDataInicioAfter(LocalDate data);
}
