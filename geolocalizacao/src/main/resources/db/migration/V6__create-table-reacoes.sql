-- Tabela de Reações
CREATE TABLE TbReacoe (
    idReacao INT AUTO_INCREMENT PRIMARY KEY,
    idRelato INT NOT NULL,
    quantidade INT NOT NULL DEFAULT 0,
    dataHourCreated DATETIME DEFAULT CURRENT_TIMESTAMP,
    dataHourChanged DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    dataHourDeleted DATETIME,
    CONSTRAINT fk_relato FOREIGN KEY (idRelato) REFERENCES TbRelatos(idRelato)
);