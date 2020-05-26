create database if not exists jugueteria;
use jugueteria;

CREATE TABLE IF NOT EXISTS `persona` (
  `IdPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(75) NOT NULL,
  `Apellido1` varchar(75) NOT NULL,
  `Apellido2` varchar(75) DEFAULT NULL,
  `DNI` varchar(9) NOT NULL,
  `email` varchar(75) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  PRIMARY KEY (`IdPersona`)
);

insert into personas values ('1','Antonio','Cadenas','Sarmiento','71528435E','acades00@estudiantes.unileon.es','1998-11-23');