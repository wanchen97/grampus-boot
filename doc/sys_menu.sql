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

 Date: 07/06/2021 17:26:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE = InnoDB AUTO_INCREMENT = 357849982723902413 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (35782761320038400, 0, 0, '系统管理', '', '/sys', 'icon-setting', 0, 0);
INSERT INTO `sys_menu` VALUES (35783059505692672, 35782761320038400, 0, '用户管理', '', '/sys/user', 'icon-user', 0, 0);
INSERT INTO `sys_menu` VALUES (35783467523391488, 35783059505692672, 1, '用户查询', 'sys:user:list,sys:user:info', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35783541309587456, 35783059505692672, 1, '用户新增', 'sys:user:save', '', '', 1, 0);
INSERT INTO `sys_menu` VALUES (35783682821210112, 35783059505692672, 1, '用户更新', 'sys:user:update', '', '', 2, 0);
INSERT INTO `sys_menu` VALUES (35783727977086976, 35783059505692672, 1, '用户删除', 'sys:user:delete', '', '', 3, 0);
INSERT INTO `sys_menu` VALUES (35783807568199680, 35783059505692672, 1, '用户导出', 'sys:user:export', '', '', 4, 0);
INSERT INTO `sys_menu` VALUES (35783915168874496, 35782761320038400, 0, '部门管理', '', '/sys/dept', 'icon-adjust', 0, 0);
INSERT INTO `sys_menu` VALUES (35784093372268544, 35783915168874496, 1, '部门查询', 'sys:dept:list,sys:dept:info', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784174175535104, 35783915168874496, 1, '部门新增', 'sys:dept:save', '', '', 1, 0);
INSERT INTO `sys_menu` VALUES (35784189501521920, 35783915168874496, 1, '部门更新', 'sys:dept:update', '', '', 2, 0);
INSERT INTO `sys_menu` VALUES (35784195071557632, 35783915168874496, 1, '部门删除', 'sys:dept:delete', '', '', 3, 0);
INSERT INTO `sys_menu` VALUES (35784212310147072, 35783915168874496, 1, '部门导出', 'sys:dept:export', '', '', 4, 0);
INSERT INTO `sys_menu` VALUES (35784408578408448, 35782761320038400, 0, '角色管理', '', '/sys/role', 'icon-layers', 0, 0);
INSERT INTO `sys_menu` VALUES (35784473598509056, 35784408578408448, 1, '角色查询', 'sys:role:list,sys:role:info', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784478723948544, 35784408578408448, 1, '角色新增', 'sys:role:save', '', '', 1, 0);
INSERT INTO `sys_menu` VALUES (35784480661716992, 35784408578408448, 1, '角色更新', 'sys:role:update', '', '', 2, 0);
INSERT INTO `sys_menu` VALUES (35784482863726592, 35784408578408448, 1, '角色删除', 'sys:role:delete', '', '', 3, 0);
INSERT INTO `sys_menu` VALUES (35784510512578560, 35784408578408448, 1, '角色导出', 'sys:role:export', '', '', 4, 0);
INSERT INTO `sys_menu` VALUES (35784620759859200, 35782761320038400, 0, '菜单管理', '', '/sys/menu', 'icon-menu', 0, 0);
INSERT INTO `sys_menu` VALUES (35784671951339520, 35784620759859200, 1, '菜单查询', 'sys:menu:list,sys:menu:info', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784673624866816, 35784620759859200, 1, '菜单新增', 'sys:menu:save', '', '', 1, 0);
INSERT INTO `sys_menu` VALUES (35784675684270080, 35784620759859200, 1, '菜单更新', 'sys:menu:update', '', '', 2, 0);
INSERT INTO `sys_menu` VALUES (35784677496209408, 35784620759859200, 1, '菜单删除', 'sys:menu:delete', '', '', 3, 0);
INSERT INTO `sys_menu` VALUES (35784679819853824, 35784620759859200, 1, '菜单导出', 'sys:menu:export', '', '', 4, 0);
INSERT INTO `sys_menu` VALUES (35784783909896192, 35782761320038400, 0, '参数管理', '', '/sys/param', 'icon-modular', 0, 0);
INSERT INTO `sys_menu` VALUES (35784842730815488, 35784783909896192, 1, '参数查询', 'sys:param:list,sys:param:info', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784844320456704, 35784783909896192, 1, '参数新增', 'sys:param:save', '', '', 1, 0);
INSERT INTO `sys_menu` VALUES (35784846027538432, 35784783909896192, 1, '参数更新', 'sys:param:update', '', '', 2, 0);
INSERT INTO `sys_menu` VALUES (35784847692677120, 35784783909896192, 1, '参数删除', 'sys:param:delete', '', '', 3, 0);
INSERT INTO `sys_menu` VALUES (35784849408147456, 35784783909896192, 1, '参数导出', 'sys:param:export', '', '', 4, 0);
INSERT INTO `sys_menu` VALUES (35784905746038784, 35782761320038400, 0, '字典管理', '', '/sys/dict', 'icon-file-common', 0, 0);
INSERT INTO `sys_menu` VALUES (35784991360172032, 35784905746038784, 1, '字典查询', 'sys:dict:list,sys:dict:info', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (35784992954007552, 35784905746038784, 1, '字典新增', 'sys:dict:save', '', '', 1, 0);
INSERT INTO `sys_menu` VALUES (35784994493317120, 35784905746038784, 1, '字典更新', 'sys:dict:update', '', '', 2, 0);
INSERT INTO `sys_menu` VALUES (35784996384948224, 35784905746038784, 1, '字典删除', 'sys:dict:delete', '', '', 3, 0);
INSERT INTO `sys_menu` VALUES (35784998272385024, 35784905746038784, 1, '字典导出', 'sys:dict:export', '', '', 4, 0);
INSERT INTO `sys_menu` VALUES (35784998272390241, 35782761320038400, 0, '日志管理', '', '/sys/log', 'icon-file', 0, 0);
INSERT INTO `sys_menu` VALUES (35784998273492243, 35784998272390241, 1, '操作日志', 'log:operation:list', '', '', 0, 0);
INSERT INTO `sys_menu` VALUES (42292758824632320, 0, 0, '日常管理', '', '/daily', 'icon-film', 1, 0);
INSERT INTO `sys_menu` VALUES (42293123368370176, 42292758824632320, 0, '女士列表', '', '/daily/lady', 'icon-chart-bar', 0, 0);
INSERT INTO `sys_menu` VALUES (42293455334948864, 0, 0, '个人办公', '', '/work', 'icon-file', 2, 0);
INSERT INTO `sys_menu` VALUES (42293510557155328, 0, 0, '企业管理', '', '/enterprise', 'icon-training', 0, 0);
INSERT INTO `sys_menu` VALUES (43290307991715840, 42293123368370176, 0, '女士列表子', '', '/daily/lady/sub', 'icon-meh', 0, 0);
INSERT INTO `sys_menu` VALUES (43290354410078208, 43290307991715840, 0, '系统管理123', '', '/daily/lady/sub/123', 'icon-picture-filling', 0, 0);
INSERT INTO `sys_menu` VALUES (54864994416738304, 35782761320038400, 0, '日志管理', '', '/sys/log', 'icon-history', 10, 1);

SET FOREIGN_KEY_CHECKS = 1;
