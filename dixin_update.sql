-- 数据库增量脚本 
-- 规范：
-- 提交人 提交时间 描述 start end

-- 李汶龙 2020-02-22 添加字典表值 创建菜单表 角色表 权限表 add start
delete from syscode_tb;
-- activity_tb
insert into syscode_tb (name,code,value) values ('activity_state',0,'未发布');
insert into syscode_tb (name,code,value) values ('activity_state',1,'未开始');
insert into syscode_tb (name,code,value) values ('activity_state',2,'已开始');
insert into syscode_tb (name,code,value) values ('activity_state',3,'已结束');
insert into syscode_tb (name,code,value) values ('activity_state',4,'已下架');

insert into syscode_tb (name,code,value) values ('activity_type',0,'业务动态');
insert into syscode_tb (name,code,value) values ('activity_type',1,'公告公示');
insert into syscode_tb (name,code,value) values ('activity_type',2,'政策法规');
insert into syscode_tb (name,code,value) values ('activity_type',3,'政策解读');
insert into syscode_tb (name,code,value) values ('activity_type',4,'专题专栏');
insert into syscode_tb (name,code,value) values ('activity_type',5,'在线访谈');

insert into syscode_tb (name,code,value) values ('activity_if_send',0,'否');
insert into syscode_tb (name,code,value) values ('activity_if_send',1,'是');
-- activity_user_tb
insert into syscode_tb (name,code,value) values ('activity_user_state',0,'未到场');
insert into syscode_tb (name,code,value) values ('activity_user_state',1,'已到场');
-- comment_tb
insert into syscode_tb (name,code,value) values ('comment_state',0,'正常');
insert into syscode_tb (name,code,value) values ('comment_state',1,'屏蔽');
-- contri_info_tb
insert into syscode_tb (name,code,value) values ('contri_type',0,'物品');
insert into syscode_tb (name,code,value) values ('contri_type',1,'金钱');
insert into syscode_tb (name,code,value) values ('contri_type',2,'物品及金钱');

insert into syscode_tb (name,code,value) values ('contri_state',0,'待证实');
insert into syscode_tb (name,code,value) values ('contri_state',1,'已证实');
insert into syscode_tb (name,code,value) values ('contri_state',2,'有错误');

insert into syscode_tb (name,code,value) values ('contri_if_stamp',0,'否');
insert into syscode_tb (name,code,value) values ('contri_if_stamp',1,'是');
-- honour_tb
insert into syscode_tb (name,code,value) values ('honour_state',0,'待证实');
insert into syscode_tb (name,code,value) values ('honour_state',1,'已证实');
insert into syscode_tb (name,code,value) values ('honour_state',1,'有错误');
-- msg_tb
insert into syscode_tb (name,code,value) values ('msg_state',0,'正常');
insert into syscode_tb (name,code,value) values ('msg_state',1,'删除');

insert into syscode_tb (name,code,value) values ('msg_if_read',0,'未读');
insert into syscode_tb (name,code,value) values ('msg_if_read',1,'已读');

insert into syscode_tb (name,code,value) values ('msg_type',0,'通知');
insert into syscode_tb (name,code,value) values ('msg_type',1,'个人消息');
-- rent_apply_tb
insert into syscode_tb (name,code,value) values ('rent_state',0,'待审核');
insert into syscode_tb (name,code,value) values ('rent_state',1,'已证实');
insert into syscode_tb (name,code,value) values ('rent_state',2,'已发放');
insert into syscode_tb (name,code,value) values ('rent_state',3,'驳回');

insert into syscode_tb (name,code,value) values ('job_state',0,'否');
insert into syscode_tb (name,code,value) values ('job_state',1,'是');
-- sigh_tb
insert into syscode_tb (name,code,value) values ('sign_type',0,'普通签到');
insert into syscode_tb (name,code,value) values ('sign_type',1,'儿童签到');
insert into syscode_tb (name,code,value) values ('sign_type',2,'大学生签到');
-- user_tb
insert into syscode_tb (name,code,value) values ('user_state',0,'正常');
insert into syscode_tb (name,code,value) values ('user_state',1,'封禁');
insert into syscode_tb (name,code,value) values ('user_state',2,'注销');

insert into syscode_tb (name,code,value) values ('user_type',0,'普通');
insert into syscode_tb (name,code,value) values ('user_type',1,'儿童');
insert into syscode_tb (name,code,value) values ('user_type',2,'大学生');

insert into syscode_tb (name,code,value) values ('user_sex',0,'男');
insert into syscode_tb (name,code,value) values ('user_sex',1,'女');

ALTER TABLE `activity_tb`
MODIFY COLUMN `state`  int(2) NULL DEFAULT NULL COMMENT '活动状态  0未发布 1未开始 2已开始 3已结束 4已下架' AFTER `pic_url`,
MODIFY COLUMN `type`  int(2) NULL DEFAULT NULL COMMENT '活动类型  0业务动态 1公告公示 2政策法规 3政策解读 4专题专栏 5在线访谈' AFTER `state`,
MODIFY COLUMN `if_send`  int(1) NULL DEFAULT NULL COMMENT '是否推送 0否1是 ' AFTER `type`;

ALTER TABLE `activity_user_tb`
MODIFY COLUMN `state`  int(1) NULL DEFAULT NULL COMMENT '关联状态  0未到场 1已到场' AFTER `user_id`;

