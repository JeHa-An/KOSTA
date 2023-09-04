# SQL 문법

## 자료형
```
int
VARCHAR(); --()에 30이 들어갔다면 30이상이 들어오면 오류
DATE -- 2023-09-04 -(하이푼)으로 구분하며 날짜끼리 비교가 가능 
## 데이터 조회
`SQL은 대소문자를 구분하지 않으며 데이터의 시작 index는 1이다`
- SELECT FROM 테이블의 데이터를 조회할 때 사용
```SQL
SELECT * FROM emp; -- *의 의미는 전체 컬럼을 의미, emp는 조회하고자 하는 테이블명
SELECT empno, ename FROM emp; -- 조회하고 싶은 컬럼
```
- WHERE 행에 대한 조건문
```SQL
SELECT * FROM emp WHERE deptno = 10; -- 같다는 = 하나만 사용
SELECT * FROM emp WHERE deptno > 10; -- emp 테이블에서 deptno가 10보다 큰 행들을 조회
SELECT * FROM Student where grade = 2 OR grade = 3; -- grade >= 2 AND grade <= 3;
SELECT * FROM emp WHERE deptno=10 AND sal>=2000; -- 두 개의 컬럼 조건 설정 가능
SELECT * FROM student WHERE (deptno1 = 101 OR deptno2 = 101) AND grade IN(1,2); 
```
- IN
```SQL
SELECT * FROM student WHERE grade IN(2,3);
SELECT empno, ename, job FROM emp WHERE job = 'CLERK' OR job = 'SALESMAN'; -- 문자형은 ''
```
- NOT
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
```
## join
```sql
SELECT gno, gname, point  FROM gogak WHERE POINT >= 600001 AND POINT <= 700000 // gift 테이블을 보고 SQL문 작성 불편함
```
