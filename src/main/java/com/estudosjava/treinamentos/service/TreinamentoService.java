package com.estudosjava.treinamentos.service;

import com.estudosjava.treinamentos.domain.Treinamento;
import com.estudosjava.treinamentos.domain.Turma;
import com.estudosjava.treinamentos.dto.TreinamentoInput;
import com.estudosjava.treinamentos.dto.TreinamentoOutput;
import com.estudosjava.treinamentos.dto.TurmaInput;
import com.estudosjava.treinamentos.dto.TurmaOutput;
import com.estudosjava.treinamentos.repository.TreinamentoRepository;
import com.estudosjava.treinamentos.repository.TurmaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TreinamentoService {

    private final TreinamentoRepository treinamentoRepository;
    private final TurmaRepository turmaRepository;

    public TreinamentoService(TreinamentoRepository treinamentoRepository, TurmaRepository turmaRepository) {
        this.treinamentoRepository = treinamentoRepository;
        this.turmaRepository = turmaRepository;
    }

    @Transactional
    public TreinamentoOutput cadastrarTreinamento(TreinamentoInput input) {
        Treinamento treinamento = new Treinamento();
        treinamento.setTitulo(input.titulo());
        treinamento.setDescricao(input.descricao());
        treinamento.setCargaHoraria(input.cargaHoraria());
        treinamento.setNotaMinima(input.notaMinima());
        return DomainMapper.toOutput(treinamentoRepository.save(treinamento));
    }

    @Transactional
    public TurmaOutput cadastrarTurma(TurmaInput input) {
        if (input.dataFim().isBefore(input.dataInicio())) {
            throw new IllegalArgumentException("A data final da turma deve ser maior ou igual à data inicial.");
        }

        turmaRepository.findByCodigo(input.codigo()).ifPresent(t -> {
            throw new IllegalArgumentException("Já existe turma com o código informado.");
        });

        Treinamento treinamento = treinamentoRepository.findById(input.treinamentoId())
                .orElseThrow(() -> new IllegalArgumentException("Treinamento não encontrado."));

        Turma turma = new Turma();
        turma.setCodigo(input.codigo());
        turma.setDataInicio(input.dataInicio());
        turma.setDataFim(input.dataFim());
        turma.setVagas(input.vagas());
        turma.setTreinamento(treinamento);
        return DomainMapper.toOutput(turmaRepository.save(turma));
    }
}
