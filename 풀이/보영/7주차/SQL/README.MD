

## 001 즐겨찾기가 가장 많은 식당 정보 출력하기
```sql
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO
WHERE (FOOD_TYPE, FAVORITES) IN (SELECT FOOD_TYPE, MAX(FAVORITES)
                                 FROM REST_INFO
                                 GROUP BY FOOD_TYPE
                                )
GROUP BY FOOD_TYPE
ORDER BY FOOD_TYPE DESC
```


## 002 진료과별 총 예약 횟수 출력하기
```sql

```


## 003 식품분류별 가장 비싼 식품의 정보 조회하기
```sql
SELECT CATEGORY, PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE PRICE IN (SELECT MAX(PRICE)
                FROM FOOD_PRODUCT
                GROUP BY CATEGORY)
AND CATEGORY IN ('과자','국','김치','식용유')
ORDER BY PRICE DESC
```

