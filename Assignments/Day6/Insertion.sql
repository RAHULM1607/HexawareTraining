-- customers
insert into customers values
(1, 'Rahul', 'Sharma', 'Chennai', '2025-01-10'),
(2, 'Priya', 'Verma', 'Bangalore', '2025-02-15'),
(3, 'Amit', 'Kumar', 'Chennai', '2025-03-20'),
(4, 'Sneha', 'Gupta', 'Mumbai', '2025-04-05'),
(5, 'Rohit', 'Mehta', 'Bangalore', '2025-05-12'),
(6, 'Neha', 'Singh', 'Chennai', '2025-06-18');

-- products
insert into products values
(101, 'Laptop', 'Electronics', 55000),
(102, 'Mouse', 'Accessories', 500),
(103, 'Keyboard', 'Accessories', 1200),
(104, 'Monitor', 'Electronics', 12000),
(105, 'Printer', 'Electronics', 8500),
(106, 'Headphones', 'Accessories', 2000);

-- orders
insert into orders values
(1001, 1, '2026-01-01'),
(1002, 1, '2026-01-05'),
(1003, 1, '2026-01-10'),
(1004, 1, '2026-02-01'),
(1005, 2, '2026-02-05'),
(1006, 2, '2026-02-10'),
(1007, 3, '2026-02-15'),
(1008, 3, '2026-03-01'),
(1009, 4, '2026-03-05'),
(1010, 5, '2026-03-10');

-- order_items
insert into order_items values
(1, 1001, 101, 1, 55000),
(2, 1001, 102, 2, 500),
(3, 1002, 104, 1, 12000),
(4, 1003, 103, 2, 1200),
(5, 1004, 101, 1, 55000),
(6, 1005, 105, 1, 8500),
(7, 1006, 102, 3, 500),
(8, 1007, 104, 2, 12000),
(9, 1008, 106, 2, 2000),
(10, 1009, 101, 1, 55000),
(11, 1010, 103, 3, 1200);

-- payments
insert into payments values
(1, 1001, '2026-01-01', 56000, 'Paid'),
(2, 1002, '2026-01-05', 12000, 'Paid'),
(3, 1003, '2026-01-10', 2400, 'Paid'),
(4, 1005, '2026-02-05', 8500, 'Paid'),
(5, 1007, '2026-02-15', 24000, 'Paid'),
(6, 1008, '2026-03-01', 4000, 'Paid'),
(7, 1009, '2026-03-05', 55000, 'Paid');