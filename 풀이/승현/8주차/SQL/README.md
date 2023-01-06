## 1) 조건에 맞는 도서와 저자 리스트 출력하기

```sql
SELECT A.BOOK_ID, B.AUTHOR_NAME, DATE_FORMAT(A.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE 
FROM BOOK AS A JOIN AUTHOR AS B
    ON A.AUTHOR_ID = B.AUTHOR_ID
    WHERE A.CATEGORY = '경제'
    ORDER BY A.PUBLISHED_DATE
    ;
```

***DateFormat을 해줘야한다** 

- MySQL 방식

```sql
DATE_FORMAT(A.PUBLISHED_DATE, '%Y-%m-%d')
```

- Oracle 방식

```sql
TO_CHAR(A.PUBLISHED_DATE, 'yyyy-mm-dd')
```
