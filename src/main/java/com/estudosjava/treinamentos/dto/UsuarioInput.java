package com.estudosjava.treinamentos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioInput(
        @NotBlank String nome,
        @Email @NotBlank String email,
        @NotNull Long perfilId) {
}
