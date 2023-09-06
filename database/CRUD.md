# CRUD
&nbsp;CRUD는 대부분의 컴퓨터 소프트웨어가 가지는 기본적인 데이터 처리 기능인 **Create(insert), Read(select), Update(update), Delete(delete)** 를 묶어서 일컫는 말이다. 사용자 인터페이스가 갖추어야 할 기능(정보의 참조/검색/갱신)을 가리키는 용어로서도 사용된다.

## SQL 문법 종류
> ## DDL (Data Definition language)  
 create(생성), alter(변경), truncate(잘라내기), drop(삭제)
### CREATE
```sql
  CREATE DATABASE DBName;
  
  CREATE TABLE TableName(
    id INT PRIMARY KEY, -- NULL을 허용 X, 유일한 값, ALTER로 설정 가능
    NAME VARCHAR(100),
    age INT DEFAULT 0,  -- 값을 넣지 않으면 0으로 초기화
    address VARCHAR(100),
    -- PRIMARY KEY(id) 마지막에 설정 가능
  );
```
### ALTER
```sql
  ALTER TABLE TableName ADD EMAIL VARCHAR(255); -- add email column
  ALTER TABLE TableName MODIFY COLUMN city VARCHAR(255); -- add city column
  ALTER TABLE TableName DROP COLUMN email -- drop column
  ALTER TABLE emp_sub ADD deptno int DEFAULT 10; -- add column & default
  ALTER TABLE TableName RENAME COLUMN id TO jumin; -- rename column
  RENAME TABLE emp_sub TO emp_10; -- rename table
```
### DROP
```sql
  DROP DATABASE DBName; -- drop DATABASE
  DROP TABLE TableName; -- drop TABLE
```
### RENAME
```sql
  ALTER TABLE TableName RENAME COLUMN id TO jumin; -- rename column
  RENAME TABLE emp_sub TO emp_10; -- rename table
```
### TRUNCATE
```sql
  TRUNCATE TABLE TableName; -- 점유하고 있던 메모리까지 삭제
  DELETE FROM emp; -- 데이터는 지줘지지만 테이블 용량은 줄어 들지 않는다.
```
<details>
<summary>TRUNCATE vs DELETE</summary>

<!-- 작성 -->
**TRUNCATE** 은 데이터 메모리까지 삭제해 시스템 부하가 적지만 데이터를 모두 삭제해 복구 불가능하다.  
**DELETE** 은 데이터를 삭제하지만 메모리까지 삭제하지 않아 시스템 부하가 크지만 복구가 가능하다.
</details>

> ## DDL (Data Manipulation Language)  
 insert(입력), update(수정), delete(삭제), merge(병합)  
<details>
<summary>constraint</summary>

### UNIQUE
```sql
CREATE TABLE tname(
	email VARCHAR(50) UNIQUE
);

INSERT INTO tname VALUES(NULL); -- primary key와 unique 차이점 null은 허용
INSERT INTO tname VALUES(NULL); -- 같은 값 중복 허용
INSERT INTO tname VALUES('test'); -- 새로운 값 추가 허용
INSERT INTO tname VALUES('test'); -- null이 아닌 중복값은 허용하지 않는다.
```
### PRIMARY KEY &  NOT NULL
```sql
CREATE TABLE tname(
	id INT PRIMARY KEY, -- 동일한 데이터 허용하지 않고, null값도 허용하지 않는다. (unique & not null)
	NAME VARCHAR(20) NOT NULL -- null값 허용하지 않는다.
);
INSERT INTO tname VALUES(null, 'jang'); -- error
INSERT INTO tname VALUES(1, 'jang');
INSERT INTO tname VALUES(1, 'gang'); -- primary key error
INSERT INTO tname VALUES(2, NULL); -- name null error
```
### FOREIGN KEY
### CHECK
```sql
CREATE TABLE tname(
	NAME VARCHAR(20) NOT NULL,
	age INT DEFAULT 1 CHECK(age > 0) -- value의 범위 제한
);

INSERT INTO temp3 VALUES('kang', -1); -- age 범위 오류
```
</details>

### INSERT
```sql
  CREATE TABLE TableNAme(
    id INT PRIMARY KEY,
    NAME VARCHAR(20) NOT NULL
  );
  INSERT INTO TableName VALUES(int, 'string'); 
  INSERT INTO TableName (columnName) VALUES('string'); 
  -- column중 하나의 값 입력시 column명 추가
```
> ## DCL (Data Control Language)  
 grant(권한 주기), revoke(권한 뺏기)

> ## TCL (Transaction Control Language)  
 commmit(확정), rollback(취소)

> DQL (Data Query Language) : select

