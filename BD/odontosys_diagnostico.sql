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
-- Table structure for table `diagnostico`
--

DROP TABLE IF EXISTS `diagnostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagnostico` (
  `idDiagnostico` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `fk_paciente` int(11) NOT NULL,
  `resumen_hallazgos` varchar(1500) NOT NULL,
  `plan_tratamiento` varchar(1500) NOT NULL,
  `tipo` varchar(45) NOT NULL DEFAULT 'Interno',
  `fk_odontog_examen` int(11) DEFAULT NULL,
  `fk_usuario` int(11) NOT NULL,
  `empresa` varchar(50) DEFAULT NULL,
  `observaciones` varchar(300) DEFAULT NULL,
  `diagnosticocol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idDiagnostico`),
  UNIQUE KEY `idDiagnostico_UNIQUE` (`idDiagnostico`),
  KEY `fk_paciente_idx` (`fk_paciente`),
  KEY `fk_odontograma_idx` (`fk_odontog_examen`),
  KEY `fk_diagpaciente_idx` (`fk_paciente`),
  KEY `fk_diagodontog_examen_idx` (`fk_odontog_examen`),
  KEY `fk_usuario_idx` (`fk_usuario`),
  KEY `fk_diagusuario_idx` (`fk_usuario`),
  CONSTRAINT `fk_diagodontog_examen` FOREIGN KEY (`fk_odontog_examen`) REFERENCES `odontograma` (`idodontograma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_diagpaciente` FOREIGN KEY (`fk_paciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_diagusuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-28 20:59:58
