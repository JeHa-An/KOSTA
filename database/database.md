# 데이터베이스 정의
&nbsp;**데이터의 집합**이며, 여러 명의 사용자와 응용프로그램이 공유하고 동시 접근이 가능해야 한다.<br>
``MariaDB에서는 **데이터의 저장공간** 자체를 의미하기도 한다.`
+ 데이터의 접근 권한이 엄격함 <br>


여러 명의 사용자가 데이터 추가, 삭제 할 때 데이터 *이상현상*이 발생할 수 있다. 이상현상 발생을 막기 위해 데이터를 하나로 관리하고 데이터를 가져다 쓰자는 개념이 **DBMS**이다.<br>

`Client가 DB Server에 다이렉트로 연결하지 않는다. Unix를 거쳐 DB 제공`

역할에 따른 구분
- Server는 Client의 request 받음
- Client(사용자, 응용프로그램)는 Server에 데이터를 request함.<br>
`데이터를 관리하는 곳 Server(많은 Client 접근을 위해 서버급 OS 사용), 데이터를 요청하는 사용자를 Client라고 한다.`


## DBMS (MariaDB ..)
&nbsp;데이터베이스를 관리/운영하는 역할을 하는 소프트웨어<br>
`Excel은 데이터를 대용량으로 관리하지 않고, 여러 명의 사용자가 공유 하지 않으므로 DBMS가 아니다.`

+ ~빅데이터의 경우 Nosql 정형화 되어 있지 않은 데이터를 분석하는 툴이 있어 사용가능.~
+ 일반 회사의 경우 DB를 정형화해 사용
+ ~데이터의 집합은 연관 있는 데이터를 모아서 Table로 만들고 모은 것~

### 특징
- 오류가 없는 무결성(DB안의 데이터는 어떤 경로를 통해 들어왔든 데이터에 오류가 없어야 함)
- 제약 조건을 통해 무결성 구현 (반드시 있어야 하는 데이터, 중복되지 않는 데이터)
- 데이터의 독립성 (DB와 응용 프로그램은 독립적인 관계, DB의 크기, 저장소 변경에도 기존 응용 프로그램은 전혀 영향을 받지 않아야 함)
- 보안 (접근 권한으로 데이터의 접근 관리)
- 데이터 중복의 최소화(DB에 통합 - 하나의 Table로 저장/관리)
- 응용 프로그램 제작 및 수정 ( SQL 문을 사용해 응용 프로그램으로 작성 가능하며, 유지보수가 쉽다)
- 데이터 안전성 향상 (DBMS가 자체적으로 제공하는 백업/복원 기능 이용해 데이터 손실 시 복원/복구)

### 단점
- 시스템 자원을 많이 차지해 시스템이 전반적으로 느려짐, 하드웨어 발전에 따라 빨라지고 있다

## RDBMS 관계형 데이터베이스
&nbsp;**Table**은 가장 기본적이고 중요한 구성요소이며, 테이블은 하나 이상의 열(column)과 행(row)로 이루어져 있다.&nbsp;**Primary key(기본키)**는 Table에서 특정 행만을 유일하게 구별할 수 있는 키이며, 유일한 값을 가지고 있어야한다.&nbsp;**Foreign Key(외래키)**는 한 Table의 column이 다른 Table의 기본키를 참조하는 경우 사용한다. 이러한 테이블간의 관계에서 외래 키를 이용한 테이블 간 join이 가능하다.<br><br>
<p align="center"><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fdthgnu%2Fbtsc1vzNtqf%2FcdntQvkYPIAjkxXij6wF7K%2Fimg.png" width="500" height="500"></p><br>

<details>
<summary> <span style="font-size:200%">HeidiSQL</span></summary>

<!--summary 아래 빈칸 공백 두고 내용을 적는공간-->
<br>하이디SQL은 여러 종류의 DBMS를 하나의 Tool로 관리하고 편집할 수 있으며, DBMS가 아닌 DB 관리 도구이다. (MariaDB, MySQL, Microsoft SQL, PostgreSQL, SQLite 등의 데이터베이스 시스템을 실행하는 컴퓨터에 접속해 데이터 구조를 보고 편집할 수 있다.

</details> 

## [SQL](https://github.com/JeHa-An/KOSTA/blob/main/database/SQL.md)
- DBMS 제작 회사와 독립적
- 다른 시스템으로 이식성이 좋다
- 표준이 계속 발전 중
- 대화식 언어 (명령어 실행 후 바로 데이터를 가져옴)
- 분산형 클라이언트/서버 구조 클라이언트에서 질의 후 서버에서 그 질의를 받아 처리하고 다시 클라이언트에게 전달하는 구조)
- 모든 DBMS의 SQL문이 완벽하게 동일하지 않음
