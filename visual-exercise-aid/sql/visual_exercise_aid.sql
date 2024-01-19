/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : visual_exercise_aid

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 28/11/2023 15:13:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号（主键）',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '管理科');
INSERT INTO `department` VALUES (2, '训练科');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号（主键）',
  `pid` bigint(0) NULL DEFAULT NULL COMMENT '父级编号',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `href` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '链接',
  `target` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '链接打开方式',
  `role` int(0) NULL DEFAULT NULL COMMENT '角色（管理员=0，客户=1）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, '管理员服务', 'fa fa-lemon-o', 'javascript:;', '_self', 0);
INSERT INTO `menu` VALUES (2, 0, '训练员服务', 'fa fa-lemon-o', 'javascript:;', '_self', 1);
INSERT INTO `menu` VALUES (3, 1, '系统首页', 'fa fa-home', 'toHome', '_self', 0);
INSERT INTO `menu` VALUES (4, 2, '系统首页', 'fa fa-home', 'toHome', '_self', 1);
INSERT INTO `menu` VALUES (5, 1, '菜单管理', 'fa fa-window-maximize', 'toMenuManage', '_self', 0);
INSERT INTO `menu` VALUES (6, 1, '训练员管理', 'fa fa-users', 'toUserManage', '_self', 0);
INSERT INTO `menu` VALUES (7, 1, '训练部门管理', 'fa fa-sitemap', 'toDepartmentManage', '_self', 0);
INSERT INTO `menu` VALUES (8, 1, '注意事项管理', 'fa fa-bullhorn', 'toNoteManage', '_self', 0);
INSERT INTO `menu` VALUES (9, 1, '训练科目管理', 'fa fa-cube', 'toSubjectManage', '_self', 0);
INSERT INTO `menu` VALUES (10, 1, '训练建议管理', 'fa fa-comments', 'toSuggestManage', '_self', 0);
INSERT INTO `menu` VALUES (11, 1, '训练记录管理', 'fa fa-file-text', 'toRecordManage', '_self', 0);
INSERT INTO `menu` VALUES (12, 1, '训练员训练分析', 'fa fa-bar-chart', 'toAnalyze', '_self', 0);
INSERT INTO `menu` VALUES (13, 1, '接口文档', 'fa fa-code', 'toApi', '_self', 0);
INSERT INTO `menu` VALUES (14, 2, '开始训练', 'fa fa-child', 'toExercise', '_blank', 1);
INSERT INTO `menu` VALUES (15, 2, '训练记录列表', 'fa fa-file-text', 'toRecordList', '_self', 1);
INSERT INTO `menu` VALUES (16, 2, '训练建议列表', 'fa fa-comments', 'toSuggestList', '_self', 1);

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号（主键）',
  `title` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `picture` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图片路径',
  `release_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES (1, '视觉训练辅助系统实现功能简述', '1.	通过使用相机(摄像头)实现实时运动捕捉；\r\n2.	生成虚拟人物（可以更换造型）显示当前动作；\r\n3.	判断当前训练动作是否规范，包含科目：\r\n	负重深蹲：通过腿部弯曲角度等判断动作是否标准，对标准动作进行打分评价并计数；\r\n	辅助式引体向上：判断动作是否标准，对标准动作进行打分评价并计数；\r\n	电动爬绳机：评估能否通过骨架识别判断爬绳速度，控制电动爬绳机（攀绳机）的电机转速，实现自动调速并与当先训练人员攀爬速度匹配；\r\n', 'http://localhost:8888/static/layuimini/images/carousel_1.png', '2023-10-26 19:27:00');
INSERT INTO `note` VALUES (2, '视觉训练辅助系统实现总体需求', '客户通过登录客户端(前台)，根据客户预存资料(编号，姓名，年龄，部门，科目，次数统计，成绩)分类导航；实现科目选择(包含科目：自由深蹲、辅助式引体向上、电动爬绳机（攀绳机）)；并显示当前训练进度、计数值、合格率、训练科目动作标准度等(以及查阅历史资料)；显示标准动作视频（动作视频可以更换）和标准动作的文本提示。\r\n客户通过管理账户登录后台\r\n1. 建立客户资料(编号，姓名，年龄，部门）和登录密码；\r\n2. 可以浏览查询训练的历史资料（科目，次数统计，成绩等），并完成技术面图表分析，提出合理的训练建议(包含每个周期的训练项目、时长和训练强度)。\r\n3. 可上传相应科目的标准视屏，并编辑注意事项和图片\r\n', 'http://localhost:8888/static/layuimini/images/carousel_2.png', '2023-10-02 21:15:59');
INSERT INTO `note` VALUES (3, '视觉训练辅助系统实现用户界面', '前后台界面风格基本一致，界面需要简洁大方，有较高的人机交互友好度，总体设计需贴近高端的训练辅助软件水平，以后台界面为例介绍软件界面内容；', 'http://localhost:8888/static/layuimini/images/carousel_3.png', '2023-10-26 19:30:46');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号（主键）',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户编号（外键）',
  `subject_id` bigint(0) NULL DEFAULT NULL COMMENT '科目编号（外键）',
  `plan_count` int(0) NULL DEFAULT NULL COMMENT '计划训练动作数量',
  `actual_count` int(0) NULL DEFAULT NULL COMMENT '实际训练动作数量',
  `pass_count` int(0) NULL DEFAULT NULL COMMENT '合格训练动作数量',
  `progress` double NULL DEFAULT NULL COMMENT '训练进度（实际训练动作数量/计划训练动作数量）',
  `pass_rate` double NULL DEFAULT NULL COMMENT '合格率（合格训练动作数量/实际训练动作数量）',
  `standard` double NULL DEFAULT NULL COMMENT '标准度（实际训练动作得分求平均）',
  `score` double NULL DEFAULT NULL COMMENT '训练成绩（合格率+标准度/2）',
  `result` int(0) NULL DEFAULT NULL COMMENT '训练结果（优秀=0，良好=1，合格=2，不合格=3）',
  `exercise_time` datetime(0) NULL DEFAULT NULL COMMENT '训练时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `subject_id`(`subject_id`) USING BTREE,
  CONSTRAINT `record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `record_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (1, 3, 1, 13, 14, 15, 22, 33, 44, 55, 3, '2023-10-02 22:28:44');
INSERT INTO `record` VALUES (2, 3, 1, 14, 14, 14, 14, 15, 16, 17, 1, '2023-10-03 15:01:42');
INSERT INTO `record` VALUES (3, 3, 1, 1, 1, 1, 78, 66, 45, 90, 0, '2023-10-03 15:09:20');
INSERT INTO `record` VALUES (4, 3, 1, 10, 0, 0, 0, 0, 0, 0, 3, '2023-10-26 22:02:30');
INSERT INTO `record` VALUES (5, 3, 2, 0, 0, 0, 0, 0, 0, 0, 3, '2023-10-26 15:18:17');
INSERT INTO `record` VALUES (6, 3, 2, 100, 14, 7, 14.000000000000002, 50, 91.57, 70.78, 2, '2023-10-26 15:21:23');
INSERT INTO `record` VALUES (7, 3, 2, 0, 0, 0, 0, 0, 0, 0, 3, '2023-10-26 15:23:24');
INSERT INTO `record` VALUES (8, 3, 2, 0, 0, 0, 0, 0, 0, 0, 3, '2023-10-26 15:24:03');
INSERT INTO `record` VALUES (9, 3, 2, 0, 0, 0, 0, 0, 0, 0, 3, '2023-10-26 15:24:32');
INSERT INTO `record` VALUES (10, 3, 2, 0, 0, 0, 0, 0, 0, 0, 3, '2023-10-26 15:34:58');
INSERT INTO `record` VALUES (11, 3, 2, 10, 0, 0, 0, 0, 0, 0, 3, '2023-10-26 15:49:30');
INSERT INTO `record` VALUES (12, 3, 2, 5, 5, 5, 100, 100, 95.8, 97.9, 0, '2023-10-26 16:01:10');
INSERT INTO `record` VALUES (13, 3, 2, 10, 10, 7, 100, 70, 94.5, 82.25, 1, '2023-10-26 16:03:48');
INSERT INTO `record` VALUES (14, 3, 2, 12, 0, 0, 0, 0, 0, 0, 3, '2023-10-26 16:24:35');
INSERT INTO `record` VALUES (15, 3, 2, 10, 10, 6, 100, 60, 91, 75.5, 2, '2023-10-26 16:32:07');
INSERT INTO `record` VALUES (16, 3, 2, 5, 5, 3, 100, 60, 91.6, 75.8, 2, '2023-10-26 16:34:23');
INSERT INTO `record` VALUES (17, 3, 2, 12, 0, 0, 0, 0, 0, 0, 3, '2023-10-26 19:47:09');
INSERT INTO `record` VALUES (18, 3, 2, 13, 0, 0, 0, 0, 0, 0, 3, '2023-10-26 19:51:02');
INSERT INTO `record` VALUES (19, 3, 1, 10, 3, 3, 30, 100, 95.67, 97.84, 0, '2023-10-26 20:39:45');
INSERT INTO `record` VALUES (20, 3, 1, 12, 3, 0, 25, 0, 83.33, 41.66, 3, '2023-10-26 20:42:25');
INSERT INTO `record` VALUES (21, 3, 1, 10, 10, 7, 100, 70, 93.6, 81.8, 1, '2023-10-26 21:57:15');
INSERT INTO `record` VALUES (22, 3, 2, 10, 6, 4, 60, 66.67, 90, 78.34, 2, '2023-10-26 22:12:22');
INSERT INTO `record` VALUES (23, 3, 2, 5, 5, 2, 100, 40, 88.4, 64.2, 2, '2023-10-26 22:22:53');
INSERT INTO `record` VALUES (24, 1, 2, 3, 0, 0, 0, 0, 0, 0, 3, '2023-11-03 10:25:02');
INSERT INTO `record` VALUES (25, 3, 1, 100, 0, 0, 0, 0, 0, 0, 3, '2023-11-28 14:40:21');
INSERT INTO `record` VALUES (26, 3, 1, 5, 5, 5, 100, 100, 100, 100, 0, '2023-11-28 15:07:47');
INSERT INTO `record` VALUES (27, 3, 3, 2, 2, 2, 100, 100, 100, 100, 0, '2023-11-28 15:09:25');
INSERT INTO `record` VALUES (28, 3, 3, 2, 3, 3, 150, 100, 100, 100, 0, '2023-11-28 15:11:26');
INSERT INTO `record` VALUES (29, 3, 3, 2, 2, 2, 100, 100, 100, 100, 0, '2023-11-28 15:12:07');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号（主键）',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `prompt` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '标准动作文本提示',
  `video` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '标准动作视频路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES (1, '负重深蹲', '动作路线：上下直线运动。\n\n动作幅度：上至膝盖微屈，下至大腿与地面平行。\n\n动作要领：双脚分开与肩同宽，双脚脚尖冲外，11点05方向。收腹挺胸，后背挺直，下至大腿与地面平行或膝关节稍小于90°，膝盖不要超过脚尖，上至膝关节微屈，不要超伸。呼吸：下吸上呼。节奏：4-4拍。\n\n      为了让肌肉也参与发力，下蹲过程中除了后背挺直，还要尽量保持臀部绷紧并试图向上翘起，尾骨垂直向下。很多人都可能蹲不到90°了，如果后背挺直但是臀部的这个环节放松，会出现骨盆的反向卷动，腘绳肌，大收肌甚至臀大肌变得松弛，不参与发力，锻炼的效率也就降低，膝关节压力则更大。\n\n      另外蹲到小于90°的人往往是以为自己深蹲90°没有问题的人，如果按上述要求蹲不到90度，那建议立刻放弃小于90°的深蹲或者全蹲。因为蹲不到90°，说明伸髋肌群其实不仅仅没有完全调动起来也意味着控制能力不足，在伸髋肌群控制能力不足的情况下，还蹲到90°以下，那过多参与伸髋发力的是离骨骼最近的深层肌肉梨状肌，梨状肌发力初期会让股骨外旋之后才是伸髋，这样会形成股骨与髌骨关节面的滑动不吻合，股骨与髌骨出现摩擦，时间一长就会出现关节弹响和膝关节疼痛。所以全蹲有人能练有人不能练，在于身体能力不一样，和动作没关系。', 'http://localhost:9999/static/layuimini/images/video.mp4');
INSERT INTO `subject` VALUES (2, '辅助式引体向上', '1、起始姿势\n\n两手用宽握距正握（掌心向前）单杠，略宽于肩，两脚离地，两臂自然下垂伸直。 \n\n2、动作过程\n\n用背阔肌的收缩力量将身体往上拉起，当下巴超过单杠时稍作停顿，静止一秒钟，使背阔肌彻底收缩。然后逐渐放松背阔肌，让身体徐徐下降，直到回复完全下垂，重复再做。可以弯曲膝关节、将两小腿向后交叉，使身体略微后倾，能更好地锻炼背部肌肉。\n\n3、呼吸方法\n\n身体上拉时吸气，还原时呼气，不可长时间憋气。', 'http://localhost:9999/static/layuimini/images/video.mp4');
INSERT INTO `subject` VALUES (3, '检力器', '动作路线：上下直线运动。\n\n动作幅度：上至膝盖微屈，下至大腿与地面平行。\n\n动作要领：双脚分开与肩同宽，双脚脚尖冲外，11点05方向。收腹挺胸，后背挺直，下至大腿与地面平行或膝关节稍小于90°，膝盖不要超过脚尖，上至膝关节微屈，不要超伸。呼吸：下吸上呼。节奏：4-4拍。\n\n      为了让肌肉也参与发力，下蹲过程中除了后背挺直，还要尽量保持臀部绷紧并试图向上翘起，尾骨垂直向下。很多人都可能蹲不到90°了，如果后背挺直但是臀部的这个环节放松，会出现骨盆的反向卷动，腘绳肌，大收肌甚至臀大肌变得松弛，不参与发力，锻炼的效率也就降低，膝关节压力则更大。\n\n      另外蹲到小于90°的人往往是以为自己深蹲90°没有问题的人，如果按上述要求蹲不到90度，那建议立刻放弃小于90°的深蹲或者全蹲。因为蹲不到90°，说明伸髋肌群其实不仅仅没有完全调动起来也意味着控制能力不足，在伸髋肌群控制能力不足的情况下，还蹲到90°以下，那过多参与伸髋发力的是离骨骼最近的深层肌肉梨状肌，梨状肌发力初期会让股骨外旋之后才是伸髋，这样会形成股骨与髌骨关节面的滑动不吻合，股骨与髌骨出现摩擦，时间一长就会出现关节弹响和膝关节疼痛。所以全蹲有人能练有人不能练，在于身体能力不一样，和动作没关系。', 'http://localhost:9999/static/layuimini/images/video.mp4');
INSERT INTO `subject` VALUES (4, '爬绳机', '动作路线：上下直线运动。\n\n动作幅度：上至膝盖微屈，下至大腿与地面平行。\n\n动作要领：双脚分开与肩同宽，双脚脚尖冲外，11点05方向。收腹挺胸，后背挺直，下至大腿与地面平行或膝关节稍小于90°，膝盖不要超过脚尖，上至膝关节微屈，不要超伸。呼吸：下吸上呼。节奏：4-4拍。\n\n      为了让肌肉也参与发力，下蹲过程中除了后背挺直，还要尽量保持臀部绷紧并试图向上翘起，尾骨垂直向下。很多人都可能蹲不到90°了，如果后背挺直但是臀部的这个环节放松，会出现骨盆的反向卷动，腘绳肌，大收肌甚至臀大肌变得松弛，不参与发力，锻炼的效率也就降低，膝关节压力则更大。\n\n      另外蹲到小于90°的人往往是以为自己深蹲90°没有问题的人，如果按上述要求蹲不到90度，那建议立刻放弃小于90°的深蹲或者全蹲。因为蹲不到90°，说明伸髋肌群其实不仅仅没有完全调动起来也意味着控制能力不足，在伸髋肌群控制能力不足的情况下，还蹲到90°以下，那过多参与伸髋发力的是离骨骼最近的深层肌肉梨状肌，梨状肌发力初期会让股骨外旋之后才是伸髋，这样会形成股骨与髌骨关节面的滑动不吻合，股骨与髌骨出现摩擦，时间一长就会出现关节弹响和膝关节疼痛。所以全蹲有人能练有人不能练，在于身体能力不一样，和动作没关系。', 'http://localhost:9999/static/layuimini/images/video.mp4');

-- ----------------------------
-- Table structure for suggest
-- ----------------------------
DROP TABLE IF EXISTS `suggest`;
CREATE TABLE `suggest`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号（主键）',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户编号（外键）',
  `subject_id` bigint(0) NULL DEFAULT NULL COMMENT '科目编号（外键）',
  `duration` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '训练时长',
  `strength` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '训练强度',
  `suggest_time` datetime(0) NULL DEFAULT NULL COMMENT '建议时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `suggest_ibfk_1`(`user_id`) USING BTREE,
  INDEX `suggest_ibfk_2`(`subject_id`) USING BTREE,
  CONSTRAINT `suggest_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `suggest_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suggest
-- ----------------------------
INSERT INTO `suggest` VALUES (1, 3, 1, '一周', '适中', '2023-10-26 22:01:54');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号（主键）',
  `department_id` bigint(0) NULL DEFAULT NULL COMMENT '部门编号（外键）',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `age` int(0) NULL DEFAULT NULL COMMENT '年龄',
  `role` int(0) NULL DEFAULT NULL COMMENT '角色（管理员=0，客户=1）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_ibfk_1`(`department_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 1, 'admin', 'admin', 31, 0);
INSERT INTO `user` VALUES (3, 1, 'user', 'user', 14, 1);
INSERT INTO `user` VALUES (5, 2, '撒擦擦删除', '123456', 23, 1);

-- ----------------------------
-- Table structure for user_menu
-- ----------------------------
DROP TABLE IF EXISTS `user_menu`;
CREATE TABLE `user_menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号（主键）',
  `menu_id` bigint(0) NULL DEFAULT NULL COMMENT '菜单编号（外键）',
  `role` int(0) NULL DEFAULT NULL COMMENT '角色（管理员=0，客户=1）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `menu_id`(`menu_id`) USING BTREE,
  CONSTRAINT `user_menu_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_menu
-- ----------------------------
INSERT INTO `user_menu` VALUES (1, 1, 0);
INSERT INTO `user_menu` VALUES (2, 2, 1);
INSERT INTO `user_menu` VALUES (3, 3, 0);
INSERT INTO `user_menu` VALUES (4, 4, 1);
INSERT INTO `user_menu` VALUES (5, 5, 0);
INSERT INTO `user_menu` VALUES (6, 6, 0);
INSERT INTO `user_menu` VALUES (7, 7, 0);
INSERT INTO `user_menu` VALUES (8, 8, 0);
INSERT INTO `user_menu` VALUES (9, 9, 0);
INSERT INTO `user_menu` VALUES (10, 10, 0);
INSERT INTO `user_menu` VALUES (11, 11, 0);
INSERT INTO `user_menu` VALUES (12, 12, 0);
INSERT INTO `user_menu` VALUES (13, 13, 0);
INSERT INTO `user_menu` VALUES (14, 14, 1);
INSERT INTO `user_menu` VALUES (15, 15, 1);
INSERT INTO `user_menu` VALUES (16, 16, 1);

SET FOREIGN_KEY_CHECKS = 1;
