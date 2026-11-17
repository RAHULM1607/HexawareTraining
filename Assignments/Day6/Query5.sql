select
    o.order_id,
    o.customer_id,
    o.order_date
from orders o
left join payments p
on o.order_id = p.order_id
where p.payment_id is null;