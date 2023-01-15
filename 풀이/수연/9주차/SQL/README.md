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

SELECT 
    A.PRODUCT_ID
    , A.PRODUCT_NAME
   , SUM(B.AMOUNT) * A.PRICE AS TOTAL_SALES
FROM FOOD_PRODUCT A INNER JOIN FOOD_ORDER B 
                        ON A.PRODUCT_ID = B.PRODUCT_ID AND B.PRODUCE_DATE BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY A.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, A.PRODUCT_ID

```


### 009 보호소에서 중성화한 동물

```

SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_OUTS A INNER JOIN ANIMAL_INS B
                        ON A.ANIMAL_ID = B.ANIMAL_ID AND B.SEX_UPON_INTAKE LIKE 'Intact%'
WHERE A.SEX_UPON_OUTCOME LIKE 'Spayed%' OR  A.SEX_UPON_OUTCOME LIKE 'Neutered%'
ORDER BY A.ANIMAL_ID

```
  
