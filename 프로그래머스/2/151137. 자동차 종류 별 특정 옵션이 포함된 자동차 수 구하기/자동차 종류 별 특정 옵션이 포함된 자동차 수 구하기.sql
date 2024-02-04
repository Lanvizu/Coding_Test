-- 코드를 입력하세요
SELECT CAR_TYPE, count(*) as CARS
from CAR_RENTAL_COMPANY_CAR
where options like '%시트%'
group by car_type
order by car_type;