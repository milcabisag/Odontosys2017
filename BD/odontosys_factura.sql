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
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `idfactura` int(11) NOT NULL AUTO_INCREMENT,
  `fk_paciente` int(11) NOT NULL,
  `fk_orden` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `tipo_factura` varchar(20) NOT NULL DEFAULT 'Contado',
  `timbrado` int(11) NOT NULL,
  `nro_factura` varchar(15) NOT NULL,
  `descuento` int(11) NOT NULL DEFAULT '0',
  `estado` varchar(20) NOT NULL DEFAULT 'Cancelado',
  `monto_total` int(11) NOT NULL,
  `saldo` int(11) NOT NULL DEFAULT '0',
  `fk_usuario` int(11) NOT NULL,
  PRIMARY KEY (`idfactura`),
  KEY `fk_factpaciente_idx` (`fk_paciente`),
  KEY `fk_factorden_idx` (`fk_orden`),
  KEY `fk_facusuario_idx` (`fk_usuario`),
  CONSTRAINT `fk_factpaciente` FOREIGN KEY (`fk_paciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_factorden` FOREIGN KEY (`fk_orden`) REFERENCES `orden_servicio` (`idorden_servicio`) ON DELETE NO ACTION,
  CONSTRAINT `fk_factusuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-14 13:10:39
