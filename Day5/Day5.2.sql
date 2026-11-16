use hexassignment;
CREATE TABLE if not exists Items (

    Item_ID INT PRIMARY KEY,

    Item_Name VARCHAR(50) NOT NULL,

    Category VARCHAR(30),

    Price DECIMAL(10,2),

    Quantity INT,

    Supplier_Name VARCHAR(50),

    Purchase_Date DATE,

    Status VARCHAR(20)

);
/*INSERT INTO Items VALUES
(1, 'Laptop', 'Electronics', 55000, 10, 'ABC Traders', '2026-01-10', 'Available'),
(2, 'Mouse', 'Accessories', 500, 50, 'XYZ Suppliers', '2026-01-12', 'Available'),
(3, 'Keyboard', 'Accessories', 1200, 30, 'ABC Traders', '2026-01-15', 'Unavailable'),
(4, 'Printer', 'Electronics', 15000, 5, 'Tech World', '2026-01-18', 'Available'),
(5, 'Chair', 'Furniture', 2500, 20, 'Office Mart', '2026-01-20', 'Out of Stock'),
(6, 'Table', 'Furniture', 4500, 15, 'Home Decor', '2026-02-01', 'Available'),
(7, 'Monitor', 'Electronics', 12000, 12, 'Tech World', '2026-02-05', 'Unavailable'),
(8, 'Headphones', 'Accessories', 1800, 25, 'Sound Hub', '2026-02-08', 'Pending'),
(9, 'Mobile', 'Electronics', 25000, 8, 'ABC Traders', '2026-02-10', 'Available'),
(10, 'USB Cable', 'Accessories', 250, 100, 'XYZ Suppliers', '2026-02-12', 'Out of Stock'),
(11, 'Notebook', 'Stationery', 80, 200, 'Paper House', '2026-02-15', 'Available'),
(12, 'Pen', 'Stationery', 20, 500, 'Paper House', '2026-02-18', 'Unavailable'),
(13, 'Scanner', 'Electronics', 8500, 6, 'Tech World', '2026-03-01', 'Available'),
(14, 'Bookshelf', 'Furniture', 6000, 4, 'Office Mart', '2026-03-05', 'Discontinued'),
(15, 'Webcam', 'Accessories', 2200, 18, 'Sound Hub', '2026-03-08', 'Available'),
(16, 'Tablet', 'Electronics', 30000, 7, 'ABC Traders', '2026-03-10', 'Pending'),
(17, 'Office Desk', 'Furniture', 7500, 9, 'Home Decor', '2026-03-12', 'Available'),
(18, 'Marker', 'Stationery', 50, 150, 'Paper House', '2026-03-15', 'Out of Stock'),
(19, 'Speaker', 'Accessories', 3500, 14, 'Sound Hub', '2026-03-18', 'Discontinued'),
(20, 'Projector', 'Electronics', 40000, 3, 'Tech World', '2026-03-20', 'Available');*/

-- task 1 
-- select Item_Name,Category from  items;

-- task 2
-- select * from items;

-- task 3
-- select Item_name,Category,sum(Price) as totalamount from items;

-- task 4
-- select * from items where Supplier_Name='ABC';

-- task 5
/*select min(price) from items;
select count(price) from items;
select max(price) from items;*/

-- task 6
select count(*) AS items_out_of_stock
from Items where status = 'Out of Stock'

-- select * from candidates where address = "%pune%";
 