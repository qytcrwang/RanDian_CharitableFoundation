/*
Navicat MySQL Data Transfer

Source Server         : randian
Source Server Version : 50724
Source Host           : 106.12.194.99:3306
Source Database       : dixin_test

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-02-18 09:13:52
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `activity_item_tb`
-- ----------------------------
DROP TABLE IF EXISTS `activity_item_tb`;
CREATE TABLE `activity_item_tb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '关联活动id',
  `item_name` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '花费项目名称',
  `item_amount` decimal(8,2) DEFAULT NULL COMMENT '花费项目费用',
  `item_proof` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '项目花费凭证',
  `item_follow` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '花费项目后续流向',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='活动花费信息表';

-- ----------------------------
-- Records of activity_item_tb
-- ----------------------------

-- ----------------------------
-- Table structure for `activity_tb`
-- ----------------------------
DROP TABLE IF EXISTS `activity_tb`;
CREATE TABLE `activity_tb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动标题',
  `body` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '活动正文',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动地址',
  `time` bigint(10) DEFAULT NULL COMMENT '活动时间',
  `read_num` bigint(20) DEFAULT NULL COMMENT '文章阅读量',
  `good_num` bigint(20) DEFAULT NULL COMMENT '文章点赞量',
  `pic_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '封面图片地址',
  `state` int(2) DEFAULT NULL COMMENT '活动状态',
  `type` int(2) DEFAULT NULL COMMENT '活动类型',
  `if_send` int(1) DEFAULT NULL COMMENT '是否推送',
  `activity_time` int(6) DEFAULT NULL COMMENT '活动花费时间 小时',
  `apply_names` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '活动报名人员名称字符串',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除',
  `apply_nums` int(8) DEFAULT NULL COMMENT '申请人数',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='活动信息表';

-- ----------------------------
-- Records of activity_tb
-- ----------------------------

-- ----------------------------
-- Table structure for `activity_user_tb`
-- ----------------------------
DROP TABLE IF EXISTS `activity_user_tb`;
CREATE TABLE `activity_user_tb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '活动用户关联表id',
  `activity_id` bigint(20) DEFAULT NULL COMMENT '活动id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `state` int(1) DEFAULT NULL COMMENT '关联状态',
  `org_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '非用户组织或公司名称',
  `org_mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '非用户组织或公司联系方式',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='活动-用户关联表';

-- ----------------------------
-- Records of activity_user_tb
-- ----------------------------

-- ----------------------------
-- Table structure for `comment_tb`
-- ----------------------------
DROP TABLE IF EXISTS `comment_tb`;
CREATE TABLE `comment_tb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `body` varchar(600) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '评论正文',
  `activity_id` bigint(20) DEFAULT NULL COMMENT '活动id',
  `state` int(2) DEFAULT NULL COMMENT '评论状态',
  `good_num` bigint(20) DEFAULT NULL COMMENT '点赞数量',
  `time` bigint(10) DEFAULT NULL COMMENT '评论时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='评论信息表';

-- ----------------------------
-- Records of comment_tb
-- ----------------------------

-- ----------------------------
-- Table structure for `contri_info_tb`
-- ----------------------------
DROP TABLE IF EXISTS `contri_info_tb`;
CREATE TABLE `contri_info_tb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `contri_amount` decimal(10,2) DEFAULT NULL COMMENT '捐赠金额',
  `contri_things` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '捐赠物品',
  `contri_time` bigint(10) DEFAULT NULL COMMENT '捐赠时间',
  `mobile` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `org_name` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '非用户组织或公司名称',
  `org_r_name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '非用户组织或公司代表人 或个人 联系方式',
  `contri_proof` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '捐赠凭证',
  `contri_type` int(1) DEFAULT NULL COMMENT '捐赠类型 物品 钱 两者都有',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除',
  `contri_state` int(1) DEFAULT NULL COMMENT '捐赠状态',
  `if_stamp` int(1) DEFAULT NULL COMMENT '是否打印',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='捐赠信息表';

-- ----------------------------
-- Records of contri_info_tb
-- ----------------------------

-- ----------------------------
-- Table structure for `honour_tb`
-- ----------------------------
DROP TABLE IF EXISTS `honour_tb`;
CREATE TABLE `honour_tb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '荣誉id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '关联用户id',
  `honour_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '荣誉名称',
  `honour_proof` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '荣誉凭证',
  `honour_time` bigint(10) DEFAULT NULL COMMENT '获奖时间',
  `honour_state` int(1) DEFAULT NULL COMMENT '荣誉审核状态',
  `create_time` bigint(10) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(10) DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='个人荣誉表';

-- ----------------------------
-- Records of honour_tb
-- ----------------------------

-- ----------------------------
-- Table structure for `msg_tb`
-- ----------------------------
DROP TABLE IF EXISTS `msg_tb`;
CREATE TABLE `msg_tb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '通知id',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '通知标题',
  `body` varchar(300) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '通知内容',
  `time` bigint(10) DEFAULT NULL COMMENT '通知时间',
  `state` int(1) DEFAULT NULL COMMENT '显示/删除',
  `if_read` int(1) DEFAULT NULL COMMENT '已读/未读',
  `msg_type` int(1) DEFAULT NULL COMMENT '通知类型',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='通知信息表';

-- ----------------------------
-- Records of msg_tb
-- ----------------------------

-- ----------------------------
-- Table structure for `rent_apply_tb`
-- ----------------------------
DROP TABLE IF EXISTS `rent_apply_tb`;
CREATE TABLE `rent_apply_tb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '房租申请id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `school` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '毕业学校',
  `major` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '专业',
  `job_intension` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '工作意向',
  `hope_salary` int(7) DEFAULT NULL COMMENT '期望薪资',
  `state` int(2) DEFAULT NULL COMMENT '申请状态',
  `apply_time` bigint(10) DEFAULT NULL COMMENT '申请时间',
  `sent_time` bigint(10) DEFAULT NULL COMMENT '发放时间',
  `sent_amount` double(8,2) DEFAULT NULL COMMENT '发放金额',
  `sent_proof` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发放凭证',
  `job_state` int(1) DEFAULT NULL COMMENT '是否在职',
  `company_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司名称',
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除',
  `company_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司地址',
  `position` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '当前职位',
  `reject_reason` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '驳回原因',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='房租申请表';

-- ----------------------------
-- Records of rent_apply_tb
-- ----------------------------

-- ----------------------------
-- Table structure for `sign_tb`
-- ----------------------------
DROP TABLE IF EXISTS `sign_tb`;
CREATE TABLE `sign_tb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '签到id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `sign_year` int(5) DEFAULT NULL COMMENT '签到年份',
  `sign_month` int(2) DEFAULT NULL COMMENT '签到月份',
  `sign_days` bigint(11) DEFAULT NULL COMMENT '签到日 二进制',
  `type` int(1) DEFAULT NULL COMMENT '签到类型',
  `sign_nums` int(2) DEFAULT NULL COMMENT '本月签到天数',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='签到信息表';

-- ----------------------------
-- Records of sign_tb
-- ----------------------------

-- ----------------------------
-- Table structure for `syscode_tb`
-- ----------------------------
DROP TABLE IF EXISTS `syscode_tb`;
CREATE TABLE `syscode_tb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '名称',
  `code` int(2) DEFAULT NULL COMMENT '编号',
  `value` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '编号对应的实际意义',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='字典表';

-- ----------------------------
-- Records of syscode_tb
-- ----------------------------

-- ----------------------------
-- Table structure for `user_tb`
-- ----------------------------
DROP TABLE IF EXISTS `user_tb`;
CREATE TABLE `user_tb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `id_card_number` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
  `reg_time` bigint(10) DEFAULT NULL COMMENT '注册时间',
  `state` int(2) DEFAULT '0' COMMENT '用户状态 ',
  `type` int(2) DEFAULT '0' COMMENT '用户类型',
  `love_point` int(6) DEFAULT NULL COMMENT '爱心公益积分  每小时1点',
  `love_fund` double(20,2) DEFAULT NULL COMMENT '捐赠金额',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `open_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '微信openid',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户地址',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `comment` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `org_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '代表组织or公司名称',
  `old_name` varchar(60) DEFAULT NULL COMMENT '若类型为儿童基金 该字段为监护人名称',
  `old_mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '若类型为儿童基金 该字段为监护人联系方式',
  `school` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '毕业院校',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='用户信息表';

-- ----------------------------
-- Records of user_tb
-- ----------------------------
