/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : auction

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-12-03 23:11:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auction_user
-- ----------------------------
DROP TABLE IF EXISTS `auction_user`;
CREATE TABLE `auction_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `userpass` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auction_user
-- ----------------------------
INSERT INTO `auction_user` VALUES ('1', 'tomcat', 'tomcat', 'spring_test@163.com');
INSERT INTO `auction_user` VALUES ('2', 'mysql', 'mysql', 'spring_test@163.com');

-- ----------------------------
-- Table structure for bid
-- ----------------------------
DROP TABLE IF EXISTS `bid`;
CREATE TABLE `bid` (
  `bid_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `bid_price` double NOT NULL,
  `bid_date` date NOT NULL,
  PRIMARY KEY (`bid_id`),
  UNIQUE KEY `item_id` (`item_id`,`bid_price`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `bid_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `auction_user` (`user_id`),
  CONSTRAINT `bid_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bid
-- ----------------------------
INSERT INTO `bid` VALUES ('1', '2', '1', '250', '2016-04-13');
INSERT INTO `bid` VALUES ('2', '1', '3', '25000', '2016-04-09');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL,
  `item_remark` varchar(255) DEFAULT NULL,
  `item_desc` varchar(255) DEFAULT NULL,
  `kind_id` int(11) NOT NULL,
  `addtime` date NOT NULL,
  `endtime` date NOT NULL,
  `init_price` double NOT NULL,
  `max_price` double NOT NULL,
  `owner_id` int(11) NOT NULL,
  `winer_id` int(11) DEFAULT NULL,
  `state_id` int(11) NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `kind_id` (`kind_id`),
  KEY `owner_id` (`owner_id`),
  KEY `winer_id` (`winer_id`),
  KEY `state_id` (`state_id`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`kind_id`) REFERENCES `kind` (`kind_id`),
  CONSTRAINT `item_ibfk_2` FOREIGN KEY (`owner_id`) REFERENCES `auction_user` (`user_id`),
  CONSTRAINT `item_ibfk_3` FOREIGN KEY (`winer_id`) REFERENCES `auction_user` (`user_id`),
  CONSTRAINT `item_ibfk_4` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '主板', '老式主板', '老主板，还可以用', '1', '2016-04-10', '2016-05-15', '230', '250', '1', '2', '1');
INSERT INTO `item` VALUES ('2', '显卡', '老式显卡', '老显卡，还可以用', '1', '2016-04-06', '2016-04-13', '210', '210', '2', '2', '3');
INSERT INTO `item` VALUES ('3', '老房子', '老式房子', '40年的老房子', '2', '2016-04-06', '2016-04-10', '21000', '25000', '2', '1', '2');

-- ----------------------------
-- Table structure for kind
-- ----------------------------
DROP TABLE IF EXISTS `kind`;
CREATE TABLE `kind` (
  `kind_id` int(11) NOT NULL AUTO_INCREMENT,
  `kind_name` varchar(50) NOT NULL,
  `kind_desc` varchar(255) NOT NULL,
  PRIMARY KEY (`kind_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kind
-- ----------------------------
INSERT INTO `kind` VALUES ('1', '电脑硬件', '这里并不是很主流的产品，但价格绝对令你心动');
INSERT INTO `kind` VALUES ('2', '房产', '提供非常稀缺的房源');
INSERT INTO `kind` VALUES ('3', '99', '99');
INSERT INTO `kind` VALUES ('4', '88', '88');

-- ----------------------------
-- Table structure for state
-- ----------------------------
DROP TABLE IF EXISTS `state`;
CREATE TABLE `state` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of state
-- ----------------------------
INSERT INTO `state` VALUES ('1', '拍卖中');
INSERT INTO `state` VALUES ('2', '拍卖成功');
INSERT INTO `state` VALUES ('3', '流拍');
