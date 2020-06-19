/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : link_advertise

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2020-06-19 16:23:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_organization_info
-- ----------------------------
DROP TABLE IF EXISTS `t_organization_info`;
CREATE TABLE `t_organization_info` (
  `code` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `parent_code` varchar(100) DEFAULT NULL,
  `level` int(3) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `delete_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0：正常， 1：删除',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_personnel_info
-- ----------------------------
DROP TABLE IF EXISTS `t_personnel_info`;
CREATE TABLE `t_personnel_info` (
  `code` varchar(100) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `id_card_no` varchar(30) DEFAULT NULL,
  `organization_code` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `delete_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0：正常， 1：删除',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
