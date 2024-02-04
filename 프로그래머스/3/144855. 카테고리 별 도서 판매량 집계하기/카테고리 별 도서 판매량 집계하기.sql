-- 코드를 입력하세요
SELECT t1.CATEGORY, SUM(t2.SALES) as TOTAL_SALES
from BOOK t1
join BOOK_SALES t2 on t2.book_Id = t1.book_id
where Year(SALES_DATE) = 2022 and MONTH(t2.SALES_DATE) = 1
group by CATEGORY
order by CATEGORY