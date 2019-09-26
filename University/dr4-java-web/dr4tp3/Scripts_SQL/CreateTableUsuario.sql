CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id_usuario`)
);

ALTER TABLE `infnet_alex_tp3`.`usuario` 
ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE;
