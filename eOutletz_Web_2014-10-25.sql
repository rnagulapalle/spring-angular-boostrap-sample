# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.21)
# Database: eOutletz_Web
# Generation Time: 2014-10-26 02:17:04 +0000
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

DROP TABLE IF EXISTS `Address`;

CREATE TABLE `Address` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(255) NOT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `postalcode` varchar(255) NOT NULL,
  `user_id` bigint(11) NOT NULL,
  `address_type_id` bigint(11) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_address` (`user_id`,`address_type_id`),
  KEY `Address_Address_Type` (`address_type_id`),
  KEY `Address_User` (`user_id`),
  CONSTRAINT `Address_Address_Type` FOREIGN KEY (`address_type_id`) REFERENCES `Address_Type` (`id`),
  CONSTRAINT `Address_User` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;

INSERT INTO `Address` (`id`, `address1`, `address2`, `city`, `state`, `country`, `postalcode`, `user_id`, `address_type_id`, `create_date`, `update_date`)
VALUES
	(1,'3200 zanker2','unit#22112','santa clara2','CA','usa','55566',2,1,'2014-10-25 18:54:58','2014-10-25 18:54:58'),
	(2,'3200 zanker2','unit#22112','santa clara2','CA','usa','55566',1,1,'2014-10-25 18:56:37','2014-10-25 18:56:37'),
	(3,'3200 zanker2','unit#22112','santa clara2','CA','usa','55566',1,2,'2014-10-25 18:56:53','2014-10-25 18:56:53'),
	(4,'3200 zanker2','unit#22112','santa clara2','CA','usa','55566',2,2,'2014-10-25 18:57:41','2014-10-25 18:58:48');

/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Address_Type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Address_Type`;

CREATE TABLE `Address_Type` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `Category`;

CREATE TABLE `Category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;

INSERT INTO `Category` (`id`, `name`, `create_date`, `update_date`)
VALUES
	(1,'This is sample Category','2014-10-23 20:12:56','2014-10-23 20:12:56'),
	(2,'This is sample Category2','2014-10-23 20:13:16','2014-10-23 20:13:16');

/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Color
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Color`;

