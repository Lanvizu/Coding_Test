-- 코드를 입력하세요
SELECT t1.FOOD_TYPE, t1.REST_ID, t1.REST_NAME, t1.FAVORITES
from REST_INFO t1
join (select food_type, max(favorites) as favorites
     from rest_info group by food_type)
     t2 on t1.food_type = t2.food_type and t1.favorites = t2.favorites
order by t1.food_type desc;