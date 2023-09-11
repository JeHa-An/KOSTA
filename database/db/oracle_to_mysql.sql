drop table IF EXISTS emp;
CREATE TABLE EMP ( 
  EMPNO     int, 
  ENAME     VARCHAR(30), 
  JOB       VARCHAR(20), 
  MGR       int, 
  HIREDATE  DATE, 
  SAL       int,
  COMM      int, 
  DEPTNO    int) DEFAULT CHARSET=UTF8;

insert into emp values (7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
insert into emp values (7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
insert into emp values (7521,'WARD','SALESMAN',7698,'1982-02-22',1250,500,30);
insert into emp values (7566,'JONES','MANAGER',7839,'1981-04-02',2975,null,20);
insert into emp values (7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,1400,30);
insert into emp values (7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,null,30);
insert into emp values (7782,'CLARK','MANAGER',7839,'1981-06-09',2450,null,10);
insert into emp values (7788,'SCOTT','ANALYST',7566,'1987-04-17',3000,null,20);
insert into emp values (7839,'KING','PRESIDENT',null,'1981-11-17',5000,null,10);
insert into emp values (7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
insert into emp values (7876,'ADAMS','CLERK',7788,'1987-05-23',1100,null,20);
insert into emp values (7900,'JAMES','CLERK',7698,'1981-12-03',950,null,30);
insert into emp values (7902,'FORD','ANALYST',7566,'1981-12-03',3000,null,20);
insert into emp values (7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);

CREATE UNIQUE INDEX PK_EMP ON EMP (EMPNO) ;
ALTER TABLE EMP ADD  CONSTRAINT PK_EMP PRIMARY KEY (EMPNO);

drop table IF EXISTS DEPT;
CREATE TABLE DEPT (
  DEPTNO   int, 
  DNAME    VARCHAR(25), 
  LOC      VARCHAR(30))  DEFAULT CHARSET=utf8;

insert into dept values (10,'ACCOUNTING','NEW YORK');
insert into dept values (20,'RESEARCH','DALLAS');
insert into dept values (30,'SALES','CHICAGO');
insert into dept values (40,'OPERATIONS','BOSTON');

CREATE UNIQUE INDEX PK_DEPT ON DEPT (DEPTNO);
ALTER TABLE DEPT ADD  CONSTRAINT PK_DEPT PRIMARY KEY (DEPTNO);

ALTER TABLE EMP ADD CONSTRAINT FK_DEPTNO FOREIGN KEY (DEPTNO) REFERENCES DEPT (DEPTNO);


drop table IF EXISTS professor;
create table professor
(profno int primary key,
 name  varchar(20) not null, 
 id  varchar(15) not null,
 position varchar (30) not null,
 pay int not null,
 hiredate  date not null,
 bonus int ,
 deptno  int,
 email  varchar(50),
 hpage  varchar(50)) DEFAULT CHARSET=utf8;

insert into professor
values(1001,'조인형','captain','정교수',550,STR_TO_DATE('19800623','%Y%m%d'),100,101,'captain@abc.net','http://www.abc.net');

insert into professor
values(1002,'박승곤','sweety','조교수',380,STR_TO_DATE('19870130','%Y%m%d'),60,101,'sweety@abc.net','http://www.abc.net');

insert into professor
values (1003,'송도권','powerman','전임강사',270,STR_TO_DATE('19980322','%Y%m%d'),null,101,'pman@power.com','http://www.power.com');

insert into professor
values (2001,'양선희','lamb1','전임강사',250,STR_TO_DATE('20010901','%Y%m%d'),null,102,'lamb1@hamail.net',null);

insert into professor
values (2002,'김영조','number1','조교수',350,STR_TO_DATE('19851130','%Y%m%d'),80,102,'number1@naver.com','http://num1.naver.com');

insert into professor
values (2003,'주승재','bluedragon','정교수',490,STR_TO_DATE('19820429','%Y%m%d'),90,102,'bdragon@naver.com',null);

insert into professor
values (3001,'김도형','angel1004','정교수',530,STR_TO_DATE('19811023','%Y%m%d'),110,103,'angel1004@hanmir.com',null);

insert into professor
values (3002,'나한열','naone10','조교수',330,STR_TO_DATE('19970701','%Y%m%d'),50,103,'naone10@empal.com',null);

insert into professor
values (3003,'김현정','only-u','전임강사',290,STR_TO_DATE('20020224','%Y%m%d'),null,103,'only_u@abc.com',null);

insert into professor
values (4001,'심슨','simson','정교수',570,STR_TO_DATE('19811023','%Y%m%d'),130,201,'chebin@daum.net',null);

insert into professor
values (4002,'최슬기','gogogo','조교수',330,STR_TO_DATE('20090830','%Y%m%d'),null,201,'gogogo@def.com',null);

insert into professor
values (4003,'박원범','mypride','조교수',310,STR_TO_DATE('19991201','%Y%m%d'),50,202,'mypride@hanmail.net',null);

insert into professor
values (4004,'차범철','ironman','전임강사',260,STR_TO_DATE('20090128','%Y%m%d'),null,202,'ironman@naver.com',null);

insert into professor
values (4005,'바비','standkang','정교수',500,STR_TO_DATE('19850918','%Y%m%d'),80,203,'standkang@naver.com',null);

insert into professor 
values (4006,'전민','napeople','전임강사',220,STR_TO_DATE('20100628','%Y%m%d'),null,301,'napeople@jass.com',null);

insert into professor
values (4007,'허은','silver-her','조교수',290,STR_TO_DATE('20010523','%Y%m%d'),30,301,'silver-her@daum.net',null);

commit;
drop table IF EXISTS department;
create table department
( deptno int primary key ,
  dname varchar(30) not null,
  part int,
  build  varchar(24)) DEFAULT CHARSET=UTF8;

insert into department 
values (101,'컴퓨터공학과',100,'정보관');

insert into department
values (102,'멀티미디어공학과',100,'멀티미디어관');

insert into department
values (103,'소프트웨어공학과',100,'소프트웨어관');

insert into department
values (201,'전자공학과',200,'전자제어관');

insert into department
values (202,'기계공학과',200,'기계실험관');

insert into department
values (203,'화학공학과',200,'화학실습관');

insert into department
values (301,'문헌정보학과',300,'인문관');

insert into department
values (100,'컴퓨터정보학부',10,null);

insert into department
values (200,'메카트로닉스학부',10,null);

insert into department
values (300,'인문사회학부',20,null);

insert into department
values (10,'공과대학',null,null);

insert into department
values (20,'인문대학',null,null);

commit;
 
drop table IF EXISTS student;
create table student
( studno int primary key,
  name   varchar(20) not null,
  id varchar(30) not null unique,
  grade int check(grade between 1 and 6),
  jumin char(13) not null,
  birthday  date,
  tel varchar(25),
  height  int,
  weight  int,
  deptno1 int,
  deptno2 int,
  profno  int) DEFAULT CHARSET=utf8;

insert into student values (
9411,'서진수','75true',4,'7510231901810',STR_TO_DATE('19751023','%Y%m%d'),'055)381-2158',180,72,101,201,1001);

insert into student values (
9412,'서재수','pooh94',4,'7502241128467',STR_TO_DATE('19750224','%Y%m%d'),'051)426-1700',172,64,102,null,2001);

insert into student values (
9413,'이미경','angel000',4,'7506152123648',STR_TO_DATE('19750615','%Y%m%d'),'053)266-8947',168,52,103,203,3002);

insert into student values (
9414,'김재수','gunmandu',4,'7512251063421',STR_TO_DATE('19751225','%Y%m%d'),'02)6255-9875',177,83,201,null,4001);

insert into student values (
9415,'박동호','pincle1',4,'7503031639826',STR_TO_DATE('19750303','%Y%m%d'),'031)740-6388',182,70,202,null,4003);

insert into student values (
9511,'김신영','bingo',3,'7601232186327',STR_TO_DATE('19760123','%Y%m%d'),'055)333-6328',164,48,101,null,1002);

insert into student values (
9512,'신은경','jjang1',3,'7604122298371',STR_TO_DATE('19760412','%Y%m%d'),'051)418-9627',161,42,102,201,2002);

insert into student values (
9513,'오나라','nara5',3,'7609112118379',STR_TO_DATE('19760911','%Y%m%d'),'051)724-9618',177,55,202,null,4003);

insert into student values (
9514,'구유미','guyume',3,'7601202378641',STR_TO_DATE('19760120','%Y%m%d'),'055)296-3784',160,58,301,101,4007);

insert into student values (
9515,'임세현','shyun1',3,'7610122196482',STR_TO_DATE('19761012','%Y%m%d'),'02)312-9838',171,54,201,null,4001);

insert into student values (
9611,'일지매','onejimae',2,'7711291186223',STR_TO_DATE('19771129','%Y%m%d'),'02)6788-4861',182,72,101,null,1002);

insert into student values (
9612,'김진욱','samjang7',2,'7704021358674',STR_TO_DATE('19770402','%Y%m%d'),'055)488-2998',171,70,102,null,2001);

insert into student values (
9613,'안광훈','nonnon1',2,'7709131276431',STR_TO_DATE('19770913','%Y%m%d'),'053)736-4981',175,82,201,null,4002);

insert into student values (
9614,'김문호','munho',2,'7702261196365',STR_TO_DATE('19770226','%Y%m%d'),'02)6175-3945',166,51,201,null,4003);

insert into student values (
9615,'노정호','star123',2,'7712141254963',STR_TO_DATE('19771214','%Y%m%d'),'051)785-6984',184,62,301,null,4007);

insert into student values (
9711,'이윤나','prettygirl',1,'7808192157498',STR_TO_DATE('19780819','%Y%m%d'),'055)278-3649',162,48,101,null,null);

insert into student values (
9712,'안은수','silverwt',1,'7801051776346',STR_TO_DATE('19780105','%Y%m%d'),'02)381-5440',175,63,201,null,null);

insert into student values (
9713,'인영민','youngmin',1,'7808091786954',STR_TO_DATE('19780809','%Y%m%d'),'031)345-5677',173,69,201,null,null);

insert into student values (
9714,'김주현','kimjh',1,'7803241981987',STR_TO_DATE('19780324','%Y%m%d'),'055)423-9870',179,81,102,null,null);

insert into student values (
9715,'허우','wooya2702',1,'7802232116780',STR_TO_DATE('19780223','%Y%m%d'),'02)6122-2345',163,51,103,null,null);

ALTER TABLE student ADD CONSTRAINT FK_PROFNO FOREIGN KEY (PROFNO) REFERENCES professor (PROFNO);
commit;
drop table IF EXISTS EMP2;
CREATE TABLE EMP2 (
 EMPNO       int  PRIMARY KEY,
 NAME        VARCHAR(20) NOT NULL,
 BIRTHDAY    DATE,
 DEPTNO      VARCHAR(16) NOT NULL,
 EMP_TYPE    VARCHAR(18),
 TEL         VARCHAR(25),
 HOBBY       VARCHAR(40),
 PAY         int,
 POSITION    VARCHAR(18),
 PEMPNO      int
) DEFAULT CHARSET=utf8;

INSERT INTO EMP2 VALUES (19900101,'나사장',STR_TO_DATE('19640125','%Y%m%d'),'0001','정규직','054)223-0001','음악감상',100000000,'대표이사',null);
INSERT INTO EMP2 VALUES (19960101,'전부장',STR_TO_DATE('19730322','%Y%m%d'),'1000','정규직','02)6255-8000','독서',72000000,'부장',19900101);
INSERT INTO EMP2 VALUES (19970201,'최일도',STR_TO_DATE('19750415','%Y%m%d'),'1000','정규직','02)6255-8005','운동',50000000,'과장',19960101);
INSERT INTO EMP2 VALUES (19930331,'백원만',STR_TO_DATE('19760525','%Y%m%d'),'1001','정규직','02)6255-8010','자전거타기',60000000,'차장',19960101);
INSERT INTO EMP2 VALUES (19950303,'천만득',STR_TO_DATE('19730615','%Y%m%d'),'1002','정규직','02)6255-8020','마라톤',56000000,'과장',19960101);
INSERT INTO EMP2 VALUES (19966102,'일지매',STR_TO_DATE('19720705','%Y%m%d'),'1003','정규직','052)223-4000','음악감상',75000000,'부장',19900101);
INSERT INTO EMP2 VALUES (19930402,'유관순',STR_TO_DATE('19720815','%Y%m%d'),'1004','정규직','042)998-7005','등산',51000000,'과장',19966102);
INSERT INTO EMP2 VALUES (19960303,'김문호',STR_TO_DATE('19710925','%Y%m%d'),'1005','정규직','031)564-3340','등산',35000000,'대리',19966102);
INSERT INTO EMP2 VALUES (19970112,'노정호',STR_TO_DATE('19761105','%Y%m%d'),'1006','정규직','054)223-4500','수영',68000000,'부장',19900101);
INSERT INTO EMP2 VALUES (19960212,'이윤나',STR_TO_DATE('19721215','%Y%m%d'),'1007','정규직','054)223-4600',null,49000000,'과장',19970112);
INSERT INTO EMP2 VALUES (20000101,'이태백',STR_TO_DATE('19850125','%Y%m%d'),'1008','계약직','051)123-4567','등산', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000102,'김설악',STR_TO_DATE('19830322','%Y%m%d'),'1009','계약직','031)234-5678','낚시', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000203,'최오대',STR_TO_DATE('19820415','%Y%m%d'),'1010','계약직','02)2345-6789','바둑', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000334,'박지리',STR_TO_DATE('19810525','%Y%m%d'),'1011','계약직','053)456-7890','노래', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000305,'정북악',STR_TO_DATE('19800615','%Y%m%d'),'1008','수습직','051)567-8901','독서', 22000000,'',19960212);
INSERT INTO EMP2 VALUES (20006106,'유도봉',STR_TO_DATE('19800705','%Y%m%d'),'1009','수습직','031)678-9012','술',   22000000,'',19960212);
INSERT INTO EMP2 VALUES (20000407,'윤주왕',STR_TO_DATE('19800815','%Y%m%d'),'1010','수습직','02)2789-0123','오락', 22000000,'',19960212);
INSERT INTO EMP2 VALUES (20000308,'강월악',STR_TO_DATE('19800925','%Y%m%d'),'1011','인턴직','053)890-1234','골프', 20000000,'',19960212);
INSERT INTO EMP2 VALUES (20000119,'장금강',STR_TO_DATE('19801105','%Y%m%d'),'1004','인턴직','042)901-2345','술',   20000000,'',19930402);
INSERT INTO EMP2 VALUES (20000210,'나한라',STR_TO_DATE('19801215','%Y%m%d'),'1005','인턴직','031)345-3456','독서', 20000000,'',19960303);
COMMIT;

drop table IF EXISTS DEPT2;
CREATE TABLE DEPT2 (
 DCODE   VARCHAR(16)  PRIMARY KEY,
 DNAME   VARCHAR(30) NOT NULL,
 PDEPT VARCHAR(16) ,
 AREA  VARCHAR(26)
) DEFAULT CHARSET=utf8;

INSERT INTO DEPT2 VALUES ('0001','사장실','','포항본사');
INSERT INTO DEPT2 VALUES ('1000','경영지원부','0001','서울지사');
INSERT INTO DEPT2 VALUES ('1001','재무관리팀','1000','서울지사');
INSERT INTO DEPT2 VALUES ('1002','총무팀','1000','서울지사');
INSERT INTO DEPT2 VALUES ('1003','기술부','0001','포항본사');
INSERT INTO DEPT2 VALUES ('1004','H/W지원','1003','대전지사');
INSERT INTO DEPT2 VALUES ('1005','S/W지원','1003','경기지사');
INSERT INTO DEPT2 VALUES ('1006','영업부','0001','포항본사');
INSERT INTO DEPT2 VALUES ('1007','영업기획팀','1006','포항본사');
INSERT INTO DEPT2 VALUES ('1008','영업1팀','1007','부산지사');
INSERT INTO DEPT2 VALUES ('1009','영업2팀','1007','경기지사');
INSERT INTO DEPT2 VALUES ('1010','영업3팀','1007','서울지사');
INSERT INTO DEPT2 VALUES ('1011','영업4팀','1007','울산지사');

commit;
drop table IF EXISTS gift;
create table gift
( gno  int ,
  gname varchar(25) ,
  g_start  int ,
  g_end  int ) DEFAULT CHARSET=utf8;

insert into gift values(1,'참치세트',1,100000);
insert into gift values(2,'샴푸세트',100001,200000);
insert into gift values(3,'세차용품세트',200001,300000);
insert into gift values(4,'주방용품세트',300001,400000);
insert into gift values(5,'산악용자전거',400001,500000);
insert into gift values(6,'LCD모니터',500001,600000);
insert into gift values(7,'노트북',600001,700000);
insert into gift values(8,'벽걸이TV',700001,800000);
insert into gift values(9,'드럼세탁기',800001,900000);
insert into gift values(10,'양쪽문냉장고',900001,1000000);
commit ;

drop table IF EXISTS gogak;
create table gogak
(gno  int,
 gname varchar(22) ,
 jumin char(13) ,
 point int) DEFAULT CHARSET=utf8;

insert into gogak values (20010001,'서진수','7510231369824',980000);
insert into gogak values (20010002,'서재수','7502241128467',73000);
insert into gogak values (20010003,'이미경','7506152123648',320000);
insert into gogak values (20010004,'김재수','7512251063421',65000);
insert into gogak values (20010005,'박동호','7503031639826',180000);
insert into gogak values (20010006,'김신영','7601232186327',153000);
insert into gogak values (20010007,'신은경','7604212298371',273000);
insert into gogak values (20010008,'오나라','7609112118379',315000);
insert into gogak values (20010009,'김설희','7601202378641',542000);
insert into gogak values (20010010,'임세현','7610122196482',265000);
insert into gogak values (20010011,'최순규','7711291186223',110000);
insert into gogak values (20010012,'정현영','7704021358674',99000);
insert into gogak values (20010013,'안광훈','7709131276431',470000);
insert into gogak values (20010014,'모병환','7702261196365',298000);
insert into gogak values (20010015,'노정호','7712141254963',420000);
insert into gogak values (20010016,'이윤나','7808192157498',598000);
insert into gogak values (20010017,'안은수','7801051776346',625000);
insert into gogak values (20010018,'인영민','7808091786954',670000);
insert into gogak values (20010019,'김지영','7803242114563',770000);
insert into gogak values (20010020,'허우','7802232116780',730000);
commit ;

drop table IF EXISTS hakjum;
create table hakjum
(grade char(4) ,
 min_point  int ,
 max_point  int ) DEFAULT CHARSET=utf8;

insert into hakjum values ('A+',96,100);
insert into hakjum values ('A0',90,95);
insert into hakjum values ('B+',86,89);
insert into hakjum values ('B0',80,85);
insert into hakjum values ('C+',76,79);
insert into hakjum values ('C0',70,75);
insert into hakjum values ('D',0,69);

commit;

drop table IF EXISTS exam_01;
create table exam_01
(studno  int,
 total int);

insert into exam_01 values (9411,97);
insert into exam_01 values (9412,78);
insert into exam_01 values (9413,83);
insert into exam_01 values (9414,62);
insert into exam_01 values (9415,88);
insert into exam_01 values (9511,92);
insert into exam_01 values (9512,87);
insert into exam_01 values (9513,81);
insert into exam_01 values (9514,79);
insert into exam_01 values (9515,95);
insert into exam_01 values (9611,89);
insert into exam_01 values (9612,77);
insert into exam_01 values (9613,86);
insert into exam_01 values (9614,82);
insert into exam_01 values (9615,87);
insert into exam_01 values (9711,91);
insert into exam_01 values (9712,88);
insert into exam_01 values (9713,82);
insert into exam_01 values (9714,83);
insert into exam_01 values (9715,84);

commit ;

drop table IF EXISTS p_grade;
create table p_grade
( position  varchar(20) ,
  s_age int,
  e_age int,
  s_year int,
  e_year int,
  s_pay  int,
  e_pay  int) DEFAULT CHARSET=utf8;

insert into p_grade values ('주임',0,24,1,2,12000000,29990000);
insert into p_grade values ('대리',25,28,3,5,30000000,45000000);
insert into p_grade values ('과장',29,32,6,8,45010000,51000000);
insert into p_grade values ('차장',33,36,9,10,51010000,60000000);
insert into p_grade values ('부장',37,40,11,13,60010000,75000000);
insert into p_grade values ('이사',41,55,14,99,75010000,100000000);

commit ;