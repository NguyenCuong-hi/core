/*
 Navicat Premium Dump SQL

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80039 (8.0.39)
 Source Host           : localhost:3306
 Source Schema         : core

 Target Server Type    : MySQL
 Target Server Version : 80039 (8.0.39)
 File Encoding         : 65001

 Date: 15/10/2024 13:06:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_date` datetime(6) NOT NULL,
  `modify_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modify_date` datetime(6) NULL DEFAULT NULL,
  `uuid_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `voided` bit(1) NULL DEFAULT NULL,
  `change_password` bit(1) NULL DEFAULT NULL,
  `confirm_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_account_non_expired` bit(1) NULL DEFAULT NULL,
  `is_account_non_locked` bit(1) NULL DEFAULT NULL,
  `is_active` bit(1) NULL DEFAULT NULL,
  `is_credentials_non_expired` bit(1) NULL DEFAULT NULL,
  `just_created` bit(1) NULL DEFAULT NULL,
  `last_login` datetime(6) NULL DEFAULT NULL,
  `last_login_failures` bigint NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `total_login_failures` bigint NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (5, NULL, '2024-10-05 14:48:28.883607', NULL, NULL, 'b81395c8-5d69-4824-8b79-6a7e6deeb6ae', NULL, b'0', NULL, NULL, 'admin@gmail.com', b'1', b'1', b'1', b'1', b'1', NULL, NULL, NULL, '$2a$10$GgL7MIILRtETjPFKyKxs7.cid84N2G1ynlhdawtph8N3w0UBNebNy', NULL, 'admin', NULL);

SET FOREIGN_KEY_CHECKS = 1;
