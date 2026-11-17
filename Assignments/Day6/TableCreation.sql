create database if not exists retail_db;

use retail_db;

-- customers table
create table customers (
    customer_id int primary key,
    first_name varchar(50),
    last_name varchar(50),
    city varchar(50),
    join_date date
);

-- products table
create table products (
    product_id int primary key,
    product_name varchar(100),
    category varchar(50),
    price decimal(10,2)
);

-- orders table
create table orders (
    order_id int primary key,
    customer_id int,
    order_date date,
    foreign key (customer_id) references customers(customer_id)
);

-- order_items table
create table order_items (
    order_item_id int primary key,
    order_id int,
    product_id int,
    quantity int,
    unit_price decimal(10,2),
    foreign key (order_id) references orders(order_id),
    foreign key (product_id) references products(product_id)
);

-- payments table
create table payments (
    payment_id int primary key,
    order_id int,
    payment_date date,
    amount decimal(10,2),
    payment_status varchar(30),
    foreign key (order_id) references orders(order_id)
);