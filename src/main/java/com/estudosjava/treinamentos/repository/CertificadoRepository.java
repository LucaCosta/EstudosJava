package com.estudosjava.treinamentos.repository;

import com.estudosjava.treinamentos.domain.Certificado;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificadoRepository extends JpaRepository<Certificado, Long> {
    Optional<Certificado> findByInscricaoId(Long inscricaoId);
}
