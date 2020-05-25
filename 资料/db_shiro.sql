/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : db_shiro

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 25/05/2020 20:55:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_captcha
-- ----------------------------
DROP TABLE IF EXISTS `sys_captcha`;
CREATE TABLE `sys_captcha`  (
  `uuid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'uuid',
  `code` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '验证码',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统验证码' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_captcha
-- ----------------------------
INSERT INTO `sys_captcha` VALUES ('04b6566d-ea67-40b6-80c2-76645802b082', '6875', NULL);
INSERT INTO `sys_captcha` VALUES ('1d12dd0c-6e4e-4f7b-8267-64f28f047638', '6530', NULL);
INSERT INTO `sys_captcha` VALUES ('5378c5b8-b932-4945-84b5-4c2be31d8131', '3687', NULL);
INSERT INTO `sys_captcha` VALUES ('ced13207-ebe3-4531-8926-d06df8aa8056', '1273', NULL);
INSERT INTO `sys_captcha` VALUES ('ded6b5f4-ffe4-4ec8-8369-ef3f0a321940', '0510', NULL);

-- ----------------------------
-- Table structure for sys_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '功能主键',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级主键',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '项目类型:1-菜单2-按钮3-链接4-表单',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url地址',
  `is_delete` tinyint(1) NULL DEFAULT NULL COMMENT '删除标记:0未删除，1删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `create_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改日期',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改用户',
  `ts` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '时间戳',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统功能表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_module
-- ----------------------------
INSERT INTO `sys_module` VALUES (1, 0, 'user', '用户管理', NULL, 1, '/user/index.html', 0, '2020-04-14 19:07:31', 'SYSTEM', '2020-04-14 19:07:33', 'SYSTEM', '2020-04-20 21:50:23');
INSERT INTO `sys_module` VALUES (2, 1, 'user:add', '用户添加', NULL, 2, NULL, 0, NULL, NULL, NULL, NULL, '2020-04-27 13:38:45');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色主键',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '角色编码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `is_delete` tinyint(1) NULL DEFAULT NULL COMMENT '删除标记:0未删除，1删除',
  `mark` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改日期',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '修改用户',
  `ts` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '时间戳',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '000', '超级管理员', 0, '超级管理员', '2017-03-08 15:00:42', NULL, '2020-04-14 19:07:58', NULL, '2020-04-14 19:08:00');
INSERT INTO `sys_role` VALUES (2, '001', '测试角色', 0, '测试角色', '2018-12-09 17:48:13', NULL, '2018-12-09 17:48:26', NULL, '2020-04-13 22:36:17');

-- ----------------------------
-- Table structure for sys_role_module_ref
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_module_ref`;
CREATE TABLE `sys_role_module_ref`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色关联',
  `module_id` bigint(20) NULL DEFAULT NULL COMMENT '用户主键',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色功能关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_module_ref
-- ----------------------------
INSERT INTO `sys_role_module_ref` VALUES (1, 1, 1);
INSERT INTO `sys_role_module_ref` VALUES (2, 2, 1);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账户',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `secretkey` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐值，密码秘钥',
  `locked` tinyint(1) NULL DEFAULT NULL,
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `is_delete` tinyint(1) NULL DEFAULT NULL COMMENT '删除标记:0未删除，1删除',
  `create_time` datetime(0) NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建日期',
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建用户',
  `update_user` datetime(0) NULL DEFAULT NULL COMMENT '修改日期',
  `update_time` datetime(0) NULL DEFAULT '1970-01-01 00:00:00' COMMENT '修改用户',
  `ts` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'system', '7794d9e38e986f74751ed6fa6f6075a4', 'system', 0, '超级管理员', 1, NULL, 'SYSTEM', '2018-12-13 19:19:36', '2018-12-13 16:03:49', '2020-05-14 21:41:26');
INSERT INTO `sys_user` VALUES (2, 'admin', '578966146da8c139355b7bddee09dd70', 'pFtIkWuE7UcKQw0tX1Z5', 0, '管理员1', 0, '2018-12-07 15:04:03', 'SYSTEM', '2018-12-13 16:03:49', '2018-12-13 16:03:49', '2020-05-14 21:41:29');

-- ----------------------------
-- Table structure for sys_user_role_ref
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_ref`;
CREATE TABLE `sys_user_role_ref`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色关联',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户主键',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role_ref
-- ----------------------------
INSERT INTO `sys_user_role_ref` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token`  (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'token',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户Token' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES (1, '73aecd56b9adc2b1c1baf2e07c36c103', '2020-05-24 08:21:03', '2020-05-23 20:21:03');

-- ----------------------------
-- Table structure for tbl_time
-- ----------------------------
DROP TABLE IF EXISTS `tbl_time`;
CREATE TABLE `tbl_time`  (
  `id` int(11) NOT NULL,
  `custom_id` int(11) NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_time
-- ----------------------------
INSERT INTO `tbl_time` VALUES (1, 1, '2011-05-17 22:12:30', '2012-05-17 22:13:00');
INSERT INTO `tbl_time` VALUES (2, 1, '2019-05-17 22:12:30', '2020-05-17 22:13:00');
INSERT INTO `tbl_time` VALUES (3, 1, '2020-02-10 00:00:00', '2021-02-10 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
