-- 코드를 입력하세요
SELECT animal_type, count (*) as count
from ANIMAL_INS
group by animal_type
order by animal_type;