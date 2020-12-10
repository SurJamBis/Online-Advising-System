-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: onlinesystem
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `coursrs_has_student`
--

DROP TABLE IF EXISTS `coursrs_has_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coursrs_has_student` (
  `coursrs_ID` bigint NOT NULL,
  `student_ID` int NOT NULL,
  `ACTION` varchar(45) DEFAULT NULL,
  `Grade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`coursrs_ID`,`student_ID`),
  KEY `fk_coursrs_has_student_student1_idx` (`student_ID`),
  KEY `fk_coursrs_has_student_coursrs1_idx` (`coursrs_ID`),
  CONSTRAINT `fk_coursrs_has_student_coursrs1` FOREIGN KEY (`coursrs_ID`) REFERENCES `coursrs` (`ID`),
  CONSTRAINT `fk_coursrs_has_student_student1` FOREIGN KEY (`student_ID`) REFERENCES `student` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursrs_has_student`
--

LOCK TABLES `coursrs_has_student` WRITE;
/*!40000 ALTER TABLE `coursrs_has_student` DISABLE KEYS */;
INSERT INTO `coursrs_has_student` VALUES (5,100,'T','A'),(5,101,'T','A'),(6,100,'T','A'),(6,101,'T','A'),(7,100,'T','A'),(7,101,'T','A-'),(8,100,'T','A'),(8,101,'T','A'),(9,100,'NP',NULL),(9,101,'NP',NULL),(11,100,'NP',NULL),(11,101,'NP',NULL),(12,100,'T','A'),(12,101,'T','A'),(13,100,'NP',NULL),(13,101,'P',NULL),(14,100,'T','A'),(14,101,'T','A'),(16,100,'T','A'),(16,101,'T','A'),(17,100,'T','A'),(17,101,'T','A'),(18,100,'T','A'),(18,101,'T','A'),(19,100,'P',NULL),(19,101,'T','A'),(22,100,'P',NULL),(22,101,'P',NULL),(23,100,'NP',NULL),(23,101,'NP',NULL),(24,100,'NP',NULL),(24,101,'NP',NULL),(25,100,'T','A'),(25,101,'T','A'),(26,100,'T','A'),(26,101,'T','A'),(27,100,'P',NULL),(27,101,'P',NULL),(28,100,'P',NULL),(28,101,'P',NULL);
/*!40000 ALTER TABLE `coursrs_has_student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-09 18:15:49
