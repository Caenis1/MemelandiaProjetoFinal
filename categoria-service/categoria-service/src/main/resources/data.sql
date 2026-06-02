INSERT INTO categoria_meme
(id, nome, descricao, data_cadastro, usuario_id)
VALUES
(
    next value for sequence_categoria_meme,
    'Programação',
    'Memes sobre programação',
    CURRENT_DATE,
    1
);

INSERT INTO categoria_meme
(id, nome, descricao, data_cadastro, usuario_id)
VALUES
(
    next value for sequence_categoria_meme,
    'Anime',
    'Memes sobre anime',
    CURRENT_DATE,
    1
);

INSERT INTO categoria_meme
(id, nome, descricao, data_cadastro, usuario_id)
VALUES
(
    next value for sequence_categoria_meme,
    'Esportes',
    'Memes sobre esportes',
    CURRENT_DATE,
    2
);