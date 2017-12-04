/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : longsong

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2017-12-04 19:17:50
*/

SET FOREIGN_KEY_CHECKS=0;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='舰娘基础信息';

-- ----------------------------
-- Records of data_ship
-- ----------------------------
INSERT INTO `data_ship` VALUES ('0fff99f8e36f4ff58bd28b1426cc733f', '胡德', 'NO.129', '★★★☆☆☆', '战巡', '金色', '皇家', '05:50:00');
INSERT INTO `data_ship` VALUES ('515e94797af3444d8ba97d6c31400b39', '卡辛', 'NO.005', '★☆☆☆', '驱逐', '白色', '白鹰', '00:23:00');
INSERT INTO `data_ship` VALUES ('5465aca7c37441e0980300c1826c3d2f', '翔鹤', 'NO.228', '★★★☆☆☆', '航母', '金色', '重樱', '04:30:00(活动已关闭)');
INSERT INTO `data_ship` VALUES ('6412679201ba4b0a8c088c12b8425d36', '神通', 'NO.309', '★★☆☆☆', '轻巡', '紫色', '重樱', '无法建造');
INSERT INTO `data_ship` VALUES ('6fcf1843d56f481a89e74db6074f9694', '三笠', 'NO.320', '★★★☆☆☆', '战列', '金色', '重樱', '03:30:00(未实装)');
INSERT INTO `data_ship` VALUES ('9e9a72b8dc514f709aeef45ad0f0d442', '睦月', 'NO.271', '★☆☆☆', '驱逐', '白色', '重樱', '00:21:00');
INSERT INTO `data_ship` VALUES ('aaca43a4f1384ba3b19d438e14c37a72', '唐斯', 'NO.006', '★☆☆☆', '驱逐', '白色', '白鹰', '00:23:00');
INSERT INTO `data_ship` VALUES ('d50e0c1054a642e0be477cb59a2f2de8', '凤翔', 'NO.220', '★★☆☆☆', '轻母', '紫色', '重樱', '无法建造');

