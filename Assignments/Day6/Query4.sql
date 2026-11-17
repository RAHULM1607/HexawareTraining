select
    c.city,
    round(avg(order_total), 2) as average_basket_value
from customers c
inner join orders o
on c.customer_id = o.customer_id
inner join (
    select
        order_id,
        sum(quantity * unit_price) as order_total
    from order_items
    group by order_id
) t
on o.order_id = t.order_id
group by c.city;