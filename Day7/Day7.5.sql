CREATE TABLE if not exists Employee (
    Emp_ID INT PRIMARY KEY,
    Name VARCHAR(50),
    Department VARCHAR(50),
    Salary INT,
    City VARCHAR(50)
);

INSERT INTO Employee VALUES
(1, 'Amit', 'IT', 30000, 'Delhi'),
(2, 'Neha', 'HR', 45000, 'Mumbai'),
(3, 'Ravi', 'IT', 60000, 'Delhi'),
(4, 'Priya', 'Sales', 25000, 'Pune'),
(5, 'Rahul', 'HR', 50000, 'Delhi'),
(6, 'Sneha', 'Sales', 35000, 'Mumbai'),
(7, 'Karan', 'IT', 70000, 'Pune'),
(8, 'Pooja', 'HR', 40000, 'Delhi');