package com.estudosjava.treinamentos.service;

import com.estudosjava.treinamentos.domain.Certificado;
import com.estudosjava.treinamentos.domain.Inscricao;
import com.estudosjava.treinamentos.domain.StatusRegistro;
import com.estudosjava.treinamentos.domain.Treinamento;
import com.estudosjava.treinamentos.domain.Turma;
import com.estudosjava.treinamentos.domain.Usuario;
import com.estudosjava.treinamentos.dto.CertificadoOutput;
import com.estudosjava.treinamentos.dto.ConclusaoInput;
import com.estudosjava.treinamentos.dto.InscricaoInput;
import com.estudosjava.treinamentos.dto.InscricaoOutput;
import com.estudosjava.treinamentos.dto.PresencaInput;
import com.estudosjava.treinamentos.repository.CertificadoRepository;
import com.estudosjava.treinamentos.repository.InscricaoRepository;
import com.estudosjava.treinamentos.repository.TurmaRepository;
import com.estudosjava.treinamentos.repository.UsuarioRepository;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InscricaoService {

    private static final java.math.BigDecimal PRESENCA_MINIMA = java.math.BigDecimal.valueOf(75);

    private final InscricaoRepository inscricaoRepository;
    private final UsuarioRepository usuarioRepository;
    private final TurmaRepository turmaRepository;
    private final CertificadoRepository certificadoRepository;

    public InscricaoService(InscricaoRepository inscricaoRepository, UsuarioRepository usuarioRepository,
            TurmaRepository turmaRepository, CertificadoRepository certificadoRepository) {
        this.inscricaoRepository = inscricaoRepository;
        this.usuarioRepository = usuarioRepository;
        this.turmaRepository = turmaRepository;
        this.certificadoRepository = certificadoRepository;
    }

    @Transactional
    public InscricaoOutput inscrever(InscricaoInput input) {
        Usuario usuario = usuarioRepository.findById(input.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
        Turma turma = turmaRepository.findById(input.turmaId())
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada."));

        inscricaoRepository.findByUsuarioIdAndTurmaId(usuario.getId(), turma.getId()).ifPresent(i -> {
            throw new IllegalArgumentException("Usuário já inscrito na turma.");
        });

        long inscricoesAtivas = inscricaoRepository.countByTurmaIdAndStatus(turma.getId(), StatusRegistro.ATIVO);
        if (inscricoesAtivas >= turma.getVagas()) {
            throw new IllegalStateException("Não há vagas disponíveis para a turma.");
        }

        Inscricao inscricao = new Inscricao();
        inscricao.setUsuario(usuario);
        inscricao.setTurma(turma);
        inscricao.setStatus(StatusRegistro.PENDENTE);
        return DomainMapper.toOutput(inscricaoRepository.save(inscricao));
    }

    @Transactional
    public InscricaoOutput registrarPresenca(Long inscricaoId, PresencaInput input) {
        Inscricao inscricao = buscarInscricao(inscricaoId);
        inscricao.setPercentualPresenca(input.percentualPresenca());
        if (input.percentualPresenca().compareTo(PRESENCA_MINIMA) >= 0 && inscricao.getStatus() == StatusRegistro.PENDENTE) {
            inscricao.setStatus(StatusRegistro.ATIVO);
        }
        return DomainMapper.toOutput(inscricaoRepository.save(inscricao));
    }

    @Transactional
    public CertificadoOutput concluir(Long inscricaoId, ConclusaoInput input) {
        Inscricao inscricao = buscarInscricao(inscricaoId);
        Treinamento treinamento = inscricao.getTurma().getTreinamento();

        if (inscricao.getPercentualPresenca().compareTo(PRESENCA_MINIMA) < 0) {
            throw new IllegalStateException("Presença insuficiente para conclusão.");
        }
        if (input.notaFinal().compareTo(treinamento.getNotaMinima()) < 0) {
            throw new IllegalStateException("Nota insuficiente para conclusão.");
        }

        inscricao.setNotaFinal(input.notaFinal());
        inscricao.setConcluida(Boolean.TRUE);
        inscricao.setStatus(StatusRegistro.CONCLUIDO);
        inscricaoRepository.save(inscricao);

        Certificado certificado = certificadoRepository.findByInscricaoId(inscricaoId).orElseGet(Certificado::new);
        certificado.setInscricao(inscricao);
        certificado.setUsuario(inscricao.getUsuario());
        certificado.setDataEmissao(LocalDate.now());
        certificado.setCodigoValidacao("CERT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        certificado.setStatus(StatusRegistro.ATIVO);
        return DomainMapper.toOutput(certificadoRepository.save(certificado));
    }

    private Inscricao buscarInscricao(Long inscricaoId) {
        return inscricaoRepository.findById(inscricaoId)
                .orElseThrow(() -> new IllegalArgumentException("Inscrição não encontrada."));
    }
}
