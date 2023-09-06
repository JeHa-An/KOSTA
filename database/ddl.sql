-- DDL (Data Definition language)
-- create(생성), alter(변경), truncate(잘라내기), drop(삭제)

-- DDL (Data Manipulation Language)
-- insert(입력), update(수정), delete(삭제), merge(병합)

-- DCL (Data Control Language)
-- grant(권한 주기), revoke(권한 뺏기)

-- TCL (Transaction Control Language)
-- commmit(확정), rollback(취소)

-- DQL (Data Query Language) : select

CREATE DATABASE testdb;
DROP DATABASE testdb;

CREATE TABLE Person(
	NAME VARCHAR(100),
	age INT,
	address VARCHAR(100),
	email VARCHAR(100) PRIMARY KEY, 
	birthday DATE
);
-- not null & unique
-- 데이터를 넣어주지 않으면 0으로 초기화
 -- null을 허용하지 않는다.
CREATE TABLE Person(
	NAME VARCHAR(100) NOT NULL,
	age INT DEFAULT 0, 
	address VARCHAR(100),
	email VARCHAR(100),
	birthday DATE,
	PRIMARY KEY(email) 
);

DROP TABLE person;
-- https://www.w3schools.com/mysql/mysql_datatypes.asp

CREATE TABLE Persons(
	id INT,
	last_name VARCHAR(255),
	first_name VARCHAR(255),
	address VARCHAR(255),
	city VARCHAR(200)
);

-- add colume
ALTER TABLE persons ADD email VARCHAR(255);

-- modify column
ALTER TABLE persons MODIFY COLUMN city VARCHAR(255);

-- drop column
ALTER TABLE persons DROP COLUMN email;

-- add column & default
ALTER TABLE emp_sub ADD deptno int DEFAULT 10;

-- rename column
ALTER TABLE emp_sub RENAME COLUMN deptno TO dcode;

-- rename table
RENAME TABLE emp_sub TO emp_10;

-- table 비우기
TRUNCATE TABLE emp_10; -- 점유하고 있던 메모리까지 삭제

SELECT * FROM emp_10;

-- CRUD(create(insert), read(select), update(update), delete(delete))
DELETE FROM emp; -- 데이터는 지줘지지만 테이블 용량은 줄어 들지 않는다.