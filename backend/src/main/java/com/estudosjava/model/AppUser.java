package com.estudosjava.model;

public record AppUser(
        Long id,
        String username,
        String email,
        String password,
        Role role
) {
}
