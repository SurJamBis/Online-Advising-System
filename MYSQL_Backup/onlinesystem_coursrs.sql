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
-- Table structure for table `coursrs`
--

DROP TABLE IF EXISTS `coursrs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coursrs` (
  `ID` bigint NOT NULL,
  `Subject` text,
  `CRN` bigint DEFAULT NULL,
  `Title` text,
  `Units` bigint DEFAULT NULL,
  `Start_Date` text,
  `End_Date` text,
  `Meeting_Time` text,
  `Location` text,
  `Instructor` text,
  `Div` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursrs`
--

LOCK TABLES `coursrs` WRITE;
/*!40000 ALTER TABLE `coursrs` DISABLE KEYS */;
INSERT INTO `coursrs` VALUES (1,'CSC',101,'Intro.to Computer Education',3,'8/24/2020','12/16/2020','TBA','INTERNET','K Amirheshmat','LD'),(2,'CSC',111,'Intro Computers And Basic',3,'8/24/2020','12/16/2020','10:00-11:15 AM','Alternativ','J Halasa','LD'),(3,'CSC',115,'Intro to Programming Concepts',3,'8/24/2020','12/16/2020','4:00-5:15 PM','Alternativ','B Smith','LD'),(4,'CSC',116,'Intro to Comp. HW & Tools',3,'8/24/2020','12/16/2020','5:30-8:15 PM','Alternativ','J Nombrado','LD'),(5,'CSC',121,'Intro To Csc And Prog I',4,'8/24/2020','12/16/2020','2:30-3:45 PM','Alternativ','M Ghyamkhah','LDR'),(6,'CSC',123,'Intro To Csc And Prog II',4,'8/24/2020','12/16/2020','3:01-4:45 PM','Alternativ','W Blankenship','LDR'),(7,'CSC',195,'Sel Topics in Computer Science',2,'8/24/2020','12/16/2020','TBA','TBA TBA','Staff','LD'),(8,'CSC',221,'Asmbly And Intro To Org',3,'8/24/2020','12/16/2020','2:30-3:45 PM','Alternativ','M McCullough','LDR'),(9,'CSC',251,'C Lang Prog And Unix',3,'8/24/2020','12/16/2020','4:00-5:15 PM','Alternativ','G Poppe','LDE'),(10,'ITC',251,'System Program in C & Unix',3,'8/24/2020','12/16/2020','4:00-5:15 PM','Alternativ','G Poppe','LD'),(11,'CSC',255,'Dynamic Web Programming',3,'8/24/2020','12/16/2020','11:30-12:45 PM','Alternativ','J Halasa','LDE'),(12,'CSC',281,'Discrete Structures',3,'8/24/2020','12/16/2020','2:30-3:45 PM','Alternativ','L Zuo','LDE'),(13,'CSC',300,'Software Development',3,'8/24/2020','12/16/2020','4:00-5:15 PM','Alternativ','H Rosenthal','LDE'),(14,'CSC',301,'Computers And Society',3,'8/24/2020','12/16/2020','11:30-12:45 PM','Alternativ','M Suchenek','URD'),(15,'ITC',310,'IT Project Management',3,'8/24/2020','12/16/2020','08:30-09:45 AM','Alternativ','W Blankenship',NULL),(16,'CSC',311,'Data Structures',3,'8/24/2020','12/16/2020','11:30-2:15 PM','Alternativ','A Jalooli','UCR'),(17,'CSC',321,'Programming Languages',3,'8/24/2020','12/16/2020','1:00-2:15 PM','Alternativ','M McCullough','UCR'),(18,'CSC',331,'Computer Organization',3,'8/24/2020','12/16/2020','7:00-9:45 PM','Alternativ','K Salehin','UCR'),(19,'CSC',341,'Operating Systems',3,'8/24/2020','12/16/2020','4:00-5:15 PM','Alternativ','B Hollister','UCR'),(20,'ITC',395,'Selected Topics',3,'8/24/2020','12/16/2020','TBA','INTERNET','P Radfar','UEL'),(21,'ITC',399,'IT Practicum',3,'8/24/2020','12/16/2020','08:30-11:15 AM','Alternativ','G Poppe','UEL'),(22,'CSC',401,'Analysis Of Algorithms',3,'8/24/2020','12/16/2020','12:00-2:45 PM','Alternativ','L Zuo','URC'),(23,'CSC',411,'Artificial Intelligence',3,'8/24/2020','12/16/2020','09:00-11:45 AM','Alternativ','R Tankelevich','UEL'),(24,'CSC',451,'Computer Networks',3,'8/24/2020','12/16/2020','4:00-5:15 PM','Alternativ','S Rahimi Moosavi','UEL'),(25,'CSC',453,'Data Management',3,'8/24/2020','12/16/2020','5:30-6:45 PM','Alternativ','A Izaddoost','UEL'),(26,'CSC',471,'Compiler Construction I',3,'8/24/2020','12/16/2020','7:00-8:15 PM','Alternativ','L Zuo','URC'),(27,'CSC',481,'Software Engineering',3,'8/24/2020','12/16/2020','5:30-6:45 PM','Alternativ','B Hollister','URC'),(28,'CSC',492,'Senior Design',3,'8/24/2020','12/16/2020','7:00-9:45 PM','Alternativ','A Chatterjee','URC'),(29,'ITC',492,'Senior Design',3,'8/24/2020','12/16/2020','7:00-9:45 PM','Alternativ','A Chatterjee',NULL),(30,'CSC',495,'Selected Topics:',3,'8/24/2020','12/16/2020','7:00-9:45 PM','Alternativ','J Han','UEL'),(31,'CSC',500,'Research Methods',3,'8/24/2020','12/16/2020','TBA','TBA TBA','Staff',NULL),(32,'CSC',501,'Design and Analysis',3,'8/24/2020','12/16/2020','7:00-9:45 PM','Alternativ','K Salehin',NULL),(33,'CSC',501,'Design and Analysis',3,'8/24/2020','12/16/2020','12:00-2:45 PM','Alternativ','L Zuo',NULL),(34,'CSC',511,'Advanced AI',3,'8/24/2020','12/16/2020','12:00-2:45 PM','Alternativ','R Tankelevich',NULL),(35,'CSC',541,'Advanced Operating',3,'8/24/2020','12/16/2020','7:00-9:45 PM','Alternativ','A Chatterjee',NULL),(36,'CSC',551,'Communications and Networks',3,'8/24/2020','12/16/2020','4:00-5:15 PM','Alternativ','S Rahimi Moosavi',NULL),(37,'CSC',553,'Advanced DBMS',3,'8/24/2020','12/16/2020','TBA','TBA TBA','Staff',NULL),(38,'CSC',581,'Adv. Software Engineering',3,'8/24/2020','12/16/2020','5:30-6:45 PM','Alternativ','R Tankelevich',NULL),(39,'CSC',582,'OO Analysis and Design',3,'8/24/2020','12/16/2020','5:30-8:15 PM','Alternativ','B Hollister',NULL),(40,'CSC',583,'Software Engineering Processes',3,'8/24/2020','12/16/2020','7:00-9:45 PM','Alternativ','J Han',NULL),(41,'CSC',590,'Master\'s Project',3,'8/24/2020','12/16/2020','08:30-09:45 AM','Alternativ','A Izaddoost',NULL),(42,'CSC',595,'Special Topics in CS',3,'8/24/2020','12/16/2020','7:00-9:45 PM','Alternativ','J Han',NULL),(43,'CSC',599,'Master\'s Thesis',3,'8/24/2020','12/16/2020','08:30-09:45 AM','Alternativ','A Izaddoost',NULL),(44,'CSC',600,'Graduate Continuation Course',1,'8/24/2020','12/16/2020','TBA','Alternativ','M Beheshti',NULL);
/*!40000 ALTER TABLE `coursrs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-09 18:15:50
