package com.estudosjava.treinamentos.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record TreinamentoInput(
        @NotBlank String titulo,
        @NotBlank String descricao,
        @NotNull @Min(1) Integer cargaHoraria,
        @NotNull @DecimalMin("0.0") BigDecimal notaMinima) {
}
