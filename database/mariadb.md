# MariaDB

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
```
- IN
```SQL
SELECT * FROM student WHERE grade IN(2,3);
SELECT empno, ename, job FROM emp WHERE job = 'CLERK' OR job = 'SALESMAN'; -- 문자형은 ''
```
- NOT
```SQL
SELECT * FROM student WHERE NOT grade=4; -- student 테이블에서 grade=4 가 아닌 학생
SELECT * FROM student WHERE grade NOT IN(4);
```
- alias space 사용할 때 ""를 사용(alias에서만 ""사용)
```SQL
SELECT empno 사번, ename 이름, job 직무 FROM emp WHERE job = 'CLERK' OR job = 'SALESMAN'; -- empno AS 사번 에서 AS가 생략
SELECT empno 사번, ename "이 름", job 직무 FROM emp WHERE job = 'CLERK' OR job = 'SALESMAN';
```
-null 의 비교는 is를 사용
```SQL
SELECT * FROM professor WHERE hpage is null;
SELECT * FROM professor WHERE hpage is NOT null;
```
