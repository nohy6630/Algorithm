select t2.user_id, t2.nickname, t1.total as total_sales
from (
    select writer_id, sum(price) as total
    from used_goods_board
    where status='done'
    group by writer_id
    having sum(price)>=700000
) as t1
join used_goods_user as t2
on t1.writer_id=t2.user_id
order by t1.total asc