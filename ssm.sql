CREATE TABLE emp (
id int(32) PRIMARY KEY AUTO_INCREMENT, 
name varchar(10),
phone varchar(11),
email varchar(30)
);
CREATE TABLE login (
eid int(32) PRIMARY KEY AUTO_INCREMENT,
username varchar(10) UNIQUE,
password varchar(64),
purview varchar(4),
activation varchar(1),
FOREIGN KEY(eid) REFERENCES emp(id)
);
INSERT INTO mybatis.emp (id, name, phone, email) VALUES (1, '天游一', '18777502416', 'sagakisu@icloud.com');
INSERT INTO mybatis.emp (id, name, phone, email) VALUES (2, '王二', '18777502416', 'sagakisu@icloud.com');
INSERT INTO mybatis.emp (id, name, phone, email) VALUES (3, '张三', '18777502416', 'sagakisu@icloud.com');
INSERT INTO mybatis.emp (id, name, phone, email) VALUES (4, '李四', '18777502416', 'sagakisu@icloud.com');
INSERT INTO mybatis.emp (id, name, phone, email) VALUES (5, '吴文', '18777502416', 'sagakisu@icloud.com');
INSERT INTO mybatis.emp (id, name, phone, email) VALUES (6, '礼流', '18777502416', 'sagakisu@icloud.com');
INSERT INTO mybatis.emp (id, name, phone, email) VALUES (7, '齐桃', '18777502416', 'sagakisu@icloud.com');
INSERT INTO mybatis.emp (id, name, phone, email) VALUES (8, '王拔', '18777502416', 'sagakisu@icloud.com');
INSERT INTO mybatis.login (eid, username, password, purview, activation) VALUES (1, 'admin', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '管理员', '是');
INSERT INTO mybatis.login (eid, username, password, purview, activation) VALUES (2, 'test', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '普通员工', '是');
INSERT INTO mybatis.login (eid, username, password, purview, activation) VALUES (3, 'test3', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '普通员工', '是');
INSERT INTO mybatis.login (eid, username, password, purview, activation) VALUES (4, 'test4', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '管理员', '是');
INSERT INTO mybatis.login (eid, username, password, purview, activation) VALUES (5, 'test5', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '普通员工', '是');
INSERT INTO mybatis.login (eid, username, password, purview, activation) VALUES (6, 'test6', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '普通员工', '是');
INSERT INTO mybatis.login (eid, username, password, purview, activation) VALUES (7, 'test7', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '管理员', '是');
INSERT INTO mybatis.login (eid, username, password, purview, activation) VALUES (8, 'test8', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '管理员', '是');