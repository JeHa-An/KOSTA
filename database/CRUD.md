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

> ## DML (Data Manipulation Language)  
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
- Tables
```sql
CREATE TABLE user(
	id VARCHAR(100) AUTO_INCREMENT PRIMARY KEY, -- AUTO_
	NAME VARCHAR(100)
);

CREATE TABLE article(
	num INT AUTO_INCREMENT,
	title VARCHAR(500),
	content VARCHAR(1000),
	writer VARCHAR(100),
	PRIMARY KEY(num)
);
 ```

```sql
ALTER TABLE article ADD CONSTRAINT ATRICLE_USER_FK FOREIGN KEY(writer) REFERENCES user(id); -- 외부에서 제약조건 생성 외래키 이름 명시하지 않으면 자동으로 생성
INSERT article VALUES(NULL, '제목', '내용', 'hong'); -- error 'hong'이 user테이블에 없어서(외래키 제약 조건 위배)
INSERT article VALUES (NULL, '제목','내용', NULL); -- null 값은 가능

INSERT INTO user VALUES('hong', '홍길동');
INSERT article VALUES(NULL, '제목', '내용', 'hong'); -- success

-- 삭제 & 변경 불가, 외부에서 id column의 데이터를 참조하고 있어서 삭제 불가
DELETE FROM user WHERE id='hong'; -- hong 테이터를 article 데이블에서 참조하고 있어서 삭제 불가
UPDATE user SET id='kong' WHERE id='hong'; -- 삭제 & 변경 불가
UPDATE user SET NAME='홍홍' WHERE id='hong'; -- success

ALTER TABLE article DROP CONSTRAINT ATRICLE_USER_FK; -- 외래키 제약조건 삭제
INSERT INTO article VALUES(NULL, '송제목', '송내용', 'song');

ALTER TABLE article ADD CONSTRAINT ATRICLE_USER_FK FOREIGN KEY(writer) REFERENCES user(id) ON DELETE CASCADE; -- error 제약조건 위배되는 데이터가 있어('song') 불가
UPDATE article SET writer='hong' WHERE writer<>'hong';

-- on delete cascade : user id 'hong'을 참조하고 있던 aritcle 데이터 들이 같이 삭제(좋은 방법 X 다른 테이블의 데이터까지 영향이 생겨 위험)
ALTER TABLE article ADD CONSTRAINT ATRICLE_USER_FK FOREIGN KEY(writer) REFERENCES user(id) ON DELETE CASCADE; -- success
```
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
&nbsp;INSERT INTO table_name(column_name1, column_name2,...) VALUES(value1, value2,...);
```sql
INSERT INTO user (id, NAME) VALUES('kong', '공길동');
INSERT INTO user (NAME, id) VALUES('공길동', 'kong');
INSERT INTO user VALUES('park', '박길동') -- 컬럼목록을 생략할 경우 컬럼순으로 모든 값 저장
```  

&nbsp;INSERT INTO emp_sub (column_name1, column_name2,...)  
SELECT column_name1, column_name2 FROM table_name where 조건; : select의 결과값을 테이블에 삽입
```sql
INSERT INTO emp_sub (column_name1, column_name2,...)
SELECT column_name1, column_name2 FROM table_name where;

INSERT INTO emp_sub (id,NAME)
SELECT empno, ename FROM emp;
```
### UPDATE
&nbsp;UPDATE table_name SET column_name1=value1, column_name2=value2,.... where 조건;
```sql
-- emp에서 커미션이 없는 사람은 100을 준다.
UPDATE emp SET comm=100 where comm IS NULL OR comm=0;

-- deptno = 10인 부서만 comm을 급여의 10% 더 준다.
UPDATE emp SET comm=comm+sal*0.1 WHERE deptno=10;
```

### DELETE
&nbsp;DELETE FROM table_name WHERE 조건;
```sql
-- emp에서 이름이 hong인 데이터 삭제
DELETE FROM emp WHERE ename='hong';

-- emp에서 부서번호가 40인 데이터 삭제
DELETE FROM emp WHERE deptno=40;
```

### ARTICLE

> ## DCL (Data Control Language)  
 grant(권한 주기), revoke(권한 뺏기)
### 계정 생성
```sql
CREATE USER user_name IDENTIFIED BY 'password'; -- 계정 생성(only root)
CREATE USER user_name IDENTIFIED BY 'PASSWORD'; -- password 변경
DROP USER user_name; -- 계정 삭제
```
### GRANT 
```sql
--  kosta 계정에 testdb SELECT, INSERT, UPDATE 권한 부여
GRANT SELECT, INSERT, UPDATE ON testdb.* TO 'kosta';

-- kosta 계정에 testdb에 모든 권한 부여
GRANT ALL PRIVILEGES ON testdb.* TO 'kosta';

-- kosta 계정의 모든 DB에 모든 권한 부여
GRANT ALL PRIVILEGES ON *.* TO 'kosta';

SHOW GRANTS FOR 'kosta'; 
-- GRANT USAGE ON *.* TO 'kosta' : USAGE 권한 지정자는 권한 없음을 나타냄.(권한은 없지만 계정은 있다)
-- ALL PRIVILEGES ON *.* TO `kosta` : 모든 권한이 있다.
```

### REVOKE
```sql
-- kosta 계정에서 testdb의 update 권한 삭제
REVOKE UPDATE PRIVILEGES ON testdb.* FROM 'kosta';

-- kosta 계정에서 testdb의 모든 권한 삭제
REVOKE ALL PRIVILEGES ON testdb.* FROM 'kosta';

-- kosta 계정에서 모든 권한 삭제 
REVOKE ALL PRIVILEGES ON *.* FROM 'kosta';
```
> ## TCL (Transaction Control Language)  
 commmit(확정), rollback(취소)  
 Transaction : DB의 상태를 변환시키는 하나의 논리적 기능을 수행하기 위한 작업의 단위(쿼리 명렁어 하나) try/catch 구문 
```sql
START TRANSACTION; -- 일괄 처리할 SQL 명령어들을 묶은 블럭
-- 트랜잭션 처리는 INSERT, UPDATE, DELETE 문을 관리하기 위해 사용, SELECT, CREATE, DROP 작업은 ROLLBACK 못함
DELETE FROM emp_sub;

ROLLBACK; -- 발생한 변경사항을 취소하는 명령어, 시작되기 이전의 상태로 되돌아간다.
COMMIT; -- 변경된 작업 내용을 DB에 UPDATE
```
> DQL (Data Query Language) : select

