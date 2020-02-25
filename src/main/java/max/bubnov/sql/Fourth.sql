/**
  имеется таблица с 1 полем, заполненная числами по порядку: {1,2,4,7,8,11..}.
Написать SQL Запрос который делает выборку следующего вида (2 столбца): {{3,1},{5,2},...}, Т.е. в
первом поле идет число, с которого начинается пропуск, во втором количество пропущенных чисел.
Для написания скрипта рекомендуется пользоваться сервисом http://sqlfiddle.com для упрощения
проверки правильности скрипта. В решении ожидается увидеть:
a. название стандарта SQL, на котором выполнялось задание;
b. скрипт генерации таблиц и заполнения данных;
c. скрипт, решающий саму задачу.
 */

##a  MySQL 5.6

##b
CREATE TABLE number(
    id integer PRIMARY KEY
);
insert into number (id) values (1);
insert into number (id) values (2);
insert into number (id) values (4);
insert into number (id) values (5);
insert into number (id) values (7);
insert into number (id) values (8);
insert into number (id) values (11);

##c
SELECT n1.id+1 AS numb, n2.id-n1.id-1 AS len
FROM number n1
         INNER JOIN number n2 ON n2.id > n1.id
GROUP BY (n1.id)
HAVING MIN(n2.id)-1 > n1.id