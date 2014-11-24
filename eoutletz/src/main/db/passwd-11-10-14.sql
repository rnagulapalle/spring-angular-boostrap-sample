CREATE TABLE `password_request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(256) DEFAULT NULL,
  `token` varchar(128) DEFAULT NULL,
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;


/**
 * Raj changes for likes
 * 
 */
CREATE TABLE `Product_User_Likes` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `product_id` bigint(11) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_user_likes` (`user_id`,`product_id`),
  KEY `Product_Likes` (`product_id`),
  KEY `User_Likes` (`user_id`),
  CONSTRAINT `Product_Product_Likes` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`),
  CONSTRAINT `User_Likes` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=latin1;

CREATE TABLE `Product_User_Reviews` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `product_id` bigint(11) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_user_reviews` (`user_id`,`product_id`),
  KEY `Product_Reviwes` (`product_id`),
  KEY `User_Reviews` (`user_id`),
  CONSTRAINT `Product_Product_Reviews` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`),
  CONSTRAINT `User_Reviews` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;

ALTER TABLE `Product` ADD likes BIGINT( 10 )

/**
 * End of Raj changes for Product likes
**/
