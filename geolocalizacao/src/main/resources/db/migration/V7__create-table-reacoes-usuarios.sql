-- Tabela de Reações dos Usuários
CREATE TABLE TbReacoesUsuarios (
    idReacaoUsuario INT AUTO_INCREMENT PRIMARY KEY,
    idUsuario INT NOT NULL,
    idReacao INT NOT NULL,
    tipoReacao ENUM('curtir', 'descurtir') NOT NULL,
    dataHourCreated DATETIME DEFAULT CURRENT_TIMESTAMP,
    dataHourChanged DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    dataHourDeleted DATETIME,
    CONSTRAINT fk_usuario_reacao FOREIGN KEY (idUsuario) REFERENCES TbUsuarios(idUsuario),
    CONSTRAINT fk_reacao FOREIGN KEY (idReacao) REFERENCES TbReacoe(idReacao)
);