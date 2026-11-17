use shoppingdb;
 -- select Item_Name,Customer_Name from Items inner join Orders on Items.Item_ID=orders.Item_ID;
 /*SELECT
    O.Order_ID,
    O.Customer_Name,
    I.Item_Name,
    I.Price
    FROM Items I
INNER JOIN Orders O
ON I.Item_ID = O.Item_ID;*/

-- select i.Item_Name, i.Item_ID, o.Customer_Name from Items i inner join Orders o on i.Item_ID=o.Item_ID; 
-- select o.Order_ID,o.Customer_Name,i.Item_Name from items i inner join Orders o where i.Item_ID=o.Item_ID;
 -- select * from Items i left join orders o on i.Item_ID=o.Item_ID;
 -- select o.*,i.Item_Name from items i left join orders o on i.Item_ID=o.Item_ID; 
 -- SELECT * FROM Items CROSS JOIN Orders;
 -- select i.item_name,i.category,o.customer_name,o.Quantity from items i inner join orders o on i.item_id=o.Item_ID;
 -- select i.item_name,o.order_id from items i left join orders o on i.Item_ID=o.item_id;
 -- select o.*,i.item_name,i.price from items i left join orders o on i.Item_ID=o.Item_ID;
 -- select i.*,o.Customer_Name from items i left join orders o on i.Item_ID=o.Item_ID;
 -- select distinct customer_name from items i inner join orders o on i.Item_ID=o.Item_ID;
 -- select i.item_name,o.customer_name,o.order_date from items i inner join orders o on i.Item_ID=o.Item_ID;
 -- select o.order_id,i.item_name,o.customer_name,i.price,o.quantity from items i inner join orders o on i.Item_ID=o.Item_ID;
 -- select i.*,o.* from items i left join orders o on i.item_id=o.item_id;
-- SELECT * FROM Orders OINNER JOIN Items I ON O.Item_ID = I.Item_ID;
