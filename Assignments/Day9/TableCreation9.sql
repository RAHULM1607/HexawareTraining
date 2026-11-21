create database retail_db;

use retail_db;

-- products table
create table products (
    product_id int primary key auto_increment,
    product_name varchar(100),
    category varchar(50),
    quantity int,
    selling_price decimal(10,2),
    cost_price decimal(10,2),
    supplier varchar(100)
) engine=innodb;

-- customers table
create table customers (
    customer_id int primary key auto_increment,
    customer_name varchar(100),
    email varchar(100)
) engine=innodb;

-- orders table
create table orders (
    order_id int primary key auto_increment,
    customer_id int,
    order_date datetime default current_timestamp,
    status varchar(30) default 'pending',

    foreign key (customer_id)
    references customers(customer_id)
) engine=innodb;

-- order items table
create table order_items (
    order_item_id int primary key auto_increment,
    order_id int,
    product_id int,
    quantity int,
    unit_price decimal(10,2),

    foreign key (order_id)
    references orders(order_id),

    foreign key (product_id)
    references products(product_id)
) engine=innodb;

-- followups table
create table order_followups (
    followup_id int primary key auto_increment,
    order_id int,
    followup_date datetime default current_timestamp,
    message varchar(255),

    foreign key (order_id)
    references orders(order_id),

    unique key uq_order_followup(order_id)
);
