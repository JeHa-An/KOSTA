-- JOIN

-- 두 개 이상의 Table을 합쳐 출력
DROP TABLE test1;
CREATE TABLE test1(
A VARCHAR(10),
B VARCHAR(20));

DROP TABLE test2;
CREATE TABLE test2(
A VARCHAR(10),
B VARCHAR(20),
C VARCHAR(20));

INSERT INTO test1 VALUE('a1','b1');
INSERT INTO test1 VALUE('a2','b2');

INSERT INTO test2 VALUE('a3','b3', 'c3');
INSERT INTO test2 VALUE('a4','b4', 'c4');
INSERT INTO test2 VALUE('a5','b5', 'c5');

SELECT t1.*, t2.* -- 각 행은 둘의 곱한 만큼 생긴다
FROM test1 t1, test2 t2 
WHERE t1.A = 'a1';

SELECT e.empno, e.ename, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- ANSI join (표준)
SELECT e.empno, e.ename, d.dname
FROM emp e INNER JOIN dept d -- INNER 생략가능
ON e.DEPTNO=d.deptno
WHERE e.deptno=10;


-- student, department 테이블을 이용하여 학번, 학생명, 제1학과명 조회
SELECT s.studno, s.name, s.deptno1
FROM student s JOIN department d
ON s.deptno1=d.deptno;

SELECT s.studno, s.name, p.name
FROM student s LEFT JOIN professor p -- 왼쪽에 있는 s테이블의 항목을  모두 가져온다.
ON s.profno = p.profno;
UNION -- left right 합친거
SELECT s.studno, s.name, p.name
FROM student s right JOIN professor p -- 왼쪽에 있는 s테이블의 항목을  모두 가져온다.
ON s.profno = p.profno;


SELECT s.studno, s.name, s.deptno1, p.name
FROM student s JOIN department d ON s.deptno1=d.deptno
left JOIN professor p ON s.profno=p.profno;

-- student, exam_01 테이블을 이용하여 학번, 이름, 시험점수 조회
SELECT s.studno, s.name, e.total
FROM student s JOIN exam_01 e
ON s.studno=e.studno;

SELECT s.studno, s.name, e.total
FROM student s , exam_01 e
WHERE s.studno=e.studno ORDER BY 3 DESC;

SELECT s.studno, s.name, e.total, h.grade
FROM student s JOIN exam_01 e ON s.studno=e.studno
JOIN hakjum h ON e.total >= h.min_point AND e.total <= h.max_point ORDER BY 3 DESC;

SELECT g.*,  i.gname
FROM gogak g JOIN gift i
ON g.`point` BETWEEN i.g_start AND i.g_end
ORDER BY g.point DESC;


SELECT go.*, gi.gname
FROM gogak go, gift gi
WHERE go.point BETWEEN gi.g_start AND gi.g_end
ORDER BY go.point DESC;


-- emp2, p_grade 테이블을 이용하여 이름, 직위, 급여, 같은직급의 최소급여, 최대급여 조회
SELECT e.NAME, e.`POSITION`, e.PAY, p.s_pay, p.e_pay
FROM emp2 e, p_grade p 
WHERE e.`POSITION` = p.`position`;

SELECT e.NAME, e.`POSITION`, e.PAY, p.s_pay, p.e_pay
FROM emp2 e JOIN p_grade p
ON e.`POSITION` = p.`position`;

-- emp2, p_grade 테이블을 이용하여 이름, 직위, 나이, 본인의 나이에
-- 해당하는 예상 직급 조회
SELECT e.NAME, e.`POSITION`, (YEAR(NOW())-YEAR(e.BIRTHDAY)) 나이, p.position
FROM emp2 e JOIN p_grade p
ON (YEAR(NOW())-YEAR(e.BIRTHDAY)) BETWEEN p.s_age AND p.e_age
ORDER BY 3 DESC;

SELECT e.NAME, e.`POSITION`, (YEAR(NOW())-YEAR(e.BIRTHDAY)) 나이, p.position
FROM emp2 e , p_grade p
WHERE (YEAR(NOW())-YEAR(e.BIRTHDAY)) BETWEEN p.s_age AND p.e_age
ORDER BY 3 DESC;

-- 
SELECT go.gname, go.point, gi.gname
FROM gogak go JOIN gift gi ON go.point >= gi.g_start
WHERE gi.gname = '노트북' AND go.point >= gi.g_start;

SELECT go.gname, go.point, gi.gname
FROM gogak go, gift gi 
WHERE gi.gname = '노트북' AND go.point >= gi.g_start;

-- dept2 테이블을 이용하여 부서의 모든 정보와 각 부서의 상위 부서명을 조회 
SELECT d.*, pd.DNAME
FROM dept2 d left JOIN dept2 pd
ON d.PDEPT=pd.DCODE;

-- emp 테이블을 이용하여 직원의 사번, 이름, 담당 매니저 사번과 이름 조회
SELECT e1.EMPNO, e1.ENAME, e2.EMPNO, e2.ename
FROM emp e1 left JOIN emp e2
ON e1.EMPNO = e2.MGR;

-- student, department 테이블을 이용하여, 학번, 이름, 제1전공명, 제2전공명 조회
SELECT s.studno, s.name, d1.dname '제1 전공명', d2.dname '제2 전공명'
FROM student s JOIN department d1 ON s.deptno1 = d1.deptno
LEFT JOIN department d2 ON s.deptno2 = d2.deptno;

-- student, department 테이블을 이용하여 '컴퓨터정보학부'에 해당하는 학생의 학번, 이름, 학과번호
-- 학과명 조회
SELECT s.studno, s.name, s.deptno1, d1.dname, d2.dname
FROM student s JOIN department d1 ON s.deptno1 = d1.deptno
JOIN department d2 ON d1.part = d2.deptno
WHERE d2.dname = '컴퓨터정보학부';

-- student, department 테이블을 이용하여 '전자제어관'에서 수업을 듣는 학생 조회
SELECT s.studno, s.name, d1.dname, d2.dname,d1.build, d2.build
FROM student s JOIN department d1 ON s.deptno1 = d1.deptno
JOIN department d2 ON s.deptno2 = d2.deptno
WHERE d1.build='전자제어관' OR d2.build='전자제어관';

-- emp 테이블을 이용하여 사번, 이름, 입사일, 자신보다 입사일이 빠른 사람 인원수 조회
SELECT e1.EMPNO, e1.ename,e1.HIREDATE, COUNT(e2.HIREDATE)입사선배수
FROM emp e1 left JOIN emp e2 ON e1.HIREDATE > e2.HIREDATE
GROUP BY e1.empno, e1.ename
ORDER BY 1;

-- professor 테이블을 이용하여 교수번호, 교수이름, 입사일, 자신보다 먼저 입사한 사람 인원수 조회
SELECT p1.profno, p1.name, p1.hiredate, COUNT(p2.hiredate)
FROM professor p1 JOIN professor p2 ON p1.hiredate > p2.hiredate
GROUP BY p1.profnofdffsdfsdf
ORDER BY 4;

SELECT e.*, d.dname
FROM emp e JOIN dept USING(deptno); -- join하는 on의 컬럼명이 같으면 USING(컴럼명)사용


SELECT s.*, p.name
FROM student s left JOIN professor p ON s.profno=p.profno; -- 
