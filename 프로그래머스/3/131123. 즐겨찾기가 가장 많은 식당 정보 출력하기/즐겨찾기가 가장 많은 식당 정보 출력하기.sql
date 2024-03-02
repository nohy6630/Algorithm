with temp as (
    select food_type, max(favorites) as favorites
    from rest_info
    group by food_type
)
select t1.food_type, t1.rest_id, t1.rest_name, t1.favorites
from rest_info t1 join temp t2
on t1.food_type=t2.food_type and t1.favorites=t2.favorites
order by t1.food_type desc;