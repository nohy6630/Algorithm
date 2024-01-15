select car_id, if(
    count(if(
        '2022-10-16' between date_format(start_date,'%Y-%m-%d') and date_format(end_date,'%Y-%m-%d'),
        1,
        null
    ))>0,
    '대여중',
    '대여 가능'
) as availability
from car_rental_company_rental_history
group by car_id
order by car_id desc