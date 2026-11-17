select
    c.customer_id,
    concat(c.first_name, ' ', c.last_name) as customer_name,
    count(o.order_id) as total_orders
from customers c
inner join orders o
on c.customer_id = o.customer_id
group by c.customer_id, c.first_name, c.last_name
having count(o.order_id) > 3;