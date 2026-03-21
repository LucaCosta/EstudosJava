package com.estudosjava.treinamentos.dto;

import jakarta.validation.constraints.NotNull;

public record InscricaoInput(@NotNull Long usuarioId, @NotNull Long turmaId) {
}
