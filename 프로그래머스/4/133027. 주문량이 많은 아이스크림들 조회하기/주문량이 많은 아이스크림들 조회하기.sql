-- 코드를 입력하세요
SELECT a.FLAVOR 
FROM FIRST_HALF a
JOIN JULY b ON a.FLAVOR = b.FLAVOR 
GROUP BY a.FLAVOR
ORDER BY (a.TOTAL_ORDER +SUM(b.TOTAL_ORDER)) DESC
LIMIT 3;
