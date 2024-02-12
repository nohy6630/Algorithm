select a.BOOK_ID, b.AUTHOR_NAME, date_format(a.PUBLISHED_DATE,'%Y-%m-%d') as PUBLISHED_DATE
from book a join author b
on a.author_id = b.author_id
where a.category = '경제'
order by published_date asc;