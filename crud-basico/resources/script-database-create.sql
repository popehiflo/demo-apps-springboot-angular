-- -----------------------------------------------------
-- MYSQL SERVER 8.0.X
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema crud_basico
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `crud_basico`;

CREATE SCHEMA `crud_basico`;
USE `crud_basico`;

-- -----------------------------------------------------
-- Table `crud_basico`.`categoria_producto`
-- -----------------------------------------------------
/*create table categoria_producto (
	id char(32) not null,
   categoria_producto varchar(50) not null,
	primary key (id)
);*/

-- -----------------------------------------------------
-- Table `crud_basico`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS producto (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	producto VARCHAR(150) NOT NULL,
	codigo CHAR(8) NOT NULL UNIQUE,
	precio DECIMAL(13,2) DEFAULT NULL,
   /*id_categoria_producto char(32) not null references categoria_producto(id),*/
   primary key (id)
   /*key fk_categoria_producto (id_categoria_producto),*/
   /*constraint fk_categoria_producto foreign key (id_categoria_producto) references categoria_producto (id)*/
);


-- -----------------------------------------------------
-- Create new MySQL Server 8.0.X user for our crud_basico
-- -----------------------------------------------------
DROP USER IF EXISTS `crud_basico_user`;

CREATE USER 'crud_basico_user'@'localhost' IDENTIFIED BY 'crud_basico_user';
GRANT ALL PRIVILEGES ON crud_basico.* TO 'crud_basico_user'@'localhost';


ALTER USER 'crud_basico_user'@'localhost' IDENTIFIED WITH mysql_native_password BY 'crud_basico_user-123';