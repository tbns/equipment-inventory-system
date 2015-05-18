CREATE DATABASE equipmentInventorySystem;
USE equipmentInventorySystem;

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `equipment_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `magazine_id` INT(10) NOT NULL,
  `equipmentType_id` INT(10) NOT NULL,
  `equipmentName` VARCHAR(50) NOT NULL,
  `serialNumber` VARCHAR(20),
  `equipmentNumber` VARCHAR(20) NOT NULL,
  `description` VARCHAR(100),
  PRIMARY KEY (`equipment_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `equipmentsType`;
CREATE TABLE `equipmentsType` (
  `equipmentsType_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `equipmentsTypeName` VARCHAR(50) NOT NULL,
  `description` VARCHAR(100),
  PRIMARY KEY (`equipmentsType_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `equipmentsHistory`;
CREATE TABLE `equipmentsHistory` (
  `equipmentsHistory_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `equipment_id` INT(10) NOT NULL,
  `sourceMagazine_id` INT(10) NOT NULL,
  `destMagazine_id` INT(10) NOT NULL,
  `sourceUser_id` INT(10) NOT NULL,
  `destUser_id` INT(10) NOT NULL,
  `historyDate` DATE DEFAULT NULL,
  `acceptDate` DATE DEFAULT NULL,
  `rejectedDate` DATE DEFAULT NULL,
  `historyStatus` VARCHAR(50) NOT NULL,
  `description` VARCHAR(100),
  PRIMARY KEY (`equipmentsHistory_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `magazine`;
CREATE TABLE `magazine` (
  `magazine_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `openDate` DATE DEFAULT NULL,
  `closeDate` DATE DEFAULT NULL,
  `status` VARCHAR(20) NOT NULL,
  `description` VARCHAR(100),
  PRIMARY KEY (`magazine_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `usersType_id` INT(10) NOT NULL,
  `login` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `mobilePhone` VARCHAR(50),
  `mail` VARCHAR(80),
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `usersType`;
CREATE TABLE `usersType` (
  `usersType_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `description` VARCHAR(100),
  PRIMARY KEY (`usersType_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;