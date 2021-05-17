/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : grampus_system

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 02/12/2020 18:28:57
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
    `parent_id`   bigint(20) NULL DEFAULT NULL COMMENT '父级部门ID',
    `dept_name`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
    `sort`        int(11) NULL DEFAULT NULL COMMENT '排序',
    `create_by`   bigint(20) NULL DEFAULT NULL COMMENT '创建者',
    `create_date` datetime(3) NULL DEFAULT NULL COMMENT '创建日期',
    `update_by`   bigint(20) NULL DEFAULT NULL COMMENT '更新者',
    `update_date` datetime(3) NULL DEFAULT NULL COMMENT '更新日期',
    `del_flag`    tinyint(4) NULL DEFAULT NULL COMMENT '删除标识(0正常 1删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
    `dict_type`   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型',
    `dict_name`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典名称',
    `remark`      varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
    `sort`        int(11) NULL DEFAULT NULL COMMENT '排序',
    `create_by`   bigint(20) NULL DEFAULT NULL COMMENT '创建者',
    `create_date` datetime(3) NULL DEFAULT NULL COMMENT '创建日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
    `dict_id`     bigint(20) NULL DEFAULT NULL COMMENT '字典ID',
    `dict_label`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典标签',
    `dict_value`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典值',
    `sort`        int(11) NULL DEFAULT NULL COMMENT '排序',
    `create_by`   bigint(20) NULL DEFAULT NULL COMMENT '创建者',
    `create_date` datetime(3) NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   bigint(20) NULL DEFAULT NULL COMMENT '更新者',
    `update_date` datetime(3) NULL DEFAULT NULL COMMENT '更新时间',
    `del_flag`    tinyint(4) NULL DEFAULT NULL COMMENT '删除标识(0正常 1删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_login`;
CREATE TABLE `sys_log_login`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
    `user_id`     bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
    `user_no`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户号',
    `user_agent`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '浏览器信息',
    `operation`   varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户操作(1登录 2退登 3关闭应用)',
    `operate_ip`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作IP',
    `status`      tinyint(4) NULL DEFAULT NULL COMMENT '状态(0失败 1成功)',
    `create_by`   bigint(20) NULL DEFAULT NULL COMMENT '创建者',
    `create_Date` datetime(3) NULL DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户登陆日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log_login
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
    `parent_id`  bigint(20) NULL DEFAULT NULL COMMENT '父级菜单ID',
    `type`       tinyint(4) NULL DEFAULT NULL COMMENT '菜单类型(0菜单 1按钮)',
    `menu_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单名',
    `permission` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
    `path`       varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单路径',
    `icon`       varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
    `sort`       int(11) NULL DEFAULT NULL COMMENT '排序',
    `del_flag`   tinyint(4) NULL DEFAULT NULL COMMENT '删除标识(0正常 1删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_param
-- ----------------------------
DROP TABLE IF EXISTS `sys_param`;
CREATE TABLE `sys_param`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
    `code`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数编码',
    `value`       varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数值',
    `remark`      varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
    `create_by`   bigint(20) NULL DEFAULT NULL COMMENT '创建者',
    `create_date` datetime(3) NULL DEFAULT NULL COMMENT '创建日期',
    `update_by`   bigint(20) NULL DEFAULT NULL COMMENT '更新者',
    `update_date` datetime(3) NULL DEFAULT NULL COMMENT '更新日期',
    `del_flag`    tinyint(4) NULL DEFAULT NULL COMMENT '删除标识(0正常 1删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公共参数表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_param
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
    `role_name`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名',
    `role_code`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色编号',
    `create_by`   bigint(20) NULL DEFAULT NULL COMMENT '创建者',
    `create_date` datetime(3) NULL DEFAULT NULL COMMENT '创建日期',
    `update_by`   bigint(20) NULL DEFAULT NULL COMMENT '更新者',
    `update_date` datetime(3) NULL DEFAULT NULL COMMENT '更新日期',
    `del_flag`    tinyint(4) NULL DEFAULT NULL COMMENT '删除标识(0正常 1删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`
