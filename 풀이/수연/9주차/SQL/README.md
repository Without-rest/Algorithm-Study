### 007 주문량이 많은 아이스크림들 조회하기

```

SELECT S.FLAVOR
FROM FIRST_HALF S INNER JOIN (SELECT 
                                    A.FLAVOR
                                    ,SUM(B.TOTAL_ORDER + A.TOTAL_ORDER) AS TOTAL_ORDER
                                FROM FIRST_HALF A INNER JOIN JULY B
                                                ON A.FLAVOR = B.FLAVOR
                                GROUP BY B.FLAVOR
                                ORDER BY TOTAL_ORDER DESC LIMIT 3) S2
WHERE S.FLAVOR = S2.FLAVOR

```


### 008 5월 식품들의 총매출 조회하기

```



```


### 009 보호소에서 중성화한 동물

```


```
  
