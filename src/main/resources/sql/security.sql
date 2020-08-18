-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', '$2a$10$G96t61tlW1ExYPfgWKmvMuKhCVGcDzyprDasE0StnOkSOHEm7P5eC', NULL, '1', 1, '1');
INSERT INTO `t_user` VALUES (2, 'hgq', 'huangguoqiang', '$2a$10$G96t61tlW1ExYPfgWKmvMuKhCVGcDzyprDasE0StnOkSOHEm7P5eC', NULL, '1', 1, '12');


-- ----------------------------
-- Table structure for t_perssion
-- ----------------------------
DROP TABLE IF EXISTS `t_perssion`;
CREATE TABLE `t_perssion`  (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `perssion_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                               `perssion_desc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                               `perssion_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                               `create_time` datetime(0) NULL DEFAULT NULL,
                               `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                               `update_time` datetime(0) NULL DEFAULT NULL,
                               `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                               `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_perssion
-- ----------------------------
INSERT INTO `t_perssion` VALUES (1, 'r1', 'r1资源', '/r/r1', '2020-08-17 14:31:20', 'hgq', '2020-08-17 14:31:27', 'hgq', '0');
INSERT INTO `t_perssion` VALUES (2, 'r2', 'r2资源', '/r/r2', '2020-08-17 14:31:51', 'hgq', '2020-08-17 14:31:55', 'hgq', '0');
INSERT INTO `t_perssion` VALUES (3, 'r3', 'r3资源', '/r/r3', '2020-08-17 16:33:46', 'hgg', '2020-08-17 16:33:53', 'hgq', '0');


-- ----------------------------
-- Table structure for t_user_perssion
-- ----------------------------
DROP TABLE IF EXISTS `t_user_perssion`;
CREATE TABLE `t_user_perssion`  (
  `user_id` int(11) NOT NULL,
  `perssion_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_perssion
-- ----------------------------
INSERT INTO `t_user_perssion` VALUES (1, 'r2');
INSERT INTO `t_user_perssion` VALUES (2, 'r1');
INSERT INTO `t_user_perssion` VALUES (2, 'r2');
INSERT INTO `t_user_perssion` VALUES (2, 'r3');


