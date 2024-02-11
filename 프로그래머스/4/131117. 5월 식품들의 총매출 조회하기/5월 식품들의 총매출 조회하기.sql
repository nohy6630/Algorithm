with food_amount as (
    select product_id, sum(amount) as total_amount
    from food_order
    where year(produce_date)=2022 and month(produce_date)=5
    group by product_id
)
select a.PRODUCT_ID, a.PRODUCT_NAME, a.price*b.total_amount as TOTAL_SALES
from food_product a join food_amount b
on a.product_id = b.product_id
order by total_sales desc, a.product_id asc;