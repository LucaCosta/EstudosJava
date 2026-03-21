package com.estudosjava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DashboardController {

    @GetMapping("/public/health")
    public Map<String, String> health() {
        return Map.of("status", "ok");
    }

    @GetMapping("/admin/dashboard")
    public Map<String, String> adminDashboard() {
        return Map.of("message", "Conteúdo exclusivo para ADMIN");
    }

    @GetMapping("/instrutor/dashboard")
    public Map<String, String> instrutorDashboard() {
        return Map.of("message", "Conteúdo para ADMIN e INSTRUTOR");
    }

    @GetMapping("/aluno/dashboard")
    public Map<String, String> alunoDashboard() {
        return Map.of("message", "Conteúdo autenticado para todos os perfis");
    }
}
