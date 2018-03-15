

DROP TABLE IF EXISTS `phone_number`;
CREATE TABLE `phone_number` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` char(10) NOT NULL,
  PRIMARY KEY (`id`,`phone_number`),
  UNIQUE KEY `id_UNIQUE` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `facts`;
CREATE TABLE `facts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fact` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `fact_UNIQUE` (`fact`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `fact_phone`;
CREATE TABLE `fact_phone` (
  `phone_number` int(10) NOT NULL,
  `fact` int(11) NOT NULL,
  KEY `id_idx` (`phone_number`),
  KEY `fact_idx` (`fact`),

) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
