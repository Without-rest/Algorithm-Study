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
## 2) 그룹별 조건에 맞는 식당 목록 출력하기

```sql
SELECT A.MEMBER_NAME, B.REVIEW_TEXT, DATE_FORMAT(B.REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
FROM MEMBER_PROFILE A JOIN REST_REVIEW B
    ON A.MEMBER_ID = B.MEMBER_ID
WHERE (B.MEMBER_ID) IN (SELECT MEMBER_ID
                        FROM REST_REVIEW
                        GROUP BY MEMBER_ID 
                        HAVING COUNT(MEMBER_ID) = (SELECT MAX(MI)
                                                   FROM ( SELECT COUNT(MEMBER_ID) MI
                                                          FROM REST_REVIEW
                                                          GROUP BY MEMBER_ID 
                                                        ) A                
                                                  )
                       )
ORDER BY B.REVIEW_DATE
;
```

HAVING 절 사용→ 보통 ORACLE 문제를 이렇게 푸는듯

```sql
SELECT A.MEMBER_NAME, B.REVIEW_TEXT, DATE_FORMAT(B.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE A , REST_REVIEW B
WHERE A.MEMBER_ID = B.MEMBER_ID 
AND A.MEMBER_ID = (SELECT MEMBER_ID
                   FROM REST_REVIEW
                   GROUP BY MEMBER_ID
                   ORDER BY COUNT(MEMBER_ID) DESC
									 LIMIT 1)
ORDER BY B.REVIEW_DATE, B.REVIEW_TEXT
```

LIMIT ⇒ 테이블의 레코드를 조회할 때 결과 중 상위 x 개 만 표시한다.

TOP ⇒ MSSQL에서 사용


## 3)상품을 구매한 회원 비율 구하기

```sql
SELECT YEAR(B.SALES_DATE) AS YEAR
     , MONTH(B.SALES_DATE) AS MONTH 
     , COUNT(DISTINCT(B.USER_ID)) AS PUCHASED_USERS
		 --비율구하기
     , ROUND(COUNT(DISTINCT(B.USER_ID))/ ( SELECT COUNT(USER_ID) 
                                           FROM USER_INFO 
                                           WHERE YEAR(JOINED) = 2021) ,1) 
                                           AS PUCHASED_RATIO 
FROM USER_INFO A JOIN ONLINE_SALE B
ON A.USER_ID = B.USER_ID
WHERE YEAR(A.JOINED) = 2021
GROUP BY YEAR(B.SALES_DATE), MONTH(B.SALES_DATE)
ORDER BY YEAR, MONTH
;
```

**ROUND() : 반올림 사용 가능**

**ROUND(숫자, 반올림할 자릿수)**

**TRUNCATE(숫자, 버림할 자리수) : 특정 자리수 이하를 버리는 버림**

**DISTINCT() :중복된 값을 제외하고 목록을 보고싶은 경우 쓰는 함수**
