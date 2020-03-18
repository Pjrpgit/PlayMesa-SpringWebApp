-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: play_mesa
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `categoria_id` int(255) NOT NULL,
  `nombre` varchar(512) NOT NULL,
  `descripcion` varchar(1024) DEFAULT NULL,
  `imagen` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`categoria_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editorial`
--

DROP TABLE IF EXISTS `editorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editorial` (
  `editorial_id` int(255) NOT NULL,
  `nombre` varchar(512) NOT NULL,
  `descripcion` varchar(1024) DEFAULT NULL,
  `url` varchar(512) DEFAULT NULL,
  `imagen` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`editorial_id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editorial`
--

LOCK TABLES `editorial` WRITE;
/*!40000 ALTER TABLE `editorial` DISABLE KEYS */;
/*!40000 ALTER TABLE `editorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habilidad`
--

DROP TABLE IF EXISTS `habilidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habilidad` (
  `habilidad_id` int(255) NOT NULL,
  `juego_id` int(255) NOT NULL,
  `nombre` varchar(512) NOT NULL,
  `descripcion` varchar(1024) DEFAULT NULL,
  `imagen` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`habilidad_id`),
  KEY `juegofk_idx` (`juego_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habilidad`
--

LOCK TABLES `habilidad` WRITE;
/*!40000 ALTER TABLE `habilidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `habilidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juego`
--

DROP TABLE IF EXISTS `juego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `juego` (
  `juego_id` int(255) NOT NULL,
  `nombre` varchar(512) DEFAULT NULL,
  `autor` varchar(512) DEFAULT NULL,
  `categoria_id` int(255) DEFAULT NULL,
  `numero_jugadores` int(11) DEFAULT NULL,
  `editorial_id` int(255) DEFAULT NULL,
  `complejidad` enum('baja','media','alta') DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  `tematica` varchar(512) DEFAULT NULL,
  `cooperativo` tinyint(4) DEFAULT NULL,
  `edad_recomendada` int(11) DEFAULT NULL,
  `tiene_cartas` tinyint(4) DEFAULT NULL,
  `tiene_tablero` tinyint(4) DEFAULT NULL,
  `tiene_miniaturas` tinyint(4) DEFAULT NULL,
  `tiene_dados` tinyint(4) DEFAULT NULL,
  `portada` varchar(512) DEFAULT NULL,
  `tam_tablero` enum('minimo','medio','grande') DEFAULT NULL,
  PRIMARY KEY (`juego_id`),
  KEY `juegocatfk_idx` (`categoria_id`),
  KEY `juegoeditfk_idx` (`editorial_id`),
  CONSTRAINT `juegocatfk` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`categoria_id`),
  CONSTRAINT `juegoeditfk` FOREIGN KEY (`editorial_id`) REFERENCES `editorial` (`editorial_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juego`
--

LOCK TABLES `juego` WRITE;
/*!40000 ALTER TABLE `juego` DISABLE KEYS */;
/*!40000 ALTER TABLE `juego` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juego_habilidad`
--

DROP TABLE IF EXISTS `juego_habilidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `juego_habilidad` (
  `juego_id` int(255) NOT NULL,
  `habilidad_id` int(255) NOT NULL,
  `potencia_id` int(255) NOT NULL,
  `descripcion` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`potencia_id`),
  KEY `relfkjueg_idx` (`juego_id`),
  KEY `relfkhab_idx` (`habilidad_id`),
  CONSTRAINT `relfkhab` FOREIGN KEY (`habilidad_id`) REFERENCES `habilidad` (`habilidad_id`),
  CONSTRAINT `relfkjueg` FOREIGN KEY (`juego_id`) REFERENCES `juego` (`juego_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juego_habilidad`
--

LOCK TABLES `juego_habilidad` WRITE;
/*!40000 ALTER TABLE `juego_habilidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `juego_habilidad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-15 20:48:20
