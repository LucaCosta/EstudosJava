package com.estudosjava.treinamentos.service;

import com.estudosjava.treinamentos.domain.Perfil;
import com.estudosjava.treinamentos.domain.Usuario;
import com.estudosjava.treinamentos.dto.UsuarioInput;
import com.estudosjava.treinamentos.dto.UsuarioOutput;
import com.estudosjava.treinamentos.repository.PerfilRepository;
import com.estudosjava.treinamentos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PerfilRepository perfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
    }

    @Transactional
    public UsuarioOutput cadastrar(UsuarioInput input) {
        usuarioRepository.findByEmail(input.email()).ifPresent(u -> {
            throw new IllegalArgumentException("Já existe usuário com o e-mail informado.");
        });

        Perfil perfil = perfilRepository.findById(input.perfilId())
                .orElseThrow(() -> new IllegalArgumentException("Perfil não encontrado."));

        Usuario usuario = new Usuario();
        usuario.setNome(input.nome());
        usuario.setEmail(input.email());
        usuario.setPerfil(perfil);
        return DomainMapper.toOutput(usuarioRepository.save(usuario));
    }
}
