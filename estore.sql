/*
Navicat MySQL Data Transfer

Source Server         : flarum
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : estore

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2017-03-06 09:34:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `code` int(11) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `fathercode` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('51', '手机', '0');
INSERT INTO `category` VALUES ('5101', '苹果', '51');
INSERT INTO `category` VALUES ('510101', 'iPhone5', '5101');
INSERT INTO `category` VALUES ('510103', 'iPhone5s', '5101');
INSERT INTO `category` VALUES ('510104', 'iPhone6', '5101');
INSERT INTO `category` VALUES ('510105', 'iPhone 6 Plus', '5101');
INSERT INTO `category` VALUES ('510106', 'iPhone 6s', '5101');
INSERT INTO `category` VALUES ('510107', 'iPhone 6s Plus', '5101');
INSERT INTO `category` VALUES ('510108', 'iPhone 7', '5101');
INSERT INTO `category` VALUES ('510109', 'iPhone 7 Plus', '5101');
INSERT INTO `category` VALUES ('510102', 'iPhone5c', '5101');
INSERT INTO `category` VALUES ('510110', 'iPhone SE', '5101');
INSERT INTO `category` VALUES ('5102', '三星', '51');
INSERT INTO `category` VALUES ('510201', 'Galaxy S7 Edge', '5102');
INSERT INTO `category` VALUES ('510202', 'Galaxy S6', '5102');
INSERT INTO `category` VALUES ('510203', 'Galaxy S6 Edge', '5102');
INSERT INTO `category` VALUES ('510204', 'Galaxy S6 Edge+', '5102');
INSERT INTO `category` VALUES ('510205', 'Galaxy S7', '5102');
INSERT INTO `category` VALUES ('510206', 'Galaxy Note4', '5102');
INSERT INTO `category` VALUES ('510207', 'Galaxy Note5', '5102');
INSERT INTO `category` VALUES ('510208', 'Galaxy Note7', '5102');
INSERT INTO `category` VALUES ('5103', '华为', '51');
INSERT INTO `category` VALUES ('510301', 'Mate 7', '5103');
INSERT INTO `category` VALUES ('510302', 'Mate 8', '5103');
INSERT INTO `category` VALUES ('5104', '小米', '51');
INSERT INTO `category` VALUES ('510401', '小米手机5', '5104');
INSERT INTO `category` VALUES ('52', '平板', '0');
INSERT INTO `category` VALUES ('5201', 'Apple', '52');
INSERT INTO `category` VALUES ('520101', 'iPad mini 2', '5201');
INSERT INTO `category` VALUES ('520102', 'iPad mini', '5201');
INSERT INTO `category` VALUES ('520103', 'iPad 4', '5201');
INSERT INTO `category` VALUES ('520104', 'iPad Air', '5201');
INSERT INTO `category` VALUES ('520105', 'iPad Air 2', '5201');
INSERT INTO `category` VALUES ('520106', 'iPad mini 3', '5201');
INSERT INTO `category` VALUES ('520107', 'iPad mini', '5201');
INSERT INTO `category` VALUES ('520108', 'iPad Pro 12.9英寸', '5201');
INSERT INTO `category` VALUES ('520109', 'iPad Pro 9.7英寸', '5201');
INSERT INTO `category` VALUES ('5202', '亚马逊', '52');
INSERT INTO `category` VALUES ('520201', 'Kindle Oasis', '5202');
INSERT INTO `category` VALUES ('53', '笔记本', '0');
INSERT INTO `category` VALUES ('5301', '苹果', '53');
INSERT INTO `category` VALUES ('530101', 'MacBook Air(11\",Early 2015)', '5301');
INSERT INTO `category` VALUES ('530102', 'MacBook Air(13\",Early 2015)', '5301');
INSERT INTO `category` VALUES ('530103', 'MacBook (12\",Early 2015)', '5301');
INSERT INTO `category` VALUES ('530104', 'MacBook Pro (13\",Early 2015)', '5301');
INSERT INTO `category` VALUES ('530105', 'MacBook Pro (15\",Mid 2015)', '5301');
INSERT INTO `category` VALUES ('530106', 'MacBook Pro (15\",Mid 2014)', '5301');
INSERT INTO `category` VALUES ('530107', 'MacBook Pro (13\",Mid 2014)', '5301');
INSERT INTO `category` VALUES ('54', '配件', '0');
INSERT INTO `category` VALUES ('5401', '数据线', '54');
INSERT INTO `category` VALUES ('540101', 'Apple', '5401');
INSERT INTO `category` VALUES ('5402', '耳机', '54');
INSERT INTO `category` VALUES ('540101', 'Apple', '5402');
INSERT INTO `category` VALUES ('5403', '充电器', '54');
INSERT INTO `category` VALUES ('540301', 'Apple', '5403');
INSERT INTO `category` VALUES ('5404', '转换器', '54');
INSERT INTO `category` VALUES ('540401', 'Apple', '5404');
INSERT INTO `category` VALUES ('5405', '贴膜', '54');
INSERT INTO `category` VALUES ('540501', '定制', '5405');
INSERT INTO `category` VALUES ('5406', '保护套', '54');
INSERT INTO `category` VALUES ('540601', '定制', '5406');
INSERT INTO `category` VALUES (null, null, null);

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` double DEFAULT NULL,
  `receiverinfo` varchar(255) DEFAULT NULL,
  `paystate` int(11) DEFAULT NULL,
  `ordertime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '2247', '', '0', '2016-12-20 12:15:47', null);
INSERT INTO `orders` VALUES ('2', '0', null, '0', '2016-12-20 18:50:42', null);
INSERT INTO `orders` VALUES ('3', '0', null, '0', '2016-12-22 11:01:18', null);
INSERT INTO `orders` VALUES ('4', '0', null, '0', '2016-12-22 11:07:23', null);
INSERT INTO `orders` VALUES ('5', '0', null, '0', '2016-12-22 11:08:39', null);
INSERT INTO `orders` VALUES ('6', '0', null, '0', '2016-12-22 11:09:58', null);
INSERT INTO `orders` VALUES ('7', '0', null, '0', '2016-12-22 11:19:46', null);
INSERT INTO `orders` VALUES ('8', '0', null, '0', '2016-12-22 11:44:47', null);
INSERT INTO `orders` VALUES ('9', '0', null, '0', '2016-12-22 11:56:51', null);
INSERT INTO `orders` VALUES ('10', '0', null, '0', '2016-12-22 12:05:40', null);
INSERT INTO `orders` VALUES ('11', '0', null, '0', '2016-12-22 12:06:05', null);
INSERT INTO `orders` VALUES ('12', '0', null, '0', '2016-12-23 10:51:18', null);
INSERT INTO `orders` VALUES ('13', '0', null, '0', '2016-12-23 10:51:49', null);
INSERT INTO `orders` VALUES ('14', '0', null, '0', '2016-12-25 21:45:16', null);
INSERT INTO `orders` VALUES ('15', '0', null, '0', '2016-12-25 21:47:36', null);
INSERT INTO `orders` VALUES ('16', '0', null, '0', '2016-12-25 21:48:11', null);
INSERT INTO `orders` VALUES ('17', '0', null, '0', '2016-12-27 11:04:03', null);
INSERT INTO `orders` VALUES ('18', '0', null, '0', '2016-12-28 14:46:16', null);
INSERT INTO `orders` VALUES ('19', '0', null, '0', '2017-01-08 21:13:05', null);
INSERT INTO `orders` VALUES ('20', '0', null, '0', '2017-02-28 15:12:13', null);

-- ----------------------------
-- Table structure for `products`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `pnum` int(11) DEFAULT NULL,
  `c3code` int(11) DEFAULT NULL,
  `imgurl` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `color` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', 'Apple', '949', '122', '510103', '1.png', 'iPhone 5s 16G 移动4G', '黑色');
INSERT INTO `products` VALUES ('2', 'Apple', '899', '23', '510101', '2.png', 'iPhone 5s 16G 联通4G/移动4G', '金色');
INSERT INTO `products` VALUES ('3', 'Apple', '1199', '152', '510103', '3.png', 'iPhone 5s 16G 联通4G/移动4G', '白色');
INSERT INTO `products` VALUES ('4', '三星', '1099', '220', '510206', '4.png', 'Galaxy Note 4 16G 移动4G', '白色');
INSERT INTO `products` VALUES ('5', 'Apple', '1899', '123', '510104', '5.png', 'iPhone 6 16G 联通4G/移动4G/电信4G', '黑色');
INSERT INTO `products` VALUES ('6', 'Apple', '1949', '360', '510110', '6.jpg', 'iPhone SE 16G 联通4G/移动4G/电信4G', '金色');
INSERT INTO `products` VALUES ('7', 'Apple', '2549', '999', '510106', '6.png', 'iPhone 6s 16G 联通4G/移动4G/电信4G', '玫瑰金');
INSERT INTO `products` VALUES ('8', '三星', '2749', '456', '510201', '7.jpg', 'Galaxy S7 Edge 32G 移动4G/联通4G/电信4G', '白色');
INSERT INTO `products` VALUES ('9', 'Apple', '4099', '123', '510108', '8.jpg', 'iPhone 7 32G 联通4G/移动4G/电信4G', '金色');
INSERT INTO `products` VALUES ('10', 'Apple', '6099', '5665', '510109', '9.jpg', 'iPhone 7 Plus 128G 联通4G/移动4G/电信4G', '亮黑色');
INSERT INTO `products` VALUES ('11', 'Apple', '6249', '500', '510109', '10.jpg', 'iPhone 7 Plus 128G 联通4G/移动4G/电信4G', '玫瑰金');
INSERT INTO `products` VALUES ('12', 'Apple', '649', '266', '520102', '11.png', 'iPad mini 16G 港行WIFI版', '白色');
INSERT INTO `products` VALUES ('13', 'Apple', '749', '555', '520102', '12.png', 'iPad mini 16G 国行WIFI版', '白色');
INSERT INTO `products` VALUES ('14', 'Apple', '1149', '9999', '520101', '13.png', 'iPad mini 2 16G 国行WIFI版', '白色');
INSERT INTO `products` VALUES ('15', 'Apple', '1499', '200', '520101', '14.png', 'iPad mini 2 32G 港行Cellular版', '白色');
INSERT INTO `products` VALUES ('16', 'Apple', '4499', '12', '520108', '15.jpg', 'iPad Pro 128G WIFI版', '黑色');
INSERT INTO `products` VALUES ('17', 'Apple', '999', '265', '520102', '16.png', 'iPad mini 32G 国行Cellular版', '银色');
INSERT INTO `products` VALUES ('18', '苹果', '7299', '999', '530104', '17.jpg', 'MacBook Pro(13\",Early 2015)256G', '银色');
INSERT INTO `products` VALUES ('19', '苹果', '8399', '999', '530106', '18.jpg', 'MookBook Pro(15\",Mid 2014)256G', '银色');
INSERT INTO `products` VALUES ('20', 'Apple', '69', '999', '540101', '19.png', 'Lighting to USB 数据线', '白色');
INSERT INTO `products` VALUES ('21', 'Apple', '89', '999', '540101', '20.png', 'Apple EarPods 耳机', '白色');
INSERT INTO `products` VALUES ('22', 'Apple', '69', '999', '540301', '21.png', 'Apple 5W USB 电源适配器 ', '白色');
INSERT INTO `products` VALUES ('23', '爱否FView', '14.9', '9999', '540501', '22.jpg', 'iPhone6/6s HR+高透保护膜（非钢化）', '透明');
INSERT INTO `products` VALUES ('24', '爱否FView', '24.9', '6756', '540601', '23.jpg', 'iPhone 6/6s 纤薄透明保护壳', '黑色');
INSERT INTO `products` VALUES ('25', '爱否FView', '29.9', '26', '540501', '25.jpg', 'iPhone 6 Plus/6s Plus 软边钢化膜', '透明');
INSERT INTO `products` VALUES ('26', 'Apple', '2999', '265', '510106', '26.png', 'iPhone 6s 64G 联通4G/移动4G/电信4G', '银色');
INSERT INTO `products` VALUES ('27', 'Apple', '3149', '255', '510105', '27.png', 'iPhone 6 Plus 64G 联通4G/移动4G/电信4G', '白色');
INSERT INTO `products` VALUES ('28', 'Apple', '128', '45', '540101', '28.jpg', 'Apple 5W USB 电源适配器&Lightning to USB 数据线', '白色');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `activecode` varchar(100) DEFAULT NULL,
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '辜鹏', '123', '77363191@qq.com', 'user', '1', 'afd7a459-b948-4239-9ad6-29c5a172fa1e', '2016-12-05 23:20:50');
INSERT INTO `users` VALUES ('2', 'admin', '123', '10000@qq.com', 'admin', '1', '000000', '2016-12-19 16:44:18');
