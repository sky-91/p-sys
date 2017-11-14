DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `PK` BIGINT NOT NULL COMMENT '主键',
    `created_time` DATETIME(3) NOT NULL COMMENT '创建时间',
    `modified_time` DATETIME(3) COMMENT '修改时间',
    `user_id` VARCHAR(20) NOT NULL COMMENT '用户id',
    `password` VARCHAR(64) COMMENT '密码',
    `user_name` VARCHAR(20) COMMENT '用户姓名',
    `id_card` VARCHAR(18) COMMENT '身份证',
    `phone` VARCHAR(20) COMMENT '电话',
    `ext1` VARCHAR(50) COMMENT '扩展字段',
    `ext2` VARCHAR(50) COMMENT '扩展字段',
    `ext3` VARCHAR(50) COMMENT '扩展字段',
    `delete_flag` tinyint(1) default 0 COMMENT '删除标记',
    PRIMARY KEY (`PK`),
    UNIQUE (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';