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
-- Table structure for table `factura_convenio`
--

DROP TABLE IF EXISTS `factura_convenio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura_convenio` (
  `idfactura_convenio` int(11) NOT NULL AUTO_INCREMENT,
  `fk_empresa` int(11) NOT NULL,
  `fk_factura` int(11) NOT NULL,
  `estado` varchar(10) NOT NULL DEFAULT 'Pendiente',
  `monto` int(11) NOT NULL,
  `fk_facturaemp` int(11) DEFAULT NULL,
  `fk_usuario` int(11) NOT NULL,
  PRIMARY KEY (`idfactura_convenio`),
  KEY `fk_pacfacturaconvenio_idx` (`fk_empresa`),
  KEY `fk_facconvenio_idx` (`fk_factura`),
  KEY `fk_factempresa_idx` (`fk_facturaemp`),
  KEY `fk_factconvusuario_idx` (`fk_usuario`),
  CONSTRAINT `fk_empfacconvenio` FOREIGN KEY (`fk_empresa`) REFERENCES `empresa` (`idempresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_facconvenio` FOREIGN KEY (`fk_factura`) REFERENCES `factura` (`idfactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_factconv_empresa` FOREIGN KEY (`fk_facturaemp`) REFERENCES `factura_empresa` (`idfactura_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_factconv_usuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
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

-- Dump completed on 2017-11-28 21:00:00
