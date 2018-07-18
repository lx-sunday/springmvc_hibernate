/*
Navicat MySQL Data Transfer

Source Server         : localhost3306
Source Server Version : 50638
Source Host           : localhost:3306
Source Database       : work

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2018-07-18 20:43:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for acct_authority
-- ----------------------------
DROP TABLE IF EXISTS `acct_authority`;
CREATE TABLE `acct_authority` (
  `id` varchar(36) NOT NULL COMMENT '权限Id',
  `name` varchar(255) NOT NULL COMMENT '权限名称',
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of acct_authority
-- ----------------------------
INSERT INTO `acct_authority` VALUES ('b6d3ceb9-eae9-43a6-9064-424db8c53208', '查看用户');
INSERT INTO `acct_authority` VALUES ('29a366b9-bbbf-47e4-a0c2-26eec58b1822', '添加用户');

-- ----------------------------
-- Table structure for acct_role
-- ----------------------------
DROP TABLE IF EXISTS `acct_role`;
CREATE TABLE `acct_role` (
  `id` varchar(36) NOT NULL COMMENT '角色Id',
  `name` varchar(255) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of acct_role
-- ----------------------------
INSERT INTO `acct_role` VALUES ('b432d31d-ebd2-4e91-9184-1b3769e6686b', 'admin');

-- ----------------------------
-- Table structure for acct_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `acct_role_authority`;
CREATE TABLE `acct_role_authority` (
  `role_id` varchar(36) NOT NULL COMMENT '角色id',
  `authority_id` varchar(36) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`,`authority_id`),
  KEY `role_id` (`role_id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `acct_role_authority_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `acct_role` (`id`),
  CONSTRAINT `acct_role_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `acct_authority` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of acct_role_authority
-- ----------------------------
INSERT INTO `acct_role_authority` VALUES ('b432d31d-ebd2-4e91-9184-1b3769e6686b', '29a366b9-bbbf-47e4-a0c2-26eec58b1822');
INSERT INTO `acct_role_authority` VALUES ('b432d31d-ebd2-4e91-9184-1b3769e6686b', 'b6d3ceb9-eae9-43a6-9064-424db8c53208');

-- ----------------------------
-- Table structure for acct_user
-- ----------------------------
DROP TABLE IF EXISTS `acct_user`;
CREATE TABLE `acct_user` (
  `id` varchar(36) NOT NULL COMMENT '用户ID',
  `nick_name` varchar(255) NOT NULL COMMENT '昵称',
  `telephone` varchar(255) DEFAULT NULL COMMENT '电话',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`),
  KEY `nick_name` (`nick_name`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of acct_user
-- ----------------------------
INSERT INTO `acct_user` VALUES ('14ff5253-5912-4a3f-b51b-f50d9da0271d', 'zty', '13022221111', '2015-02-06 17:13:55');
INSERT INTO `acct_user` VALUES ('6e5afb1d-50e1-45fe-b6fe-b9e399415387', 'andy', '15147174722', '2015-02-06 17:06:36');
INSERT INTO `acct_user` VALUES ('ecb11949-72dc-44eb-8d9b-f286a0e16342', 'lx', '15608062650', '2018-04-25 09:43:22');
INSERT INTO `acct_user` VALUES ('fc9b9b90-82c8-4cef-ad65-fadd44b3b028', 'andy', '13022221111', '2018-04-25 09:42:25');

-- ----------------------------
-- Table structure for acct_user_role
-- ----------------------------
DROP TABLE IF EXISTS `acct_user_role`;
CREATE TABLE `acct_user_role` (
  `user_id` varchar(36) NOT NULL COMMENT '用户Id',
  `role_id` varchar(36) NOT NULL COMMENT '角色Id',
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `role_id` (`role_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `acct_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`),
  CONSTRAINT `acct_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `acct_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of acct_user_role
-- ----------------------------
INSERT INTO `acct_user_role` VALUES ('6e5afb1d-50e1-45fe-b6fe-b9e399415387', 'b432d31d-ebd2-4e91-9184-1b3769e6686b');
