# SQL 문법
클라이언트 명령 프롬프트 사용 use kosta(database name) 지정 
## 자료형
```
int
VARCHAR(); -- ()에 30이 들어갔다면 30초과시 오류
DATE -- 2023-09-04 -(하이푼)으로 구분하며 날짜끼리 비교가 가능
```
## 데이터 조회 SELECT
SQL은 대소문자를 구분하지 않으며 데이터의 시작 index는 1이다.

- select from 테이블의 데이터를 조회할 때 사용
```SQL
SELECT * FROM emp; -- *의 의미는 전체 컬럼을 의미, emp는 조회하고자 하는 테이블명
SELECT empno, ename FROM emp; -- 조회하고 싶은 컬럼
```
- where 행에 대한 조건문
```SQL
SELECT * FROM emp WHERE deptno = 10; -- 같다는 = 하나만 사용
SELECT * FROM emp WHERE deptno > 10; -- emp 테이블에서 deptno가 10보다 큰 행들을 조회
SELECT * FROM Student where grade = 2 OR grade = 3; -- grade >= 2 AND grade <= 3;
SELECT * FROM emp WHERE deptno=10 AND sal>=2000; -- 두 개의 컬럼 조건 설정 가능
SELECT * FROM student WHERE (deptno1 = 101 OR deptno2 = 101) AND grade IN(1,2); 
```
- in
```SQL
SELECT * FROM student WHERE grade IN(2,3);
SELECT empno, ename, job FROM emp WHERE job = 'CLERK' OR job = 'SALESMAN'; -- 문자형은 ''
```
- not
```SQL
SELECT * FROM student WHERE NOT grade=4; -- student 테이블에서 grade=4 가 아닌 학생
SELECT * FROM student WHERE grade NOT IN(4); -- IN을 사용해 grade의 값이 4가 아닌 학생
```
- alias 오직 alias에서 space 사용할 때 ""를 사용
```SQL
SELECT empno 사번, ename 이름, job 직무 FROM emp WHERE job = 'CLERK' OR job = 'SALESMAN'; -- empno AS 사번 에서 AS가 생략
SELECT empno 사번, ename "이 름", job 직무 FROM emp WHERE job = 'CLERK' OR job = 'SALESMAN';
```
- null 의 비교는 is를 사용
```SQL
SELECT * FROM professor WHERE hpage is null;
SELECT * FROM professor WHERE hpage is NOT null;
SELECT profno, NAME, pay + bonus FROM professor WHERE bonus IS not NULL; -- int 형 끼리 더해서 조회 가능
```

-ifnull 컬럼이 0일 경우 대체하는 값 지정
```sql
SELECT profno, NAME, pay + bonus FROM professor; -- int 와 null을 더하면 null로 출력
SELECT profno, NAME, pay + IFNULL (bonus, 0) FROM professor; -- bonus가 null이면 0 (DBMS마다 다름)
```
- between A and B B값 포함, 날짜도 가능
```sql
SELECT studno, total FROM exam_01 WHERE total >= 80 AND total < 90; -- 성능은 비교 연산자가 더 좋다
SELECT studno, total FROM exam_01 WHERE total BETWEEN 80 AND 89; -- 80 ~ 89 까지
SELECT * FROM student WHERE birthday BETWEEN '1976-01-01' AND '1977-01-01' -- A값은 B값보다 작아야 한다.
```
- order by 정렬
```sql
SELECT * FROM emp order BY sal ASC; -- 오름차순(기본)
SELECT * FROM emp ORDER BY sal DESC; -- 내림차순
SELECT studno, NAME, birthday, deptno1 FROM student WHERE grade IN(4) ORDER BY birthday;
SELECT studno, NAME, birthday, deptno1 FROM student WHERE grade IN(4) ORDER BY 3;
SELECT * FROM emp ORDER BY deptno ASC, sal DESC; -- deptno값이 같으면 sal값을 비교 ASC DESC는 각각 정해준다
```

- distinct 중복 행(row) 제거
```sql
SELECT DISTINCT deptno1 FROM student;
```

- like 컬럼의 문자열에 특정 문자열이 포함된 것을 거를때 사용 ex) name의 성이 '서'인 학생 조회
```sql
SELECT * FROM student WHERE NAME LIKE '서%'; -- '서'로 시작하는, % 아무거나 null이 아닌 문자
SELECT * FROM student WHERE NAME LIKE '%서'; -- '서'로 끝나는
SELECT * FROM student WHERE NAME LIKE '%서%'; -- 서를 포함한
SELECT * FROM emp WHERE job LIKE '_A%'; -- _ 이 자리에 한 char가 와햐한다. 즉 두번째가 A인 job을 찾는다.
```

- concat 문자열을 합할때 사용
```sql
SELECT CONCAT(ename, '(',job,')') FROM emp; -- 두 개의 컬럼을 조합해 한 컬럼으로 출력 하지만 컬럼명이 없음
SELECT CONCAT(ename, '(',job,')') as 'ename_job' FROM emp; -- as로 이름을 다시 지어줄 수 있다
SELECT CONCAT(ename, '''s sal is $', sal) AS info FROM emp; -- ename`s sal is $4000
```
- format 숫자형 데이터의 포맷 지정 반올림 자리로 받은 값+1에서 반올림과 콤마를 붙히고 String 타입으로 반환
```sql
SELECT FORMAT(250500.1234, 2); -- 250500.12 
```
- insert(컬럼명, fromindex, 추가할 문자 수, 추가할문자열) 문자열 내의 지정된 위치에 특정 문자 수만큼 변경
```sql
SELECT INSERT('http://naver.com', 8, 5, 'kosta');  -- http://kosta.com , 8번째 index 8 'n'에서 5개 ('kosta')변경
SELECT studno, NAME, INSERT(jumin, 8, 6,'******') AS 'jumin' FROM student; -- 9904091******
SELECT gno 고객번호, INSERT(gname, 2, 1, '*') AS 이름 FROM gogak; -- 서*민
```
- instr 문자열 내에서 특정 문자의 위치(index)를 구한다
```sql
SELECT INStr('http://naver.com', 'n'); -- 8
SELECT INSTR(tel, ')') FROM student; -- 3
```
- substr(컬럼명, fromindex, toindex) 문자열 내에서 부분 문자열 추출
```sql
SELECT SUBSTR(tel, 1) FROM student; -- index 1부터 끝까지
SELECT SUBSTR(tel,1,INSTR(tel, 1, ')' - 1))FROM student; -- 02, 053 컬럼 tel의 index 1 부터 INSTR(tel, 1, ')' - 1 까지
SELECT studno, NAME, jumin from student WHERE SUBSTR(jumin, 3, 2) = '09'; -- where 사용해 조건 가능
SELECT substr(tel, INSTR(tel, ')')+1, INSTR(tel, '-') - INSTR(tel, ')')-1)FROM student;
```
- length 문자열 길이 구하기
```sql
SELECT LENGTH(tel) FROM student;
SELECT LENGTH(email) FROM student;
SELECT SUBSTR(email, INSTR(email, '@')) FROM professor; -- 
```
<br> 
## join
```sql
SELECT gno, gname, point  FROM gogak WHERE POINT >= 600001 AND POINT <= 700000 // gift 테이블을 보고 SQL문 작성 불편함
```
