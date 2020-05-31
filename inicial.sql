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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `roles` (
  `IdRol` int(11) NOT NULL AUTO_INCREMENT,
  `TipoUsuario` char(1) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`IdRol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

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

CREATE TABLE IF NOT EXISTS `tareas` (
  `IdTarea` int(11) NOT NULL AUTO_INCREMENT,
  `IdJuguete` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `IdPersona` int(11) NOT NULL,
  PRIMARY KEY (`IdTarea`),
  KEY `FK_Tarea_Persona` (`IdPersona`),
  KEY `FK_Tarea_Juguete` (`IdJuguete`),
  CONSTRAINT `FK_Tarea_Persona` FOREIGN KEY (`IdPersona`) REFERENCES `persona` (`IdPersona`),
  CONSTRAINT `FK_Tarea_Juguete` FOREIGN KEY (`IdJuguete`) REFERENCES `juguete` (`IdJuguete`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

insert into roles values(1, 'A', 'Admin');
insert into roles values(2, 'T', 'Trabajador');
insert into persona values ('1','Antonio','Cadenas','Sarmiento','71528435E','acades00@estudiantes.unileon.es','1998-10-23');
insert into usuarios values (1, 'A', 'A', '2020-05-31 19:13:56', 1,1);
insert into persona values ('2','Jose Antonio','Sousa','Porto','71474562S','jsousp00@estudiantes.unileon.es','1998-10-31');
insert into usuarios values (2, 'J', 'J', '2020-05-31 19:13:56', 2,1);
insert into persona values ('3','Trabajador1','Uno','Uno','12345678X','random00@estudiantes.unileon.es','1988-05-16');
insert into usuarios values (3, '1', '1', '2020-05-31 19:13:56', 3,2);
insert into persona values ('4','Trabajador2','Dos','Dos','87654321X','random01@estudiantes.unileon.es','1988-05-16');
insert into usuarios values (4, '2', '2', '2020-05-31 19:13:56', 4,2);
insert into juguete values(1, 'PATRULLA CANINA SEA PATROL VEHÍCULOS ACUÁTICOS', 50, '¡La Patrulla canina marítima está lista para vigilar tierra, mar y aire! Esta figura de Paw Patrol conduce un vehículo transformable que también navega y desplegando sus alas vuela.
Reúne a los 6 adorables cachorros y vehículos de Sea Patrol para trabajar juntos como un equipo.
6 modelos diferentes. Precio unidad. Se servirán según disponibilidad.');
insert into juguete values(2, 'DC BATMAN 2 EN 1 VEHÍCULO TRANSFORMABLE BATMOVIL - BATBOAT', 25, 'El nuevo Batmobile de Batman ofrece el doble de posibilidades ya que ahora puede convertirse en una lancha para luchar contra los enemigos de Gotham City.
Cuando el puerto de Gotham City esté en peligro, convierte el Batimóvil en Batboat con un solo movimiento. Simplemente levanta la tapa de la cabina y tira.
Los personajes héroes de 10 cm (se vende por separado) pueden sentarse detrás
al volante de esta máquina.');
insert into material values(1, 'Perros Patrulla Canina', 50, 1);
insert into material values(2, 'Vehiculos Patrulla Canina', 50, 1);
insert into material values(3, 'Chasis Batmovil', 25, 2);
insert into material values(4, 'Set Ruedas Batmovil', 25, 2);
insert into material values(5, 'Batboat Batmovil', 25, 2);