-- 코드를 입력하세요
SELECT t2.USER_ID, t2.NICKNAME, sum(t1.price) as TOTAL_SALES
from used_goods_user t2
join USED_GOODS_BOARD t1 on t1.writer_id = t2.user_id
where t1.status = "DONE"
group by t2.user_id
having sum(t1.price) >= 700000
order by total_sales;
    