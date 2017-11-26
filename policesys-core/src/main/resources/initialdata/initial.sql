DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `user_to_role`;
DROP TABLE IF EXISTS `permission`;
DROP TABLE IF EXISTS `role_to_permission`;

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