UPDATE TbRelatos
SET dataHourCreated = NOW()
WHERE idRelato IN (2, 3, 4, 5);