ALTER TABLE `comment_tb`
MODIFY COLUMN `state`  int(2) NULL DEFAULT NULL COMMENT '评论状态 0正常1屏蔽' AFTER `activity_id`;

ALTER TABLE `contri_info_tb`
MODIFY COLUMN `contri_type`  int(1) NULL DEFAULT NULL COMMENT '捐赠类型 0物品1金钱2物品及金钱' AFTER `contri_proof`,
MODIFY COLUMN `contri_state`  int(1) NULL DEFAULT NULL COMMENT '捐赠状态 0待证实1已证实2有错误' AFTER `is_delete`,
MODIFY COLUMN `if_stamp`  int(1) NULL DEFAULT NULL COMMENT '是否打印 0否1是' AFTER `contri_state`;

ALTER TABLE `honour_tb`
MODIFY COLUMN `honour_state`  int(1) NULL DEFAULT NULL COMMENT '荣誉审核状态 0待证实1已证实2有错误' AFTER `honour_time`;

ALTER TABLE `msg_tb`
MODIFY COLUMN `state`  int(1) NULL DEFAULT NULL COMMENT '显示/删除 0正常1删除' AFTER `time`,
MODIFY COLUMN `if_read`  int(1) NULL DEFAULT NULL COMMENT '已读/未读 0未读1已读' AFTER `state`,
MODIFY COLUMN `msg_type`  int(1) NULL DEFAULT NULL COMMENT '通知类型 0通知1个人消息' AFTER `if_read`;

ALTER TABLE `rent_apply_tb`
MODIFY COLUMN `state`  int(2) NULL DEFAULT NULL COMMENT '申请状态 0待审核 1已证实 2已发放 3驳回' AFTER `hope_salary`,
MODIFY COLUMN `job_state`  int(1) NULL DEFAULT NULL COMMENT '是否在职  0否1是' AFTER `sent_proof`;

ALTER TABLE `sign_tb`
MODIFY COLUMN `type`  int(1) NULL DEFAULT NULL COMMENT '签到类型  0普通签到 1儿童签到 2大学生签到' AFTER `sign_days`;

ALTER TABLE `user_tb`
MODIFY COLUMN `state`  int(2) NULL DEFAULT 0 COMMENT '用户状态 0正常1封禁 2注销' AFTER `reg_time`,
MODIFY COLUMN `type`  int(2) NULL DEFAULT 0 COMMENT '用户类型 0普通 1儿童 2大学生' AFTER `state`,
MODIFY COLUMN `sex`  int(1) NULL DEFAULT NULL COMMENT '性别 0女1男' AFTER `open_id`;

-- 菜单表
DROP TABLE IF EXISTS `menu_tb`;
CREATE TABLE `menu_tb` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `name` varchar(90) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单名称',
  `buttons` varchar(90) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '按钮功能字符串',
  `url` varchar(90) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单url',
  `state` int(2) DEFAULT NULL COMMENT '菜单状态 0正常 1禁用',
  `fid` int(10) DEFAULT NULL COMMENT '父级菜单id',
  `sort` int(2) DEFAULT NULL COMMENT '同级菜单顺序',
  `create_time` bigint(10) DEFAULT NULL,
  `update_time` bigint(10) DEFAULT NULL,
  `is_delete` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='菜单表';

-- 角色表
DROP TABLE IF EXISTS `role_tb`;
CREATE TABLE `role_tb` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `state` int(2) DEFAULT NULL COMMENT '角色状态 0正常1禁用',
  `create_time` bigint(10) DEFAULT NULL,
  `update_time` bigint(10) DEFAULT NULL,
  `is_delete` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色表';

-- 菜单角色表
DROP TABLE IF EXISTS `menu_role_tb`;
CREATE TABLE `menu_role_tb` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '菜单角色关联id',
  `menu_id` int(10) DEFAULT NULL COMMENT '菜单id',
  `role_id` int(10) DEFAULT NULL COMMENT '角色id',
  `buttons` varchar(90) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色-菜单的按钮权限字符串',
  `create_time` bigint(10) DEFAULT NULL,
  `update_time` bigint(10) DEFAULT NULL,
  `is_delete` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='菜单角色关联表';

-- menu_tb
insert into syscode_tb (name,code,value) values ('menu_state',0,'正常');
insert into syscode_tb (name,code,value) values ('menu_state',1,'禁用');
-- role_tb
insert into syscode_tb (name,code,value) values ('role_state',0,'正常');
insert into syscode_tb (name,code,value) values ('role_state',1,'禁用');

-- 李汶龙 2020-02-22 添加字典表值 创建菜单表 角色表 权限表 add end

-- 李汶龙 2020-02-26 添加用户字段 企业统一代码 学号 add start
ALTER TABLE `user_tb`
ADD COLUMN `org_num`  varchar(90) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '企业统一代码' AFTER `org_name`,
ADD COLUMN `school_num`  varchar(90) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '学号' AFTER `school`;
-- 李汶龙 2020-02-26 添加用户字段 企业统一代码 学号 add end

-- 李汶龙 2020-02-27 添加活动字段 封面图片地址 add start
ALTER TABLE `activity_tb`
ADD COLUMN `cover_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '封面图片url' AFTER `good_num`,
MODIFY COLUMN `pic_url`  varchar(600) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '文本图片地址' AFTER `cover_url`;
-- 李汶龙 2020-02-27 添加活动字段 封面图片地址 add end



