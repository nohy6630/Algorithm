with
available_cars as (
    select car_id
    from car_rental_company_car
    where car_id not in (
        select car_id
        from car_rental_company_rental_history
        where start_date <= '2022-11-30 23:59:59' and end_date >= '2022-11-01 00:00:00'
    )
),
fees as (
    select a.car_id, a.car_type, cast(a.daily_fee * 30 * ((100-b.discount_rate)/100) as signed) as fee
    from car_rental_company_car a join car_rental_company_discount_plan b
    on a.car_type = b.car_type
    where b.duration_type = '30일 이상' and a.car_type in ('세단','SUV')
)
select a.car_id, a.car_type, a.fee
from fees a join available_cars b
on a.car_id = b.car_id
where a.fee between 500000 and 2000000
order by a.fee desc, a.car_type asc, a.car_id desc