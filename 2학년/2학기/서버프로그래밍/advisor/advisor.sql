-- MySQL dump 10.13  Distrib 5.5.36, for Win64 (x86)
--
-- Host: localhost    Database: advisordb
-- ------------------------------------------------------
-- Server version	5.5.36

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
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `pid` int(10) unsigned NOT NULL,
  `name` varchar(10) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `office` varchar(10) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (1,'음두헌','8345','차332','서울'),(2,'정원호','8343','차339','서울'),(3,'강남희','8347','차340','서울'),(4,'임양미','8350','차342','서울'),(5,'박태정','8360','차346','일산');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `snum` int(10) unsigned NOT NULL,
  `name` varchar(10) NOT NULL,
  `id` varchar(15) NOT NULL,
  `passwd` varchar(15) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `advisor_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`snum`),
  KEY `fk_student_professor_idx` (`advisor_id`),
  CONSTRAINT `fk_student_professor` FOREIGN KEY (`advisor_id`) REFERENCES `professor` (`pid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (201610,'해원','haewon','1234','010955482',1),(2017888,'강하나','khn','kang','0102222',1),(3088888,'eum','dheum','saejin0','0102222',1),(20000000,'하하하','ha','ha','1000000000',1),(20140870,'김수린','ronica8558','rlatnfls00','0108466',3),(20141112,'김지연','jy','1234','01012345678',1),(20151132,'박수진','soojin20215','tourclub0118','112',3),(20161077,'룰루랄라','룰루','1111','0000000000',3),(20161087,'박해원','haewon','1234','01091966055',1),(20161089,'최미정','polly140911','140911','01041121905',3),(20161090,'이유나','yunayuna','yunayuna','01012345678',2),(20161092,'송영은','song','youngeun','01028880000',4),(20161093,'박영은','qkrduddms2','qlrqlr7254','01072545930',1),(20161094,'정은이','dmsdl375','wjddodan375','.01000000000',2),(20161095,'박소연','asdf1234','duksung','01012345678',2),(20161098,'이예은','dldPdms','dldPdms','01012345678',3),(20161105,'강민지','mjk','1234','01000000000',1),(20161106,'이승연','julysum','1939','01029771939',2),(20161108,'조연주','joo9610','duswn1193','01047181196',3),(20161110,'조혜영','love970922','970922','01078901234',3),(20161112,'심현정','sim1117','guswjd97','01010041004',5),(20161116,'우영주','irene096','dndudwn1996','01091160402',3),(20161122,'신혜빈','dddd','dddd','010555555555',1),(20161124,'송나연','songod109','7857','01010041004',1),(20161125,'이예은','ye20161125','ok05272016^^','01093758107',1),(20168888,'최익룡','ikkkkkkkk','456875','01098753215',1),(20169999,'김익명','ikkkk','ikkk','01002348561',1),(20181459,'이수연','dltn','1234','01012345678',1),(20191004,'천윤서','cys','cyscys','01050676630',4),(20191005,'주경연','aeong','aeong802','01099990802',1),(20191007,'강민경','12','12','123',1),(20191008,'임정민','eastfild','east192','01045451212',5),(20191010,'김규리','sisodo','1456','01056565656',5),(20191011,'조유빈','dd','1234','01001010101',3),(20191012,'김가연','gayeon','duksung','01099999999',4),(20191013,'김희진','8432','4509','01088888888',5),(20191014,'조윤경','whdbsrud7588','12345678','01077777777',4),(20191016,'최정윤','choi','123456','01012345678',5),(20191017,'이현지','guswl4174','guswl4174','01012435867',1),(20191020,'정채현','stagnationhyun','560112','01030344803',5),(20191021,'김재린','jlyn','12341234','0100000000',1),(20191023,'이지민','mumin','mumin','01012345678',3),(20191024,'이하영','gom0807','1024','01011112222',4),(20191027,'박혜린','hyeryn','hyeryn','01012011201',3),(20191028,'이자영','jayoung','1999','01022223333',1),(20191031,'김성민','sung','sung','01011112222',1),(20191035,'장혜림','halley0323','wkdgPfla0323','01012345678',3),(20191038,'장지현','jh','1234','01087654321',1),(20191039,'김명서','duksung','duksung','01011111111',3),(20191042,'이은수','dmstn','1234','01041039923',1),(20191044,'김미서','김미서','rlaaltj','01011111111',1),(20191045,'홍서연','hsy','1234','01012345678',3),(20191046,'최지우','wldnwldn','00390039','01033715389',5),(20200000,'newyear','new','new','010999999',1),(40199999,'김아무개','kim','kim','01022222',1),(2019212121,'현빈','hyun','nyun','102910291',4);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-16 13:45:28
