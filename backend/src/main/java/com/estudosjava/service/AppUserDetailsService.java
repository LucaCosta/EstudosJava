package com.estudosjava.service;

import com.estudosjava.model.AppUser;
import com.estudosjava.repository.InMemoryUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final InMemoryUserRepository userRepository;

    public AppUserDetailsService(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsernameOrEmail(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new User(
                user.username(),
                user.password(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.role().name()))
        );
    }

    public AppUser findDomainUser(String login) {
        return userRepository.findByUsernameOrEmail(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
