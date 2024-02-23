with join_user as (
    select distinct user_id
    from user_info
    where year(joined)=2021
)
select year(sales_date) as year, month(sales_date) as month, count(distinct user_id) as puchased_users,round(count(distinct user_id)/(select count(*) from join_user),1) as puchased_ratio
from online_sale
where user_id in (select user_id from join_user)
group by year, month
order by year asc, month asc