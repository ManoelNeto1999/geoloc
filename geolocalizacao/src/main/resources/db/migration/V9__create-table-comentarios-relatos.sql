-- Tabela de Comentários dos Relatos
CREATE TABLE TbComentarios (
    idComentario INT AUTO_INCREMENT PRIMARY KEY,
    idUsuario INT NOT NULL,
    idRelato INT NOT NULL,
    comentario TEXT NOT NULL,
    dataHourCreated DATETIME DEFAULT CURRENT_TIMESTAMP,
    dataHourChanged DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    dataHourDeleted DATETIME,
    CONSTRAINT fk_usuario_comentario FOREIGN KEY (idUsuario) REFERENCES TbUsuarios(idUsuario),
    CONSTRAINT fk_relato_comentario FOREIGN KEY (idRelato) REFERENCES TbRelatos(idRelato)
);