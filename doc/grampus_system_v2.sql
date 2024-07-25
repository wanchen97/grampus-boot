/*
 Navicat Premium Data Transfer

 Source Server         : beck_db
 Source Server Type    : MySQL
 Source Server Version : 80022 (8.0.22-txsql)
 Source Host           : gz-cdb-8zjp88cp.sql.tencentcdb.com:63366
 Source Schema         : grampus_system

 Target Server Type    : MySQL
 Target Server Version : 80022 (8.0.22-txsql)
 File Encoding         : 65001

 Date: 25/07/2024 12:00:22
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
  `authorization` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '请求令牌',
  `user_agent` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'UA信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `parent_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '父级部门ID',
  `dept_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '部门名称',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `create_by` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建者',
  `create_date` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '创建日期',
  `update_by` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `update_date` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '更新日期',
  `del_flag` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除标识(0正常 1删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dept_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_relation`;
CREATE TABLE `sys_dept_relation`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `dept_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '部门ID',
  `child_dept_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '所有子部门ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字典类型',
  `dict_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字典名称',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `create_by` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建者',
  `create_date` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_dict_type`(`dict_type` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `dict_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '字典ID',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字典类型',
  `dict_label` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字典值',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `create_by` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建者',
  `create_date` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '创建时间',
  `update_by` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `update_date` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '更新时间',
  `del_flag` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除标识(0正常 1删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_dict_type`(`dict_type` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_language
-- ----------------------------
DROP TABLE IF EXISTS `sys_language`;
CREATE TABLE `sys_language`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `table_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '表名',
  `table_id` bigint NOT NULL DEFAULT 0 COMMENT '表数据ID',
  `field_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字段名',
  `field_value` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字段值',
  `language` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '语言',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_sys_language_tname_tid_fname_language`(`table_name` ASC, `table_id` ASC, `field_name` ASC, `language` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统语言表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_log_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_login`;
CREATE TABLE `sys_log_login`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `user_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户ID',
  `user_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户号',
  `user_agent` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '浏览器信息',
  `operation` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户操作(1登录 2退登 3关闭应用)',
  `operate_ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作IP',
  `status` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态(0失败 1成功)',
  `create_by` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建者',
  `create_Date` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户登陆日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `parent_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '父级菜单ID',
  `type` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '菜单类型(0菜单 1按钮)',
  `menu_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '菜单名',
  `permission` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限标识',
  `path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '菜单路径',
  `icon` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图标',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `del_flag` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除标识(0正常 1删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_param
-- ----------------------------
DROP TABLE IF EXISTS `sys_param`;
CREATE TABLE `sys_param`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '参数编码',
  `value` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '参数值',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_by` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建者',
  `create_date` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '创建日期',
  `update_by` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `update_date` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '更新日期',
  `del_flag` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除标识(0正常 1删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公共参数表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `role_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名',
  `role_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色编号',
  `create_by` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建者',
  `create_date` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '创建日期',
  `update_by` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `update_date` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '更新日期',
  `del_flag` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除标识(0正常 1删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `role_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色ID',
  `menu_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `user_no` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '员工号',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `gender` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '性别',
  `dept_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属部门ID',
  `super_admin` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否超级管理员(0普通 1超管)',
  `status` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否启用(0停用 1启用)',
  `create_by` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建者',
  `create_date` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '创建时间',
  `update_by` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `update_date` datetime(3) NOT NULL DEFAULT '1000-01-01 00:00:00.000' COMMENT '更新时间',
  `del_flag` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除标记(0正常 1删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `user_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户ID',
  `role_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;