-- ----------------------------
-- Table structure for `data_ship_advanced`
-- ----------------------------
DROP TABLE IF EXISTS `data_ship_advanced`;
CREATE TABLE `data_ship_advanced` (
  `id` char(32) NOT NULL,
  `ship_id` char(32) NOT NULL COMMENT '舰娘id',
  `adv_name` varchar(128) NOT NULL COMMENT '阶段名称',
  `adv_content` varchar(512) NOT NULL COMMENT '阶段描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='舰娘进阶信息';

-- ----------------------------
-- Records of data_ship_advanced
-- ----------------------------
INSERT INTO `data_ship_advanced` VALUES ('0610727284164514bf258131a699f13c', '515e94797af3444d8ba97d6c31400b39', '二阶', '鱼雷底座+1/鱼雷预装填+1/全武器效率提高3%');
INSERT INTO `data_ship_advanced` VALUES ('1edb3fc5f1774869a0b880652493a7ba', '6fcf1843d56f481a89e74db6074f9694', '一阶', '主炮底座+1/主炮效率提高5%');
INSERT INTO `data_ship_advanced` VALUES ('299c4fd58a3545808da46cc847b0e615', '9e9a72b8dc514f709aeef45ad0f0d442', '一阶', '获得全弹发射I/鱼雷效率提高5%');
INSERT INTO `data_ship_advanced` VALUES ('33b48190455a441eb357eb6ef6293f61', '6412679201ba4b0a8c088c12b8425d36', '三阶', '全弹发射弹幕升级/鱼雷效率提高15%');
INSERT INTO `data_ship_advanced` VALUES ('35b8c740ca4944ea9b962bb33ed99a64', 'd50e0c1054a642e0be477cb59a2f2de8', '三阶', '所有舰载机+1/舰载机效率提高7%');
INSERT INTO `data_ship_advanced` VALUES ('3722638f6dd3462fbcd061e71d175b4a', '5465aca7c37441e0980300c1826c3d2f', '一阶', '所有鱼雷机+1/鱼雷机效率提高5%');
INSERT INTO `data_ship_advanced` VALUES ('440655ff15bb424d9804575eca44c6d9', '6fcf1843d56f481a89e74db6074f9694', '二阶', '副炮底座+1/主炮效率提高10%');
INSERT INTO `data_ship_advanced` VALUES ('4f126faa071e4b12b554293ea649db8b', '6fcf1843d56f481a89e74db6074f9694', '三阶', '主炮底座+1/主炮效率提高15%');
INSERT INTO `data_ship_advanced` VALUES ('5889911ae57349febc0bea09ac15c3fc', '6412679201ba4b0a8c088c12b8425d36', '一阶', '获得全弹发射I/主炮效率提高5%');
INSERT INTO `data_ship_advanced` VALUES ('599fc817256b42048173d73b91d4a9cb', 'aaca43a4f1384ba3b19d438e14c37a72', '一阶', '获得全弹发射1/全武器效率提高2%');
INSERT INTO `data_ship_advanced` VALUES ('5f5031de54834557ac0fe864e64afa3f', 'aaca43a4f1384ba3b19d438e14c37a72', '三阶', '全弹发射弹幕升级/全武器效率提高5%');
INSERT INTO `data_ship_advanced` VALUES ('5fdaec014bf942dc98e75b141230e69d', '9e9a72b8dc514f709aeef45ad0f0d442', '三阶', '全弹发射弹幕升级/全武器效率提高5%');
INSERT INTO `data_ship_advanced` VALUES ('746e198c6c0749fc8983e55843b7a39b', '0fff99f8e36f4ff58bd28b1426cc733f', '三阶', '主炮底座+1/主炮效率提高15%');
INSERT INTO `data_ship_advanced` VALUES ('7f0d398030cf440aaf6043b0185cb303', 'd50e0c1054a642e0be477cb59a2f2de8', '一阶', '所有战斗机+1/舰载机效率提高3%');
INSERT INTO `data_ship_advanced` VALUES ('828410d507c1448eaa78f3a8b1c6881a', '5465aca7c37441e0980300c1826c3d2f', '二阶', '机库容量+1/所有轰炸机+1/鱼雷机效率提高10%');
INSERT INTO `data_ship_advanced` VALUES ('8f901f9f17424a23b2072bc67eb7f046', '0fff99f8e36f4ff58bd28b1426cc733f', '二阶', '副炮底座+2/主炮效率提高10%');
INSERT INTO `data_ship_advanced` VALUES ('91b782656a3e4429917ed82f77f5238c', '6412679201ba4b0a8c088c12b8425d36', '二阶', '鱼雷底座+1/鱼雷预装填+1/鱼雷效率提高10%');
INSERT INTO `data_ship_advanced` VALUES ('9a5faad8f8c048d59445dba74027b39a', '515e94797af3444d8ba97d6c31400b39', '一阶', '获得全弹发射1/全武器效率提高2%');
INSERT INTO `data_ship_advanced` VALUES ('ba17c055f7494e8194a9354c03d66786', 'aaca43a4f1384ba3b19d438e14c37a72', '二阶', '鱼雷底座+1/鱼雷预装填+1/全武器效率提高3%');
INSERT INTO `data_ship_advanced` VALUES ('ca4d2aa566e64793a7f412de11ffbfc4', 'd50e0c1054a642e0be477cb59a2f2de8', '二阶', '机库容量+1/所有鱼雷机+1/舰载机效率提高5%');
INSERT INTO `data_ship_advanced` VALUES ('ce1d93c7050747d18830acb65240e7c4', '0fff99f8e36f4ff58bd28b1426cc733f', '一阶', '主炮底座+1/主炮效率提高5%');
INSERT INTO `data_ship_advanced` VALUES ('d47f91be0c3544dc82d2e95ade2bfac1', '515e94797af3444d8ba97d6c31400b39', '三阶', '全弹发射弹幕升级/全武器效率提高5%');
INSERT INTO `data_ship_advanced` VALUES ('e7267ff3a6234729b8c03c06ad6a5de7', '5465aca7c37441e0980300c1826c3d2f', '三阶', '所有舰载机+1//鱼雷机效率提高15%');
INSERT INTO `data_ship_advanced` VALUES ('ebab67255427488f99e8728517d30ec2', '9e9a72b8dc514f709aeef45ad0f0d442', '二阶', '鱼雷底座+1/鱼雷预装填+1/鱼雷效率提高10%');

-- ----------------------------
-- Table structure for `data_ship_performance`
-- ----------------------------
DROP TABLE IF EXISTS `data_ship_performance`;
CREATE TABLE `data_ship_performance` (
  `id` char(32) NOT NULL,
  `ship_id` char(32) NOT NULL COMMENT '舰娘id',
  `attr_nj` varchar(128) NOT NULL COMMENT '耐久',
  `attr_zj` varchar(128) NOT NULL COMMENT '装甲',
  `attr_zt` varchar(128) NOT NULL COMMENT '装填',
  `attr_pj` varchar(128) NOT NULL COMMENT '炮击',
  `attr_lj` varchar(128) NOT NULL COMMENT '雷击',
  `attr_jd` varchar(128) NOT NULL COMMENT '机动',
  `attr_fk` varchar(128) NOT NULL COMMENT '防空',
  `attr_hk` varchar(128) NOT NULL COMMENT '航空',
  `attr_xh` varchar(128) NOT NULL COMMENT '消耗',
  `attr_hs` varchar(128) NOT NULL COMMENT '航速',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='舰娘基础属性';

-- ----------------------------
-- Records of data_ship_performance
-- ----------------------------
INSERT INTO `data_ship_performance` VALUES ('393b62c9456c47999cb1d6e61a73e193', '9e9a72b8dc514f709aeef45ad0f0d442', '240', '轻型', '72', '11', '82', '72', '26', '0', '1', '45');
INSERT INTO `data_ship_performance` VALUES ('3c31ce71fe54415aab93e6d98b14b6c0', '6412679201ba4b0a8c088c12b8425d36', '447', '轻型', '70', '29', '65', '29', '53', '0', '3', '35');
INSERT INTO `data_ship_performance` VALUES ('5c8672a6433f4e93ae9e7077fa3d1989', '5465aca7c37441e0980300c1826c3d2f', '1152', '中型', '44', '0', '0', '14', '66', '79', '4', '0');
INSERT INTO `data_ship_performance` VALUES ('601d367522ee4b149a86cbaaf9c0cf96', 'd50e0c1054a642e0be477cb59a2f2de8', '599', '中型', '65', '0', '0', '18', '48', '53', '3', '0');
INSERT INTO `data_ship_performance` VALUES ('98cc0520e1e24a34ae9a22ed42bfc1d6', '6fcf1843d56f481a89e74db6074f9694', '884', '重型', '60', '63', '0', '3', '32', '0', '5', '0');
INSERT INTO `data_ship_performance` VALUES ('b5937a5b033743b4ab83a288bd4b0ad6', '0fff99f8e36f4ff58bd28b1426cc733f', '1485', '中型', '58', '66', '0', '9', '61', '0', '5', '0');
INSERT INTO `data_ship_performance` VALUES ('ebbdcd481ae3430d8f5ba53c42a0bc7e', 'aaca43a4f1384ba3b19d438e14c37a72', '280', '轻型', '70', '14', '53', '60', '31', '0', '1', '44');
INSERT INTO `data_ship_performance` VALUES ('f1b405797d924f25b69ff37bc667d1ff', '515e94797af3444d8ba97d6c31400b39', '280', '轻型', '70', '14', '53', '60', '31', '0', '1', '44');

-- ----------------------------
-- Table structure for `data_ship_performance_max`
-- ----------------------------
DROP TABLE IF EXISTS `data_ship_performance_max`;
CREATE TABLE `data_ship_performance_max` (
  `id` char(32) NOT NULL,
  `ship_id` char(32) NOT NULL COMMENT '舰娘id',
  `attr_nj` varchar(128) NOT NULL COMMENT '耐久',
  `attr_zj` varchar(128) NOT NULL COMMENT '装甲',
  `attr_zt` varchar(128) NOT NULL COMMENT '装填',
  `attr_pj` varchar(128) NOT NULL COMMENT '炮击',
  `attr_lj` varchar(128) NOT NULL COMMENT '雷击',
  `attr_jd` varchar(128) NOT NULL COMMENT '机动',
  `attr_fk` varchar(128) NOT NULL COMMENT '防空',
  `attr_hk` varchar(128) NOT NULL COMMENT '航空',
  `attr_xh` varchar(128) NOT NULL COMMENT '消耗',
  `attr_hs` varchar(128) NOT NULL COMMENT '航速',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='舰娘最高属性';

-- ----------------------------
-- Records of data_ship_performance_max
-- ----------------------------
INSERT INTO `data_ship_performance_max` VALUES ('0b9cf9b45f9d4f2b8349f121d9112b78', '515e94797af3444d8ba97d6c31400b39', '1446→1611', '轻型', '165→185', '66→91', '248→258', '156→181', '146→146', '0→0', '7', '47');
INSERT INTO `data_ship_performance_max` VALUES ('453de827c86c4cbd90964453ceb72ec1', '0fff99f8e36f4ff58bd28b1426cc733f', '7677', '中型', '138', '312', '0', '22', '285', '0', '14', '0');
INSERT INTO `data_ship_performance_max` VALUES ('4d007b610b284ef7a75420c058fe99b8', '5465aca7c37441e0980300c1826c3d2f', '5954', '中型', '104', '0', '0', '36', '310', '370', '13', '0');
INSERT INTO `data_ship_performance_max` VALUES ('83d3bb169b2a4244a922a4b405a324c7', '6fcf1843d56f481a89e74db6074f9694', '', '重型', '', '', '0', '', '', '0', '', '0');
INSERT INTO `data_ship_performance_max` VALUES ('ab07849930e94b5e9cb0cc8a673d906b', 'aaca43a4f1384ba3b19d438e14c37a72', '1446→1611', '轻型', '165→185', '66→91', '248→258', '156→181', '146→146', '0→0', '7', '47');
INSERT INTO `data_ship_performance_max` VALUES ('b89bc09a3b6346c6854d8f530b94782f', '6412679201ba4b0a8c088c12b8425d36', '2310→2550', '轻型', '167→172', '136→156', '309→374', '75→75', '250→265', '0→0', '10', '35');
INSERT INTO `data_ship_performance_max` VALUES ('bc400be1125a4b4482f254ed377a1247', 'd50e0c1054a642e0be477cb59a2f2de8', '3095', '中型', '153', '0', '0', '47', '224', '251', '11', '0');
INSERT INTO `data_ship_performance_max` VALUES ('f57ab473580e44c992f95ff955792e9d', '9e9a72b8dc514f709aeef45ad0f0d442', '1239', '轻型', '171', '51', '385', '187', '120', '0', '7', '45');

-- ----------------------------
-- Table structure for `data_ship_skill`
-- ----------------------------
DROP TABLE IF EXISTS `data_ship_skill`;
CREATE TABLE `data_ship_skill` (
  `id` char(32) NOT NULL,
  `ship_id` char(32) NOT NULL COMMENT '舰娘id',
  `skill_name` varchar(128) NOT NULL COMMENT '技能名称',
  `skill_content` varchar(1024) NOT NULL COMMENT '技能描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_ship_skill
-- ----------------------------
INSERT INTO `data_ship_skill` VALUES ('2fdd2e42be7c4a4c8efede19d4a3a6cd', '9e9a72b8dc514f709aeef45ad0f0d442', '快速装填', '每隔20秒，有30.0%（60.0%）的概率发动，提高自身20.0%（40.0%）装填，持续10秒');
INSERT INTO `data_ship_skill` VALUES ('30e3fbc8a6a84adc8a5f9d0b5c5278d7', '6412679201ba4b0a8c088c12b8425d36', '华之二水战', '在队伍中(存活)时，队伍内所有驱逐、轻巡的雷击和装填属性提高5.0%（满级20.0%）');
INSERT INTO `data_ship_skill` VALUES ('31ce79262c5d4cefa35988fd8f690315', 'aaca43a4f1384ba3b19d438e14c37a72', '快速装填', '每隔20s，有30.0%（60%）的概率发动，提高自身20.0%（40.0%）填装，持续10秒');
INSERT INTO `data_ship_skill` VALUES ('32aa0b1456e143ed8da4b9ab86d90620', '9e9a72b8dc514f709aeef45ad0f0d442', '全弹发射I（II）', '主炮每进行15（10）次攻击，触发全弹发射-睦月级I（II）');
INSERT INTO `data_ship_skill` VALUES ('3a0efee6a4b44b7eaaf40e9f3f09120e', 'd50e0c1054a642e0be477cb59a2f2de8', '制空支援', '每次执行空袭后提高己方其他航母5%（15%）航空持续8秒');
INSERT INTO `data_ship_skill` VALUES ('3ad4934d2b654cbc8e8d7e6b43182382', '515e94797af3444d8ba97d6c31400b39', '快速装填', '每隔20s，有30.0%（60%）的概率发动，提高自身20.0%（40.0%）填装，持续10秒');
INSERT INTO `data_ship_skill` VALUES ('55e6c87ea4f440ed91e70669f87d66b1', '6fcf1843d56f481a89e74db6074f9694', '新生联合舰队旗舰', '自身受到伤害时，4.5%（12.0%）概率减少50.0%伤害，作为旗舰出击时，重樱群岛全员炮击、装填提高5.0%（20.0%）');
INSERT INTO `data_ship_skill` VALUES ('5f317085269b4e7a98680897939554f5', '5465aca7c37441e0980300c1826c3d2f', '鹤之加护', '空中支援后，队伍中全员伤害提高4.0%（满级10.0%），受到伤害降低4.0%（10.0%），持续12秒');
INSERT INTO `data_ship_skill` VALUES ('6dfbe2a8cb324c77ab474b859d7d48b4', '6fcf1843d56f481a89e74db6074f9694', '丁字战法', '主炮开火时，30.0%（60.0%）概率触发，队伍中战巡、战列伤害提高5.0%（20.0%），持续8秒');
INSERT INTO `data_ship_skill` VALUES ('75ecf0feff5d4731a05ffcf6bd65a3d1', '6412679201ba4b0a8c088c12b8425d36', '不屈之神通', '自身受到伤害降低20.0%，在队伍中(存活)时，队伍内所有驱逐、轻巡鱼雷暴击率提高4.0%(满级10.0%，额外提高暴击伤害30.0%)');
INSERT INTO `data_ship_skill` VALUES ('7d4bc992060f42eeacc32456a834f23e', '5465aca7c37441e0980300c1826c3d2f', '五航战', '与鹤在同一个舰队时，自身航空性能提高12.0%（满级30%），受到伤害提高4.0%（满级10.0%）');
INSERT INTO `data_ship_skill` VALUES ('8eae9d297cb6401c99d22a6df7432a2d', 'aaca43a4f1384ba3b19d438e14c37a72', '全弹发射I（II）', '主炮每进行15（10）次攻击，触发全弹发射-马汉级I（II）');
INSERT INTO `data_ship_skill` VALUES ('9e9851d2c1c641ea97d6e3ffffb31ae1', '515e94797af3444d8ba97d6c31400b39', '浴火重生', '耐久低于20%时，恢复16.0%（25.0%）耐久，每场战斗只能触发1次');
INSERT INTO `data_ship_skill` VALUES ('ccc6dfaf09684112af817541179c458a', '6412679201ba4b0a8c088c12b8425d36', '全弹发射I（II）', '每进行12（8）次攻击，触发全弹发射-川内级I（II）');
INSERT INTO `data_ship_skill` VALUES ('ce96d35b7b604b728e605bf89ef1167d', 'd50e0c1054a642e0be477cb59a2f2de8', '航空先驱', '战斗后，队伍中的航母获得经验值增加5%（15%）');
INSERT INTO `data_ship_skill` VALUES ('d47d825adedb46b384a16e7e8811ddba', '515e94797af3444d8ba97d6c31400b39', '全弹发射I（II）', '主炮每进行15（10）次攻击，触发全弹发射-马汉级I（II）');
INSERT INTO `data_ship_skill` VALUES ('e5cf69e55f6c480fb24015a1e5fcaf4f', 'aaca43a4f1384ba3b19d438e14c37a72', '浴火重生', '耐久低于20%时，恢复16.0（25.0）%耐久，每场战斗只能触发1次');
INSERT INTO `data_ship_skill` VALUES ('f309156dfdec41038f7cbf59f83e1f46', '0fff99f8e36f4ff58bd28b1426cc733f', '皇家舰队的荣耀', '主炮开火时，有40%(70%)概率朝自己前方发射一轮专属弹幕（威力依据技能等级），所有主力舰队角色装填提高20.0%（40%），持续8秒');

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
