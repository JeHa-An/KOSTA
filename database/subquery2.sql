-- SELECT colume_liSt < main query
-- FROM talbe
-- WHERE 조건연산자 (SELECT columee_list FROM TABLE WHERE 조건); < sub query
-- self join 비교 search

-- =, <>(!=), >, >=, <, <= : 단일행 서브쿼리 연산자
-- sub query 16 + 16
SELECT ename, comm
FROM emp
WHERE comm < (SELECT comm FROM emp WHERE ename='ward');

-- self join 16 * 16
SELECT e1.ename, e1.comm
FROM emp e1 JOIN emp e2 ON e1.COMM < e2.comm
WHERE e2.ename='ward';

SELECT e1.ename, e1.comm
FROM emp e1. emp e2
WHERE e2.ename='ward' AND e1.comm < e2.comm;

-- student, department 테이블을 이용하여 '서진수'학생과 주전공이 동일한 학생들의
-- 이름과 전공 조회
SELECT s.name, d.dname
FROM student s JOIN department d ON s.deptno1=d.deptno
WHERE deptno1 = (SELECT deptno1 FROM student WHERE NAME='서진수');

-- professor, department 테이블을 이용하여 박원범 교슈보다 나중에 입사한
-- 사람의 이름, 입사일, 학과명 조회
SELECT p.name, p.hiredate, d.dname
FROM professor p JOIN department d ON p.deptno=d.deptno
WHERE hiredate > (SELECT hiredate FROM professor WHERE NAME='박원범');

-- student 테이블에서 주전공이 201번인 학과의 평균 몸무게보다 몸무게가 많은
-- 학생들의 이름과 몸무게 조회
SELECT NAME, weight
FROM student
WHERE weight > (SELECT AVG(weight) FROM student WHERE deptno1=201)
ORDER BY 2 desc;

-- student 테이블에서 주전공이 '전자공학과'인 학과의 평균 몸무게보다 몸무게가 많은
-- 학생들의 이름과 몸무게 조회
SELECT NAME, weight
FROM student
WHERE weight > (SELECT AVG(s.weight) FROM student s JOIN department d WHERE d.dname='전자공학과')
ORDER BY 2 DESC;

-- gogak, gift 테이블을 이용하여 노트북을 받을 수 있는 고객의
-- 이름, 포인트, 상품명 조회
SELECT gNAME, POINT, '노트북' 상품명
FROM gogak
WHERE POINT >= (SELECT g_start FROM gift WHERE gname='노트북');

-- emp, dept 테이블을 이용하여 NEW YORK에서 근무하는 직원목록 조회
SELECT *
FROM emp 
WHERE deptno = (SELECT deptno FROM dept WHERE LOC='NEW YORK');

-- student, professor 테이블의 '박원범' 교수가 지도하는 학생 목록
SELECT *
FROM student
WHERE profno=(SELECT profno FROM professor WHERE NAME='박원범');

-- gogak, gift 테이블을 사용하여 '안광훈' 고객이 포인터로 받을 수 있는
-- 상품 목록 조회
SELECT gname
FROM gift 
WHERE g_start < (SELECT point FROM gogak WHERE gNAME='안광훈');

-- emp, dept 테이블을 사용하여 sales 부서를 제외한 나머지 부서에 속한 직원의
-- 사번, 이름, 부서명 조회
SELECT e.empno 사번, e.ename 이름, d.dname 부서명
FROM emp e JOIN dept d ON e.DEPTNO=d.DEPTNO -- USING(DEPTNO)
WHERE e.deptno != (SELECT deptno FROM dept WHERE DNAME='SALES');

-- student, exam_01, hakjum 테이블을 이용하여 학점이 B미만인 학생의
-- 학번, 이름, 점수 조회
SELECT s.studno, s.name, e.total
FROM student s JOIN exam_01 e USING(studno)
WHERE e.total < (SELECT min_point FROM hakjum WHERE grade='B0')
ORDER BY 3 DESC;

-- student, exam_01, hakjum 테이블을 이용하여 학점이 'A0'인 학생의
-- 학번, 이름, 점수 조회
SELECT s.studno, s.name, e.total
FROM student s JOIN exam_01 e USING(studno)
WHERE e.total BETWEEN 
		(SELECT min_point FROM hakjum WHERE grade='A0') AND
		(SELECT max_point FROM hakjum WHERE grade='A0');
		
		
-- 다중 서브쿼리 연산자
-- in, exists(존재), >any(가장 작은 것보다 큰 것any중 하나라도 크면), <any(가장 큰 것보다 작은거 any중 하나라도 작으면)
-- <all(가장 작은 것 보다 작은거), >all(가장 큰것 보다 큰 것)

-- emp2, dept2 테이블을 이용하여 '포항본사'에서 근무하는 직원들의
-- 사번, 이름, 부서명, 직급, 조회
SELECT e.EMPNO, e.NAME, e.`POSITION`, d.dname
FROM emp2 e JOIN dept2 d ON e.DEPTNO=d.DCODE
where dcode IN (SELECT dcode FROM dept2 WHERE AREA='포항본사');

