CREATE DATABASE  IF NOT EXISTS `odontosys` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `odontosys`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: odontosys
-- ------------------------------------------------------
-- Server version	5.4.3-beta-community

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
-- Table structure for table `detalle_hallazgo`
--

DROP TABLE IF EXISTS `detalle_hallazgo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_hallazgo` (
  `iddetalle_hallazgo` int(11) NOT NULL AUTO_INCREMENT,
  `fk_odontograma` int(11) NOT NULL,
  `fk_hallazgo` int(11) NOT NULL,
  `fk_diente` int(11) NOT NULL,
  `sigla` varchar(4) DEFAULT NULL,
  `ubicacion` varchar(50) DEFAULT NULL,
  `especificacion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`iddetalle_hallazgo`),
  KEY `fk_odontdiente_idx` (`fk_odontograma`),
  KEY `fk_dhallazgo_idx` (`fk_hallazgo`),
  KEY `fk_dhaldient_idx` (`fk_diente`),
  CONSTRAINT `fk_dhaldient` FOREIGN KEY (`fk_diente`) REFERENCES `diente` (`iddiente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dhallazgo` FOREIGN KEY (`fk_hallazgo`) REFERENCES `hallazgo` (`idhallazgo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dhalodont` FOREIGN KEY (`fk_odontograma`) REFERENCES `odontograma` (`idodontograma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-30 11:55:46
