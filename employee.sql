

CREATE TABLE employee(
id int,
name varchar2(50),
salary float,
primary key(id)
);
desc employee

INSERT INTO employee (id,name,salary) VALUES(1,'nam1',1000.0);
INSERT INTO employee (id,name,salary) VALUES(2,'nam2',2000.0);

SELECT * FROM employee;