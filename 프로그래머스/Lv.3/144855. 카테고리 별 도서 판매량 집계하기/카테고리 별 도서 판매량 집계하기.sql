select category, sum(sales)
from book as t1
join (
    select *
    from book_sales
    where year(sales_date)=2022 and month(sales_date)=1
) as t2
on t1.book_id=t2.book_id
group by t1.category
order by category asc;
