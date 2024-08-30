
select sum(SCORE) as SCORE, em.EMP_NO, EMP_NAME, POSITION, EMAIL
from HR_EMPLOYEES as em left join HR_GRADE as gr
on em.EMP_NO = gr.EMP_NO
where em.EMP_NO = 
(
select EMP_NO from HR_GRADE 
group by EMP_NO order by sum(SCORE) DESC limit 1
)
group by EMP_NO

# select EMP_NO, sum(SCORE) as sum_score from HR_GRADE 
# group by EMP_NO 
# order by sum_score DESC limit 1;
