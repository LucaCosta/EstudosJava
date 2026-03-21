package com.estudosjava.treinamentos.dto;

import com.estudosjava.treinamentos.domain.StatusRegistro;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TreinamentoOutput(
        Long id,
        String titulo,
        String descricao,
        Integer cargaHoraria,
        BigDecimal notaMinima,
        StatusRegistro status,
        OffsetDateTime criadoEm,
        OffsetDateTime atualizadoEm) {
}
