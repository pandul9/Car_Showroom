-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: project_schema
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `add_services`
--

DROP TABLE IF EXISTS `add_services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `add_services` (
  `ID` varchar(5) NOT NULL,
  `Price` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Price`,`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_services`
--

LOCK TABLES `add_services` WRITE;
/*!40000 ALTER TABLE `add_services` DISABLE KEYS */;
INSERT INTO `add_services` VALUES ('5','0','Nothing'),('3','15000','Color'),('2','150000','Camera'),('4','350000','Interior'),('1','80000','Tires');
/*!40000 ALTER TABLE `add_services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `ID` varchar(5) NOT NULL,
  `Price` int NOT NULL,
  `Manufacturer` varchar(20) NOT NULL,
  `Model` varchar(15) NOT NULL,
  `In_stock` int NOT NULL,
  `Category_Name` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`,`Price`,`Category_Name`),
  UNIQUE KEY `Price_UNIQUE` (`Price`),
  KEY `fk_Car_Category_idx` (`Category_Name`),
  CONSTRAINT `fk_Car_Category` FOREIGN KEY (`Category_Name`) REFERENCES `category` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES ('1',900000,'Hyundai','Solaris',10,'Economy'),('2',957000,'Vlokswagen','Polo',9,'Economy'),('3',1700000,'KIA','K5',10,'Comfort'),('4',1473000,'Skoda','Octavia',11,'Comfort'),('5',14600000,'Mercedec','S-Class',4,'Premium'),('6',7390000,'BMW','M4',7,'Premium');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `ID` int NOT NULL,
  `Name` varchar(20) NOT NULL,
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (2,'Comfort'),(1,'Economy'),(3,'Premium');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `ID` varchar(5) NOT NULL,
  `Telephone` varchar(20) NOT NULL,
  `First Name` varchar(50) NOT NULL,
  `Middle Name` varchar(50) NOT NULL,
  `Last Name` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Telephone_UNIQUE` (`Telephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('cl1','89319218732','Vladislav','Vladimirovich','Shinshilin','shinshila_vlad@gmail.ru'),('cl2','89219903215','Alexander','Ahmatovich','Magamedov','maga_ne@mail.ru'),('cl3','89316742346','Egor','Petrovich','Kozlov','kozel_ep@yandex.ru'),('cl4','89218893213','Ali','Yakubich','Han','camry_3_5@gmail.ru'),('cl5','89218805991','Ivan','Nikolaevich','Kuleshov','ivank@mail.ru');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_has_car`
--

DROP TABLE IF EXISTS `client_has_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_has_car` (
  `Client_ID` varchar(5) NOT NULL,
  `Car_ID` varchar(5) NOT NULL,
  `Car_Price` int NOT NULL,
  `Car_Category_Name` varchar(20) NOT NULL,
  `Add_services_Price` varchar(45) NOT NULL,
  `Add_services_Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Client_ID`,`Car_ID`,`Car_Price`,`Car_Category_Name`,`Add_services_Price`,`Add_services_Name`),
  KEY `fk_Client_has_Car_Car1_idx` (`Car_ID`,`Car_Price`,`Car_Category_Name`),
  KEY `fk_Client_has_Car_Client1_idx` (`Client_ID`),
  KEY `fk_Client_has_Car_Add_services1_idx` (`Add_services_Price`,`Add_services_Name`),
  CONSTRAINT `fk_Client_has_Car_Add_services1` FOREIGN KEY (`Add_services_Price`, `Add_services_Name`) REFERENCES `add_services` (`Price`, `Name`),
  CONSTRAINT `fk_Client_has_Car_Car1` FOREIGN KEY (`Car_ID`, `Car_Price`, `Car_Category_Name`) REFERENCES `car` (`ID`, `Price`, `Category_Name`),
  CONSTRAINT `fk_Client_has_Car_Client1` FOREIGN KEY (`Client_ID`) REFERENCES `client` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_has_car`
--

LOCK TABLES `client_has_car` WRITE;
/*!40000 ALTER TABLE `client_has_car` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_has_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `Purchase amount` varchar(45) NOT NULL,
  `Employee_ID` varchar(5) NOT NULL,
  `Client_has_Car_Client_ID` varchar(5) NOT NULL,
  `Client_has_Car_Car_ID` varchar(5) NOT NULL,
  `Client_has_Car_Car_Price` int NOT NULL,
  `Client_has_Car_Car_Category_Name` varchar(20) NOT NULL,
  `Client_has_Car_Add_services_Price` varchar(45) NOT NULL,
  `Client_has_Car_Add_services_Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Purchase amount`,`Client_has_Car_Client_ID`,`Client_has_Car_Car_ID`,`Client_has_Car_Car_Price`,`Client_has_Car_Car_Category_Name`,`Client_has_Car_Add_services_Price`,`Client_has_Car_Add_services_Name`),
  KEY `fk_Contract_Employee1_idx` (`Employee_ID`),
  KEY `fk_Contract_Client_has_Car1_idx` (`Client_has_Car_Client_ID`,`Client_has_Car_Car_ID`,`Client_has_Car_Car_Price`,`Client_has_Car_Car_Category_Name`,`Client_has_Car_Add_services_Price`,`Client_has_Car_Add_services_Name`),
  CONSTRAINT `fk_Contract_Client_has_Car1` FOREIGN KEY (`Client_has_Car_Client_ID`, `Client_has_Car_Car_ID`, `Client_has_Car_Car_Price`, `Client_has_Car_Car_Category_Name`, `Client_has_Car_Add_services_Price`, `Client_has_Car_Add_services_Name`) REFERENCES `client_has_car` (`Client_ID`, `Car_ID`, `Car_Price`, `Car_Category_Name`, `Add_services_Price`, `Add_services_Name`),
  CONSTRAINT `fk_Contract_Employee1` FOREIGN KEY (`Employee_ID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `ID` varchar(5) NOT NULL,
  `Telephone` varchar(20) NOT NULL,
  `First Name` varchar(50) NOT NULL,
  `Last Name` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Position` varchar(50) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Telephone_UNIQUE` (`Telephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('e1','89218463821','Vladimir','Efremov','efr_vl@gmail.ru','Administrator','123'),('e2','89217532152','Max','Kolosov','kolosmax@yandex.ru','Administrator','321'),('e3','89993331123','Andrew','Kaoksd','kaokds@mail.ru','Administrator','111');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'project_schema'
--

--
-- Dumping routines for database 'project_schema'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-19 23:05:48
