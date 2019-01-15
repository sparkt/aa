/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : jfinal_wudi_init

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-01-15 11:50:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `navs`
-- ----------------------------
DROP TABLE IF EXISTS `navs`;
CREATE TABLE `navs` (
  `id` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL COMMENT '显示的标题',
  `icon` varchar(255) DEFAULT '&#xe630;' COMMENT '图标',
  `href` varchar(255) DEFAULT '' COMMENT '访问路径',
  `fid` varchar(255) DEFAULT NULL COMMENT '父id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of navs
-- ----------------------------
INSERT INTO `navs` VALUES ('1', '后台首页', '&#xe630;', 'page/main.html', '-1');
INSERT INTO `navs` VALUES ('2', '系統管理', '&#xe630;', '', '-1');
INSERT INTO `navs` VALUES ('21', '菜单管理', 'icon-text', 'admin/navsinfo', '2');
INSERT INTO `navs` VALUES ('22', '404页面', '&#xe61c;', 'page/404.html', '2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` tinyint(4) DEFAULT '0' COMMENT '0正常，1异常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '0');
