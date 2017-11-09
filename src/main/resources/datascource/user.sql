CREATE TABLE `user` (
`userid`  bigint(20) NULL AUTO_INCREMENT COMMENT '用户编号' ,
`username`  varchar(50) NULL COMMENT '名称' ,
`address`  varchar(200) NULL COMMENT '地址' ,
PRIMARY KEY (`userid`)
)
;
