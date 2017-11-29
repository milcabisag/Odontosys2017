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
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(255) NOT NULL,
  `Apellidos` varchar(255) NOT NULL,
  `Nro_CI` int(11) NOT NULL,
  `Fecha_Nac` date NOT NULL,
  `Sexo` varchar(1) NOT NULL,
  `Tel_LB` varchar(20) DEFAULT NULL,
  `Tel_Cel` varchar(10) DEFAULT NULL,
  `Direccion` varchar(500) NOT NULL,
  `Ciudad` varchar(100) NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Peso` int(11) NOT NULL,
  `Enfermedades` varchar(500) NOT NULL DEFAULT 'Ninguno',
  `Medicamentos` varchar(500) NOT NULL DEFAULT 'Ninguno',
  `Alergias` varchar(500) NOT NULL DEFAULT 'Ninguno',
  `Cirugias` varchar(500) NOT NULL DEFAULT 'Ninguno',
  `Observaciones` varchar(1000) NOT NULL DEFAULT 'Ninguno',
  `estado` varchar(8) NOT NULL DEFAULT 'Activo',
  PRIMARY KEY (`idPaciente`),
  UNIQUE KEY `idPaciente_UNIQUE` (`idPaciente`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-28 20:59:18
