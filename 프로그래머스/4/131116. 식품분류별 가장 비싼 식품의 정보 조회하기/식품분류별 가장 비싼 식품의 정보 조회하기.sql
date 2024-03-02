with t as(
select category, max(price) as price
from food_product
where category in ('국','김치','과자','식용유')
group by category
)
select category, price, product_name
from food_product
where (category,price) in (select * from t)
order by price desc;