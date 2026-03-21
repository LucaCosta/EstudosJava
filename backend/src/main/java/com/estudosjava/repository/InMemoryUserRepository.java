package com.estudosjava.repository;

import com.estudosjava.model.AppUser;
import com.estudosjava.model.Role;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class InMemoryUserRepository {

    private final PasswordEncoder passwordEncoder;
    private final List<AppUser> users = new CopyOnWriteArrayList<>();

    public InMemoryUserRepository(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    void init() {
        users.add(new AppUser(1L, "admin", "admin@estudosjava.com", passwordEncoder.encode("admin123"), Role.ADMIN));
        users.add(new AppUser(2L, "instrutor", "instrutor@estudosjava.com", passwordEncoder.encode("instrutor123"), Role.INSTRUTOR));
        users.add(new AppUser(3L, "aluno", "aluno@estudosjava.com", passwordEncoder.encode("aluno123"), Role.ALUNO));
    }

    public Optional<AppUser> findByUsernameOrEmail(String login) {
        return users.stream()
                .filter(user -> user.username().equalsIgnoreCase(login) || user.email().equalsIgnoreCase(login))
                .findFirst();
    }
}
