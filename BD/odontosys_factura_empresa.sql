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
-- Table structure for table `factura_empresa`
--

DROP TABLE IF EXISTS `factura_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura_empresa` (
  `idfactura_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `fk_empresa` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `tipo` varchar(45) NOT NULL DEFAULT 'Contado',
  `estado` varchar(45) NOT NULL DEFAULT 'Cancelado',
  `montoTotal` int(11) NOT NULL,
  `saldo` int(11) NOT NULL DEFAULT '0',
  `fk_usuario` int(11) NOT NULL,
  `fk_talonario` int(11) NOT NULL,
  `fk_movimiento_emp` int(11) NOT NULL,
  `fk_orden_empresa` int(11) NOT NULL,
  PRIMARY KEY (`idfactura_empresa`),
  KEY `fk_empfactura_idx` (`fk_empresa`),
  KEY `fk_empfacusuario_idx` (`fk_usuario`),
  KEY `fk_empfactalonario_idx` (`fk_talonario`),
  KEY `fk_empfac_ordenempresa_idx` (`fk_orden_empresa`),
  KEY `fk_empfacmovimiento_idx` (`fk_movimiento_emp`),
  CONSTRAINT `fk_empfacmovimiento` FOREIGN KEY (`fk_movimiento_emp`) REFERENCES `movimiento_empresa` (`idmovimiento_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_empfactalonario` FOREIGN KEY (`fk_talonario`) REFERENCES `talonario` (`idtalonario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_empfactura` FOREIGN KEY (`fk_empresa`) REFERENCES `empresa` (`idempresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_empfacusuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_empfac_ordenempresa` FOREIGN KEY (`fk_orden_empresa`) REFERENCES `orden_empresa` (`idorden_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION
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

-- Dump completed on 2017-11-29 10:28:39
