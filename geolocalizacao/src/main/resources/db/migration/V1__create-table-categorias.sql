-- Tabela de Categorias
CREATE TABLE TbCategorias (
    idCategoria INT AUTO_INCREMENT PRIMARY KEY,
    nomeCategoria VARCHAR(255) NOT NULL,
    isPaga TINYINT(1) NOT NULL DEFAULT 0, -- Coluna para indicar se a categoria é paga (0 = não paga, 1 = paga)
    dataHourCreated DATETIME DEFAULT CURRENT_TIMESTAMP,
    dataHourChanged DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    dataHourDeleted DATETIME
);