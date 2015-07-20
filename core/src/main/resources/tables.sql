DROP DATABASE IF EXISTS user_management;
CREATE DATABASE user_management DEFAULT CHARACTER SET utf8;
USE user_management;

CREATE TABLE employees (
  id INT NOT NULL PRIMARY AUTO_INCREMENT,
  name VARCHAR(50),
  gender VARCHAR (50),
  role VARCHAR (50)
);

CREATE TABLE courses (
  id INT NOT NULL PRIMARY AUTO_INCREMENT,
  name VARCHAR (50),
  coach VARCHAR (50),
  discribe VARCHAR (50)
)

CREATE TABLE course_times (
  id INT NOT NULL PRIMARY AUTO_INCREMENT,
  course INT FOREIGN PEFERENCES  courses(id),
  time DATE
)

CREATE TABLE customers (
  id INT NOT NULL PRIMARY AUTO_INCREMENT,
  no INT UNIQUE,
  name VARCHAR (50) ,
  gender VARCHAR (50),
  coach INT FOREIGN PEFERENCES employees(id)
)

CREATE TABLE course_customers (
  id INT NOT NULL PRIMARY AUTO_INCREMENT,
  course INT FOREIGN PEFERENCES courses(id),
  custom INT FOREIGN PEFERENCES customers(id)
)

CREATE TABLE users (
  id INT NOT NULL PRIMARY AUTO_INCREMENT,
  employee INT FOREIGN PEFERENCES employees(id),
  name VARCHAR (50),
  password VARCHAR (50)
)

INSERT INTO employees (id, name, gender, role)
  VALUES (1, '李逍遥', '男', 'OPs'),
  (2, '哈林', '男', 'Coach'),
  (3, '花千骨', '女', 'HR'),
  (4, '周杰伦', '男', 'Coach'),
  (5, '汪峰', '男', 'Coach');

INSERT INTO courses (id, name, coach, discribe)
  VALUES (1, '跆拳道', 4, '跆拳道课程'),
    (2, '拉丁舞', 2, '拉丁舞训练'),
    (3, '动感车房', 5, '动感车房课程');

INSERT INTO course_times (id, course, time)
  VALUES (1, 1, '2015-5-5'),
        (2, 1, '2015-5-6'),
        (3, 1, '2015-5-8'),
        (3, 1, '2015-5-10');

INSERT INTO customers(id, no, name, gender)
  VALUES (1, 1, 'ColdPlay', '男'),
        (2, 2, 'OneRepublic', '男'),
        (3, 3, 'Maroon5', '男'),
        (4, 4, 'Taylor', '女');


INSERT INTO course_customers (course, custom)
  VALUES (1, 1),
    (1, 2),
    (1, 3),
    (2, 1),
    (2, 2),
    (3, 4);
