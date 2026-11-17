select
    p.product_id,
    p.product_name,
    sum(oi.quantity * oi.unit_price) as total_revenue
from products p
inner join order_items oi
on p.product_id = oi.product_id
group by p.product_id, p.product_name
order by total_revenue desc
limit 5;