(
    `id`      bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
    `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
    `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
    `user_no`     varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '员工号',
    `name`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
    `password`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
    `gender`      tinyint(4) NULL DEFAULT NULL COMMENT '性别',
    `dept_id`     bigint(20) NULL DEFAULT NULL COMMENT '所属部门ID',
    `super_admin` tinyint(4) NULL DEFAULT NULL COMMENT '是否超级管理员(0普通 1超管)',
    `enabled`     tinyint(4) NULL DEFAULT NULL COMMENT '是否启用(0停用 1启用)',
    `create_by`   bigint(20) NULL DEFAULT NULL COMMENT '创建者',
    `create_date` datetime(3) NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   bigint(20) NULL DEFAULT NULL COMMENT '更新者',
    `update_date` datetime(3) NULL DEFAULT NULL COMMENT '更新时间',
    `del_flag`    tinyint(4) NULL DEFAULT NULL COMMENT '删除标记(0正常 1删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `id`      bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
    `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
    `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (35782761320038400, 0, 0, '系统管理', '', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35783059505692672, 35782761320038400, 0, '用户管理', '', '/sys/user', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35783467523391488, 35783059505692672, 1, '用户查询', 'sys:user:list,sys:user:info', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35783541309587456, 35783059505692672, 1, '用户新增', 'sys:user:save', '', '', 1, 0);
INSERT INTO `sys_menu` VALUES (35783682821210112, 35783059505692672, 1, '用户更新', 'sys:user:update', '', '', 2, 0);
INSERT INTO `sys_menu` VALUES (35783727977086976, 35783059505692672, 1, '用户删除', 'sys:user:delete', '', '', 3, 0);
INSERT INTO `sys_menu` VALUES (35783807568199680, 35783059505692672, 1, '用户导出', 'sys:user:export', '', '', 4, 0);
INSERT INTO `sys_menu` VALUES (35783915168874496, 35782761320038400, 0, '部门管理', '', '/sys/dept', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784093372268544, 35783915168874496, 1, '部门查询', 'sys:dept:list,sys:dept:info', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784174175535104, 35783915168874496, 1, '部门新增', 'sys:dept:save', '', '', 1, 0);
INSERT INTO `sys_menu` VALUES (35784189501521920, 35783915168874496, 1, '部门更新', 'sys:dept:update', '', '', 2, 0);
INSERT INTO `sys_menu` VALUES (35784195071557632, 35783915168874496, 1, '部门删除', 'sys:dept:delete', '', '', 3, 0);
INSERT INTO `sys_menu` VALUES (35784212310147072, 35783915168874496, 1, '部门导出', 'sys:dept:export', '', '', 4, 0);
INSERT INTO `sys_menu` VALUES (35784408578408448, 35782761320038400, 0, '角色管理', '', '/sys/role', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784473598509056, 35784408578408448, 1, '角色查询', 'sys:role:list,sys:role:info', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784478723948544, 35784408578408448, 1, '角色新增', 'sys:role:save', '', '', 1, 0);
INSERT INTO `sys_menu` VALUES (35784480661716992, 35784408578408448, 1, '角色更新', 'sys:role:update', '', '', 2, 0);
INSERT INTO `sys_menu` VALUES (35784482863726592, 35784408578408448, 1, '角色删除', 'sys:role:delete', '', '', 3, 0);
INSERT INTO `sys_menu` VALUES (35784510512578560, 35784408578408448, 1, '角色导出', 'sys:role:export', '', '', 4, 0);
INSERT INTO `sys_menu` VALUES (35784620759859200, 35782761320038400, 0, '菜单管理', '', '/sys/menu', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784671951339520, 35784620759859200, 1, '菜单查询', 'sys:menu:list,sys:menu:info', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784673624866816, 35784620759859200, 1, '菜单新增', 'sys:menu:save', '', '', 1, 0);
INSERT INTO `sys_menu` VALUES (35784675684270080, 35784620759859200, 1, '菜单更新', 'sys:menu:update', '', '', 2, 0);
INSERT INTO `sys_menu` VALUES (35784677496209408, 35784620759859200, 1, '菜单删除', 'sys:menu:delete', '', '', 3, 0);
INSERT INTO `sys_menu` VALUES (35784679819853824, 35784620759859200, 1, '菜单导出', 'sys:menu:export', '', '', 4, 0);
INSERT INTO `sys_menu` VALUES (35784783909896192, 35782761320038400, 0, '参数管理', '', '/sys/param', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784842730815488, 35784783909896192, 1, '参数查询', 'sys:param:list,sys:param:info', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784844320456704, 35784783909896192, 1, '参数新增', 'sys:param:save', '', '', 1, 0);
INSERT INTO `sys_menu` VALUES (35784846027538432, 35784783909896192, 1, '参数更新', 'sys:param:update', '', '', 2, 0);
INSERT INTO `sys_menu` VALUES (35784847692677120, 35784783909896192, 1, '参数删除', 'sys:param:delete', '', '', 3, 0);
INSERT INTO `sys_menu` VALUES (35784849408147456, 35784783909896192, 1, '参数导出', 'sys:param:export', '', '', 4, 0);
INSERT INTO `sys_menu` VALUES (35784905746038784, 35782761320038400, 0, '字典管理', '', '/sys/dict', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784991360172032, 35784905746038784, 1, '字典查询', 'sys:dict:list,sys:dict:info', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784992954007552, 35784905746038784, 1, '字典新增', 'sys:dict:save', '', '', 1, 0);
INSERT INTO `sys_menu` VALUES (35784994493317120, 35784905746038784, 1, '字典更新', 'sys:dict:update', '', '', 2, 0);
INSERT INTO `sys_menu` VALUES (35784996384948224, 35784905746038784, 1, '字典删除', 'sys:dict:delete', '', '', 3, 0);
INSERT INTO `sys_menu` VALUES (35784998272385024, 35784905746038784, 1, '字典导出', 'sys:dict:export', '', '', 4, 0);

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (126742336940032000, 'H001', 'H001', '$2a$10$Blav.U6cFEu7/1ONBeRAoudAQK12bA0qnysGEcl9CIOq.b4L7E94m', NULL, NULL, 1, NULL, NULL, '2020-12-15 09:48:47.812', NULL, '2020-12-15 09:48:47.812', 0);

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 126742336940032000, 1);

SET
FOREIGN_KEY_CHECKS = 1;
