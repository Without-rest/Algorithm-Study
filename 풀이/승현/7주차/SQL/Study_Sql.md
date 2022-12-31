# SQL 공부

## *프로그래머스 Group By

**진료과별 총 예약 횟수 출력하기**

**Oracle**

DATE 변환

```sql
BETWEEN TO_DATE('2022-05-01', 'YYYY-MM-DD') AND
TO_DATE('2022-05-31', 'YYYY-MM-DD')
```

**즐겨찾기가 가장 많은 식당 정보 출력하기**

*실행 결과가 여러개 나오는 서브쿼리

**다중행 연산자(IN, ANY, SOME, ALL, EXISTS)를 사용하여 값 비교**

IN : 하나라도 일치한 데이터가 있으면 TRUE

ANY, SOME : 만족하는 결과가 하나 이상이면 TRUE

ALL : 결과가 모두 만족하면 ALL

EXISTS : 결과가 존재하면 TRUE(행이 1개 이상이면 TRUE)

**다중열 서브쿼리**

*비교할 열이 여러개

서브쿼리의 SELECT절에 비교할 데이터를 여러 개 지정하는 방식(복수열 서브쿼리)
