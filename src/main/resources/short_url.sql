/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 127.0.0.1:3306
 Source Schema         : short_url

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 19/01/2020 18:01:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_app_user
-- ----------------------------
DROP TABLE IF EXISTS `t_app_user`;
CREATE TABLE `t_app_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `app_key` varchar(16) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'app key',
  `status` tinyint(4) NOT NULL COMMENT '状态[0禁用 1正常]',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_app_key` (`app_key`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='应用信息表';

-- ----------------------------
-- Table structure for t_short_url
-- ----------------------------
DROP TABLE IF EXISTS `t_short_url`;
CREATE TABLE `t_short_url` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `short_url` varchar(10) COLLATE utf8mb4_general_ci NOT NULL COMMENT '短连接',
  `long_url` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '长连接',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  `app_key` varchar(16) COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_short_url` (`short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='短链接表';

-- ----------------------------
-- Table structure for t_short_url_access_log
-- ----------------------------
DROP TABLE IF EXISTS `t_short_url_access_log`;
CREATE TABLE `t_short_url_access_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `short_url` varchar(10) COLLATE utf8mb4_general_ci NOT NULL COMMENT '短链接',
  `access_ip` varchar(15) COLLATE utf8mb4_general_ci NOT NULL COMMENT '访问IP地址',
  `access_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '访问时间',
  PRIMARY KEY (`id`),
  KEY `ix_short_url` (`short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='短链接访问日志表';

SET FOREIGN_KEY_CHECKS = 1;

-- 插入测试用户
INSERT INTO `short_url`.`t_app_user`(`id`, `app_key`, `status`, `create_time`) VALUES (1, 'app-test', 1, '2020-01-19 17:22:15');
