## 1 雇员表
INSERT INTO employees (id, name, gender, role)

  VALUES (1, '李逍遥', '男', 'OPs'),

  (2, '哈林', '男', 'Coach'),

  (3, '花千骨', '女', 'HR'),

  (4, '周杰伦', '男', 'Coach'),

  (5, '汪峰', '男', 'Coach');


## 2 课程表
INSERT INTO courses (id, name, coach, describes)

  VALUES (1, '跆拳道', 4, '跆拳道课程'),

    (2, '拉丁舞', 2, '拉丁舞训练'),

    (3, '动感车房', 5, '动感车房课程');


## 3 课程时间表
INSERT INTO course_times (id, course, time)

  VALUES (1, 1, '2015-5-5'),

        (2, 1, '2015-5-6'),

        (3, 1, '2015-5-8'),

        (4, 1, '2015-5-10');


## 4 顾客表
INSERT INTO customers(id, number, name, gender)

  VALUES (1, 1, 'ColdPlay', '男'),

        (2, 2, 'OneRepublic', '男'),

        (3, 3, 'Maroon5', '男'),

        (4, 4, 'Taylor', '女');




## 5 课程顾客表
INSERT INTO course_customers (course, custom)

  VALUES (1, 1),

    (1, 2),

    (1, 3),

    (2, 1),

    (2, 2),

    (3, 4);

INSERT INTO users(employee, name, password)
  VALUES (1, '大白', 'dabai');