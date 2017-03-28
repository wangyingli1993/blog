CREATE DATABASE blog;
USE blog;

# MySQL5.0版本以上，varchar(50)，指的是可以存放50字符，无论存放的是数字、字母还是UTF8汉字，都只能存放50个
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id       INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  username VARCHAR(20) NOT NULL COMMENT '用户名',
  password VARCHAR(32)         DEFAULT NULL COMMENT '密码',
  nickname VARCHAR(20)         DEFAULT NULL COMMENT '昵称',
  email    VARCHAR(32)         DEFAULT NULL COMMENT '邮箱',
  sign     VARCHAR(80)         DEFAULT NULL COMMENT '签名',
  avatar   VARCHAR(80)         DEFAULT NULL COMMENT '头像'
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COMMENT '用户';
# AUTO_INCREMENT=1表示主键自增从1开始

INSERT INTO user (username, password, nickname, email, sign, avatar)
  VALUE ('Alent', '123', 'Gain', '123@163.com', '一切皆有可能', 'http:baidu.com');

DROP TABLE IF EXISTS blog;
CREATE TABLE blog (
  id          INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  user_id     INT(11)      NOT NULL COMMENT '用户id',
  title       VARCHAR(100) NOT NULL COMMENT '标题',
  content_html     TEXT COMMENT '正文html形式',
  content_markdown     TEXT COMMENT '正文markdown形式',
  create_time DATETIME            DEFAULT NULL COMMENT '创建时间',
  publish_time DATETIME            DEFAULT NULL COMMENT '发布时间',
  state TINYINT DEFAULT 0 COMMENT '状态：发布1，未发布0',
  read_num INT(11) DEFAULT 0 COMMENT '阅读数',
  FOREIGN KEY (user_id) REFERENCES user (id)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COMMENT '博客';


DROP TABLE IF EXISTS 'comment';
CREATE TABLE 'comment' (
  id           INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  blog_id      INT(11) NOT NULL COMMENT '博客id',
  comment_date DATETIME            DEFAULT NULL COMMENT '评论时间',
  content      VARCHAR(500)        DEFAULT NULL COMMENT '评论内容',
  FOREIGN KEY (blog_id) REFERENCES blog (id)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COMMENT '评论';


