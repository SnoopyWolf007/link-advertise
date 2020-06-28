/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : link_advertise

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2020-06-28 19:42:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_account_info
-- ----------------------------
DROP TABLE IF EXISTS `t_account_info`;
CREATE TABLE `t_account_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `channel_id` bigint(20) NOT NULL,
  `account` varchar(100) DEFAULT NULL,
  `owners` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告投放账户表';

-- ----------------------------
-- Table structure for t_channel_info
-- ----------------------------
DROP TABLE IF EXISTS `t_channel_info`;
CREATE TABLE `t_channel_info` (
  `id` bigint(20) NOT NULL,
  `code` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告渠道表';

-- ----------------------------
-- Table structure for t_domain_info
-- ----------------------------
DROP TABLE IF EXISTS `t_domain_info`;
CREATE TABLE `t_domain_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `domain_url` text,
  `domain_md5` varchar(50) NOT NULL,
  `owners` varchar(500) DEFAULT NULL COMMENT '域名拥有者 code集合,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志位：0-正常，1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='投放域名表';

-- ----------------------------
-- Table structure for t_landing_page_info
-- ----------------------------
DROP TABLE IF EXISTS `t_landing_page_info`;
CREATE TABLE `t_landing_page_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `domain_id` bigint(20) DEFAULT NULL COMMENT '域名id',
  `landing_page_url` text COMMENT '落地页地址',
  `landing_page_md5` varchar(50) DEFAULT NULL COMMENT 'md5',
  `landing_page_params` text COMMENT '插码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  `creator_code` varchar(50) DEFAULT NULL COMMENT '创建人code',
  `delete_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志位：0-正常，1-删除',
  PRIMARY KEY (`id`),
  KEY `idx_domian` (`domain_id`),
  CONSTRAINT `t_landing_page_info_ibfk_1` FOREIGN KEY (`domain_id`) REFERENCES `t_domain_info` (`id`) ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='落地页表';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织架构表';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员信息表';

-- ----------------------------
-- Function structure for fn_get_org_child
-- ----------------------------
DROP FUNCTION IF EXISTS `fn_get_org_child`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fn_get_org_child`(rCode CHAR) RETURNS varchar(2000) CHARSET utf8
BEGIN
#声明两个临时变量
DECLARE temp VARCHAR(2000);
DECLARE temp_child VARCHAR(2000);
SET temp = '$';
SET temp_child = rCode;
WHILE temp_child is not null DO
SET temp = CONCAT(temp,',',temp_child);#循环把所有节点连接成字符串。
SELECT GROUP_CONCAT(`code`) INTO temp_child FROM `t_organization_info` where FIND_IN_SET(parent_code, temp_child) > 0;
END WHILE;
RETURN temp;
END
;;
DELIMITER ;
SET FOREIGN_KEY_CHECKS=1;
