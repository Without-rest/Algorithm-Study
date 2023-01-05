## 8주차

### MySQL 과 Oracle
- Oracle의 TO_CHAR는 MySQL의 DATE_FORMAT과 대응된다.
- Oracle TO_CHAR 사용 예
```sql
select TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') from dual
```
결과 | `20201206153514` |


- MySQL DATE_FORMAT 사용 예
```sql
select DATE_FORMAT(now(), '%Y%m%d%H%i%s')
```
결과 |`20201206154329`|


