-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema muffins
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema muffins
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `muffins` DEFAULT CHARACTER SET latin1 ;
USE `muffins` ;

-- -----------------------------------------------------
-- Table `muffins`.`t_muffin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `muffins`.`t_muffin` (
  `id_muffin` INT(11) NOT NULL,
  `name_muffin` VARCHAR(2000) NOT NULL,
  `desc_muffin` VARCHAR(1000) NOT NULL,
  `price_muffin` INT(10) UNSIGNED NOT NULL,
  `img_muffin` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_muffin`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `muffins`.`t_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `muffins`.`t_order` (
  `id_order` INT(11) NOT NULL AUTO_INCREMENT,
  `name_order` VARCHAR(100) NOT NULL,
  `date_order` INT(11) NOT NULL,
  `phone_order` INT(11) NOT NULL,
  PRIMARY KEY (`id_order`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `muffins`.`t_muffin_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `muffins`.`t_muffin_order` (
  `id_muffin_order` INT(11) NOT NULL AUTO_INCREMENT,
  `order_id` INT(11) NOT NULL,
  `muffin_id` INT(11) NOT NULL,
  `count_muffin_order` INT(11) NOT NULL,
  `price_muffin_order` INT(11) NOT NULL,
  PRIMARY KEY (`id_muffin_order`),
  INDEX `order_idx` (`order_id` ASC),
  INDEX `muffin_idx` (`muffin_id` ASC),
  CONSTRAINT `muffin`
    FOREIGN KEY (`muffin_id`)
    REFERENCES `muffins`.`t_muffin` (`id_muffin`)
    ON UPDATE CASCADE,
  CONSTRAINT `order`
    FOREIGN KEY (`order_id`)
    REFERENCES `muffins`.`t_order` (`id_order`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE `muffins`.`t_muffin_cart` (
  `id_muffin_cart` INT NOT NULL AUTO_INCREMENT,
  `id_cart` INT NOT NULL,
  `id_muffin` INT NOT NULL,
  PRIMARY KEY (`id_muffin_cart`));

USE `muffins` ;

-- -----------------------------------------------------
-- procedure p_get_random_muffins
-- -----------------------------------------------------

USE `muffins`;
DROP procedure IF EXISTS `p_get_random_muffins`;
DELIMITER $$
USE `muffins`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_get_random_muffins`()
BEGIN
	select * from t_muffin ORDER BY RAND()  limit 3;
END$$
DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


CREATE TABLE `muffins`.`t_cart` (
  `id_cart` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id_cart`));


ALTER TABLE `muffins`.`t_muffin_cart`
CHANGE COLUMN `id_cart` `id_cart` BIGINT(20) NOT NULL ;