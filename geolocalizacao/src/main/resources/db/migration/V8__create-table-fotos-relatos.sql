-- Tabela de Fotos dos Relatos
CREATE TABLE TbFotos (
    idFoto INT AUTO_INCREMENT PRIMARY KEY,
    idRelato INT NOT NULL,
    caminhoFoto VARCHAR(255) NOT NULL,
    descricaoFoto TEXT,
    dataHourCreated DATETIME DEFAULT CURRENT_TIMESTAMP,
    dataHourChanged DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    dataHourDeleted DATETIME,
    CONSTRAINT fk_relato_foto FOREIGN KEY (idRelato) REFERENCES TbRelatos(idRelato)
);