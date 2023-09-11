# JDBC(Java Database Connectivity)
> JDBC는 Java 기반 애플리케이션에서 DB에 접근하기 위해 JDBC API를 사용하여 DB 연동하며, DB에서 데이터를 Query하거나 업데이트 방법을 제공하는 Java API 이다.

## JDBC 3가지 인터페이스
1. java.sql.Connection (연결)
```java
Connection conn = null;
conn = conn.getConnection();
Class.forName("org.mariadb.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testdb","root","1234");
``` 
2. java.sql.Statement, PreparedStatement(SQL을 담은 내용)
```java
String sql1 = String.format("update account set balance='%d' where id=%s",balance, id);
String sql2 = "update account set balance=? where id=?";

stmt = conn.createStatement(sql);

pstmt = conn.createStatement(sql);
pstmt.setInt(1, value);
pstmt.setString(2, value);
```  
3. java.sql.ResultSet (SQL 요청 응답)
```java
String sql = "Select * from account";
Statement stmt = null; ResultSet rs = null;
try{
  stmt = conn.createStatement(); rs = stmt.executeQuery(sql);
  if(rs!=null){
    while(rs.next()){
      String id = rs.getString(1);
      String name = rs.getString(2);
      Integer balance = rs.getInt(3);
      String grade = rs.getString(4);
    }
  }
} catch (Exception e){
  e.printStackTrace();
} finally {
  try{
    if(rs!=null) rs.close();
    if(stmt!=null) stmt.close();
} catch(Exception e){
    e.printStackTrace();
```
## 동작 흐름
Java 애플리케이션 --> JDBC API --> JDBC 드라이버 --> Database

## JDBC 드라이버
> DB와의 통신을 담당하는 인터페이스 DBMS에 알맞은 JDBC 드라이버를 구현하여 제공
<details>
<summary>쿼리 실행 메서드</summary>
<div markdown="1">

- executeUpdate
&nbsp;데이터를 Insert, Delete, Update하는 SQL문을 실행하며, 반환값으로 해당 SQL문 실행에 영향을 받는 행 수(int : row count)를 반환
```java
public int executeUpdate(String sql) throws SQLException;
```
- executeQuery
&nbsp;DB에서 데이터를 가져와 결과 집합을 반환하며, Select문에서만 실행한다.  
(ResultSet : object that contains the data produced by the given query)
```java
public ResultSet executeQuery(String sql) throws SQLException;
```
</div>
</details>

## 연결 방법
<details>
<summary>내부적</summary>
  
```java
Connection conn = null;
String sql = String.format("insert into user (id,name) values('%s','%s')", id, name);
Statement stmt = null;
try{
  Class.forName("org.mariadb.jdbc.Driver");
  conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testdb","root","1234");
  stmt = conn.createStatement();
  int cnt = stmt.executeUpdate(sql);
} catch(Exception e) {
  e.printStackTrade();
} finally {
  try{
    if(stmt != null) stmt.close();
  } catch(Exception e) {
    e.printStackTrace();
  }
}
close(conn);
```
</details>

<details>
<summary>외부적</summary>

- Properties
  > Map 계열 중 하나의 자료구조이며, Key, value값을 세트로 저장한다.
  > 외부설정파일을 읽어오거나 & 파일형태로 출력하고자 할 때 쓴다.
```properties
// driver.properties
driver=org.mariadb.jdbc.Driver
url=jdbc:mariadb://localhost:3306/testdb
user=root
password=1234
```
- code
```sql
public static Connection getConnection(){
  Connection conn = null;
  try {
    Properties db = new Properties();
    db.load(new FileInputStream("db.properties"));
    Class.forName(db.getProperty("driver"));
    conn=DriverManager.getConnection(db.getProperty("url"), db.getProperty("user"), db.getProperty("password"));
  }catch(Exception e) {
    e.printStackTrace();
  }
  return conn;
}
```
</details>
