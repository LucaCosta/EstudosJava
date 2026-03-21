package com.estudosjava.dto;

public record LoginResponse(String token, String username, String email, String role) {
}
