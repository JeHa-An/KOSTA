# JDBC(Java Database Connectivity)
> JDBC는 Java 기반 애플리케이션에서 DB에 접근하기 위해 JDBC API를 사용하여 DB 연동하며, DB에서 데이터를 Query하거나 업데이트 방법을 제공하는 Java API 이다.

## JDBC 3가지 인터페이스
1. java.sql.Connection (연결)
2. java.sql.Statement (SQL을 담은 내용)
3. java.sql.ResultSet (SQL 요청 응)

## 동작 흐름
Java 애플리케이션 --> JDBC API --> JDBC 드라이버 --> Database

## JDBC 드라이버
> DB와의 통신을 담당하는 인터페이스 DBMS에 알맞은 JDBC 드라이버를 구현하여 제공

## 연결 방법
1. 내부적
2. 외부적
```txt
driver=mariadb.jdbc.MariaDriver
url=
user=
pass
sql
```
