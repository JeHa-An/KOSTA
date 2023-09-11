-- constraint : 제약조건
-- not null, unique, primary key, foreign key, check
CREATE TABLE temp(
	id INT PRIMARY KEY, -- 동일한 데이터 허용하지 않고, null값도 허용하지 않는다. (unique & not null)
	NAME VARCHAR(20) NOT NULL -- null값 허용하지 않는다.
);
INSERT INTO temp VALUES(null, 'jang'); -- primary key는 null도 허용하지 않는다.
INSERT INTO temp VALUES(1, 'jang');
INSERT INTO temp VALUES(1, 'gang'); -- primary key error
INSERT INTO temp VALUES(2, NULL); -- name null error

CREATE TABLE temp2(
	email VARCHAR(50) UNIQUE
);

INSERT INTO temp2 VALUES(NULL); -- primary key와 unique 차이점 null은 허용
INSERT INTO temp2 VALUES(NULL);
INSERT INTO temp2 VALUES('test'); -- null이 아닌 중복값은 허용하지 않는다.
INSERT INTO temp2 VALUES('test');

CREATE TABLE temp3(
	NAME VARCHAR(20) NOT NULL,
	age INT DEFAULT 1 CHECK(age > 0) -- value의 범위 제한
);

INSERT INTO temp3 (NAME) VALUES('hong');
INSERT INTO temp3 VALUES('kang', -1); -- age 범위 오류