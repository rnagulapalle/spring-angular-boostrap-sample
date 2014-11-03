# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.21)
# Database: eOutletz_Web
# Generation Time: 2014-11-03 02:06:20 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Address
# ------------------------------------------------------------

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;

INSERT INTO `Address` (`id`, `address1`, `address2`, `city`, `state`, `country`, `postalcode`, `user_id`, `address_type_id`, `create_date`, `update_date`)
VALUES
	(1,'3200 zanker2','unit#22112','santa clara','CA','usa','95051',2,1,'2014-10-25 18:54:58','2014-10-27 21:50:42'),
	(2,'3200 zanker2','unit#22112','santa clara','CA','usa','96078',1,1,'2014-10-25 18:56:37','2014-10-27 21:50:46'),
	(3,'3200 zanker2','unit#22112','santa clara','CA','usa','95054',1,2,'2014-10-25 18:56:53','2014-10-27 21:50:51'),
	(4,'3200 zanker2','unit#22112','santa clara','CA','usa','95055',2,2,'2014-10-25 18:57:41','2014-10-27 21:50:55');

/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Address_Type
# ------------------------------------------------------------

LOCK TABLES `Address_Type` WRITE;
/*!40000 ALTER TABLE `Address_Type` DISABLE KEYS */;

INSERT INTO `Address_Type` (`id`, `type`, `create_date`, `update_date`)
VALUES
	(1,'shipping','2014-10-23 19:03:55','2014-10-23 19:03:55'),
	(2,'billing','2014-10-23 19:04:00','2014-10-23 19:04:00');

/*!40000 ALTER TABLE `Address_Type` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Category
# ------------------------------------------------------------

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;

INSERT INTO `Category` (`id`, `name`, `create_date`, `update_date`)
VALUES
	(1,'This is sample Category','2014-10-23 20:12:56','2014-10-23 20:12:56'),
	(2,'This is sample Category2','2014-10-23 20:13:16','2014-10-23 20:13:16'),
	(3,'This is sample Category3','2014-10-23 20:13:16','2014-10-27 21:48:31'),
	(4,'This is sample Category4','2014-10-23 20:13:16','2014-10-27 21:48:33'),
	(5,'This is sample Category5','2014-10-23 20:13:16','2014-10-27 21:48:34'),
	(6,'This is sample Category6','2014-10-23 20:13:16','2014-10-27 21:48:36'),
	(7,'This is sample Category7','2014-10-23 20:13:16','2014-10-27 21:48:54'),
	(8,'This is sample Category8','2014-10-23 20:13:16','2014-10-27 21:49:03'),
	(9,'This is sample Category9','2014-10-23 20:13:16','2014-10-27 21:49:14'),
	(10,'This is sample Category10','2014-10-23 20:13:16','2014-10-27 21:49:32');

/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Color
# ------------------------------------------------------------



# Dump of table Image
# ------------------------------------------------------------

LOCK TABLES `Image` WRITE;
/*!40000 ALTER TABLE `Image` DISABLE KEYS */;

