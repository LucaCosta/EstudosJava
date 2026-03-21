package com.estudosjava.controller;

import com.estudosjava.dto.LoginRequest;
import com.estudosjava.dto.LoginResponse;
import com.estudosjava.model.AppUser;
import com.estudosjava.security.JwtService;
import com.estudosjava.service.AppUserDetailsService;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AppUserDetailsService userDetailsService;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager,
                          AppUserDetailsService userDetailsService,
                          JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.login(), request.password())
        );

        AppUser user = userDetailsService.findDomainUser(request.login());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.login());
        String token = jwtService.generateToken(userDetails, Map.of("role", user.role().name(), "email", user.email()));

        return new LoginResponse(token, user.username(), user.email(), user.role().name());
    }
}
