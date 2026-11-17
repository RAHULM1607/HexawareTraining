select
    date_format(o.order_date, '%Y-%m') as sales_month,
    sum(oi.quantity * oi.unit_price) as monthly_sales
from orders o
inner join order_items oi
on o.order_id = oi.order_id
group by date_format(o.order_date, '%Y-%m')
order by sales_month;