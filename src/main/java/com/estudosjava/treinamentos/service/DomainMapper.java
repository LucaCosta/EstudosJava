package com.estudosjava.treinamentos.service;

import com.estudosjava.treinamentos.domain.Certificado;
import com.estudosjava.treinamentos.domain.Inscricao;
import com.estudosjava.treinamentos.domain.Treinamento;
import com.estudosjava.treinamentos.domain.Turma;
import com.estudosjava.treinamentos.domain.Usuario;
import com.estudosjava.treinamentos.dto.CertificadoOutput;
import com.estudosjava.treinamentos.dto.InscricaoOutput;
import com.estudosjava.treinamentos.dto.TreinamentoOutput;
import com.estudosjava.treinamentos.dto.TurmaOutput;
import com.estudosjava.treinamentos.dto.UsuarioOutput;

public final class DomainMapper {

    private DomainMapper() {
    }

    public static UsuarioOutput toOutput(Usuario usuario) {
        return new UsuarioOutput(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getPerfil().getNome(),
                usuario.getStatus(), usuario.getCriadoEm(), usuario.getAtualizadoEm());
    }

    public static TreinamentoOutput toOutput(Treinamento treinamento) {
        return new TreinamentoOutput(treinamento.getId(), treinamento.getTitulo(), treinamento.getDescricao(),
                treinamento.getCargaHoraria(), treinamento.getNotaMinima(), treinamento.getStatus(),
                treinamento.getCriadoEm(), treinamento.getAtualizadoEm());
    }

    public static TurmaOutput toOutput(Turma turma) {
        return new TurmaOutput(turma.getId(), turma.getCodigo(), turma.getDataInicio(), turma.getDataFim(), turma.getVagas(),
                turma.getTreinamento().getId(), turma.getTreinamento().getTitulo(), turma.getStatus(),
                turma.getCriadoEm(), turma.getAtualizadoEm());
    }

    public static InscricaoOutput toOutput(Inscricao inscricao) {
        return new InscricaoOutput(inscricao.getId(), inscricao.getUsuario().getId(), inscricao.getUsuario().getNome(),
                inscricao.getTurma().getId(), inscricao.getTurma().getCodigo(), inscricao.getPercentualPresenca(),
                inscricao.getNotaFinal(), inscricao.getConcluida(), inscricao.getStatus(), inscricao.getCriadoEm(),
                inscricao.getAtualizadoEm());
    }

    public static CertificadoOutput toOutput(Certificado certificado) {
        return new CertificadoOutput(certificado.getId(), certificado.getCodigoValidacao(), certificado.getDataEmissao(),
                certificado.getUsuario().getId(), certificado.getInscricao().getId(), certificado.getCriadoEm(),
                certificado.getAtualizadoEm());
    }
}
