-- CREATE DATABASE if not exists ShoppingDB;
 
USE ShoppingDB;
 
/*CREATE TABLE if not exists Items (
    Item_ID INT PRIMARY KEY,
    Item_Name VARCHAR(50),
    Category VARCHAR(30),
    Price DECIMAL(10,2),
    Stock INT
);

CREATE TABLE if not exists Orders (
    Order_ID INT PRIMARY KEY,
    Customer_Name VARCHAR(50),
    Item_ID INT,
    Quantity INT,
    Order_Date DATE,
    Order_Status VARCHAR(20),
    FOREIGN KEY (Item_ID) REFERENCES Items(Item_ID)
);*/

/*INSERT INTO Items VALUES

(1, 'Laptop', 'Electronics', 55000, 20),

(2, 'Mouse', 'Accessories', 500, 100),

(3, 'Keyboard', 'Accessories', 1200, 50),

(4, 'Monitor', 'Electronics', 12000, 15),

(5, 'Printer', 'Electronics', 8500, 10),

(6, 'Headphones', 'Accessories', 2000, 40),

(7, 'Mobile', 'Electronics', 25000, 25),

(8, 'Tablet', 'Electronics', 18000, 12),

(9, 'Webcam', 'Accessories', 1500, 0),

(10, 'Speaker', 'Accessories', 3000, 30);
 
INSERT INTO Orders VALUES

(101, 'Rahul', 1, 1, '2026-01-01', 'Delivered'),

(102, 'Priya', 2, 2, '2026-01-02', 'Delivered'),

(103, 'Amit', 1, 1, '2026-01-03', 'Pending'),

(104, 'Neha', 3, 1, '2026-01-04', 'Delivered'),

(105, 'Karan', 4, 2, '2026-01-05', 'Shipped'),

(106, 'Simran', 2, 3, '2026-01-06', 'Delivered'),

(107, 'Rohit', 6, 1, '2026-01-07', 'Pending'),

(108, 'Anjali', 7, 1, '2026-01-08', 'Delivered'),

(109, 'Vikas', 1, 2, '2026-01-09', 'Shipped'),

(110, 'Pooja', 5, 1, '2026-01-10', 'Delivered'),
 
(111, 'Arjun', 3, 2, '2026-01-11', 'Pending'),

(112, 'Meena', 4, 1, '2026-01-12', 'Delivered'),

(113, 'Ravi', 2, 1, '2026-01-13', 'Shipped'),

(114, 'Sneha', 7, 2, '2026-01-14', 'Delivered'),

(115, 'Mohit', 6, 2, '2026-01-15', 'Pending'),

(116, 'Kavita', 1, 1, '2026-01-16', 'Delivered'),

(117, 'Deepak', 5, 2, '2026-01-17', 'Shipped'),

(118, 'Nisha', 3, 1, '2026-01-18', 'Delivered'),

(119, 'Varun', 8, 1, '2026-01-19', 'Pending'),

(120, 'Komal', 2, 4, '2026-01-20', 'Delivered'),
 
(121, 'Sahil', 4, 1, '2026-01-21', 'Delivered'),

(122, 'Ritu', 1, 1, '2026-01-22', 'Pending'),

(123, 'Manish', 6, 1, '2026-01-23', 'Shipped'),

(124, 'Divya', 7, 1, '2026-01-24', 'Delivered'),

(125, 'Aakash', 3, 3, '2026-01-25', 'Pending'),

(126, 'Tanya', 2, 2, '2026-01-26', 'Delivered'),

(127, 'Gaurav', 5, 1, '2026-01-27', 'Shipped'),

(128, 'Isha', 1, 1, '2026-01-28', 'Delivered'),

(129, 'Nitin', 4, 2, '2026-01-29', 'Pending'),

(130, 'Sonia', 8, 1, '2026-01-30', 'Delivered'),
 
(131, 'Akash', 2, 1, '2026-02-01', 'Delivered'),

(132, 'Reena', 3, 2, '2026-02-02', 'Pending'),

(133, 'Harsh', 7, 1, '2026-02-03', 'Shipped'),

(134, 'Payal', 1, 2, '2026-02-04', 'Delivered'),

(135, 'Ramesh', 6, 1, '2026-02-05', 'Pending'),

(136, 'Seema', 4, 1, '2026-02-06', 'Delivered'),

(137, 'Ajay', 5, 1, '2026-02-07', 'Shipped'),

(138, 'Kiran', 2, 3, '2026-02-08', 'Delivered'),

(139, 'Varsha', 3, 1, '2026-02-09', 'Pending'),

(140, 'Suresh', 7, 2, '2026-02-10', 'Delivered'),
 
(141, 'Rohini', 1, 1, '2026-02-11', 'Delivered'),

(142, 'Tarun', 4, 1, '2026-02-12', 'Pending'),

(143, 'Ankit', 6, 2, '2026-02-13', 'Shipped'),

(144, 'Mona', 2, 1, '2026-02-14', 'Delivered'),

(145, 'Yash', 5, 1, '2026-02-15', 'Pending'),

(146, 'Sakshi', 3, 2, '2026-02-16', 'Delivered'),

(147, 'Pankaj', 7, 1, '2026-02-17', 'Shipped'),

(148, 'Riya', 1, 1, '2026-02-18', 'Delivered'),

(149, 'Abhishek', 8, 2, '2026-02-19', 'Pending'),

(150, 'Muskan', 4, 1, '2026-02-20', 'Delivered');*/

select * from items;
 