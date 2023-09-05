# SQL 문법
SQL은 대소문자를 구분하지 않으며 데이터의 시작 index는 1이다.<br>
`클라이언트 명령 프롬프트 사용 시 use kosta(database name) 지정 `
## 자료형
```
int
VARCHAR(); -- ()에 30이 들어갔다면 30초과시 오류
DATE -- 2023-09-04 -(하이푼)으로 구분하며 날짜끼리 비교가 가능
```
## 데이터 조회 SELECT
### select from 
테이블의 데이터를 조회할 때 사용
```SQL
SELECT * FROM emp; -- *의 의미는 전체 컬럼을 의미, emp는 조회하고자 하는 테이블명
SELECT empno, ename FROM emp; -- 조회하고 싶은 컬럼
```
### where 
행에 대한 조건문
```SQL
SELECT * FROM emp WHERE deptno = 10; -- 같다는 = 하나만 사용
SELECT * FROM emp WHERE deptno > 10; -- emp 테이블에서 deptno가 10보다 큰 행들을 조회
SELECT * FROM Student where grade = 2 OR grade = 3; -- grade >= 2 AND grade <= 3;
SELECT * FROM emp WHERE deptno=10 AND sal>=2000; -- 두 개의 컬럼 조건 설정 가능
SELECT * FROM student WHERE (deptno1 = 101 OR deptno2 = 101) AND grade IN(1,2); 
```
### in
```SQL
SELECT * FROM student WHERE grade IN(2,3);
SELECT empno, ename, job FROM emp WHERE job = 'CLERK' OR job = 'SALESMAN'; -- 문자형은 ''
```
### not
```SQL
SELECT * FROM student WHERE NOT grade=4; -- student 테이블에서 grade=4 가 아닌 학생
SELECT * FROM student WHERE grade NOT IN(4); -- IN을 사용해 grade의 값이 4가 아닌 학생
```
### alias 
오직 alias에서 space 사용할 때 ""를 사용
```SQL
SELECT empno 사번, ename 이름, job 직무 FROM emp WHERE job = 'CLERK' OR job = 'SALESMAN'; -- empno AS 사번 에서 AS가 생략
SELECT empno 사번, ename "이 름", job 직무 FROM emp WHERE job = 'CLERK' OR job = 'SALESMAN';
```
### is
null 비교 함수
```SQL
SELECT * FROM professor WHERE hpage is null;
SELECT * FROM professor WHERE hpage is NOT null;
SELECT profno, NAME, pay + bonus FROM professor WHERE bonus IS not NULL; -- int 형 끼리 더해서 조회 가능
```

### ifnull()
컬럼이 0일 경우 대체하는 값 지정
```sql
SELECT profno, NAME, pay + bonus FROM professor; -- int 와 null을 더하면 null로 출력
SELECT profno, NAME, pay + IFNULL (bonus, 0) FROM professor; -- bonus가 null이면 0 (DBMS마다 다름)
```
### between
between A and B B값 포함, 날짜도 가능
```sql
SELECT studno, total FROM exam_01 WHERE total >= 80 AND total < 90; -- 성능은 비교 연산자가 더 좋다
SELECT studno, total FROM exam_01 WHERE total BETWEEN 80 AND 89; -- 80 ~ 89 까지
SELECT * FROM student WHERE birthday BETWEEN '1976-01-01' AND '1977-01-01' -- A값은 B값보다 작아야 한다.
```
### order by
정렬
```sql
SELECT * FROM emp order BY sal ASC; -- 오름차순(기본)
SELECT * FROM emp ORDER BY sal DESC; -- 내림차순
SELECT studno, NAME, birthday, deptno1 FROM student WHERE grade IN(4) ORDER BY birthday;
SELECT studno, NAME, birthday, deptno1 FROM student WHERE grade IN(4) ORDER BY 3;
SELECT * FROM emp ORDER BY deptno ASC, sal DESC; -- deptno값이 같으면 sal값을 비교 ASC DESC는 각각 정해준다
```

### distinct 
중복 행(row) 제거
```sql
SELECT DISTINCT deptno1 FROM student;
```

### like 
컬럼의 문자열에 특정 문자열이 포함된 것을 거를때 사용 ex) name의 성이 '서'인 학생 조회
```sql
SELECT * FROM student WHERE NAME LIKE '서%'; -- '서'로 시작하는, % 아무거나 null이 아닌 문자
SELECT * FROM student WHERE NAME LIKE '%서'; -- '서'로 끝나는
SELECT * FROM student WHERE NAME LIKE '%서%'; -- 서를 포함한
SELECT * FROM emp WHERE job LIKE '_A%'; -- _ 이 자리에 한 char가 와햐한다. 즉 두번째가 A인 job을 찾는다.
```

