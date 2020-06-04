DROP DATABASE IF EXISTS `db_school`;
CREATE DATABASE `db_school`;
USE `db_school`;


DROP TABLE IF EXISTS `operate_log`;
CREATE TABLE `operate_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `method_name` varchar(255) DEFAULT '' COMMENT '方法名称',
  `parameter_name` varchar(2000) DEFAULT NULL COMMENT '参数名称',
  `parameter_value` varchar(2000) DEFAULT NULL COMMENT '参数值',
  `consume_time` bigint(20) DEFAULT NULL COMMENT '响应时间（毫秒）',
  `result` varchar(2000) DEFAULT NULL COMMENT '响应结果',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `bz` varchar(2000) DEFAULT NULL COMMENT '备注、说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `sno` int(11) DEFAULT NULL COMMENT '学生学号',
  `sname` varchar(20) DEFAULT NULL COMMENT '学生姓名',
  `sage` int(2) DEFAULT NULL COMMENT '学生年龄',
  `sex` varchar(10) DEFAULT NULL COMMENT '学生性别',
  `tel` varchar(20) DEFAULT NULL COMMENT '学生联系方式',
  `email` varchar(20) DEFAULT NULL COMMENT '学生电子邮箱',
  `address` varchar(50) DEFAULT NULL COMMENT '学生家庭住址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
