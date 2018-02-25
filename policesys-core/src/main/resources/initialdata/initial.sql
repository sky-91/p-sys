DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `user_to_role`;
DROP TABLE IF EXISTS `permission`;
DROP TABLE IF EXISTS `role_to_permission`;
DROP TABLE IF EXISTS `special_person`;
DROP TABLE IF EXISTS `important_person_info`;
DROP TABLE IF EXISTS `person_contact_info`;
DROP TABLE IF EXISTS `important_person_record`;
DROP TABLE IF EXISTS `group_record`;
DROP TABLE IF EXISTS `group_summary`;
-- DROP VIEW IF EXISTS `person_score_view`;
-- DROP VIEW IF EXISTS `group_score_view`;

CREATE TABLE `user` (
    `PK` BIGINT NOT NULL COMMENT '主键',
    `created_time` DATETIME(3) NOT NULL COMMENT '创建时间',
    `modified_time` DATETIME(3) COMMENT '修改时间',
    `user_id` VARCHAR(20) NOT NULL COMMENT '用户id',
    `password` VARCHAR(64) COMMENT '密码',
    `user_name` VARCHAR(20) COMMENT '用户姓名',
    `id_card` VARCHAR(18) COMMENT '身份证',
    `phone` VARCHAR(20) COMMENT '电话',
    `ext1` VARCHAR(50) COMMENT '扩展字段1',
    `ext2` VARCHAR(50) COMMENT '扩展字段2',
    `ext3` VARCHAR(50) COMMENT '扩展字段3',
    `delete_flag` tinyint(1) default 0 COMMENT '删除标记',
    PRIMARY KEY (`PK`),
    UNIQUE (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';

CREATE TABLE `role` (
    `PK` BIGINT NOT NULL COMMENT '主键',
    `created_time` DATETIME(3) NOT NULL COMMENT '创建时间',
    `modified_time` DATETIME(3) COMMENT '修改时间',
    `role_id` VARCHAR(20) NOT NULL COMMENT '角色id',
    `role_name` VARCHAR(20) COMMENT '角色名称',
    `ext1` VARCHAR(50) COMMENT '扩展字段1',
    `ext2` VARCHAR(50) COMMENT '扩展字段2',
    `ext3` VARCHAR(50) COMMENT '扩展字段3',
    `delete_flag` tinyint(1) default 0 COMMENT '删除标记',
    PRIMARY KEY (`PK`),
    UNIQUE (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色表';

CREATE TABLE `user_to_role` (
    `PK` BIGINT NOT NULL COMMENT '主键',
    `created_time` DATETIME(3) NOT NULL COMMENT '创建时间',
    `modified_time` DATETIME(3) COMMENT '修改时间',
    `user_pk` VARCHAR(20) NOT NULL COMMENT '用户pk',
    `role_pk` VARCHAR(20) NOT NULL COMMENT '角色pk',
    `ext1` VARCHAR(50) COMMENT '扩展字段1',
    `ext2` VARCHAR(50) COMMENT '扩展字段2',
    `ext3` VARCHAR(50) COMMENT '扩展字段3',
    PRIMARY KEY (`PK`),
    UNIQUE (`user_pk`, `role_pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户角色表';

CREATE TABLE `permission` (
    `PK` BIGINT NOT NULL COMMENT '主键',
    `created_time` DATETIME(3) NOT NULL COMMENT '创建时间',
    `modified_time` DATETIME(3) COMMENT '修改时间',
    `code` VARCHAR(20) NOT NULL COMMENT '权限code',
    `name` VARCHAR(20) COMMENT '权限名称',
    `resourceType` VARCHAR(10) COMMENT '资源类型',
    `url` VARCHAR(100) COMMENT '资源路径',
    `permission` VARCHAR(200) COMMENT '权限字符串',
    `parent` BIGINT COMMENT '父权限',
    `ext1` VARCHAR(50) COMMENT '扩展字段1',
    `ext2` VARCHAR(50) COMMENT '扩展字段2',
    `ext3` VARCHAR(50) COMMENT '扩展字段3',
    `delete_flag` tinyint(1) default 0 COMMENT '删除标记',
    PRIMARY KEY (`PK`),
    UNIQUE (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '权限表';

CREATE TABLE `role_to_permission` (
    `PK` BIGINT NOT NULL COMMENT '主键',
    `created_time` DATETIME(3) NOT NULL COMMENT '创建时间',
    `modified_time` DATETIME(3) COMMENT '修改时间',
    `role_pk` VARCHAR(20) NOT NULL COMMENT '角色pk',
    `permission_pk` VARCHAR(20) NOT NULL COMMENT '权限pk',
    `ext1` VARCHAR(50) COMMENT '扩展字段1',
    `ext2` VARCHAR(50) COMMENT '扩展字段2',
    `ext3` VARCHAR(50) COMMENT '扩展字段3',
    PRIMARY KEY (`PK`),
    UNIQUE (`role_pk`, `permission_pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色权限表';

CREATE TABLE `special_person` (
    `PK` BIGINT NOT NULL COMMENT '主键',
    `created_time` DATETIME(3) NOT NULL COMMENT '创建时间',
    `modified_time` DATETIME(3) COMMENT '修改时间',
    `name` VARCHAR(20) NOT NULL COMMENT '姓名',
    `id_card` CHAR(18) NOT NULL COMMENT '身份证号',
    `phone` VARCHAR(11) COMMENT '手机号码',
    `jurisdiction` VARCHAR(10) COMMENT '管辖单位',
    `resource_name` VARCHAR(10) COMMENT '资源名称',
    `activity_place` VARCHAR(60) COMMENT '活动场所',
    `activity_place_detail` VARCHAR(80) COMMENT '活动场所详址',
    `activity_time` DATETIME(3) COMMENT '活动时间',
    `push_time` DATETIME(3) COMMENT '推送时间',
    `domicile` VARCHAR(80) COMMENT '户籍地',
    `person_type` tinyint(1) default 0 COMMENT '人员类型',
    `nation` VARCHAR(5) COMMENT '民族',
    `stay_internet_site` VARCHAR(5) COMMENT '住宿上网地点',
    `tj_time_reason` VARCHAR(50) COMMENT '来津时间及事由',
    `vehicle` VARCHAR(20) COMMENT '来津方式',
    `tj_stay_site` VARCHAR(60) COMMENT '在津住地',
    `tj_contact` VARCHAR(30) COMMENT '来津联系人',
    `belongings` VARCHAR(50) COMMENT '随身物品',
    `virtual_identity` VARCHAR(20) COMMENT '虚拟身份',
    `peer_staff` VARCHAR(50) COMMENT '同行人员',
    `stay_staff` VARCHAR(50) COMMENT '同住人员',
    `car_num` VARCHAR(50) COMMENT '驾乘车辆号牌',
    `terrorist_char` VARCHAR(10) COMMENT '有无涉恐表象特征',
    `control_type` VARCHAR(20) COMMENT '重点人列控类型',
    `check_site` VARCHAR(50) COMMENT '核查地点',
    `check_police` VARCHAR(30) COMMENT '核查民警',
    `ext1` VARCHAR(50) COMMENT '扩展字段1',
    `ext2` VARCHAR(50) COMMENT '扩展字段2',
    `ext3` VARCHAR(50) COMMENT '扩展字段3',
    `delete_flag` tinyint(1) default 0 COMMENT '删除标记',
    PRIMARY KEY (`PK`),
    UNIQUE (`name`, `id_card`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '疆藏人员表';

CREATE TABLE `important_person_info` (
    `PK` BIGINT NOT NULL COMMENT '主键',
    `created_time` DATETIME(3) NOT NULL COMMENT '创建时间',
    `modified_time` DATETIME(3) COMMENT '修改时间',
    `name` VARCHAR(20) NOT NULL COMMENT '姓名',
    `id_card` CHAR(18) NOT NULL COMMENT '身份证号',
    `sex` tinyint(1) COMMENT '性别',
    `nation` VARCHAR(5) COMMENT '民族',
    `age` tinyint(4) COMMENT '年龄',
    `group_type` VARCHAR(5) COMMENT '群体类别',
    `controll_keyword` VARCHAR(11) COMMENT '列控关键字',
    `marital_status` CHAR(2) COMMENT '婚姻状况',
    `domicile` VARCHAR(60) COMMENT '户籍地',
    `residence` VARCHAR(60) COMMENT '现住地',
    `jurisdiction` VARCHAR(10) COMMENT '管辖单位',
    `juri_police` VARCHAR(10) COMMENT '管辖派出所',
    `education` VARCHAR(5) COMMENT '学历',
    `veteran_status` VARCHAR(5) COMMENT '兵役状况',
    `job` VARCHAR(5) COMMENT '职业',
    `work_place` VARCHAR(50) COMMENT '服务处所',
    `work_status` CHAR(2) COMMENT '工作状态',
    `controll_reason` VARCHAR(50) COMMENT '列控事由',
    `remark` VARCHAR(50) COMMENT '备注',
    `ext1` VARCHAR(50) COMMENT '扩展字段1',
    `ext2` VARCHAR(50) COMMENT '扩展字段2',
    `ext3` VARCHAR(50) COMMENT '扩展字段3',
    `delete_flag` tinyint(1) default 0 COMMENT '删除标记',
    PRIMARY KEY (`PK`),
    UNIQUE (`name`, `id_card`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '重点人员底库表';

CREATE TABLE `person_contact_info` (
    `PK` BIGINT NOT NULL COMMENT '主键',
    `created_time` DATETIME(3) NOT NULL COMMENT '创建时间',
    `modified_time` DATETIME(3) COMMENT '修改时间',
    `person_pk` BIGINT NOT NULL COMMENT '人员',
    `phone` VARCHAR(15) COMMENT '联系方式',
    `wechat_name` VARCHAR(15) COMMENT '微信绑定名称',
    `ext1` VARCHAR(50) COMMENT '扩展字段1',
    `delete_flag` tinyint(1) default 0 COMMENT '删除标记',
    PRIMARY KEY (`PK`),
    UNIQUE (`person_pk`, `phone`, `wechat_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '重点人员联系信息表';

CREATE TABLE `important_person_record` (
    `PK` BIGINT NOT NULL COMMENT '主键',
    `created_time` DATETIME(3) NOT NULL COMMENT '创建时间',
    `modified_time` DATETIME(3) COMMENT '修改时间',
    `name` VARCHAR(20) NOT NULL COMMENT '姓名',
    `id_card` CHAR(18) NOT NULL COMMENT '身份证号',
    `score` tinyint(4) COMMENT '分数',
    `record_date` DATE COMMENT '日期',
    `week` CHAR(1) COMMENT '星期',
    `group_type` VARCHAR(5) COMMENT '群体类别',
    `petition_location` VARCHAR(5) COMMENT '上访地点',
    `petition_region` CHAR(2) COMMENT '上访区域',
    `petition_dynamic` VARCHAR(5) COMMENT '上访动态',
    `confirm` tinyint(1) default 0 COMMENT '是否落实',
    `incite_method` VARCHAR(5) COMMENT '轨迹类型',
    `info_sources` VARCHAR(5) COMMENT '信息来源',
    `qq_group` VARCHAR(15) COMMENT 'QQ群',
    `wechat_group` VARCHAR(15) COMMENT '微信群',
    `group_size` SMALLINT COMMENT '规模等级',
    `consequence` tinyint(1) default 0 COMMENT '是否造成后果',
    `conse_score` tinyint(4) COMMENT '造成后果分数',
    `petition_situation` VARCHAR(300) COMMENT '上访情况简介',
    `record_type` VARCHAR(4) COMMENT '轨迹类别',
    `ext1` VARCHAR(50) COMMENT '扩展字段1',
    `ext2` VARCHAR(50) COMMENT '扩展字段2',
    `ext3` VARCHAR(50) COMMENT '扩展字段3',
    `delete_flag` tinyint(1) default 0 COMMENT '删除标记',
    PRIMARY KEY (`PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '重点人员轨迹积分表';

CREATE TABLE `group_record` (
    `PK` BIGINT NOT NULL COMMENT '主键',
    `created_time` DATETIME(3) NOT NULL COMMENT '创建时间',
    `modified_time` DATETIME(3) COMMENT '修改时间',
    `group_name` VARCHAR(30) NOT NULL COMMENT '群体名称',
    `record_date` DATE COMMENT '日期',
    `score` tinyint(4) COMMENT '分数',
    `petition_location` VARCHAR(15) COMMENT '上访地点',
    `petition_region` CHAR(10) COMMENT '所属区域',
    `petition_dynamic` VARCHAR(5) COMMENT '上访动态',
    `confirm` tinyint(1) default 0 COMMENT '是否落实',
    `incite_method` VARCHAR(15) COMMENT '轨迹类型',
    `info_sources` VARCHAR(15) COMMENT '信息来源',
    `action_group` VARCHAR(15) COMMENT '维权方式',
    `group_size` SMALLINT COMMENT '规模等级',
    `consequence` tinyint(1) default 0 COMMENT '是否造成后果',
    `conse_score` tinyint(4) COMMENT '造成后果分数',
    `petition_situation` VARCHAR(300) COMMENT '上访情况概述',
    `ext1` VARCHAR(50) COMMENT '扩展字段1',
    `ext2` VARCHAR(50) COMMENT '扩展字段2',
    `ext3` VARCHAR(50) COMMENT '扩展字段3',
    `delete_flag` tinyint(1) default 0 COMMENT '删除标记',
    PRIMARY KEY (`PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '群体活动记录表';

CREATE TABLE `group_summary` (
    `PK` BIGINT NOT NULL COMMENT '主键',
    `created_time` DATETIME(3) NOT NULL COMMENT '创建时间',
    `modified_time` DATETIME(3) COMMENT '修改时间',
    `group_name` VARCHAR(30) NOT NULL COMMENT '群体名称',
    `group_type` VARCHAR(20) COMMENT '群体类别',
    `group_introduce` VARCHAR(300) COMMENT '群体简介',
    `ext1` VARCHAR(50) COMMENT '扩展字段1',
    `delete_flag` tinyint(1) default 0 COMMENT '删除标记',
    PRIMARY KEY (`PK`),
    UNIQUE (`group_name`, `group_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '群体汇总信息表';

-- CREATE VIEW `person_score_view` AS
--     SELECT ipi.name AS name, ipi.id_card AS id_card, SUM(ipr.score) AS person_score,
--     SUM(person_score) AS total_score, CONCAT (FORMAT(person_score*100/total_score,2), '%') AS activity
--     FROM important_person_info AS ipi JOIN important_person_record AS ipr
--     WHERE ipi.id_card = ipr.id_card GROUP BY ipr.id_card;
--
-- CREATE VIEW `group_score_view` AS
--     SELECT gs.group_name AS name, SUM(gr.score) AS group_score,
--     SUM(group_score) AS total_score, CONCAT (FORMAT(group_score*100/total_score,2), '%') AS activity
--     FROM group_summary AS gs JOIN group_record AS gr
--     WHERE gs.group_name = gr.group_name GROUP BY gr.group_name;

INSERT INTO `user` VALUES (1,'2018-01-08 11:00:00.123','2018-01-08 11:00:00.123','admin','wyhND5RgbeH9KvFyq6Fb8w==','张三','100100200010101234','13113113113',NULL,NULL,NULL,0);
INSERT INTO `role` VALUES (1,'2018-01-08 11:00:00.123','2018-01-08 11:00:00.123','adminGroup','管理员',NULL,NULL,NULL,0);
INSERT INTO `user_to_role` VALUES (1,'2018-01-08 11:00:00.123','2018-01-08 11:00:00.123','1','1',NULL,NULL,NULL);
