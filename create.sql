CREATE TABLE mybatis.emp (
id int(32) PRIMARY KEY AUTO_INCREMENT, 
name varchar(10),
phone varchar(11),
email varchar(30)
);
CREATE TABLE mybatis.login (
nid int(32) PRIMARY KEY AUTO_INCREMENT,
username varchar(10) UNIQUE,
password varchar(64),
purview varchar(4),
activation varchar(1),
eid int(32),
FOREIGN KEY(eid) REFERENCES emp(id)
);