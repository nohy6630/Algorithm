with temp as (
    select category, price, product_name
    from food_product
    group by category, price
    order by price desc
)
select category CATEGORY, price MAX_PRICE, product_name PRODUCT_NAME
from temp
group by category
having category in ('과자','국','김치','식용유')
order by price desc