package com.estudosjava.treinamentos.repository;

import com.estudosjava.treinamentos.domain.Treinamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinamentoRepository extends JpaRepository<Treinamento, Long> {
}
