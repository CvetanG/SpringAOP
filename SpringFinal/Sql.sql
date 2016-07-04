CREATE TABLE `users` (
  `id_user` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8



CREATE TABLE `products` (
  `id_product` INT(11) NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(20) NOT NULL,
  `manufacturer` VARCHAR(20) NOT NULL,
  `product` VARCHAR(20) NOT NULL,
  `price` DECIMAL(6,2) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1

CREATE TABLE `orders` (
  `id_order` INT(11) NOT NULL AUTO_INCREMENT,
  `status` ENUM('NEW','SENT','UPDATED','RECEIVED','CANCELED','PROCESSED') DEFAULT NULL,
  `user_id` INT(11) DEFAULT NULL,
  `product_id` INT(11) DEFAULT NULL,
  `pcs` INT(2) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id_order`),
  KEY `id_user` (`user_id`),
  KEY `id_product` (`product_id`),
  CONSTRAINT `products` FOREIGN KEY (`product_id`) REFERENCES `products` (`id_product`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id_user`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8
