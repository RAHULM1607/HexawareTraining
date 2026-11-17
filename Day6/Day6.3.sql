use hexassignment;
/*CREATE TABLE if not exists Employee1 (

    Emp_ID INT PRIMARY KEY,

    First_Name VARCHAR(30),

    Last_Name VARCHAR(30),

    Email VARCHAR(50),

    Department VARCHAR(30),

    Salary DECIMAL(10,2),

    Bonus DECIMAL(10,2),

    Age INT,

    Experience DECIMAL(4,1),

    Phone_Number VARCHAR(15)

);
 
INSERT INTO Employee1 VALUES

(1, 'Rahul', 'Sharma', 'rahul@gmail.com', 'IT', 45000.75, 5000.50, 25, 2.5, '9876543210'),

(2, 'Priya', 'Verma', 'priya@gmail.com', 'HR', 52000.80, 4500.25, 28, 4.0, '9876543211'),

(3, 'Amit', 'Kumar', 'amit@gmail.com', 'Sales', 38500.60, 3500.75, 24, 1.5, '9876543212'),

(4, 'Sneha', 'Gupta', 'sneha@gmail.com', 'Finance', 65000.90, 7000.40, 32, 7.5, '9876543213'),

(5, 'Rohit', 'Mehta', 'rohit@gmail.com', 'IT', 75000.45, 8500.60, 35, 10.0, '9876543214'),

(6, 'Neha', 'Singh', 'neha@gmail.com', 'Marketing', 42000.30, 3000.50, 26, 3.0, '9876543215'),

(7, 'Vikas', 'Malhotra', 'vikas@gmail.com', 'IT', 58000.75, 6000.25, 30, 6.5, '9876543216'),

(8, 'Anjali', 'Rao', 'anjali@gmail.com', 'HR', 47500.90, 4000.80, 27, 3.5, '9876543217'),

(9, 'Karan', 'Joshi', 'karan@gmail.com', 'Sales', 33500.55, 2500.45, 23, 1.0, '9876543218'),

(10, 'Pooja', 'Agarwal', 'pooja@gmail.com', 'Finance', 82000.80, 9000.75, 38, 12.0, '9876543219'),

(11, 'Arjun', 'Kapoor', 'arjun@gmail.com', 'IT', 69500.65, 7500.35, 33, 8.5, '9876543220'),

(12, 'Ritu', 'Chopra', 'ritu@gmail.com', 'Marketing', 39500.40, 3200.60, 25, 2.0, '9876543221'),

(13, 'Manish', 'Yadav', 'manish@gmail.com', 'Sales', 44500.85, 3800.25, 29, 5.0, '9876543222'),

(14, 'Kavita', 'Nair', 'kavita@gmail.com', 'HR', 56000.50, 5200.75, 31, 7.0, '9876543223'),

(15, 'Suresh', 'Patel', 'suresh@gmail.com', 'IT', 90500.95, 10000.50, 40, 15.0, '9876543224'),

(16, 'Meena', 'Das', 'meena@gmail.com', 'Finance', 48500.70, 4200.30, 28, 4.5, '9876543225'),

(17, 'Deepak', 'Mishra', 'deepak@gmail.com', 'Sales', 36500.25, 2800.90, 26, 3.0, '9876543226'),

(18, 'Simran', 'Kaur', 'simran@gmail.com', 'Marketing', 61000.80, 6500.45, 34, 9.0, '9876543227'),

(19, 'Varun', 'Bansal', 'varun@gmail.com', 'IT', 53500.60, 4800.75, 29, 5.5, '9876543228'),

(20, 'Nisha', 'Reddy', 'nisha@gmail.com', 'Finance', 72500.90, 8000.25, 36, 11.0, '9876543229');*/

-- select first_name,round(salary,0) from employee1;
 -- select first_name,round(salary,1) from employee1;
 -- select first_name,ceil(salary) from employee1;
 -- select first_name,floor(salary) from employee1;
 -- select first_name,abs(salary-bonus) from employee1;
 -- select first_name,mod(salary,100) from employee1;
 select first_name,pow(age,2) from employee1;
 select first_name, truncate(salary, 1) from employee1;
 select first_name, salary + bonus as total_salary from employee1;