INSERT INTO `Image` (`id`, `image`, `prod_id`, `create_date`, `update_date`)
VALUES
	(1,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',1,'2014-10-23 21:22:50','2014-10-23 21:22:50'),
	(2,'http://upload.wikimedia.org/wikipedia/commons/5/52/Bangalore_Shiva.jpg',1,'2014-10-23 21:23:41','2014-10-23 21:23:41'),
	(3,'http://upload.wikimedia.org/wikipedia/commons/5/52/Bangalore_Shiva.jpg',2,'2014-10-23 21:23:47','2014-10-23 21:23:47'),
	(4,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',2,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(6,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',3,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(7,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',4,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(8,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',5,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(9,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',6,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(10,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',7,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(11,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',8,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(12,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',9,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(13,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',10,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(14,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',11,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(15,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',12,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(16,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',13,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(17,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',14,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(18,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',15,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(22,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',15,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(23,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',14,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(24,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',13,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(25,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',12,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(26,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',11,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(28,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',10,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(29,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',9,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(30,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',8,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(31,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',7,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(32,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',6,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(33,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',5,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(34,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',4,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(35,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',3,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(36,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',2,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(37,'http://demo.18maret.com/demo/mimity/images/product-2.jpg',1,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(38,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',1,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(39,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',2,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(40,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',3,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(41,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',4,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(42,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',5,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(43,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',6,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(44,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',7,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(45,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',8,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(46,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',9,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(47,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',10,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(48,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',11,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(49,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',12,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(50,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',13,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(51,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',14,'2014-10-23 21:23:54','2014-10-23 21:23:54'),
	(52,'http://demo.18maret.com/demo/mimity/images/product-5.jpg',15,'2014-10-23 21:23:54','2014-10-23 21:23:54');

/*!40000 ALTER TABLE `Image` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Order_Status
# ------------------------------------------------------------



# Dump of table Order_Tracking
# ------------------------------------------------------------



# Dump of table Orders
# ------------------------------------------------------------



# Dump of table Partner
# ------------------------------------------------------------

LOCK TABLES `Partner` WRITE;
/*!40000 ALTER TABLE `Partner` DISABLE KEYS */;

INSERT INTO `Partner` (`name`, `email`, `id`, `create_date`, `update_date`)
VALUES
	('venkanna','test-us-9242060@paypal.com',1,'2014-10-23 19:03:39','2014-10-23 19:03:39'),
	('venkanna','test-us-9242960@paypal.com',2,'2014-10-23 19:03:50','2014-10-23 19:03:50');

/*!40000 ALTER TABLE `Partner` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Partner_Contact
# ------------------------------------------------------------

LOCK TABLES `Partner_Contact` WRITE;
/*!40000 ALTER TABLE `Partner_Contact` DISABLE KEYS */;

INSERT INTO `Partner_Contact` (`id`, `address1`, `address2`, `city`, `state`, `country`, `type_id`, `partner_id`, `create_date`, `update_date`, `postal_code`)
VALUES
	(1,'3200 zanker2','unit#22112','santa clara2','CA','usa',1,1,'2014-10-23 19:04:44','2014-10-23 19:04:44','55566'),
	(2,'3200 zanker2','unit#22112','santa clara2','CA','usa',1,2,'2014-10-23 19:05:05','2014-10-23 19:05:05','55566'),
	(3,'3200 zanker2','unit#22112','santa clara2','CA','usa',2,1,'2014-10-23 19:05:13','2014-10-23 19:05:13','55566'),
	(4,'3200 zanker2','unit#22112','santa clara2','CA','usa',2,2,'2014-10-23 19:05:24','2014-10-25 19:11:27','55566');

/*!40000 ALTER TABLE `Partner_Contact` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Payment_Type
# ------------------------------------------------------------

LOCK TABLES `Payment_Type` WRITE;
/*!40000 ALTER TABLE `Payment_Type` DISABLE KEYS */;

INSERT INTO `Payment_Type` (`id`, `type`, `create_date`, `update_date`)
VALUES
	(1,'PayPal','2014-10-27 22:12:22','2014-10-27 22:12:22'),
	(2,'Visa','2014-10-27 22:12:28','2014-10-27 22:12:28'),
	(3,'Master Card','2014-10-27 22:12:43','2014-10-27 22:12:43'),
	(4,'Amex','2014-10-27 22:13:07','2014-10-27 22:13:07');

/*!40000 ALTER TABLE `Payment_Type` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Phone
# ------------------------------------------------------------

LOCK TABLES `Phone` WRITE;
/*!40000 ALTER TABLE `Phone` DISABLE KEYS */;

INSERT INTO `Phone` (`id`, `type`, `phone`, `user_id`, `create_date`, `update_date`)
VALUES
	(1,'mobile','4088377788',1,'2014-10-27 22:10:13','2014-10-27 22:10:32'),
	(2,'mobile','4088377788',2,'2014-10-27 22:10:13','2014-10-27 22:10:32'),
	(3,'home','4088377788',2,'2014-10-27 22:10:13','2014-10-27 22:10:32'),
	(7,'home','4088377788',1,'2014-10-27 22:10:13','2014-10-27 22:10:32');

/*!40000 ALTER TABLE `Phone` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Product
# ------------------------------------------------------------

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;

INSERT INTO `Product` (`id`, `sku`, `name`, `price`, `description`, `partner_id`, `size_id`, `quantity`, `msrp`, `units_in_stock`, `units_in_order`, `unit_price`, `create_date`, `update_date`)
VALUES
	(1,'332HHHHSSSLL222','Age Of Wisdom Tan Graphic Tee',10.11,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,1,22,22.11,10,0,11.00,'2014-10-23 20:58:24','2014-10-27 21:43:49'),
	(2,'332HHHHSSSLL222','Classic Laundry Green Graphic T-Shirt',21.00,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,1,20,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:12'),
	(3,'332HHHHSSSLL222','Disc Jockey Print T-Shirt',33.22,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,2,12,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:16'),
	(4,'332HHHHSSSLL222','Penn State College T-Shirt',33.23,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,4,13,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:18'),
	(5,'332HHHHSSSLL222','Live Nation 3 Days of Peace and Music Carbon',10.99,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,3,13,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:22'),
	(6,'332HHHHSSSLL222','Live Nation ACDC Gray T-Shirt',19.99,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,1,15,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:26'),
	(7,'332HHHHSSSLL222','Live Nation Aerosmith Ivory T-Shirt',21.99,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,5,16,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:29'),
	(8,'332HHHHSSSLL222','Ohio State College T-Shirt',22.99,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,1,17,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:32'),
	(9,'332HHHHSSSLL222','Adidas Men Blue & Red Striped Polo T-shirt',23.87,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,4,18,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:34'),
	(10,'332HHHHSSSLL222','Adidas Men Flame Black T-shirt',21.95,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,5,19,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:37'),
	(11,'332HHHHSSSLL222','Adidas Men Red Printed T-shirt',23.99,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,6,16,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:42'),
	(12,'332HHHHSSSLL222','Live Nation ACDC Gray T-Shirt',34.00,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,4,12,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:46'),
	(13,'332HHHHSSSLL222','Ohio State College T-Shirt',32.99,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,1,13,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:49'),
	(14,'332HHHHSSSLL222','Live Nation ACDC Gray T-Shirt',21.99,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,2,14,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:51'),
	(15,'332HHHHSSSLL222','Live Nation ACDC Gray T-Shirt',21.99,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum',2,4,14,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-27 21:45:54');

/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Product_Category
# ------------------------------------------------------------

LOCK TABLES `Product_Category` WRITE;
/*!40000 ALTER TABLE `Product_Category` DISABLE KEYS */;

INSERT INTO `Product_Category` (`id`, `category_id`, `product_id`, `create_date`, `update_date`)
VALUES
	(1,1,1,'2014-10-23 20:58:24','2014-10-23 20:58:24'),
	(2,2,1,'2014-10-23 20:58:24','2014-10-23 20:58:24'),
	(3,1,2,'2014-10-23 21:00:17','2014-10-23 21:00:17'),
	(5,2,2,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(7,3,2,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(8,3,3,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(9,3,4,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(10,4,5,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(11,3,5,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(12,4,6,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(13,4,7,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(14,4,8,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(15,6,8,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(16,5,8,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(17,6,9,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(18,6,10,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(19,6,11,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(20,6,12,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(21,4,13,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(22,2,13,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(23,1,13,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(24,5,13,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(25,5,14,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(26,5,15,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(27,1,15,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(28,2,15,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(30,6,13,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(33,6,1,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(34,6,2,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(35,6,3,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(36,1,3,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(37,2,3,'2014-10-23 21:00:17','2014-10-25 18:26:14'),
	(40,3,11,'2014-10-23 21:00:17','2014-10-25 18:26:14');

/*!40000 ALTER TABLE `Product_Category` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Product_Color
# ------------------------------------------------------------



# Dump of table Product_Order
# ------------------------------------------------------------



# Dump of table Size
# ------------------------------------------------------------

LOCK TABLES `Size` WRITE;
/*!40000 ALTER TABLE `Size` DISABLE KEYS */;

INSERT INTO `Size` (`id`, `size`, `create_date`, `update_date`)
VALUES
	(1,'M','2014-10-23 19:11:20','2014-10-23 19:11:20'),
	(2,'S','2014-10-23 21:35:22','2014-10-23 21:35:22'),
	(3,'X','2014-10-23 21:35:27','2014-10-23 21:35:27'),
	(4,'L','2014-10-23 21:35:31','2014-10-23 21:35:31'),
	(5,'XL','2014-10-23 21:35:36','2014-10-23 21:35:36'),
	(6,'XXL','2014-10-23 21:35:41','2014-10-23 21:35:41');

/*!40000 ALTER TABLE `Size` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table User
# ------------------------------------------------------------

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;

INSERT INTO `User` (`id`, `firstname`, `lastname`, `email`, `password`, `merchant`, `create_date`, `update_date`)
VALUES
	(1,'venkanna','ttrrfff','test-us-9242002@paypal.com','$2a$12$rtPeFF8HZ5CiNmN7BJrW2.LYso9gnMQGBc4TbhQF1SY13m6BrSx46','N','2014-10-23 20:14:12','2014-10-23 20:14:12'),
	(2,'venkanna','ttrrfff','test-us-9242003@paypal.com','$2a$12$vHhH5XeufwkvY62C46fpvu12ns0XPlswlTOYfGDpSXGvWhWr/0qH6','Y','2014-10-23 20:14:29','2014-10-23 20:14:29');

/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
