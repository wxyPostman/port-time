/*
 Navicat Premium Data Transfer

 Source Server         : yjw
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : campuspt

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 10/05/2019 11:04:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tab_position
-- ----------------------------
DROP TABLE IF EXISTS `tab_position`;
CREATE TABLE `tab_position`  (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '职位分类编号',
  `pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位分类名称',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tab_position
-- ----------------------------
INSERT INTO `tab_position` VALUES (1, '简单易做');
INSERT INTO `tab_position` VALUES (2, '跑腿办事');
INSERT INTO `tab_position` VALUES (3, '专业技能');
INSERT INTO `tab_position` VALUES (4, '优秀青年');
INSERT INTO `tab_position` VALUES (5, '特色职位');
INSERT INTO `tab_position` VALUES (6, '体力达人');
INSERT INTO `tab_position` VALUES (9, '其它');

-- ----------------------------
-- Table structure for tab_receiveorders
-- ----------------------------
DROP TABLE IF EXISTS `tab_receiveorders`;
CREATE TABLE `tab_receiveorders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `oid` int(11) NOT NULL COMMENT '订单编号',
  `uid` int(11) NOT NULL COMMENT '接单人编号',
  `status` int(11) NOT NULL COMMENT '状态 0正在接单 1等待验收 2未完成 3已完成 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tab_receiveorders
-- ----------------------------
INSERT INTO `tab_receiveorders` VALUES (1, 6, 7, 0);
INSERT INTO `tab_receiveorders` VALUES (4, 6, 7, 0);

-- ----------------------------
-- Table structure for tab_releaseorders
-- ----------------------------
DROP TABLE IF EXISTS `tab_releaseorders`;
CREATE TABLE `tab_releaseorders`  (
  `oid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `sid` int(11) NOT NULL COMMENT '学校编号',
  `pid` int(11) NOT NULL COMMENT '兼职种类编号',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单标题',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单描述',
  `paymethod` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付方式 （日结/月结/完工结...）',
  `recruitnum` int(11) NOT NULL COMMENT '招聘人数',
  `releasetime` date NOT NULL COMMENT '发布时间',
  `uid` int(11) NOT NULL COMMENT '发单人',
  `salary` double(50, 0) NOT NULL COMMENT '薪资',
  `status` int(11) NOT NULL COMMENT '状态 （0正在找/1不招）',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tab_releaseorders
-- ----------------------------
INSERT INTO `tab_releaseorders` VALUES (6, 5, 6, '兼职1', '<div class=\"title-m\">\r\n                                <h4>\r\n                                    职位详情\r\n                                </h4>\r\n                                <hr />\r\n                                <p class=\"work_text\">\r\n                                    <span class=\"work_text_title\">\r\n                                        任职资格\r\n                                    </span>\r\n\r\n                                    <br />\r\n                                    1、高中及以上学历，面谈合适可破格录取。\r\n                                    <br />\r\n                                    2、年龄25～50周岁，条件合适可适当放宽条件。\r\n                                    <br />\r\n                                    3、了解销售业务流程或有销售工作经验的优先。\r\n                                    <br />\r\n                                    4、主动性强，具有敬业精神和责任心、上进心。\r\n                                    <br />\r\n\r\n                                    <span class=\"work_text_title\">\r\n                                        福利待遇\r\n                                    </span>\r\n                                    <br />\r\n                                    1、底薪5100，高提成(20%－30%)+高额奖金+年终奖=月薪6k～12k\r\n                                    <br />\r\n                                    2、缴纳保险（养老保险、医疗保险、工伤保险、失业保险、生育保险、意外险），有话补，高温补贴；\r\n                                    <br />\r\n                                    3、各类带薪休假（法定假日、年假、婚假、产假、陪产假、带薪年假等）；\r\n                                    <br />\r\n                                    4、做五休二，8:30-17:00，除国家法定节假日外，每年免费旅游，以及各种员工活动（聚餐、郊游、员工生日会等）；\r\n                                    <br />\r\n                                    5、免费带薪培训，公司拥有全面的培训体系，能使您在最短的时间内掌握比其它人更多、更实用的技能。\r\n                                    <br />\r\n                                    <span class=\"work_text_title\">\r\n                                        岗位职责\r\n                                    </span>\r\n                                    <br />\r\n                                    1、及时跟踪及处理客户反馈，维护客户关系；\r\n                                    <br />\r\n                                    2、负责联络沟通客户，审核客户资料并录入系统；\r\n                                    <br />\r\n                                    3、协助主管完善部门操作流程与规范，做好销售的后台支持；\r\n                                    <br />\r\n                                    4、其它主管交办事项。\r\n                                    <br />\r\n                                    <span class=\"work_text_title\">\r\n                                        温馨提示\r\n                                    </span>\r\n                                    <br />\r\n                                    公司直招不收取任何费用，面试请携带身份证、学历证书等\r\n                                </p>\r\n                            </div>', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (8, 5, 5, '兼职2', '兼职描述2', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (10, 5, 4, '兼职3', '兼职描述3', '日结', 50, '2019-05-08', 9, 200, 0);
INSERT INTO `tab_releaseorders` VALUES (11, 5, 3, '兼职4', '兼职描述4', '完工结', 200, '2019-05-07', 9, 150, 0);
INSERT INTO `tab_releaseorders` VALUES (12, 5, 2, '兼职5', '兼职描述5', '日结', 250, '2019-05-01', 10, 88, 0);
INSERT INTO `tab_releaseorders` VALUES (13, 5, 1, '兼职6', '兼职描述6', '完工结', 180, '2019-05-05', 10, 99, 0);
INSERT INTO `tab_releaseorders` VALUES (14, 4, 7, '兼职7', '兼职描述7', '日结', 66, '2019-04-01', 10, 66, 0);
INSERT INTO `tab_releaseorders` VALUES (15, 4, 6, '兼职8', '兼职描述8', '月结', 55, '2018-01-09', 11, 77, 0);
INSERT INTO `tab_releaseorders` VALUES (16, 4, 5, '兼职9', '兼职描述9', '日结', 44, '2019-05-06', 11, 11, 0);
INSERT INTO `tab_releaseorders` VALUES (17, 4, 4, '兼职10', '兼职描述10', '月结', 33, '2019-03-26', 7, 22, 0);
INSERT INTO `tab_releaseorders` VALUES (18, 4, 3, '兼职11', '兼职描述11', '完工结', 222, '2019-02-01', 7, 11, 0);
INSERT INTO `tab_releaseorders` VALUES (19, 1, 1, '兼职12', '兼职描述12', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (20, 1, 1, '兼职13', '兼职描述13', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (21, 1, 1, '兼职14', '兼职描述14', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (22, 1, 1, '兼职15', '兼职描述15', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (23, 1, 1, '兼职16', '兼职描述16', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (24, 1, 1, '兼职17', '兼职描述17', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (25, 1, 1, '兼职18', '兼职描述18', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (26, 1, 1, '兼职19', '兼职描述19', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (27, 1, 1, '兼职20', '兼职描述20', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (28, 1, 1, '兼职21', '兼职描述21', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (29, 1, 1, '兼职22', '兼职描述22', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (30, 1, 1, '兼职23', '兼职描述23', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (31, 1, 1, '兼职24', '兼职描述24', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (32, 1, 1, '兼职25', '兼职描述25', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (33, 1, 1, '兼职26', '兼职描述26', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (34, 1, 1, '兼职27', '兼职描述27', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (35, 1, 1, '兼职28', '兼职描述28', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (36, 1, 1, '兼职29', '兼职描述29', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (37, 1, 1, '兼职30', '兼职描述30', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (38, 1, 2, '兼职31', '兼职描述31', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (39, 1, 3, '兼职32', '兼职描述32', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (40, 1, 4, '兼职33', '兼职描述33', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (41, 1, 5, '兼职34', '兼职描述34', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (42, 1, 6, '兼职35', '兼职描述35', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (43, 1, 7, '兼职36', '兼职描述36', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (44, 2, 1, '兼职37', '兼职描述37', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (45, 2, 2, '兼职38', '兼职描述38', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (46, 2, 3, '兼职39', '兼职描述39', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (47, 2, 4, '兼职40', '兼职描述40', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (48, 2, 5, '兼职41', '兼职描述41', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (49, 2, 6, '兼职42', '兼职描述42', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (50, 2, 7, '兼职43', '兼职描述43', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (51, 3, 1, '兼职44', '兼职描述44', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (52, 3, 2, '兼职45', '兼职描述45', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (53, 3, 3, '兼职46', '兼职描述46', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (54, 3, 4, '兼职47', '兼职描述47', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (55, 3, 5, '兼职48', '兼职描述48', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (56, 3, 6, '兼职49', '兼职描述49', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (57, 3, 7, '兼职50', '兼职描述50', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (58, 4, 1, '兼职51', '兼职描述51', '月结', 100, '2000-01-01', 7, 100, 0);
INSERT INTO `tab_releaseorders` VALUES (59, 4, 2, '兼职52', '兼职描述52', '月结', 100, '2000-01-01', 7, 100, 0);

-- ----------------------------
-- Table structure for tab_school
-- ----------------------------
DROP TABLE IF EXISTS `tab_school`;
CREATE TABLE `tab_school`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '学校编号',
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学校名',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tab_school
-- ----------------------------
INSERT INTO `tab_school` VALUES (1, '浙江水利水电学院');
INSERT INTO `tab_school` VALUES (2, '浙江大学');
INSERT INTO `tab_school` VALUES (3, '浙江理工大学');
INSERT INTO `tab_school` VALUES (4, '杭州电子科技大学');
INSERT INTO `tab_school` VALUES (5, ' 杭州师范大学');
INSERT INTO `tab_school` VALUES (6, '浙江工商大学');
INSERT INTO `tab_school` VALUES (7, '浙江工业大学');

-- ----------------------------
-- Table structure for tab_user
-- ----------------------------
DROP TABLE IF EXISTS `tab_user`;
CREATE TABLE `tab_user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `sid` int(11) NOT NULL COMMENT '学校编号',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱地址',
  `totalscore` int(11) NULL DEFAULT NULL COMMENT '被评总分',
  `appraisenum` int(255) NULL DEFAULT NULL COMMENT '评价人数',
  `permission` int(11) NOT NULL COMMENT '权限 0为普通用户 99为管理员',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tab_user
-- ----------------------------
INSERT INTO `tab_user` VALUES (7, 1, 'yjw', '666', '男', '12345678910', '729721503@qq.com', 90, 0, 0);
INSERT INTO `tab_user` VALUES (9, 2, 'lqf', '666', '男', '88888888888', '888888888@qq.com', 88, 0, 0);
INSERT INTO `tab_user` VALUES (10, 3, 'qhc', '666', '女', '123456789123', '123456789@qq.com', 80, 0, 0);
INSERT INTO `tab_user` VALUES (11, 8, 'wxy', '666', '男', '12345678912', '123456789@qq.com', 80, 0, 0);
INSERT INTO `tab_user` VALUES (12, 5, 'yhd', '666', '男', '12345678912', '123456789@qq.com', 50, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
