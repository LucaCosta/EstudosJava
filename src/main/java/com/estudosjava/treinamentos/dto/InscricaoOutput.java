package com.estudosjava.treinamentos.dto;

import com.estudosjava.treinamentos.domain.StatusRegistro;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record InscricaoOutput(
        Long id,
        Long usuarioId,
        String usuarioNome,
        Long turmaId,
        String turmaCodigo,
        BigDecimal percentualPresenca,
        BigDecimal notaFinal,
        boolean concluida,
        StatusRegistro status,
        OffsetDateTime criadoEm,
        OffsetDateTime atualizadoEm) {
}
