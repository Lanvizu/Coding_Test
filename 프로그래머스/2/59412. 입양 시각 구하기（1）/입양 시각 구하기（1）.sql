-- 코드를 입력하세요
SELECT HOUR(DATETIME) as HOUR, count(*) as count
from ANIMAL_OUTS
group by HOUR
having hour>=9 AND hour<20
order by HOUR