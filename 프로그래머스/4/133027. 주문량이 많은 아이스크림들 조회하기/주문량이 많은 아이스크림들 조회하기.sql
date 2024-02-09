select b.flavor
from first_half a right join july b on a.shipment_id = b.shipment_id
group by b.flavor
order by sum(ifnull(a.total_order,0))+sum(b.total_order) desc
limit 3