CREATE TABLE `Color` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(255) NOT NULL DEFAULT '',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `color` (`color`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Image
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Image`;

CREATE TABLE `Image` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(75) NOT NULL,
  `prod_id` bigint(11) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `image` (`image`,`prod_id`),
  KEY `Image_Prod` (`prod_id`),
  CONSTRAINT `Image_Prod ` FOREIGN KEY (`prod_id`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Image` WRITE;
/*!40000 ALTER TABLE `Image` DISABLE KEYS */;

INSERT INTO `Image` (`id`, `image`, `prod_id`, `create_date`, `update_date`)
VALUES
	(1,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',1,'2014-10-23 21:22:50','2014-10-23 21:22:50'),
	(2,'http://upload.wikimedia.org/wikipedia/commons/5/52/Bangalore_Shiva.jpg',1,'2014-10-23 21:23:41','2014-10-23 21:23:41'),
	(3,'http://upload.wikimedia.org/wikipedia/commons/5/52/Bangalore_Shiva.jpg',2,'2014-10-23 21:23:47','2014-10-23 21:23:47'),
	(4,'http://demo.18maret.com/demo/mimity/images/product-8.jpg',2,'2014-10-23 21:23:54','2014-10-23 21:23:54');

/*!40000 ALTER TABLE `Image` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Order_Status
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Order_Status`;

CREATE TABLE `Order_Status` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `status` bigint(11) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Order_Tracking
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Order_Tracking`;

CREATE TABLE `Order_Tracking` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `order_id` bigint(11) NOT NULL,
  `comments` varchar(255) NOT NULL,
  `order_status_id` bigint(11) NOT NULL,
  `tracking_number` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_status_tracking` (`order_id`,`order_status_id`,`tracking_number`),
  KEY `Order_Tracking_Order_Status` (`order_status_id`),
  CONSTRAINT `Order_Tracking_Order_Status` FOREIGN KEY (`order_status_id`) REFERENCES `Order_Status` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Orders
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Orders`;

CREATE TABLE `Orders` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `payment_type_id` bigint(11) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `address_id` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Order_Address` (`address_id`),
  KEY `Order_Payment_Type` (`payment_type_id`),
  KEY `Order_User` (`user_id`),
  CONSTRAINT `Order_Address` FOREIGN KEY (`address_id`) REFERENCES `Address` (`id`),
  CONSTRAINT `Order_Payment_Type` FOREIGN KEY (`payment_type_id`) REFERENCES `Payment_Type` (`id`),
  CONSTRAINT `Order_User` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Partner
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Partner`;

CREATE TABLE `Partner` (
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `Partner_Contact`;

CREATE TABLE `Partner_Contact` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(255) NOT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `type_id` bigint(11) NOT NULL,
  `partner_id` bigint(11) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `postal_code` varchar(25) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `type_id` (`type_id`,`partner_id`),
  KEY `Partner_Contact_Partner` (`partner_id`),
  KEY `Partner_Contact_Address_Type` (`type_id`),
  CONSTRAINT `Partner_Contact_Address_Type` FOREIGN KEY (`type_id`) REFERENCES `Address_Type` (`id`),
  CONSTRAINT `Partner_Contact_Partner` FOREIGN KEY (`partner_id`) REFERENCES `Partner` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `Payment_Type`;

CREATE TABLE `Payment_Type` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Phone
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Phone`;

CREATE TABLE `Phone` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `user_id` bigint(11) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`type`,`phone`),
  KEY `Phone_User` (`user_id`),
  CONSTRAINT `Phone_User` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Product
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Product`;

CREATE TABLE `Product` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `sku` varchar(25) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL,
  `price` decimal(12,2) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `partner_id` bigint(11) NOT NULL,
  `size_id` bigint(11) NOT NULL,
  `quantity` bigint(11) NOT NULL,
  `msrp` decimal(12,2) NOT NULL,
  `units_in_stock` bigint(11) NOT NULL,
  `units_in_order` bigint(11) NOT NULL,
  `unit_price` decimal(12,2) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `product_Partner` (`partner_id`),
  KEY `product_Size` (`size_id`),
  CONSTRAINT `product_Partner` FOREIGN KEY (`partner_id`) REFERENCES `Partner` (`id`),
  CONSTRAINT `product_Size` FOREIGN KEY (`size_id`) REFERENCES `Size` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;

INSERT INTO `Product` (`id`, `sku`, `name`, `price`, `description`, `partner_id`, `size_id`, `quantity`, `msrp`, `units_in_stock`, `units_in_order`, `unit_price`, `create_date`, `update_date`)
VALUES
	(1,'332HHHHSSSLL222','Sample Product',33.23,'This is sample description',2,1,22,22.11,10,0,11.00,'2014-10-23 20:58:24','2014-10-23 20:58:24'),
	(2,'332HHHHSSSLL222','Sample Productwww',33.23,'This is sample description',2,1,22,22.11,10,0,11.00,'2014-10-23 21:00:17','2014-10-23 21:00:17');

/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Product_Category
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Product_Category`;

CREATE TABLE `Product_Category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(11) NOT NULL,
  `product_id` bigint(11) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `category_id` (`category_id`,`product_id`),
  KEY `Product_Product` (`product_id`),
  KEY `Category_Category` (`category_id`),
  CONSTRAINT `Category_Category ` FOREIGN KEY (`category_id`) REFERENCES `Category` (`id`),
  CONSTRAINT `Product_Product` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Product_Category` WRITE;
/*!40000 ALTER TABLE `Product_Category` DISABLE KEYS */;

INSERT INTO `Product_Category` (`id`, `category_id`, `product_id`, `create_date`, `update_date`)
VALUES
	(1,1,1,'2014-10-23 20:58:24','2014-10-23 20:58:24'),
	(2,2,1,'2014-10-23 20:58:24','2014-10-23 20:58:24'),
	(3,1,2,'2014-10-23 21:00:17','2014-10-23 21:00:17'),
	(5,2,2,'2014-10-23 21:00:17','2014-10-25 18:26:14');

/*!40000 ALTER TABLE `Product_Category` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Product_Color
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Product_Color`;

CREATE TABLE `Product_Color` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(11) NOT NULL,
  `color_id` bigint(11) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_id` (`product_id`,`color_id`),
  KEY `Product_Color_Color` (`color_id`),
  KEY `Product_Color_Product` (`product_id`),
  CONSTRAINT `Product_Color_Color` FOREIGN KEY (`color_id`) REFERENCES `Color` (`id`),
  CONSTRAINT `Product_Color_Product` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Product_Order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Product_Order`;

CREATE TABLE `Product_Order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(11) NOT NULL,
  `order_id` bigint(11) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_id` (`product_id`,`order_id`),
  KEY `Product_Order` (`order_id`),
  KEY `Product_Product_Id` (`product_id`),
  CONSTRAINT `Product_Order` FOREIGN KEY (`order_id`) REFERENCES `Order` (`id`),
  CONSTRAINT `Product_Product_Id` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Size
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Size`;

CREATE TABLE `Size` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(3) NOT NULL DEFAULT '',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `size` (`size`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL DEFAULT '',
  `merchant` char(1) NOT NULL DEFAULT 'N',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`,`merchant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