-- emp2 테이블을 이용하여 '과장'직급의 최소연봉보다 연봉이 높은 직원의 
-- 사번,이름,직급, 연봉 조회
SELECT empno, NAME, POSITION, pay
FROM emp2
where pay >ANY (SELECT pay FROM emp2 WHERE POSITION='과장');

-- 각 학년별 키가 가장 큰 학생의 이름과 학년 조회
SELECT NAME, grade, height
FROM student
WHERE (grade, height) IN (SELECT grade, MAX(height) FROM student GROUP BY grade)
ORDER BY 2; -- group by 2 동일 값 나옴

-- student 테이블에서 2학년 학생들의 체중에서 가장 적게 나가는 학생보다 
-- 적은 학생의 이름, 학번, 학년 몸무게 조회
SELECT NAME, grade, weight
FROM student 
WHERE weight <all (select min(weight) FROM student where grade=2)
ORDER BY 3;

-- emp2 테이블에서 본인이 속한 부서의 평균 연봉보다 적게 받는 직원의 
-- 이름, 연봉, 부서명 조회
SELECT e1.name, e1.pay, d.dname
FROM emp2 e1 JOIN dept2 d ON e1.deptno = d.DCODE
WHERE e1.pay < (SELECT AVG(pay) FROM emp2 WHERE  deptno=e1.deptno);

-- emp2, dept2 테이블에서 각 부서별 평균 연봉을 구하고 그 중에서 평균 연봉이 가장
-- 적은 부서의 평균 연봉보다 많이받는 직원들의 직원명, 부서명, 연봉 조회
SELECT e1.NAME, d.DNAME, e1.PAY 
FROM emp2 e1 JOIN dept2 d ON e1.deptno = d.DCODE
WHERE pay >any
(SELECT AVG(pay) FROM emp2 GROUP BY deptno);

-- professor, department 테이블에서 각 학과별 입사일이 가장 오래된 교수의
-- 교수번호, 이름, 입사일,학과명 조회
SELECT p.profno, p.name, p.hiredate, d.dname
FROM professor p JOIN department d USING(deptno)
WHERE (deptno, hiredate) IN
(SELECT deptno ,MIN(hiredate) FROM professor GROUP BY deptno)
ORDER BY 3;

-- emp2 테이블에서 직급별 최대 연봉을 받는 직원의 이름과 직급, 연봉 조회
SELECT NAME, `POSITION`, pay
FROM emp2 
WHERE (`POSITION`, pay) IN (SELECT `POSITION`, MAX(pay) FROM emp2 GROUP BY `POSITION`);

-- student, exam_01, department 테이블에서 같은학과 같은 학년 학생의 평균 점수보다 점수가
-- 높은 학생의 학번, 이름, 학과,  점수학년, 점수 조회
SELECT s1.studno,  s1.name, d.dname, s1.grade, e1.total
FROM student s1 JOIN department d ON s1.deptno1=d.deptno
JOIN exam_01 e1 USING(studno)
WHERE e1.total >
(SELECT AVG(total) FROM student s2 join exam_01 e2 USING(studno) 
WHERE s2.deptno1=s1.deptno1 AND s2.grade=s1.grade)
ORDER BY s1.deptno1, s1.grade;

SELECT deptno1, grade, AVG(total)
FROM student s2 JOIN exam_01 e2 USING(studno)
GROUP BY deptno1, grade;

-- emp2 테이블에서 직원들 중 자신의 직급의 평균연봉과 같거나 많이 받는 사람들의
-- 이름, 직급, 연봉 조회 단, 직급이 없으면 좋회하지 않음
SELECT e1.name, e1.`POSITION`, e1.pay
FROM emp2 e1 
WHERE e1.PAY >=
(SELECT AVG(pay) FROM emp2 WHERE POSITION=e1.position GROUP BY POSITION);

-- student, professor 테이블에서 담당 학생이 있는 교수들의 교수번호 교수명 조회
SELECT DISTINCT s.profno ,p.name
FROM student s join professor p using(profno) WHERE s.profno IS NOT NULL;

SELECT profno, p.name
FROM(SELECT DISTINCT profno FROM student) e JOIN professor p USING(profno);

-- student, professor 테이블에서 담당 학생이 없는 교수들의 교수번호 교수명 조회
SELECT p1.profno, p1.name
FROM professor p1
WHERE not EXISTS(SELECT * FROM student WHERE profno=p1.profno);

-- emp, dept 테이블에서 직원이 한 명도 소속되지 않은 부서의 부서번호와 부서명 조회
INSERT INTO dept VALUES(50, 'MARKETING','HONGKONG');

SELECT deptno, DNAME
FROM dept d
WHERE NOT EXISTS(SELECT * FROM emp WHERE deptno=d.deptno);

-- limit 
SELECT *
FROM emp
ORDER BY sal DESC
LIMIT 0, 5; -- 예외적으로 첫번째(0) 부터 5개

SELECT *
FROM emp
ORDER BY sal DESC
LIMIT 5,5;

