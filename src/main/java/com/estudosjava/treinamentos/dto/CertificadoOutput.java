package com.estudosjava.treinamentos.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public record CertificadoOutput(
        Long id,
        String codigoValidacao,
        LocalDate dataEmissao,
        Long usuarioId,
        Long inscricaoId,
        OffsetDateTime criadoEm,
        OffsetDateTime atualizadoEm) {
}
