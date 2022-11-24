CREATE DATABASE  IF NOT EXISTS `bakery_recipe` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bakery_recipe`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: bakery_recipe
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `account_tbl`
--

DROP TABLE IF EXISTS `account_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_tbl` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP,
  `is_actived` bit(1) DEFAULT b'1',
  `is_admin` bit(1) DEFAULT b'0',
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `FKAccount_tb597642` (`user_id`),
  CONSTRAINT `FKAccount_tb597642` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_tbl`
--

LOCK TABLES `account_tbl` WRITE;
/*!40000 ALTER TABLE `account_tbl` DISABLE KEYS */;
INSERT INTO `account_tbl` VALUES (1,1,'kmatevushev0','c0b6597f097e393bec3b7faf978f9fa1d4b84a4a12162ce71e6c8567fe8e8ce1','ppoat0@bizjournals.com','6392836763','2021-11-24 00:00:00',_binary '\0',_binary '\0'),(2,2,'gdomino1','4acdd90ee9ff419a47f662df1f5f67ce3e28805c292b5de1bc02c93ec112b4be','djanse1@imdb.com','7514845071','2021-12-07 00:00:00',_binary '\0',_binary '\0'),(3,3,'sberfoot2','40f6dd84d75616c15b1ecf39e3101916901fb592ddf35e53d4586be9fb1f9acd','tbacken2@indiegogo.com','1209354602','2022-03-11 00:00:00',_binary '',_binary '\0'),(4,4,'ecockrell3','04df6d16060130a22b7d4d35f4925726fecb732516bbbfbfdee902095e50272c','ewhitworth3@biblegateway.com','8231042914','2022-03-08 00:00:00',_binary '',_binary '\0'),(5,5,'hburchatt4','fd0aae7dcaa1b6e878f6d49f57566363fd11e758e1bffb96fcde8f369386d71c','ebeig4@hp.com','2231295353','2022-01-07 00:00:00',_binary '',_binary '\0'),(6,6,'vcanto5','f4d69716ca42a61217c26b4b6408d9bc8eebdd3d052d651428a88c6473effd8b','bmagrannell5@wikispaces.com','3524063843','2022-07-05 00:00:00',_binary '',_binary '\0'),(7,7,'mcraik6','758a0a4212ec7062c4f5e54de598d9876eb7e8944be23c9a89d162a9151f80fa','rgillion6@imdb.com','4716167742','2021-10-29 00:00:00',_binary '',_binary '\0'),(8,8,'ybooeln7','65cf232710a89061de7de6b0df4144eb6bee976479c5fda517fb8ecd60f5c3e5','bcruces7@howstuffworks.com','7176465394','2022-07-10 00:00:00',_binary '',_binary '\0'),(9,9,'kgerant8','1f199880be36b95d66d4a4f928e5f9541e62d69b23a4072c3ca65414374e5856','gmeaders8@blog.com','1737492211','2021-12-06 00:00:00',_binary '',_binary '\0'),(10,10,'sheinrici9','51a7559b3afe4d88b972316e6bf1c63f53abaa1c682d3cf52a6d0c36d5566cec','hwhitmore9@engadget.com','3632522686','2022-02-26 00:00:00',_binary '',_binary '\0'),(11,11,'ikornouseka','b291bf92d67eab0b532af3a300651ee816472b1408b056aadd115711423c8bf4','vbanghea@msn.com','7338188693','2022-04-02 00:00:00',_binary '',_binary '\0'),(12,12,'dpenhearowb','531e203aff600fc4a6436e5d35682946e7b68b1fe97349ed44273c49608e085c','hedinborob@google.co.jp','7683445620','2022-09-10 00:00:00',_binary '',_binary '\0'),(13,13,'gharriec','3dd1fb121667123eef30550780bdaa1274b593d94c87b5b8d7766a37011e92ed','gdomicoc@weibo.com','3581736912','2022-06-09 00:00:00',_binary '',_binary '\0'),(14,14,'cflatmand','1cffe8c82f779424d5b71490c09a6e700f895ff45ab89697b5f7f5f0778842fd','cmcalessd@indiegogo.com','8341668549','2021-10-03 00:00:00',_binary '',_binary '\0'),(15,15,'hpontine','d227d482543999f7fbdb4222992404339e96b4990f58830f53f4ad1ecee66ea2','cstaggee@xrea.com','9265694981','2022-03-31 00:00:00',_binary '',_binary '\0'),(16,16,'fgibbingsf','46eb25548a497e44ea219647e290518cda710e60bdf4a58b53522d4ff6340021','ecoylef@flickr.com','6048757927','2022-07-30 00:00:00',_binary '',_binary '\0'),(17,17,'croscherg','1f3ec80349c79700e712cc8cc30fc0cc1ea99ec8ebbee312cbe911eaefa3bfe7','mmicheletg@biblegateway.com','2408333517','2022-06-11 00:00:00',_binary '',_binary '\0'),(18,18,'bromeih','233aecba45835dfe093ee75854c54a0dded697f0b9aebd0632ca19220e4197e9','csouthgateh@wunderground.com','3072789754','2021-10-21 00:00:00',_binary '',_binary '\0'),(19,19,'prymmeri','20e8675a1e88154e88ff2fe120b377a16e8172c19df24be70e65720ad1215945','jveillardi@woothemes.com','8666291298','2021-11-16 00:00:00',_binary '',_binary '\0'),(20,20,'acashamj','5c867641aff224e35cc49994efae2cf5f93627f3a07e5db74b11f4163922a8de','fchallenorj@tinypic.com','6216338911','2022-02-28 00:00:00',_binary '',_binary '\0'),(21,21,'ssilcocksk','9ac8122acdd8021bed1c513a4a37cb81a75bfc9b057180dd4356758a273c89a5','sgawthorpek@nhs.uk','2192113127','2022-01-25 00:00:00',_binary '',_binary '\0'),(22,22,'ghendonsonl','9c8c4c9df5e50a0cc61f73fa316fb1ae38a436232e6a7674c0c19837faa2fdaa','otreugel@sohu.com','4385885662','2022-02-12 00:00:00',_binary '',_binary '\0'),(23,23,'aormistonm','d01733157cff2228d5f69b6b0f11179ebf19fa4c04ab94c7e6a3356f0bae896f','obonehamm@ucla.edu','6138075666','2021-12-07 00:00:00',_binary '',_binary '\0'),(24,24,'rsoltann','a9499f36e937e1c1b8a69f72a64e054d24d2fc8967219166663dded0082be7ff','nglassardn@usda.gov','8609178071','2022-03-01 00:00:00',_binary '',_binary '\0'),(25,25,'rsteggleso','361bb23d01332a5ce33f01635db8e7e95a86863bce61eeea55525419d0283dd3','cmerrikino@sbwire.com','6512238742','2022-07-29 00:00:00',_binary '',_binary '\0'),(26,26,'useedp','c91bce09036482db0bfe580af0491fb52d81ff7b683d47bdba71bcb1765e1909','ebridgettp@examiner.com','3492211725','2022-05-28 00:00:00',_binary '',_binary '\0'),(27,27,'yvaggq','3421e660e9fb47c6e8c7b6be0fdcf43c03b1b30047546a45c18854c1d5cdb235','mllewellynq@joomla.org','6656909227','2022-08-31 00:00:00',_binary '',_binary '\0'),(28,28,'cfenemorer','716e8b3df406fc3f6706d77df2b797b1f261267d1e9919aa7e4737b8442bdd70','knorkerr@twitter.com','9859225024','2021-10-09 00:00:00',_binary '',_binary '\0'),(29,29,'gwaterworths','9b62e1384c0d28ac30250f43282dc21b02041a077f2c163dae0960d79a321f7a','gcoggeshalls@vistaprint.com','2216398372','2021-09-24 00:00:00',_binary '',_binary '\0'),(30,30,'dgreenhillt','92cdd7d30877e5b0159d14cc27b492c7a7dc08b6b21a8f7ed61aa04ba9b4d379','mlaffint@ameblo.jp','3143497207','2022-06-05 00:00:00',_binary '',_binary '\0'),(31,31,'agarrettu','9e82b497ea66d826df20d51a7fb6289ba49585573d693b3f48984d4e35f15353','dblinkhornu@yelp.com','4576439182','2021-11-24 00:00:00',_binary '',_binary '\0'),(32,32,'rconwellv','6b28cc9ef0ab23579926c59ecb409eacedd771d731c29ba728a262c834bf2da7','wfozardv@linkedin.com','1526535038','2021-11-12 00:00:00',_binary '',_binary '\0'),(33,33,'ltweediew','4625f54ad50fbe3ca353260b77896013cfbe6d40baae3eeeb486e9a2a399716a','jbomanw@hp.com','7808487815','2022-01-30 00:00:00',_binary '',_binary '\0'),(34,34,'gobruenx','13da99bc8cd44329fc6575941d06c7afcde9d139c06987cd5b78bc4e378d5ad7','reynonx@gizmodo.com','8547028608','2021-11-07 00:00:00',_binary '',_binary '\0'),(35,35,'lhoonahany','4a9c2b0ad7c7384b534488ebf1c03f4989e2c1325e2d856e35b4db361926ad4d','aivanichevy@comsenz.com','5333786454','2022-01-25 00:00:00',_binary '',_binary '\0'),(36,36,'ljaneckiz','169d21968d61f24b86a190d3ccef8878ee17116b503fd3a1c50b6bd390112d32','swhacketz@sun.com','4776021371','2021-12-28 00:00:00',_binary '',_binary '\0'),(37,37,'itant10','62ce23d631a811380bf437a898c4c1cb8bbe7cd3dfd8d2782014d77243f5576d','hbanbury10@shutterfly.com','2172971639','2021-10-23 00:00:00',_binary '',_binary '\0'),(38,38,'dlouisot11','403d00d99a434415e386d1920931a0cdde26877db652eb742b2d028134cff353','rplenderleith11@csmonitor.com','4915228168','2022-08-31 00:00:00',_binary '',_binary '\0'),(39,39,'mszantho12','5c2f77ebec9259422f1891d77fb7e20cbdb950b3759520475b26f7439de5cf12','ecarrett12@goo.gl','2707378574','2022-02-02 00:00:00',_binary '',_binary '\0'),(40,40,'vgreenly13','277740ec547a6feb61be60c9b492155adf1af6325eeb1ec7bbcc2d7241551dd0','aprobet13@japanpost.jp','5427000252','2022-09-06 00:00:00',_binary '',_binary '\0'),(41,41,'ekiddy14','a03aa92fda12eeaca781f10ff3f47a1e214269df0302d4b9f176127442bad6c8','sotuohy14@cnn.com','1281021487','2022-03-09 00:00:00',_binary '',_binary '\0'),(42,42,'ggoodall15','8140bee2b61e3e87ae417617298f375784b0254a7d84ad618006544b478015a9','hscramage15@ovh.net','5076915214','2021-11-06 00:00:00',_binary '',_binary '\0'),(43,43,'jsally16','a54da54d8fba4842ec1c924ac27dbf0b664bfee0cd3f72e448c6bc3c2c8302aa','vquinnelly16@ezinearticles.com','1917782156','2022-07-02 00:00:00',_binary '',_binary '\0'),(44,44,'rboag17','9e5b2d9dbc94886240a0636a52309a750770af716f96fce316b60335c73107db','jbread17@rediff.com','9473584793','2022-02-07 00:00:00',_binary '',_binary '\0'),(45,45,'gvamplew18','e8898ec9a06d2b9a5ed020a0f5b4128dcca3703157c34cbd9f9d616684f11cc2','nbulter18@ocn.ne.jp','9728289544','2022-05-31 00:00:00',_binary '',_binary '\0'),(46,46,'ssturdey19','48535176b7f8cdc4cb776c7fa5eff9209ff545fab3b609f66b0a5172120c3556','lchambers19@wordpress.org','5163295137','2022-01-12 00:00:00',_binary '',_binary '\0'),(47,47,'gwinterburn1a','c63d7e354bc95c94b6f91ca1eb2244e2137644d767030bd6e62caa21cb8409a6','jbates1a@jigsy.com','8935108202','2022-04-01 00:00:00',_binary '',_binary '\0'),(48,48,'lrominov1b','5532ea3eeb1efd995f96768dc9a5dcd30793f70f00a3837d5e289efefddb4c5d','rkiggel1b@multiply.com','6769946925','2022-05-20 00:00:00',_binary '',_binary '\0'),(49,49,'fcowderay1c','9a89ee0a0f333d391b8c38ca3b65d2d829ef29492e954aaf60fa3d1c2a4c75d4','kwoolatt1c@flavors.me','7077417012','2022-01-19 00:00:00',_binary '',_binary '\0'),(50,50,'flexa1d','6d5f201ef479bbd6f3250274a040937980a52c04c23665e4f71f58757b738dd2','hdollimore1d@kickstarter.com','4692362862','2022-07-31 00:00:00',_binary '',_binary '\0'),(51,51,'admin','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5','ppoat0@bizjournals.com','6392836763','2021-11-24 00:00:00',_binary '',_binary ''),(52,52,'user','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5','ppoat0@bizjournals.com','6392836763','2021-11-24 00:00:00',_binary '',_binary '\0'),(53,53,'lamvo','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f',NULL,NULL,'2022-09-29 16:35:13',_binary '',_binary '\0'),(90,90,'trungthongnguyen2002@gmail.com','056fcbc2f3e516b9f0a182f65b6fd90754a0187cf73f9b3aa710269fe02da19f','trungthongnguyen2002@gmail.com',NULL,'2022-11-14 00:00:00',_binary '',_binary '\0'),(99,91,'thongnt','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f',NULL,'6392836764','2022-11-14 21:36:33',_binary '',_binary '\0'),(100,92,'anhhd','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f',NULL,'6392836765','2022-11-14 21:36:33',_binary '',_binary '\0'),(101,93,'hieuvm','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f',NULL,'6392836766','2022-11-14 21:36:33',_binary '',_binary '\0'),(102,94,'locchp','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f',NULL,'6392836767','2022-11-14 21:36:33',_binary '',_binary '\0');
/*!40000 ALTER TABLE `account_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_tbl`
--

DROP TABLE IF EXISTS `category_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_tbl` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `count_num` int DEFAULT '0',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_tbl`
--

LOCK TABLES `category_tbl` WRITE;
/*!40000 ALTER TABLE `category_tbl` DISABLE KEYS */;
INSERT INTO `category_tbl` VALUES (1,'Butter Cake',7),(2,'Pound Cake',29),(3,'Spoond',14),(4,'Angle Food',3),(5,'Chiffon',1),(6,'Baked Flow',1),(7,'Massione',0),(8,'Maintifact',0),(9,'Reavlue',0),(10,'Butter Cup',0),(11,'Massan',0),(12,'Mochii',3),(13,'Lyfful',0),(14,'Liltionm',0),(15,'Materislim',0),(16,'Bigmon',1),(17,'Kaido',0),(18,'Donotunt',0),(19,'Leaclte',0),(20,'Expperession',1),(21,'Pancake',3);
/*!40000 ALTER TABLE `category_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_tbl`
--

DROP TABLE IF EXISTS `comment_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_tbl` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `recipe_id` int NOT NULL,
  `comment_detail` text NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_actived` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`comment_id`),
  KEY `FKComment_tb970236_idx` (`recipe_id`),
  KEY `FKComment_tb988724_idx` (`user_id`),
  CONSTRAINT `FKComment_tb970236` FOREIGN KEY (`recipe_id`) REFERENCES `recipe_tbl` (`recipe_id`),
  CONSTRAINT `FKComment_tb988724` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_tbl`
--

LOCK TABLES `comment_tbl` WRITE;
/*!40000 ALTER TABLE `comment_tbl` DISABLE KEYS */;
INSERT INTO `comment_tbl` VALUES (1,53,73,'asdasdasd','2022-10-17 00:00:00','2022-10-17 00:00:00',_binary ''),(2,53,73,'asdasdasd','2022-10-17 00:00:00','2022-10-17 00:00:00',_binary ''),(3,53,73,'asdasdasd','2022-10-17 00:00:00','2022-10-17 00:00:00',_binary ''),(4,53,73,'test comment 1','2022-10-17 00:00:00','2022-10-17 00:00:00',_binary ''),(5,53,73,'test 2','2022-10-17 00:00:00','2022-10-17 00:00:00',_binary ''),(10,61,73,'bài viết triệu like oooo','2022-10-19 00:00:00','2022-10-19 00:00:00',_binary ''),(11,53,54,'test comment 1111','2022-11-01 00:00:00','2022-11-01 00:00:00',_binary ''),(12,53,54,'test comment 2','2022-11-01 00:00:00','2022-11-01 00:00:00',_binary ''),(21,86,48,'This recipe is so bad','2022-11-12 00:00:00','2022-11-12 00:00:00',_binary '\0'),(22,86,48,'This recipe is so good','2022-11-12 00:00:00','2022-11-12 00:00:00',_binary ''),(23,86,48,'This comment is testing','2022-11-12 00:00:00','2022-11-12 00:00:00',_binary '\0'),(24,86,48,'sfwefwe','2022-11-12 00:00:00','2022-11-12 00:00:00',_binary ''),(25,88,166,'Extra Light and Fluffy Pancakes\r\n','2022-11-14 00:00:00','2022-11-14 00:00:00',_binary ''),(26,88,166,'Extra Light and Fluffy Pancakes\r\n','2022-11-14 00:00:00','2022-11-14 00:00:00',_binary ''),(27,88,166,'Beat the egg whites until light and fluffy and soft peaks appear as for meringue. Add the sugar toward the end of the beating. Fold the egg whites gently into the batter with a spatula. Add milk as necessary to get the right consistency.\r\n','2022-11-14 00:00:00','2022-11-14 00:00:00',_binary '');
/*!40000 ALTER TABLE `comment_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow_tbl`
--

DROP TABLE IF EXISTS `follow_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follow_tbl` (
  `user_id` int NOT NULL,
  `user_id_followed` int NOT NULL,
  PRIMARY KEY (`user_id`,`user_id_followed`),
  KEY `FKFollow_tbl382277` (`user_id_followed`),
  CONSTRAINT `FKFollow_tbl382277` FOREIGN KEY (`user_id_followed`) REFERENCES `user_tbl` (`user_id`),
  CONSTRAINT `FKFollow_tbl6137` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow_tbl`
--

LOCK TABLES `follow_tbl` WRITE;
/*!40000 ALTER TABLE `follow_tbl` DISABLE KEYS */;
INSERT INTO `follow_tbl` VALUES (53,48),(86,53),(88,53),(91,53);
/*!40000 ALTER TABLE `follow_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image_tbl`
--

DROP TABLE IF EXISTS `image_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_tbl` (
  `img_id` int NOT NULL AUTO_INCREMENT,
  `recipe_id` int NOT NULL,
  `img_link` varchar(500) NOT NULL,
  PRIMARY KEY (`img_id`),
  KEY `FKImage_tbl397680` (`recipe_id`),
  CONSTRAINT `FKImage_tbl397680` FOREIGN KEY (`recipe_id`) REFERENCES `recipe_tbl` (`recipe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_tbl`
--

LOCK TABLES `image_tbl` WRITE;
/*!40000 ALTER TABLE `image_tbl` DISABLE KEYS */;
INSERT INTO `image_tbl` VALUES (31,31,'https://monngonmoingay.com/wp-content/uploads/2019/12/pancake-bap-500.jpg'),(32,32,'https://cdnsg.kilala.vn/data/upload/article/6217/daifukumochi.jpg'),(33,33,'https://toplist.vn/images/800px/dia-chi-ban-banh-donut-sieu-hap-dan-tai-tphcm-801789.jpg'),(34,34,'https://media.loveitopcdn.com/22184/28.jpg'),(35,35,'https://cdn.huongnghiepaau.com/wp-content/uploads/2018/04/b7bca45bde7511e36d009c009edb72be.jpg'),(36,36,'https://tuvaobep.com/wp-content/uploads/2021/07/cach-lam-banh-crepe.jpg'),(37,37,'https://blog.beemart.vn/wp-content/uploads/2016/06/cach-lam-crepe-xoai-cuc-ngon-cuc-de-khong-the-bo-qua-1.jpg'),(38,38,'https://nauantainha.com/wp-content/uploads/cooked/images/recipes/recipe_2854.jpg'),(39,39,'https://toplist.vn/images/800px/dia-chi-ban-banh-donut-sieu-hap-dan-tai-tphcm-801789.jpg'),(40,40,'https://blog.beemart.vn/wp-content/uploads/2016/06/cach-lam-crepe-xoai-cuc-ngon-cuc-de-khong-the-bo-qua-1.jpg'),(41,41,'https://toplist.vn/images/800px/dia-chi-ban-banh-donut-sieu-hap-dan-tai-tphcm-801789.jpg'),(42,42,'https://cdnsg.kilala.vn/data/upload/article/6217/daifukumochi.jpg'),(43,43,'https://tuvaobep.com/wp-content/uploads/2021/07/cach-lam-banh-crepe.jpg'),(44,44,'https://hips.hearstapps.com/ghk.h-cdn.co/assets/16/38/1474822198-how-to-make-pancakes.jpg?crop=0.998xw:0.749xh;0.00163xw,0.232xh&resize=640:*'),(45,45,'https://www.cookingclassy.com/wp-content/uploads/2012/08/red-velvet-cookies-8-500x375.jpg'),(46,46,'https://img.taste.com.au/UTLenFVe/taste/2020/09/pancake-recipe-for-one-165241-2.jpg'),(47,47,'https://images-gmi-pmc.edge-generalmills.com/faa9b91b-aa4f-4459-817f-f95b23a18da1.jpg'),(48,48,'https://static.toiimg.com/thumb/61912223.cms?width=1200&height=900'),(49,49,'https://www.maangchi.com/wp-content/uploads/2016/03/gyerangppang-cut.jpg'),(50,50,'https://images-gmi-pmc.edge-generalmills.com/faa9b91b-aa4f-4459-817f-f95b23a18da1.jpg'),(51,51,'https://blog.beemart.vn/wp-content/uploads/2016/06/cach-lam-crepe-xoai-cuc-ngon-cuc-de-khong-the-bo-qua-1.jpg'),(52,52,'https://img.taste.com.au/UTLenFVe/taste/2020/09/pancake-recipe-for-one-165241-2.jpg'),(53,53,'https://www.allrecipes.com/thmb/INlN7eEfjoHUuQX16Sr_HHWjRoQ=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/3706911-332141df2c594f65afb2a4a659a60b42.jpg'),(54,54,'https://i.pinimg.com/564x/ae/75/6d/ae756db33a32742de78533a010bc9cee.jpg'),(55,55,'https://images-gmi-pmc.edge-generalmills.com/faa9b91b-aa4f-4459-817f-f95b23a18da1.jpg'),(56,56,'https://content.instructables.com/F0P/Y25G/LACIEQCN/F0PY25GLACIEQCN.jpg?auto=webp&frame=1&width=700&height=1024&fit=bounds&md=beb21f59513373a7f4942153034ad574'),(57,57,'https://www.tasteofhome.com/wp-content/uploads/2018/07/braided-bread.jpg'),(58,58,'https://images.food52.com/vogMwwPkVAIH99H9drzXMi7CQKg=/1536x1022/filters:format(webp)/22f3ffa5-e8f5-4116-9cdf-2a390961f30e--2021-0211_chocolate-yeasted-puff-pastry_bake-it-up-a-notch_3x2_rocky-luten_016.jpg'),(59,59,'https://www.maangchi.com/wp-content/uploads/2016/03/gyerangppang-cut.jpg'),(60,60,'https://i.ytimg.com/vi/duBwUH5S65c/maxresdefault.jpg'),(70,71,'https://images-gmi-pmc.edge-generalmills.com/faa9b91b-aa4f-4459-817f-f95b23a18da1.jpg'),(71,72,'https://th.bing.com/th/id/R.c2909384f0d2dd54649f40a72aff5bd6?rik=0G6uEAB30OGAcA&riu=http%3a%2f%2fimages.media-allrecipes.com%2fuserphotos%2f960x960%2f5630658.jpg&ehk=6wf4u3k8SqGWDzd3Sri8sLIkBb2v4TItUL4IKLxCs6g%3d&risl=&pid=ImgRaw&r=0'),(73,73,'https://cdn.tgdd.vn/2020/07/CookProduct/157263421739499900-1200x676.jpg'),(182,166,'https://www.allrecipes.com/thmb/INlN7eEfjoHUuQX16Sr_HHWjRoQ=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/3706911-332141df2c594f65afb2a4a659a60b42.jpg'),(183,167,'https://images-gmi-pmc.edge-generalmills.com/faa9b91b-aa4f-4459-817f-f95b23a18da1.jpg'),(184,168,'https://www.humanesociety.org/sites/default/files/styles/1240x698/public/2020-07/kitten-510651.jpg?h=f54c7448&itok=ZhplzyJ9'),(185,170,'upload_images/pancake-la-gi-4.jpeg'),(186,171,'upload_images/oh-my-days_sydney-bakery.jpg');
/*!40000 ALTER TABLE `image_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient_tbl`
--

DROP TABLE IF EXISTS `ingredient_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredient_tbl` (
  `ingredient_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `unit` varchar(50) NOT NULL DEFAULT 'none',
  PRIMARY KEY (`ingredient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient_tbl`
--

LOCK TABLES `ingredient_tbl` WRITE;
/*!40000 ALTER TABLE `ingredient_tbl` DISABLE KEYS */;
INSERT INTO `ingredient_tbl` VALUES (1,'Flour','gram'),(2,'Whole wheat flour','gram'),(3,'Whole grain flour','gram'),(4,'Whole wheat flour','gram'),(5,'Bread flour','gram'),(6,'Pastry flour','gram'),(7,'Self-rising flour','gram'),(8,'Alternative non-wheat flours','gram'),(9,'Cornmeal','gram'),(10,'Cornstarch','gram'),(11,'Baking soda','gram'),(12,'Baking powder','gram'),(13,'Yeast','gram'),(14,'Sugar','coffe spoon'),(15,'Granulated sugar','coffe spoon'),(16,'Powdered sugar','coffe spoon'),(17,'Brown sugar','coffe spoon'),(18,'Superfine sugar','coffe spoon'),(19,'Sanding suga','coffe spoon'),(20,'Egg','none'),(21,'Apple','none'),(22,'Organe','none'),(23,'Water','mililiter'),(24,'Cheese','gram'),(25,'Milk','mililiter'),(26,'Sifted all-purpose','cup'),(27,'Salt','teaspoon '),(28,'Baking powder','tablespoon '),(29,'Egg yolks','none'),(30,'Egg whites','none'),(31,'Milk','cups'),(32,'Butter','tablespoons '),(33,'Sugar','tablespoon ');
/*!40000 ALTER TABLE `ingredient_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `like_tbl`
--

DROP TABLE IF EXISTS `like_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `like_tbl` (
  `user_id` int NOT NULL,
  `recipe_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`recipe_id`),
  KEY `FKLike_tbl999893` (`recipe_id`),
  CONSTRAINT `FKLike_tbl981405` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`),
  CONSTRAINT `FKLike_tbl999893` FOREIGN KEY (`recipe_id`) REFERENCES `recipe_tbl` (`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like_tbl`
--

LOCK TABLES `like_tbl` WRITE;
/*!40000 ALTER TABLE `like_tbl` DISABLE KEYS */;
INSERT INTO `like_tbl` VALUES (53,48),(65,48),(86,48),(86,59),(53,73),(61,73),(65,73),(88,166);
/*!40000 ALTER TABLE `like_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification_tbl`
--

DROP TABLE IF EXISTS `notification_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification_tbl` (
  `noti_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `detail` text NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`noti_id`),
  KEY `FKNotificati321251` (`user_id`),
  CONSTRAINT `FKNotificati321251` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification_tbl`
--

LOCK TABLES `notification_tbl` WRITE;
/*!40000 ALTER TABLE `notification_tbl` DISABLE KEYS */;
INSERT INTO `notification_tbl` VALUES (28,53,'Thong has followed.Lam Vo','2022-11-15 00:00:00'),(29,88,'Lam Vo has created a reicpe.','2022-11-15 00:00:00'),(30,91,'Lam Vo has created a reicpe.','2022-11-15 00:00:00');
/*!40000 ALTER TABLE `notification_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile_tbl`
--

DROP TABLE IF EXISTS `profile_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile_tbl` (
  `profile_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `avatar_url` varchar(500) DEFAULT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`profile_id`),
  UNIQUE KEY `user_id` (`user_id`),
  CONSTRAINT `FKProfile_tb133462` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile_tbl`
--

LOCK TABLES `profile_tbl` WRITE;
/*!40000 ALTER TABLE `profile_tbl` DISABLE KEYS */;
INSERT INTO `profile_tbl` VALUES (1,1,'gossenna0','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-03-19 00:00:00'),(2,2,'gfissenden1','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-02-11 00:00:00'),(3,3,'beppson2','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2021-11-28 00:00:00'),(4,4,'cwloch3','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-07-20 00:00:00'),(5,5,'mgrenshields4','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-08-31 00:00:00'),(6,6,'ipeeter5','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-03-01 00:00:00'),(7,7,'bparrot6','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-04-05 00:00:00'),(8,8,'dmcgavin7','Polygender','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-05-02 00:00:00'),(9,9,'jalentyev8','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2021-10-23 00:00:00'),(10,10,'shalford9','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2021-11-05 00:00:00'),(11,11,'fstruijsa','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-08-12 00:00:00'),(12,12,'abaystonb','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2021-12-21 00:00:00'),(13,13,'lspontonc','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-08-03 00:00:00'),(14,14,'wschuhd','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-06-10 00:00:00'),(15,15,'oyeowelle','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-07-03 00:00:00'),(16,16,'alenchenkof','Non-binary','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-08-05 00:00:00'),(17,17,'rcontig','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2021-12-17 00:00:00'),(18,18,'twanklynh','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2021-10-08 00:00:00'),(19,19,'epenkethi','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-01-30 00:00:00'),(20,20,'tmackeanj','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-07-28 00:00:00'),(21,21,'sclemk','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-05-10 00:00:00'),(22,22,'rnockl','Non-binary','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2021-11-30 00:00:00'),(23,23,'atabrettm','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-08-12 00:00:00'),(24,24,'swaycotn','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-07-30 00:00:00'),(25,25,'fmandello','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-04-20 00:00:00'),(26,26,'jdelacourtp','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-07-21 00:00:00'),(27,27,'mallmenq','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-03-28 00:00:00'),(28,28,'ahaquardr','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-06-25 00:00:00'),(29,29,'gtrenoweths','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2021-10-17 00:00:00'),(30,30,'tvynardet','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2021-09-26 00:00:00'),(31,31,'tleitheru','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-07-06 00:00:00'),(32,32,'bfranciottiv','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-03-02 00:00:00'),(33,33,'dchapew','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-05-21 00:00:00'),(34,34,'fraikerx','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-06-08 00:00:00'),(35,35,'aiwaszkiewiczy','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2021-12-28 00:00:00'),(36,36,'apettifordz','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-05-02 00:00:00'),(37,37,'estavers10','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-04-04 00:00:00'),(38,38,'asalvidge11','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-04-21 00:00:00'),(39,39,'acallcott12','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-08-03 00:00:00'),(40,40,'cmarquet13','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-07-29 00:00:00'),(41,41,'idutch14','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-08-16 00:00:00'),(42,42,'csmaleman15','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-03-02 00:00:00'),(43,43,'rpaschek16','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-09-07 00:00:00'),(44,44,'dfeldstein17','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-06-27 00:00:00'),(45,45,'cturvie18','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-06-15 00:00:00'),(46,46,'tfoli19','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2021-12-09 00:00:00'),(47,47,'cmalser1a','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-07-27 00:00:00'),(48,48,'eallonby1b','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-08-10 00:00:00'),(49,49,'bthurlbourne1c','Male','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-02-24 00:00:00'),(50,50,'fnestoruk1d','Female','https://picsum.photos/200','Anh như,trịnh thăng bình với cái bịnh thăng trầm','2022-01-17 00:00:00'),(52,53,'Lam Vo','Female','https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg','My biography... I love cooking and blogging. Using a fork, break salmon. Halve reserved ','2022-10-04 22:25:33'),(54,55,NULL,NULL,NULL,NULL,'2022-10-06 00:00:00'),(55,56,NULL,NULL,NULL,NULL,'2022-10-06 00:00:00'),(56,57,NULL,NULL,NULL,NULL,'2022-10-06 00:00:00'),(57,58,NULL,NULL,NULL,NULL,'2022-10-06 00:00:00'),(58,59,'Lam',NULL,NULL,NULL,'2022-10-14 00:00:00'),(59,60,'Lam',NULL,NULL,NULL,'2022-10-14 00:00:00'),(60,61,'lamlampooo0',NULL,NULL,NULL,'2022-10-14 00:00:00'),(61,62,'lamal123456',NULL,NULL,NULL,'2022-10-14 00:00:00'),(62,63,'aaaaaaaa',NULL,NULL,NULL,'2022-10-17 00:00:00'),(63,64,'abc 12345678',NULL,NULL,NULL,'2022-10-18 00:00:00'),(64,65,'Lam Vo',NULL,NULL,NULL,'2022-10-19 00:00:00'),(66,52,'user','male',NULL,NULL,'2022-11-01 11:33:57'),(68,68,'Nguyen Van B',NULL,NULL,NULL,'2022-11-04 00:00:00'),(69,69,'lam lam lam lam',NULL,NULL,NULL,'2022-11-08 00:00:00'),(70,70,'lam vo lam',NULL,NULL,NULL,'2022-11-08 00:00:00'),(71,71,'lamal as',NULL,NULL,NULL,'2022-11-08 00:00:00'),(72,72,'lam lam lam lam',NULL,NULL,NULL,'2022-11-08 00:00:00'),(73,73,'lam vo lam',NULL,NULL,NULL,'2022-11-08 00:00:00'),(74,74,'lam vo lam',NULL,NULL,NULL,'2022-11-08 00:00:00'),(75,75,'lam vo lam',NULL,NULL,NULL,'2022-11-08 00:00:00'),(76,76,'lam vo lam',NULL,NULL,NULL,'2022-11-08 00:00:00'),(77,77,'lam lam lam',NULL,NULL,NULL,'2022-11-08 00:00:00'),(78,78,'lam lam lam lam',NULL,NULL,NULL,'2022-11-08 00:00:00'),(79,79,'lam vo lam',NULL,NULL,NULL,'2022-11-08 00:00:00'),(80,80,'lam vo lam',NULL,NULL,NULL,'2022-11-08 00:00:00'),(81,81,'lamal',NULL,NULL,NULL,'2022-11-08 00:00:00'),(82,82,'lamal',NULL,NULL,NULL,'2022-11-08 00:00:00'),(83,83,'lamal',NULL,NULL,NULL,'2022-11-08 00:00:00'),(84,84,NULL,NULL,NULL,NULL,'2022-11-10 00:00:00'),(85,85,NULL,NULL,NULL,NULL,'2022-11-11 00:00:00'),(86,86,'ttttttttttt10',NULL,'https://avatars.githubusercontent.com/u/98933833?s=400&u=ba0336ca080528af6eb06af4d56d8e5e2d5a3f05&v=4',NULL,'2022-11-12 00:00:00'),(87,87,NULL,NULL,NULL,NULL,'2022-11-13 00:00:00'),(88,88,NULL,NULL,NULL,NULL,'2022-11-14 00:00:00'),(89,89,NULL,NULL,'https://lh3.googleusercontent.com/a-/ACNPEu8r9FmbjRMgadNAuAOwq1_5hGVACk67rdGvmZmQHrw=s96-c',NULL,'2022-11-14 00:00:00'),(90,90,NULL,NULL,'https://lh3.googleusercontent.com/a-/ACNPEu8r9FmbjRMgadNAuAOwq1_5hGVACk67rdGvmZmQHrw=s96-c',NULL,'2022-11-14 00:00:00'),(91,91,'Thong',NULL,'https://demoda.vn/wp-content/uploads/2022/01/avatar-gau.jpg',NULL,'2022-11-14 00:00:00'),(92,92,'Hoang Anh',NULL,'https://phunugioi.com/wp-content/uploads/2022/03/Avatar-Gau.jpg',NULL,'2022-11-14 00:00:00'),(93,93,'Hieu',NULL,'https://kynguyenlamdep.com/wp-content/uploads/2022/06/avatar-cute-meo-con-than-chet.jpg',NULL,'2022-11-14 00:00:00'),(94,94,'Loc',NULL,'https://kynguyenlamdep.com/wp-content/uploads/2022/06/avatar-cute.jpg',NULL,'2022-11-14 00:00:00'),(95,95,NULL,NULL,'https://lh3.googleusercontent.com/a-/ACNPEu8r9FmbjRMgadNAuAOwq1_5hGVACk67rdGvmZmQHrw=s96-c',NULL,'2022-11-14 00:00:00');
/*!40000 ALTER TABLE `profile_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe_ingredient_tbl`
--

DROP TABLE IF EXISTS `recipe_ingredient_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe_ingredient_tbl` (
  `recipe_id` int NOT NULL,
  `ingredient_id` int NOT NULL,
  `quantity` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`recipe_id`,`ingredient_id`),
  KEY `FKRecipe_Ing369555` (`ingredient_id`),
  CONSTRAINT `FKRecipe_Ing369555` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient_tbl` (`ingredient_id`),
  CONSTRAINT `FKRecipe_Ing670201` FOREIGN KEY (`recipe_id`) REFERENCES `recipe_tbl` (`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe_ingredient_tbl`
--

LOCK TABLES `recipe_ingredient_tbl` WRITE;
/*!40000 ALTER TABLE `recipe_ingredient_tbl` DISABLE KEYS */;
INSERT INTO `recipe_ingredient_tbl` VALUES (31,1,200),(31,2,150),(31,7,20),(31,29,20),(34,1,100),(34,13,100),(34,18,2),(45,1,200),(45,2,100),(45,14,3),(46,1,200),(46,2,100),(46,9,100),(56,1,100),(56,2,200),(56,13,100),(56,14,2),(56,29,3),(72,2,90),(72,18,70),(73,1,100),(73,3,49.99),(73,7,20),(166,12,0.5),(166,14,1),(166,26,1),(166,29,2),(167,12,0.5),(167,25,0.75),(167,26,1),(167,29,2),(168,2,12),(168,7,32),(169,2,1.99),(169,7,43),(170,3,2),(171,1,23),(171,3,23);
/*!40000 ALTER TABLE `recipe_ingredient_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe_tbl`
--

DROP TABLE IF EXISTS `recipe_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe_tbl` (
  `recipe_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `category_id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `serving` int NOT NULL DEFAULT '0',
  `instruction` text,
  `prepare_time` int DEFAULT '0',
  `cook_time` int DEFAULT '0',
  `liked_count` int NOT NULL DEFAULT '0',
  `saved_count` int NOT NULL DEFAULT '0',
  `view_count` int DEFAULT '0',
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_actived` bit(1) NOT NULL DEFAULT b'1',
  `is_hidden` bit(1) NOT NULL DEFAULT b'0',
  `step` varchar(1000) NOT NULL DEFAULT ' ',
  PRIMARY KEY (`recipe_id`),
  KEY `FKRecipe_tbl798583` (`category_id`),
  KEY `FKRecipe_tbl547119` (`user_id`),
  CONSTRAINT `FKRecipe_tbl547119` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`),
  CONSTRAINT `FKRecipe_tbl798583` FOREIGN KEY (`category_id`) REFERENCES `category_tbl` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe_tbl`
--

LOCK TABLES `recipe_tbl` WRITE;
/*!40000 ALTER TABLE `recipe_tbl` DISABLE KEYS */;
INSERT INTO `recipe_tbl` VALUES (31,91,17,'Baily Koop',8,'Glaucoma w systemic synd',75,84,500,139,2,'2022-06-25 00:00:00','2022-11-14 23:44:55',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(32,91,5,'Thaddus Pizey',6,'Infect dis NEC-delivered',37,71,0,557,0,'2021-11-27 00:00:00','2022-07-26 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(33,91,2,'Derek Loffill',17,'Neonatal bradycardia',19,78,0,531,0,'2022-01-02 00:00:00','2021-12-02 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(34,91,11,'Durant Noad',20,'Extreme immat 1000-1249g',88,49,400,67,4,'2021-11-28 00:00:00','2022-11-14 23:45:39',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(35,91,15,'Shaylyn Sancroft',1,'Protein defic anemia',16,14,0,241,0,'2022-05-30 00:00:00','2022-08-25 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(36,91,17,'Abbe Dumblton',20,'Anomalies of uterus NEC',18,79,0,622,0,'2022-05-12 00:00:00','2022-02-07 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(37,91,8,'Abran Caesman',6,'Lordosis in oth dis',50,72,0,213,0,'2022-06-01 00:00:00','2022-05-14 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(38,91,4,'Frederica Cearley',13,'Ankylosis-upper/arm',16,42,0,375,0,'2022-02-02 00:00:00','2022-05-05 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(39,91,16,'Heriberto Tranter',10,'Situs inversus',56,43,0,259,0,'2021-10-17 00:00:00','2022-04-08 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(40,91,18,'Milissent Onians',15,'Reading disorder NOS',50,42,150,690,1,'2021-12-11 00:00:00','2022-09-03 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(41,92,12,'Zabrina Adamthwaite',19,'Rheumatic heart failure',20,78,0,104,0,'2022-03-17 00:00:00','2022-02-10 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(42,92,9,'Lucius Alphege',3,'Ganglion NOS',26,55,0,119,0,'2022-05-16 00:00:00','2022-04-16 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(43,92,12,'Haroun Sivorn',13,'TB thorax node-cult dx',68,30,0,236,0,'2022-08-15 00:00:00','2022-06-27 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(44,92,1,'Cathy Pawlicki',12,'Herpes zoster of eyelid',32,21,0,446,0,'2022-02-25 00:00:00','2022-04-15 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(45,92,12,'Fraser Isson',5,'Illeg ab w embolism-comp',43,83,0,641,2,'2022-03-09 00:00:00','2022-11-14 23:46:35',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(46,92,20,'Hymie Flanner',10,'Herpangina',56,38,0,43,2,'2022-07-29 00:00:00','2022-11-14 23:47:09',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(47,92,17,'Myriam Anan',3,'Hx of past noncompliance',54,81,0,223,0,'2022-02-11 00:00:00','2022-03-19 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(48,92,4,'Avis Elce',5,'Scarring of conjunctiva',76,69,102,426,1,'2022-01-23 00:00:00','2022-04-26 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(49,92,13,'Livvy Scutching',4,'Adv eff vasodilators NEC',29,13,0,48,0,'2022-03-27 00:00:00','2022-01-27 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(50,94,10,'Johnathan Dovidian',5,'Cereb degeneration NEC',38,33,0,218,0,'2022-09-10 00:00:00','2022-06-16 00:00:00',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(51,53,12,'Strawberry Cake Cream',5,'My recipe will show you how to make a delicious strawberry cream cake.',10,20,0,100,0,'2022-10-03 19:48:34','2022-10-03 19:48:34',_binary '\0',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(52,53,12,'Sweet Cheeks Cakes',5,'My recipe will show you how to make a delicious strawberry cream cake.',10,20,0,100,0,'2022-10-03 19:53:35','2022-10-03 19:53:35',_binary '\0',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(53,53,10,'Sugarboo Bakery',5,'My recipe will show you how to make a delicious strawberry cream cake.',10,20,0,100,0,'2022-10-03 19:53:35','2022-10-03 19:53:35',_binary '\0',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(54,53,9,'Nutty Baker',5,'My recipe will show you how to make a delicious strawberry cream cake.',10,20,130,100,1,'2022-10-03 19:53:35','2022-10-03 19:53:35',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(55,53,8,'Kneads Bakery',5,'My recipe will show you how to make a delicious strawberry cream cake.',10,20,0,100,0,'2022-10-03 19:53:35','2022-10-03 19:53:35',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(56,53,6,'Pretty Baked',5,'My recipe will show you how to make a delicious strawberry cream cake.',10,20,0,100,5,'2022-10-03 19:53:35','2022-11-14 21:58:45',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(57,53,5,'For Goodness Cakes',5,'My recipe will show you how to make a delicious strawberry cream cake.',10,20,0,100,0,'2022-10-03 19:53:35','2022-10-03 19:53:35',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(58,53,1,'Delicious Chic',5,'My recipe will show you how to make a delicious strawberry cream cake.',10,20,0,100,0,'2022-10-03 19:53:35','2022-10-03 19:53:35',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(59,53,2,'	Tasteful',5,'My recipe will show you how to make a delicious strawberry cream cake.',10,20,101,100,4,'2022-10-03 19:53:35','2022-10-03 19:53:35',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(60,53,3,'Fresh Bake',5,'My recipe will show you how to make a delicious strawberry cream cake.',10,20,0,100,0,'2022-10-03 19:53:35','2022-10-03 19:53:35',_binary '\0',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(71,53,3,'Vegetarian Chili in the World',45,'My description here.....',10,20,0,0,1,'2022-10-13 01:07:58','2022-10-13 01:07:58',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(72,53,8,'Easy Roasted Broccoli',5,'Roasted broccoli is easy to make and so much more flavorsome than boiled. My favorite part is the roasted sliced stem pieces.',10,20,170,0,8,'2022-10-13 01:13:30','2022-10-13 01:13:30',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(73,53,12,'Mochi',5,'A bakery is an establishment that produces and sells flour-based food baked in an oven such as bread, cookies, cakes, donuts, pastries, and pies. Some retail bakeries are also categorized as cafés, serving coffee and tea to customers who wish to consume the baked goods on the premises.',5,10,300,0,12,'2022-10-13 18:56:09','2022-10-13 18:56:09',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(166,53,21,'Extra Light and Fluffy Pancakes',4,'This recipe incorporates whipped egg whites for extra light and fluffy pancakes. Because they use the yolks and melted butter, they are still rich and tender.\r\n',10,10,1,0,16,'2022-11-14 16:23:45','2022-11-14 16:24:53',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Make a well in the middle of the dry ingredients and add the mixed wet ingredients all at once. Stir until just combined. (Over-mixing will make for a tough pancake.) --- Mix all dry ingredients together lightly to distribute. (Flour, sugar, baking powder, salt). --- Bake 30 to 35 minutes or until toothpick comes out clean. --- The liquid in the cake (milk) serves to dissovle the sugar, provides consistency for the batter and controls the temperature in the oven.'),(167,53,21,'Sugar Free Egyptian Rice Pudding With Date and Cinnamon ( Roz Bel Laban)',4,'This recipe incorporates whipped egg whites for extra light and fluffy pancakes. Because they use the yolks and melted butter, they are still rich and tender.\r\n',10,10,0,0,6,'2022-11-14 16:32:36','2022-11-14 16:33:20',_binary '',_binary '\0','Sift the dry ingredients together. --- In another bowl, mix the yolks, most of the milk, and the melted butter together until smooth. --- Beat the egg whites until light and fluffy and soft peaks appear as for meringue. Add the sugar toward the end of the beating. Fold the egg whites gently into the batter with a spatula. Add milk as necessary to get the right consistency.'),(168,53,2,'Meow',3,'meow meow meow',1,2,0,0,17,'2022-11-14 16:40:42','2022-11-14 16:40:42',_binary '',_binary '\0','Mewo mwoe mweo --- mwew mewo mewo --- mewo moew moew'),(169,53,2,'Test 15/11',3,'fasdf',1,2,0,0,1,'2022-11-15 00:41:34','2022-11-15 00:41:34',_binary '',_binary '\0','fdfsd --- fdsfsa'),(170,53,4,'test 1555/11',3,'sdfa',1,2,0,0,1,'2022-11-15 00:54:43','2022-11-15 00:54:43',_binary '',_binary '\0','sdfasd'),(171,53,2,'Test 15/11111',3,'dsfsa',1,2,0,0,1,'2022-11-15 01:10:05','2022-11-15 01:10:05',_binary '',_binary '\0','asd');
/*!40000 ALTER TABLE `recipe_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report_tbl`
--

DROP TABLE IF EXISTS `report_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report_tbl` (
  `report_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `recipe_id` int DEFAULT NULL,
  `report_detail` varchar(500) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  PRIMARY KEY (`report_id`),
  KEY `FKReport_tbl58374_idx` (`user_id`),
  KEY `FKReport_tbl58375_idx` (`recipe_id`),
  CONSTRAINT `FKReport_tbl58374` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`),
  CONSTRAINT `FKReport_tbl58375` FOREIGN KEY (`recipe_id`) REFERENCES `recipe_tbl` (`recipe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_tbl`
--

LOCK TABLES `report_tbl` WRITE;
/*!40000 ALTER TABLE `report_tbl` DISABLE KEYS */;
INSERT INTO `report_tbl` VALUES (1,88,168,'Id : 168 - by : lamvo - sms: adasdsadsa','2022-11-14'),(2,88,168,'Id : 168 - by : lamvo - sms: report 222222','2022-11-14'),(3,53,168,'Id : 168 - by : lamvo - sms: epwqoesdanasds','2022-11-14'),(4,88,168,'Id : 168 - by : lamvo - sms: new','2022-11-14'),(5,88,73,'Id : 73 - by : lamvo - sms: `2123','2022-11-14'),(6,53,168,'Id : 168 - by : lamvo - sms: abc','2022-11-14'),(7,88,168,'Id : 168 - by : lamvo - sms: asdasdc','2022-11-14');
/*!40000 ALTER TABLE `report_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `save_tbl`
--

DROP TABLE IF EXISTS `save_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `save_tbl` (
  `user_id` int NOT NULL,
  `recipe_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`recipe_id`),
  KEY `FKSave_tbl597275` (`recipe_id`),
  CONSTRAINT `FKSave_tbl578787` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`),
  CONSTRAINT `FKSave_tbl597275` FOREIGN KEY (`recipe_id`) REFERENCES `recipe_tbl` (`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `save_tbl`
--

LOCK TABLES `save_tbl` WRITE;
/*!40000 ALTER TABLE `save_tbl` DISABLE KEYS */;
INSERT INTO `save_tbl` VALUES (53,48),(53,59),(53,73),(88,73),(88,166);
/*!40000 ALTER TABLE `save_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_detail_tbl`
--

DROP TABLE IF EXISTS `tag_detail_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag_detail_tbl` (
  `recipe_id` int NOT NULL,
  `tag_id` int NOT NULL,
  PRIMARY KEY (`recipe_id`,`tag_id`),
  KEY `FKTagtbl128375_idx` (`tag_id`),
  CONSTRAINT `FKTagtbl128374` FOREIGN KEY (`recipe_id`) REFERENCES `recipe_tbl` (`recipe_id`),
  CONSTRAINT `FKTagtbl128375` FOREIGN KEY (`tag_id`) REFERENCES `tag_tbl` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_detail_tbl`
--

LOCK TABLES `tag_detail_tbl` WRITE;
/*!40000 ALTER TABLE `tag_detail_tbl` DISABLE KEYS */;
INSERT INTO `tag_detail_tbl` VALUES (166,6),(167,6),(168,10),(166,12),(167,12),(166,13),(167,13),(166,14),(167,14),(56,26),(56,27),(56,28);
/*!40000 ALTER TABLE `tag_detail_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_tbl`
--

DROP TABLE IF EXISTS `tag_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag_tbl` (
  `tag_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `count` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_tbl`
--

LOCK TABLES `tag_tbl` WRITE;
/*!40000 ALTER TABLE `tag_tbl` DISABLE KEYS */;
INSERT INTO `tag_tbl` VALUES (1,'cookie',0),(2,'hambuger',1),(3,'breakfast',1),(4,'plan',0),(5,'hot',0),(6,'sweet',5),(7,'asian',0),(8,'vietnam',0),(9,'thailand',0),(10,'lam',16),(11,'mal',4),(12,'pancake',3),(13,'light',3),(14,'grilled',3),(15,'dsad',1),(16,'asd',2),(17,'ads',1),(18,'hello-world',1),(19,'cake',1),(20,'recipe',2),(21,'morning',2),(22,'thgs',1),(23,'ddddd',1),(24,'ddddd\\',1),(25,'dc',1),(26,'prety',1),(27,'cookies',1),(28,'fried',1);
/*!40000 ALTER TABLE `tag_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tbl`
--

DROP TABLE IF EXISTS `user_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_tbl` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tbl`
--

LOCK TABLES `user_tbl` WRITE;
/*!40000 ALTER TABLE `user_tbl` DISABLE KEYS */;
INSERT INTO `user_tbl` VALUES (1,'2022-06-21 00:00:00'),(2,'2022-04-02 00:00:00'),(3,'2022-06-20 00:00:00'),(4,'2022-04-20 00:00:00'),(5,'2021-10-14 00:00:00'),(6,'2022-06-27 00:00:00'),(7,'2022-08-25 00:00:00'),(8,'2022-07-05 00:00:00'),(9,'2022-01-27 00:00:00'),(10,'2022-05-11 00:00:00'),(11,'2021-11-26 00:00:00'),(12,'2021-12-24 00:00:00'),(13,'2022-03-15 00:00:00'),(14,'2021-10-18 00:00:00'),(15,'2022-04-10 00:00:00'),(16,'2022-07-05 00:00:00'),(17,'2021-12-31 00:00:00'),(18,'2022-01-19 00:00:00'),(19,'2022-01-24 00:00:00'),(20,'2022-07-18 00:00:00'),(21,'2022-05-12 00:00:00'),(22,'2022-02-20 00:00:00'),(23,'2022-05-19 00:00:00'),(24,'2022-06-28 00:00:00'),(25,'2022-07-10 00:00:00'),(26,'2022-05-27 00:00:00'),(27,'2021-11-16 00:00:00'),(28,'2021-10-16 00:00:00'),(29,'2022-09-04 00:00:00'),(30,'2021-10-17 00:00:00'),(31,'2022-03-26 00:00:00'),(32,'2022-07-02 00:00:00'),(33,'2022-06-24 00:00:00'),(34,'2021-10-09 00:00:00'),(35,'2021-12-26 00:00:00'),(36,'2022-08-21 00:00:00'),(37,'2022-07-19 00:00:00'),(38,'2022-08-11 00:00:00'),(39,'2022-05-01 00:00:00'),(40,'2022-08-27 00:00:00'),(41,'2022-03-21 00:00:00'),(42,'2021-12-12 00:00:00'),(43,'2022-07-13 00:00:00'),(44,'2022-01-26 00:00:00'),(45,'2022-08-01 00:00:00'),(46,'2021-10-17 00:00:00'),(47,'2022-06-02 00:00:00'),(48,'2022-06-29 00:00:00'),(49,'2022-09-01 00:00:00'),(50,'2022-05-05 00:00:00'),(51,'2021-04-21 00:00:00'),(52,'2021-04-21 00:00:00'),(53,'2022-09-29 16:20:24'),(54,'2022-09-30 00:00:00'),(55,'2022-10-06 00:00:00'),(56,'2022-10-06 00:00:00'),(57,'2022-10-06 00:00:00'),(58,'2022-10-06 00:00:00'),(59,'2022-10-14 00:00:00'),(60,'2022-10-14 00:00:00'),(61,'2022-10-14 00:00:00'),(62,'2022-10-14 00:00:00'),(63,'2022-10-17 00:00:00'),(64,'2022-10-18 00:00:00'),(65,'2022-10-19 00:00:00'),(68,'2022-11-04 00:00:00'),(69,'2022-11-08 00:00:00'),(70,'2022-11-08 00:00:00'),(71,'2022-11-08 00:00:00'),(72,'2022-11-08 00:00:00'),(73,'2022-11-08 00:00:00'),(74,'2022-11-08 00:00:00'),(75,'2022-11-08 00:00:00'),(76,'2022-11-08 00:00:00'),(77,'2022-11-08 00:00:00'),(78,'2022-11-08 00:00:00'),(79,'2022-11-08 00:00:00'),(80,'2022-11-08 00:00:00'),(81,'2022-11-08 00:00:00'),(82,'2022-11-08 00:00:00'),(83,'2022-11-08 00:00:00'),(84,'2022-11-10 00:00:00'),(85,'2022-11-11 00:00:00'),(86,'2022-11-12 00:00:00'),(87,'2022-11-13 00:00:00'),(88,'2022-11-14 00:00:00'),(89,'2022-11-14 00:00:00'),(90,'2022-11-14 00:00:00'),(91,'2022-11-14 00:00:00'),(92,'2022-11-14 00:00:00'),(93,'2022-11-14 00:00:00'),(94,'2022-11-14 00:00:00'),(95,'2022-11-14 00:00:00');
/*!40000 ALTER TABLE `user_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video_tbl`
--

DROP TABLE IF EXISTS `video_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video_tbl` (
  `video_id` int NOT NULL AUTO_INCREMENT,
  `recipe_id` int NOT NULL,
  `video_link` varchar(255) NOT NULL,
  PRIMARY KEY (`video_id`),
  KEY `FKVideo_tbl462035` (`recipe_id`),
  CONSTRAINT `FKVideo_tbl462035` FOREIGN KEY (`recipe_id`) REFERENCES `recipe_tbl` (`recipe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video_tbl`
--

LOCK TABLES `video_tbl` WRITE;
/*!40000 ALTER TABLE `video_tbl` DISABLE KEYS */;
INSERT INTO `video_tbl` VALUES (5,31,'https://www.youtube.com/watch?v=FsgWXCnT8yE');
/*!40000 ALTER TABLE `video_tbl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-25  0:40:23
