with rest_score as (
    select rest_id,round(sum(review_score)/count(*),2) as score
    from rest_review
    group by rest_id
)
select a.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS, b.SCORE
from rest_info a join rest_score b
on a.rest_id = b.rest_id
where a.address like '서울%'
order by score desc, favorites desc