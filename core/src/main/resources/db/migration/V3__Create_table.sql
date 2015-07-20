## 1 雇员表
CREATE TABLE employees (

  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,

  name VARCHAR(50),

  gender VARCHAR (50),

  role VARCHAR (50)

);

## 2 课程表

CREATE TABLE courses (

  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,

  name VARCHAR (50),

  coach VARCHAR (50),

  describes VARCHAR (50)

);

## 3课程时间表

CREATE TABLE course_times (

  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  course INT,
  time DATE,
  FOREIGN KEY (course) REFERENCES courses(id)


);


## 4 用户表

CREATE TABLE customers (

  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,

  number INT UNIQUE,

  name VARCHAR(50),

  gender VARCHAR(50),

  coach INT,
  FOREIGN KEY (coach) REFERENCES employees(id)

);


## 5 课程用户表
CREATE TABLE course_customers (

  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  course INT,
  custom INT,
  FOREIGN KEY (course) REFERENCES courses(id),
  FOREIGN KEY (course) REFERENCES customers(id)

);

## 6 用户表
CREATE TABLE users (

  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  employee INT,
  name VARCHAR (50),
  password VARCHAR (50),
  FOREIGN KEY (employee) REFERENCES employees(id)

);


