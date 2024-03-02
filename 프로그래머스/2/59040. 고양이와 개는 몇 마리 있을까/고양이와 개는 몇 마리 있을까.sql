select animal_type ANIMAL_TYPE, count(*) count
from animal_ins
group by animal_type
order by animal_type asc;