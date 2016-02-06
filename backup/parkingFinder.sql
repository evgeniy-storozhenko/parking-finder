CREATE DATABASE  IF NOT EXISTS `parkingFinder` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `parkingFinder`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: parkingFinder
-- ------------------------------------------------------
-- Server version	5.6.23

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
-- Table structure for table `City`
--

DROP TABLE IF EXISTS `City`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `City` (
  `CITY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CITY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `City`
--

LOCK TABLES `City` WRITE;
/*!40000 ALTER TABLE `City` DISABLE KEYS */;
INSERT INTO `City` VALUES (1,'Новосибирск');
/*!40000 ALTER TABLE `City` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Parking`
--

DROP TABLE IF EXISTS `Parking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Parking` (
  `PARKING_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `lastImage` varchar(255) DEFAULT NULL,
  `lastUpdate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `city_CITY_ID` bigint(20) DEFAULT NULL,
  `coordinate_POINT_ID` bigint(20) DEFAULT NULL,
  `source_SOURCE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`PARKING_ID`),
  KEY `FK33F14B98615A9D02` (`city_CITY_ID`),
  KEY `FK33F14B9815F5E825` (`coordinate_POINT_ID`),
  KEY `FK33F14B98D7B5E7B2` (`source_SOURCE_ID`),
  CONSTRAINT `FK33F14B9815F5E825` FOREIGN KEY (`coordinate_POINT_ID`) REFERENCES `Point` (`POINT_ID`),
  CONSTRAINT `FK33F14B98615A9D02` FOREIGN KEY (`city_CITY_ID`) REFERENCES `City` (`CITY_ID`),
  CONSTRAINT `FK33F14B98D7B5E7B2` FOREIGN KEY (`source_SOURCE_ID`) REFERENCES `Source` (`SOURCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Parking`
--

LOCK TABLES `Parking` WRITE;
/*!40000 ALTER TABLE `Parking` DISABLE KEYS */;
INSERT INTO `Parking` VALUES (1,'/resources/images/records/1.jpg','2016-02-06 21:48:20','Пересечение Красного проспекта и ул.Ленина',1,1,1);
/*!40000 ALTER TABLE `Parking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ParkingPlace`
--

DROP TABLE IF EXISTS `ParkingPlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ParkingPlace` (
  `PARKING_PLACE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `empty` tinyint(1) NOT NULL,
  `rectangle_RECTANGLE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`PARKING_PLACE_ID`),
  KEY `FK9E201C4F22706BAE` (`rectangle_RECTANGLE_ID`),
  CONSTRAINT `FK9E201C4F22706BAE` FOREIGN KEY (`rectangle_RECTANGLE_ID`) REFERENCES `Rectangle` (`RECTANGLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ParkingPlace`
--

LOCK TABLES `ParkingPlace` WRITE;
/*!40000 ALTER TABLE `ParkingPlace` DISABLE KEYS */;
INSERT INTO `ParkingPlace` VALUES (1,1,1),(2,1,2);
/*!40000 ALTER TABLE `ParkingPlace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Parking_ParkingPlace`
--

DROP TABLE IF EXISTS `Parking_ParkingPlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Parking_ParkingPlace` (
  `Parking_PARKING_ID` bigint(20) NOT NULL,
  `places_PARKING_PLACE_ID` bigint(20) NOT NULL,
  UNIQUE KEY `places_PARKING_PLACE_ID` (`places_PARKING_PLACE_ID`),
  KEY `FKB22FD196CF1C1DB8` (`places_PARKING_PLACE_ID`),
  KEY `FKB22FD196A4B64225` (`Parking_PARKING_ID`),
  CONSTRAINT `FKB22FD196A4B64225` FOREIGN KEY (`Parking_PARKING_ID`) REFERENCES `Parking` (`PARKING_ID`),
  CONSTRAINT `FKB22FD196CF1C1DB8` FOREIGN KEY (`places_PARKING_PLACE_ID`) REFERENCES `ParkingPlace` (`PARKING_PLACE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Parking_ParkingPlace`
--

LOCK TABLES `Parking_ParkingPlace` WRITE;
/*!40000 ALTER TABLE `Parking_ParkingPlace` DISABLE KEYS */;
INSERT INTO `Parking_ParkingPlace` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `Parking_ParkingPlace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Point`
--

DROP TABLE IF EXISTS `Point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Point` (
  `POINT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `x` double DEFAULT NULL,
  `y` double DEFAULT NULL,
  PRIMARY KEY (`POINT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Point`
--

LOCK TABLES `Point` WRITE;
/*!40000 ALTER TABLE `Point` DISABLE KEYS */;
INSERT INTO `Point` VALUES (1,74.3,36.2),(2,30,30),(3,40,60),(4,10,10),(5,13,40),(6,130,30),(7,140,60),(8,110,10),(9,113,40);
/*!40000 ALTER TABLE `Point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Rectangle`
--

DROP TABLE IF EXISTS `Rectangle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Rectangle` (
  `RECTANGLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `maxLeft_POINT_ID` bigint(20) DEFAULT NULL,
  `maxRight_POINT_ID` bigint(20) DEFAULT NULL,
  `minLeft_POINT_ID` bigint(20) DEFAULT NULL,
  `minRight_POINT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`RECTANGLE_ID`),
  KEY `FKBA47CD4F8C496B92` (`maxLeft_POINT_ID`),
  KEY `FKBA47CD4F86EDFA65` (`maxRight_POINT_ID`),
  KEY `FKBA47CD4F887ADD64` (`minLeft_POINT_ID`),
  KEY `FKBA47CD4F10EAC2D3` (`minRight_POINT_ID`),
  CONSTRAINT `FKBA47CD4F10EAC2D3` FOREIGN KEY (`minRight_POINT_ID`) REFERENCES `Point` (`POINT_ID`),
  CONSTRAINT `FKBA47CD4F86EDFA65` FOREIGN KEY (`maxRight_POINT_ID`) REFERENCES `Point` (`POINT_ID`),
  CONSTRAINT `FKBA47CD4F887ADD64` FOREIGN KEY (`minLeft_POINT_ID`) REFERENCES `Point` (`POINT_ID`),
  CONSTRAINT `FKBA47CD4F8C496B92` FOREIGN KEY (`maxLeft_POINT_ID`) REFERENCES `Point` (`POINT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Rectangle`
--

LOCK TABLES `Rectangle` WRITE;
/*!40000 ALTER TABLE `Rectangle` DISABLE KEYS */;
INSERT INTO `Rectangle` VALUES (1,2,3,4,5),(2,6,7,8,9);
/*!40000 ALTER TABLE `Rectangle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Source`
--

DROP TABLE IF EXISTS `Source`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Source` (
  `SOURCE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SOURCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Source`
--

LOCK TABLES `Source` WRITE;
/*!40000 ALTER TABLE `Source` DISABLE KEYS */;
INSERT INTO `Source` VALUES (1,'m3u8','http://webcam.211.ru/camera54_6/index.m3u8');
/*!40000 ALTER TABLE `Source` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-06 21:54:19
