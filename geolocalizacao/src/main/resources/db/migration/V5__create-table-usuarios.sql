-- Tabela de Usuários
CREATE TABLE TbUsuarios (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nomeUsuario VARCHAR(255) NOT NULL,
    emailUsuario VARCHAR(255) UNIQUE NOT NULL,
    senhaUsuario VARCHAR(255) NOT NULL,
    dataHourCreated DATETIME DEFAULT CURRENT_TIMESTAMP,
    dataHourChanged DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    dataHourDeleted DATETIME
);