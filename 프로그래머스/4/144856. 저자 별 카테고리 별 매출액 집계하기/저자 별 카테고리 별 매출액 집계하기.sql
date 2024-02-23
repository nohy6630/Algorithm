with selected_books as (
    select a.book_id, a.author_id, a.category,sum(b.sales*a.price) as sales
    from book a join book_sales b
    on a.book_id = b.book_id
    where year(b.sales_date)=2022 and month(b.sales_date)=1
    group by a.author_id, a.category
)
select a.author_id as AUTHOR_ID, b.author_name as AUTHOR_NAME, a.category as CATEGORY, a.sales as TOTAL_SALES
from selected_books a join author b
on a.author_id=b.author_id
order by a.author_id asc, a.category desc