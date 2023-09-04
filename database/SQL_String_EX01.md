```sql
SELECT INSTR(email, '@')+1 FROM professor; -- '@'앞의 index 출력
SELECT SUBSTR(email, INSTR(email, '@')+1) FROM professor; -- '@'앞의 index 부터 끝까지 출력 > abc.net
SELECT LENGTH(SUBSTR(email, INSTR(email, '@')+1)) FROM professor; -- abc.net의 길이 출력
SELECT email, insert(email, INSTR(email, '@')+1, LENGTH(SUBSTR(email, INSTR(email, '@')+1)), 'kosta.com') FROM professor;
-- insert(email 컬럼에서, '@'앞의 index 부터, '@'앞의 index 부터 끝까지의 문자들을, 'kosta.com'로 바꾼다.
```
