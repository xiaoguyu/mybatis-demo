create table Student
(
    id   int unsigned not null auto_increment,
    name varchar(255) comment '名字',
    age  int unsigned comment '年龄',
    primary key (id)
);

INSERT INTO `student` (`id`, `name`, `age`)
VALUES (1, '张三', 15),
       (2, '李四', 16),
       (3, '王五', 17);