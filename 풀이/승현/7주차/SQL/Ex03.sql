-- 코드를 입력하세요
SELECT CATEGORY, PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY,PRICE) IN (SELECT CATEGORY, MAX(PRICE)
                           FROM FOOD_PRODUCT
                           WHERE CATEGORY IN ('과자','국','김치','식용유')
                           GROUP BY CATEGORY
                          )
GROUP BY CATEGORY
ORDER BY PRICE DESC;

