-- 코드를 입력하세요
SELECT t2.ingredient_type, sum(t1.total_order) as total_order
from FIRST_HALF t1
join ICECREAM_INFO t2 on t1.flavor= t2.flavor
group by t2.ingredient_type
order by total_order;
