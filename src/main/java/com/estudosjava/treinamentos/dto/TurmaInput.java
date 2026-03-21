package com.estudosjava.treinamentos.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record TurmaInput(
        @NotBlank String codigo,
        @NotNull @FutureOrPresent LocalDate dataInicio,
        @NotNull LocalDate dataFim,
        @NotNull @Min(1) Integer vagas,
        @NotNull Long treinamentoId) {
}
