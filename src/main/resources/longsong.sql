/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_mysql
Source Server Version : 50517
Source Host           : 127.0.0.1:3306
Source Database       : longsong

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2017-12-08 17:19:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `data_gate`
-- ----------------------------
DROP TABLE IF EXISTS `data_gate`;
CREATE TABLE `data_gate` (
  `id` char(32) NOT NULL,
  `name` varchar(128) NOT NULL COMMENT '关卡名称',
  `need_level` varchar(128) NOT NULL COMMENT '需求等级',
  `boss_add` varchar(128) NOT NULL COMMENT '旗舰刷新',
  `clear_award` varchar(128) NOT NULL COMMENT '地图掉落',
  `award_list` varchar(1024) DEFAULT NULL COMMENT '掉落信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_gate
-- ----------------------------

-- ----------------------------
-- Table structure for `data_index`
-- ----------------------------
DROP TABLE IF EXISTS `data_index`;
CREATE TABLE `data_index` (
  `id` char(32) NOT NULL,
  `code` varchar(128) NOT NULL,
  `type` varchar(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_index
-- ----------------------------

-- ----------------------------
-- Table structure for `data_ship`
-- ----------------------------
DROP TABLE IF EXISTS `data_ship`;
CREATE TABLE `data_ship` (
  `id` char(32) NOT NULL,
  `name` varchar(128) NOT NULL COMMENT '舰娘名称',
  `no` varchar(128) NOT NULL COMMENT '编号',
  `star` varchar(128) NOT NULL COMMENT '初始星级',
  `type` varchar(128) NOT NULL COMMENT '类型',
  `rarity` varchar(128) NOT NULL COMMENT '稀有度',
  `group` varchar(128) NOT NULL COMMENT '阵营',
  `building_time` varchar(128) NOT NULL COMMENT '建造耗时',
  `catch_place` varchar(512) NOT NULL COMMENT '获取关卡',
  `nutritive_value` varchar(512) NOT NULL COMMENT '强化价值',
  `sell_value` varchar(512) NOT NULL COMMENT '卖出价值',
  `advanced` text COMMENT '进阶',
  `performance` text COMMENT '属性',
  `performance_max` text COMMENT '最大属性',
  `skill` text COMMENT '技能',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='舰娘基础信息';

-- ----------------------------
-- Records of data_ship
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_fun`
-- ----------------------------
DROP TABLE IF EXISTS `sys_fun`;
CREATE TABLE `sys_fun` (
  `id` char(32) NOT NULL,
  `display` varchar(128) NOT NULL,
  `ctl` varchar(128) NOT NULL,
  `act` varchar(128) NOT NULL,
  `level` int(11) NOT NULL,
  `is_enabled` char(1) NOT NULL DEFAULT '0',
  `no` varchar(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_fun
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` char(32) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `level` int(11) NOT NULL,
  `create_time` char(19) NOT NULL,
  `create_by` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
