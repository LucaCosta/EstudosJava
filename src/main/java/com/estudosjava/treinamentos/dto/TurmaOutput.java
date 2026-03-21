package com.estudosjava.treinamentos.dto;

import com.estudosjava.treinamentos.domain.StatusRegistro;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public record TurmaOutput(
        Long id,
        String codigo,
        LocalDate dataInicio,
        LocalDate dataFim,
        Integer vagas,
        Long treinamentoId,
        String treinamentoTitulo,
        StatusRegistro status,
        OffsetDateTime criadoEm,
        OffsetDateTime atualizadoEm) {
}
