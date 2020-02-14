/*
Navicat MySQL Data Transfer

Source Server         : LOCAL_CONNECTION
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : dixin

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-02-14 09:44:29
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `activity_tb`
-- ----------------------------
DROP TABLE IF EXISTS `activity_tb`;
CREATE TABLE `activity_tb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `title` varchar(100) DEFAULT NULL COMMENT '活动标题',
  `body` longtext COMMENT '活动正文',
  `address` varchar(100) DEFAULT NULL COMMENT '活动地址',
  `time` bigint(10) DEFAULT NULL COMMENT '活动时间',
  `read_num` bigint(20) DEFAULT NULL COMMENT '文章阅读量',
  `good_num` bigint(20) DEFAULT NULL COMMENT '文章点赞量',
  `pic_url` varchar(200) DEFAULT NULL COMMENT '封面图片地址',
  `state` int(2) DEFAULT NULL COMMENT '活动状态',
  `type` int(2) DEFAULT NULL COMMENT '活动类型',
  `if_send` int(1) DEFAULT NULL COMMENT '是否推送',
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
  `state` bigint(20) DEFAULT NULL COMMENT '关联状态',
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
  `body` varchar(600) DEFAULT NULL COMMENT '评论正文',
  `activity_id` bigint(20) DEFAULT NULL COMMENT '活动id',
  `state` int(2) DEFAULT NULL COMMENT '评论状态',
  `good_num` bigint(20) DEFAULT NULL COMMENT '点赞数量',
  `time` bigint(10) DEFAULT NULL COMMENT '评论时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='评论信息表';

-- ----------------------------
-- Records of comment_tb
-- ----------------------------

-- ----------------------------
-- Table structure for `msg_tb`
-- ----------------------------
DROP TABLE IF EXISTS `msg_tb`;
CREATE TABLE `msg_tb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '通知id',
  `title` varchar(100) DEFAULT NULL COMMENT '通知标题',
  `body` varchar(300) DEFAULT NULL COMMENT '通知内容',
  `time` bigint(10) DEFAULT NULL COMMENT '通知时间',
  `state` int(1) DEFAULT NULL COMMENT '显示/删除',
  `if_read` int(1) DEFAULT NULL COMMENT '已读/未读',
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
  `school` varchar(60) DEFAULT NULL COMMENT '毕业学校',
  `major` varchar(60) DEFAULT NULL COMMENT '专业',
  `job_intension` varchar(100) DEFAULT NULL COMMENT '工作意向',
  `hope_salary` int(7) DEFAULT NULL COMMENT '期望薪资',
  `state` int(2) DEFAULT NULL COMMENT '申请状态',
  `time` bigint(10) DEFAULT NULL COMMENT '申请时间',
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
  `time` bigint(10) DEFAULT NULL COMMENT '签到时间',
  `type` int(1) DEFAULT NULL COMMENT '签到类型',
  `amount` double(10,2) DEFAULT NULL COMMENT '签到花费',
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
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `code` int(2) DEFAULT NULL COMMENT '编号',
  `value` varchar(30) DEFAULT NULL COMMENT '编号对应的实际意义',
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
  `name` varchar(30) DEFAULT NULL COMMENT '用户姓名',
  `id_card_number` varchar(60) DEFAULT NULL COMMENT '身份证号',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机号',
  `reg_time` bigint(10) DEFAULT NULL COMMENT '注册时间',
  `state` int(2) DEFAULT '0' COMMENT '用户状态 ',
  `type` int(2) DEFAULT '0' COMMENT '用户类型',
  `love_point` bigint(20) DEFAULT NULL COMMENT '爱心积分',
  `love_fund` double(20,2) DEFAULT NULL COMMENT '爱心基金',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `open_id` varchar(100) DEFAULT NULL COMMENT '微信openid',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(100) DEFAULT NULL COMMENT '用户地址',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `comment` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='用户信息表';

-- ----------------------------
-- Records of user_tb
-- ----------------------------
