CREATE TABLE perfis (
    id BIGSERIAL PRIMARY KEY,
    criado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    atualizado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    status VARCHAR(20) NOT NULL,
    nome VARCHAR(80) NOT NULL UNIQUE,
    descricao VARCHAR(255)
);

CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    criado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    atualizado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    status VARCHAR(20) NOT NULL,
    nome VARCHAR(120) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    perfil_id BIGINT NOT NULL REFERENCES perfis(id)
);

CREATE TABLE treinamentos (
    id BIGSERIAL PRIMARY KEY,
    criado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    atualizado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    status VARCHAR(20) NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    descricao VARCHAR(2000) NOT NULL,
    carga_horaria INTEGER NOT NULL,
    nota_minima NUMERIC(10,2) NOT NULL
);

CREATE TABLE turmas (
    id BIGSERIAL PRIMARY KEY,
    criado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    atualizado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    status VARCHAR(20) NOT NULL,
    codigo VARCHAR(80) NOT NULL UNIQUE,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    vagas INTEGER NOT NULL,
    treinamento_id BIGINT NOT NULL REFERENCES treinamentos(id)
);

CREATE TABLE inscricoes (
    id BIGSERIAL PRIMARY KEY,
    criado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    atualizado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    status VARCHAR(20) NOT NULL,
    usuario_id BIGINT NOT NULL REFERENCES usuarios(id),
    turma_id BIGINT NOT NULL REFERENCES turmas(id),
    percentual_presenca NUMERIC(5,2) NOT NULL DEFAULT 0,
    nota_final NUMERIC(5,2),
    concluida BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT uk_inscricao_usuario_turma UNIQUE (usuario_id, turma_id)
);

CREATE TABLE certificados (
    id BIGSERIAL PRIMARY KEY,
    criado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    atualizado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    status VARCHAR(20) NOT NULL,
    codigo_validacao VARCHAR(120) NOT NULL UNIQUE,
    data_emissao DATE NOT NULL,
    usuario_id BIGINT NOT NULL REFERENCES usuarios(id),
    inscricao_id BIGINT NOT NULL UNIQUE REFERENCES inscricoes(id)
);
