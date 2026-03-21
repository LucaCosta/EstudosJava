package com.estudosjava.treinamentos.dto;

import com.estudosjava.treinamentos.domain.StatusRegistro;
import java.time.OffsetDateTime;

public record UsuarioOutput(
        Long id,
        String nome,
        String email,
        String perfil,
        StatusRegistro status,
        OffsetDateTime criadoEm,
        OffsetDateTime atualizadoEm) {
}
