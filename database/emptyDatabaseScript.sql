CREATE DATABASE  IF NOT EXISTS `eqis` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `eqis`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: eqis
-- ------------------------------------------------------
-- Server version	5.6.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment` (
  `equipment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `DateCreated` datetime DEFAULT NULL,
  `equipmentDescription` varchar(2000) DEFAULT NULL,
  `equipmentsNumber` varchar(100) DEFAULT NULL,
  `equipmentName` varchar(100) DEFAULT NULL,
  `serialNumber` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipmentstype`
--

DROP TABLE IF EXISTS `equipmentstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipmentstype` (
  `equipmentsType_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `equipmentsTypeDescription` varchar(2000) DEFAULT NULL,
  `equipmentsTypeName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`equipmentsType_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipmentstype`
--

LOCK TABLES `equipmentstype` WRITE;
/*!40000 ALTER TABLE `equipmentstype` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipmentstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipmentstype_equipment`
--

DROP TABLE IF EXISTS `equipmentstype_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipmentstype_equipment` (
  `equipmentsType_id` bigint(20) NOT NULL,
  `equipment_id` bigint(20) NOT NULL,
  KEY `FK_ig070dw7et0sx16tf3cnuqrvj` (`equipment_id`),
  KEY `FK_qhs08ak21r090ex1uauf6d2jg` (`equipmentsType_id`),
  CONSTRAINT `FK_ig070dw7et0sx16tf3cnuqrvj` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`equipment_id`),
  CONSTRAINT `FK_qhs08ak21r090ex1uauf6d2jg` FOREIGN KEY (`equipmentsType_id`) REFERENCES `equipmentstype` (`equipmentsType_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipmentstype_equipment`
--

LOCK TABLES `equipmentstype_equipment` WRITE;
/*!40000 ALTER TABLE `equipmentstype_equipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipmentstype_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magazine`
--

DROP TABLE IF EXISTS `magazine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `magazine` (
  `magazine_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `closeDate` datetime DEFAULT NULL,
  `magazineDescription` varchar(2000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `openDate` datetime DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`magazine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magazine`
--

LOCK TABLES `magazine` WRITE;
/*!40000 ALTER TABLE `magazine` DISABLE KEYS */;
/*!40000 ALTER TABLE `magazine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magazine_equipment`
--

DROP TABLE IF EXISTS `magazine_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `magazine_equipment` (
  `magazine_id` bigint(20) NOT NULL,
  `equipment_id` bigint(20) NOT NULL,
  KEY `FK_nnjyruoupcbiuastrweq7bwxq` (`equipment_id`),
  KEY `FK_54bxyy380s0klsk1wlwcetjdy` (`magazine_id`),
  CONSTRAINT `FK_54bxyy380s0klsk1wlwcetjdy` FOREIGN KEY (`magazine_id`) REFERENCES `magazine` (`magazine_id`),
  CONSTRAINT `FK_nnjyruoupcbiuastrweq7bwxq` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magazine_equipment`
--

LOCK TABLES `magazine_equipment` WRITE;
/*!40000 ALTER TABLE `magazine_equipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `magazine_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transmissionhistory`
--

DROP TABLE IF EXISTS `transmissionhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transmissionhistory` (
  `transmisHist_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `DateCreated` datetime DEFAULT NULL,
  `acceptDate` date DEFAULT NULL,
  `equipmentDescription` varchar(2000) DEFAULT NULL,
  `rejectDate` date DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `transmisDate` date DEFAULT NULL,
  `destMagazine_id` bigint(20) DEFAULT NULL,
  `equipment_id` bigint(20) DEFAULT NULL,
  `sourceMagazine_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`transmisHist_id`),
  KEY `FK_ib3nvyvqeimgr23dkv2poq2qh` (`destMagazine_id`),
  KEY `FK_fgvfydwfe7n45l3o0v85hjexj` (`equipment_id`),
  KEY `FK_a9gp86pcgg8klxkc5worr085q` (`sourceMagazine_id`),
  CONSTRAINT `FK_a9gp86pcgg8klxkc5worr085q` FOREIGN KEY (`sourceMagazine_id`) REFERENCES `magazine` (`magazine_id`),
  CONSTRAINT `FK_fgvfydwfe7n45l3o0v85hjexj` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`equipment_id`),
  CONSTRAINT `FK_ib3nvyvqeimgr23dkv2poq2qh` FOREIGN KEY (`destMagazine_id`) REFERENCES `magazine` (`magazine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transmissionhistory`
--

LOCK TABLES `transmissionhistory` WRITE;
/*!40000 ALTER TABLE `transmissionhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `transmissionhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'eqis'
--

--
-- Dumping routines for database 'eqis'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-06 23:43:53
