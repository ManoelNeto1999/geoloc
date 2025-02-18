-- Tabela de Relatos (Problemas)
CREATE TABLE TbRelatos (
    idRelato INT AUTO_INCREMENT PRIMARY KEY,
    latitude DECIMAL(9,6) NOT NULL,
    longitude DECIMAL(9,6) NOT NULL,
    descricao TEXT NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    idCategoria INT NOT NULL,
    idStatus INT NOT NULL DEFAULT 1, -- Status inicial como "Relatado"
    dataHourCreated DATETIME DEFAULT CURRENT_TIMESTAMP,
    dataHourChanged DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    dataHourDeleted DATETIME,
    CONSTRAINT fk_categoria FOREIGN KEY (idCategoria) REFERENCES TbCategorias(idCategoria),
    CONSTRAINT fk_status FOREIGN KEY (idStatus) REFERENCES TbStatus(idStatus)
);