### concat() 
문자열을 합할때 사용
```sql
SELECT CONCAT(ename, '(',job,')') FROM emp; -- 두 개의 컬럼을 조합해 한 컬럼으로 출력 하지만 컬럼명이 없음
SELECT CONCAT(ename, '(',job,')') as 'ename_job' FROM emp; -- as로 이름을 다시 지어줄 수 있다
SELECT CONCAT(ename, '''s sal is $', sal) AS info FROM emp; -- ename`s sal is $4000
```
### format() 
숫자형 데이터의 포맷 지정 반올림 자리로 받은 값+1에서 반올림과 콤마를 붙히고 String 타입으로 반환
```sql
SELECT FORMAT(250500.1234, 2); -- 250500.12 
```
### insert(컬럼명, fromindex, 추가할 문자 수, 추가할 문자열)
문자열 내의 지정된 위치에 특정 문자 수만큼 변경
```sql
SELECT INSERT('http://naver.com', 8, 5, 'kosta');  -- http://kosta.com , 8번째 index 8 'n'에서부터 5개 ('kosta')변경
SELECT studno, NAME, INSERT(jumin, 8, 6,'******') AS 'jumin' FROM student; -- 9904091******
SELECT gno 고객번호, INSERT(gname, 2, 1, '*') AS 이름 FROM gogak; -- 서*민
```
### instr(컬럼명, 찾을 문자)
문자열 내에서 특정 문자의 위치(index)를 구한다
```sql
SELECT INSTR('http://naver.com', 'n'); -- 8
SELECT INSTR(tel, ')') FROM student; -- 3
```
### substr(), substring()
substr(컬럼명, fromindex, 몇개의 문자)문자열 내에서 부분 문자열 추출
```sql
SELECT SUBSTR('http://naver.com', 8, 5);
SELECT SUBSTRING('http://naver.com', 8, 5);
SELECT SUBSTR(tel, 1) FROM student; -- index 1부터 끝까지
SELECT SUBSTR(tel,1,INSTR(tel, 1, ')' - 1))FROM student; -- 02, 053 컬럼 tel의 index 1 부터 INSTR(tel, 1, ')' - 1 까지
SELECT studno, NAME, jumin from student WHERE SUBSTR(jumin, 3, 2) = '09'; -- where 사용해 조건 가능
SELECT substr(tel, INSTR(tel, ')')+1, INSTR(tel, '-') - INSTR(tel, ')')-1)FROM student;
```
### length() 
문자열 길이(byte 수) 구하기 (영문 1byte, 한글 3byte)
```sql
SELECT LENGTH(tel) FROM student;
SELECT LENGTH(email) FROM student;
SELECT ename, LENGTH(ename) FROM emp; -- 영어는 하나 당 1byte
SELECT NAME, LENGTH(NAME) FROM student; -- MariaDB에서 한글은 한 글자는 3byte 그래서 길이는 9
SELECT NAME, CHAR_LENGTH(NAME) FROM student; -- 문자의 개수 3
```
### [insert, instr, substr, length 사용 예제](https://github.com/JeHa-An/KOSTA/blob/main/database/SQL_String_EX01.md)

### lower(), lcase()
소문자로 변경
```sql
SELECT ename, LOWER(ename) FROM emp;
SELECT ename LCASE(ename) FROM emp;
```
### upper(), ucase() 
대문자로 변경
```sql
SELECT id, UPPER(id) FROM professor;
SELECT id, ucase(id) FROM professor;
```

### trim() 
앞뒤 공백 제거
```sql
SELECT TRIM(' 		test  	'); -- test
SELECT TRIM('t e s t'); -- t e s t
```

### ltrim(), rtrim()
왼쪽, 오른쪽 공백 제거
```sql
SELECT LENGTH(LTRIM('  test  ')), LENGTH(LTRIM('  test  ')); -- test__
SELECT LENGTH(RTRIM('  test  ')), LENGTH(RTRIM('  test  ')); -- __test
```

### lpad(), rpad()
lpad, rpad(컬럼명, 총길이, 넣을 문자)
```sql
SELECT sal, lpad(ename, 20, '#') 이름 FROM emp; -- ###############JONES
SELECT sal, rpad(ename, 20, '#') 이름 FROM emp; -- SMITH###############
SELECT LPAD(email, 20, '1234566789') FROM professor; -- 12345captain@abc.net 여유 있는 만큼 채워 넣는다
```
##  날짜 함수
### curdate(), current_date()
현재 실행 중인 프로그램의 날짜
```sql
SELECT CURDATE(); -- 2023-09-04
SELECT CURRENT_DATE(); -- 2023-09-04
SELECT CURRENT_DATE() + 1; -- 20230905 int형으로 변환
```
### adddate(), date_add()
연, 월, 일을 더하거나 뺀다 (DAY가 기본값)
```sql
SELECT adddate(CURDATE(), INTERVAL 1 DAY); -- 2023-09-05 
SELECT adddate(CURDATE(), INTERVAL -1 MONTH); -- 2023-08-04
SELECT adddate(CURDATE(), INTERVAL -1 year); -- 2022-09-04
SELECT ADDTIME(CURTIME(), '1:10:5'); -- add 1hour 10 minite 5 second
SELECT ADDTIME(NOW(), '2 1:10:5'); -- add 2day 1 hour 10minite 5 second
SELECT hiredate,  ADDDATE(hiredate, INTERVAL +10 YEAR) AS "10년 기념일" FROM emp; -- 1981-11-17 , 1991-11-17
```
### curtime() ,current_time(), now()
```sql
SELECT CURTIME(), CURRENT_TIME(); -- 17:50:53 , 17:50:53
SELECT NOW(); -- 2023-09-04 17:50:12
```
### datediff()
날짜 일수 차이
```sql
SELECT hiredate, DATEDIFF(CURDATE(), hiredate) FROM emp;
SELECT DATEDIFF(CURDATE(), '1999-04-09')일수;
```
### date_format
```sql
SELECT DATE_FORMAT('2017-06-15', "%m %d %y"); -- 06 15 17
SELECT DATE_FORMAT('2017-06-15', "%M %D %Y"); -- June 15th 2017
SELECT DATE_FORMAT(NOW(), "%M %d %Y %h %i %s %W"); -- September 05 2023 10 02 36
-- 월 : %M(September), %b(Sep), %m(9),
-- 연 : %Y(2023), %y(23)
-- 일 : %D(8th), %d(08), %e(8)
-- 요일 : %W(Tuesday), %d(Tue)
-- 시간 : %H(13), %h(1)
-- %r : hh:mm:ss AM,PM
-- 분 : %i
-- 초 : %S
```

### DAY(), DAYOFMONTH()
```sql
DAY(시분초다 있음YEAR, HOUR, MONTH, SECOND)
SELECT hiredate, DAY(hiredate) FROM emp;
SELECT hiredate, DAYOFMONTH(hiredate) FROM emp;
```

### DAYNAME()
날짜에서 요일 추출
```sql
SELECT hiredate, DAYNAME(hiredate) FROM emp;
SELECT hiredate, DAYOFWEEK(hiredate) FROM emp; -- 숫자로 바뀜
```
### EXTRACT
날짜 정보 추출 ()
```sql
SELECT CURDATE(), EXTRACT(MONTH FROM CURDATE()) AS MONTH; -- 9
SELECT CURDATE(), EXTRACT(YEAR FROM CURDATE()) AS YEAR; -- 2023
SELECT CURDATE(), EXTRACT(DAY FROM CURDATE()) AS DAY; -- 5
SELECT CURDATE(), EXTRACT(WEEK FROM CURDATE()) AS DAY;
SELECT CURDATE(), EXTRACT(QUARTER FROM CURDATE()) AS QUARTER;
SELECT CURDATE(), EXTRACT(HOUR FROM NOW()) AS HOUR;
SELECT CURDATE(), EXTRACT(MINUTE FROM NOW()) AS MINUTE;
SELECT CURDATE(), EXTRACT(SECOND FROM NOW()) AS SECOND;
```
### TIME_TO_SEC()
시간을 초로 변환
```sql
SELECT CURTIME(), TIME_TO_SEC(CURTIME());
SELECT CURTIME(), time_to_sec(TIMEDIFF(CURTIME(), '08:48:27'));
```

## 숫자 함수
### count()
조건에 만족하는 레코드(행) 수
```sql
SELECT COUNT(*) FROM emp;
SELECT COUNT(comm) FROM emp; -- 컬럼명이 매개변수로 사용시 null인 레코드는 제외
SELECT COUNT(*) FROM emp WHERE deptno=10; -- deptno가 10인 컬럼의 수
```
### sun ()
컬럼 전체의 총합
```sql
SELECT SUM(sal) FROM emp; -- emp 테이블의 sal의 총합
SELECT SUM(sal) FROM emp WHERE deptno=10; -- emp테이블에서 deptno가 10인 sal의 총합
```
### avg()
컬럼 전체의 평균
```sql
SELECT SUM(sal), SUM(sal)/COUNT(*), AVG(sal) FROM emp; // SUM(sal)/COUNT(*) 값과 AVG(SAL)값과 동일
SELECT SUM(comm), COUNT(comm), COUNT(*), SUM(comm)/COUNT(*), AVG(ifnull(comm, 0)) FROM emp;
```
### max()
```sql
SELECT MAX(sal) FROM emp;
SELECT ename, MAX(sal) FROM emp; -- ename 컬럼의 값과 MAX(sal)이 같은 행이 아니다 이유-찾는 중
```
### min()
```sql
SELECT MIN(sal) FROM emp; -- emp 테이블의 sal 컬럼의 최솟값을 가진 컬럼 
SELECT ename, MIN(sal) FROM emp; -- 오류
SELECT profno, NAME, pay, ifnull(bonus, 0), pay*12+IFNULL(bonus, 0) FROM professor; 
```
## GROUP BY, HAVING
GROUP BY 특정 컬럼을 그룹핑해 특정 그룹별로 출력, HAVING 그룹핑한 것에 대한 조건은 HAVING 절을 사용
```sql
SELECT deptno, job, COUNT(*), SUM(sal) FROM emp GROUP BY deptno, job; --  GROUP BY 선택된 컬럼이 셀렉트 컬럼에 올 수 있다. 
SELECT deptno, job, COUNT(*), SUM(sal) FROM emp GROUP BY deptno; -- job은 설렉트 컬럼에 써도 오류는 나지 않는다.

SELECT deptno1, COUNT(*) FROM student GROUP BY deptno1;
SELECT grade, format(avg(height),1) FROM student GROUP BY grade;

SELECT deptno, ename,  MAX(sal) FROM emp GROUP BY deptno; -- 잘못 된 데이터가 나옴
SELECT deptno no, MAX(sal) FROM emp GROUP BY no;

-- emp 테이블에서 평균 급여가 2000이상인 부서의 부서번호와 평균급여 조회
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno HAVING AVG(sal)>=2000;

-- student 테이블에서 각확과와 학년별 평균 몸구게, 최대/최소 몸무게를 조회하시오
SELECT deptno1, grade, COUNT(*), AVG(weight), MAX(weight), MIN(weight) 
FROM student 
GROUP BY deptno1, grade
HAVING AVG(weight) > 50
ORDER BY deptno1, grade;
```
## CASE
조건에 따라서 값을 지정
```sql

SELECT NAME, tel, 
		case SUBSTR(tel, 1, INSTR(tel, ')') - 1)
			when '02' then '서울'
			when '031' then '경기'
			when '051' then '부산'
			when '052' then '울산'
			when '055' then '경남'
		END 지역
FROM student
WHERE deptno1=101;
```
<br> 

## join
각 테이블의 곱해 조회해 데이터가 많아져 느려질 수 있다. 
```sql
-- ANSI join (표준)
SELECT e.empno, e.ename, d.dname
FROM emp e INNER JOIN dept d -- INNER 생략가능
ON e.DEPTNO=d.deptno
WHERE e.deptno=10;
```
### INNER, LEFT, RIGHT, UNION
- INNER 양쪽에 존재하는 테이블의 항목을 모두 가져온다
- LEFT 왼쪽에 있는 테이블의 항목을 모두 가져온다
- RIGHT 오른쪽에 있는 테이블의 항목을 모두 가져온다
- UNION 테이블을 합친다.
```sql
SELECT s.studno, s.name, p.name
FROM student s LEFT JOIN professor p -- 왼쪽에 있는 s테이블의 항목을  모두 가져온다.
ON s.profno = p.profno;
UNION -- left right 합친거
SELECT s.studno, s.name, p.name
FROM student s right JOIN professor p -- 왼쪽에 있는 s테이블의 항목을  모두 가져온다.
ON s.profno = p.profno;
```
```sql
-- student, exam_01 테이블을 이용하여 학번, 이름, 시험점수 조회
-- ANSI
SELECT s.studno, s.name, e.total
FROM student s JOIN exam_01 e
ON s.studno=e.studno;
-- 일반
SELECT s.studno, s.name, e.total
FROM student s , exam_01 e
WHERE s.studno=e.studno;
```
### 3개 이상의 테이블 join
SELECT s.studno, s.name, s.deptno1, p.name
FROM student s JOIN department d ON s.deptno1=d.deptno
left JOIN professor p ON s.profno=p.profno;

```
