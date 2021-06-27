/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.8.110
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 192.168.8.110:3306
 Source Schema         : grampus_system

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 31/05/2021 18:26:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log_operation
-- ----------------------------
DROP TABLE IF EXISTS `log_operation`;
CREATE TABLE `log_operation`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `module` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '所属模块',
  `subject` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作对象',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '描述',
  `request_method` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'RequestMethod',
  `request_uri` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'RequestUri',
  `request_param` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT 'RequestParam',
  `request_body` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT 'RequestBody',
  `successful` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否成功(0失败 1成功)',
  `class_method` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '类方法',
  `exception_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '异常信息',
  `request_ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求IP',
  `request_start_time` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '请求开始时间',
  `request_end_time` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '请求结束时间',
  `cost_time` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '请求耗时',
  `authorization` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求令牌',
  `user_agent` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'UA信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
