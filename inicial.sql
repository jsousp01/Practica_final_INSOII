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

CREATE TABLE IF NOT EXISTS `tareas` (
  `IdTarea` int(11) NOT NULL AUTO_INCREMENT,
  `IdJuguete` int(11) NOT NULL,
  `NombreJuguete` varchar(50) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `IdPersona` int(11) NOT NULL,
  PRIMARY KEY (`IdTarea`),
  KEY `FK_Tarea_Persona` (`IdPersona`),
  CONSTRAINT `FK_Tarea_Persona` FOREIGN KEY (`IdPersona`) REFERENCES `persona` (`IdPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `usuarios` (
  `IdUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(20) NOT NULL,
  `Contrasena` varchar(50) NOT NULL,
  `UltimaConexion` datetime DEFAULT CURRENT_TIMESTAMP,
  `IdPersona` int(11) NOT NULL,
  `IdRol` int(11) NOT NULL,
  PRIMARY KEY (`IdUsuario`),
  KEY `FK_Usuario_Persona` (`IdPersona`),
  KEY `FK_Usuario_Rol` (`IdRol`),
  CONSTRAINT `FK_Usuario_Persona` FOREIGN KEY (`IdPersona`) REFERENCES `persona` (`IdPersona`),
  CONSTRAINT `FK_Usuario_Rol` FOREIGN KEY (`IdRol`) REFERENCES `roles` (`IdRol`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `roles` (
  `IdRol` int(11) NOT NULL AUTO_INCREMENT,
  `TipoUsuario` char(1) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`IdRol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `juguete` (
  `IdJuguete`int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Descripcion` VARCHAR(700) NULL,
  PRIMARY KEY (`IdJuguete`)
) ENGINE = InnoDB AUTO_INCREMENT = 8 DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `material` (
  `IdMaterial` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `IdJuguete` int(11) NOT NULL,
  PRIMARY KEY (`IdMaterial`),
  KEY `FK_Material_Juguete` (`IdJuguete`),
  CONSTRAINT `FK_Material_Juguete` FOREIGN KEY (`IdJuguete`) REFERENCES `juguete` (`IdJuguete`)
) ENGINE = InnoDB AUTO_INCREMENT = 25 DEFAULT CHARACTER SET = utf8;

insert into roles values(1, 'A', 'Admin');
insert into roles values(2, 'T', 'Trabajador');
insert into persona values ('1','Antonio','Cadenas','Sarmiento','71528435E','acades00@estudiantes.unileon.es','1998-11-23');
insert into persona values ('2','Antonio','Cadenas','Sarmiento','71528435E','acades00@estudiantes.unileon.es','1998-11-23');
insert into usuarios values (1, 'a', 'a', '2018-01-27 00:03:56', 1,1);
insert into usuarios values (2, 't', 't', '2018-01-27 00:03:56', 2,2);
insert into tareas values ('1', '1', 'Coche', '50' ,'1');