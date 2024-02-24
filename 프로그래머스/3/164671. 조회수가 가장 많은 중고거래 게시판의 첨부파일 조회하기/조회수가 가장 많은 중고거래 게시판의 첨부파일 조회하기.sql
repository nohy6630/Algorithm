with best_board as (
    select board_id
    from used_goods_board
    order by views desc
    limit 1
)
select concat('/home/grep/src/',board_id,'/',file_id,file_name,file_ext) as FILE_PATH
from used_goods_file
where board_id in (select board_id from best_board)
order by file_id desc;