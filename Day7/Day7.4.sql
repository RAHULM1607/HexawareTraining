
USE RetailInventoryDB;

-- 1. INSERT 10 SUPPLIERS
INSERT INTO Suppliers VALUES
('SUP001', 'ABC Traders', '9876543210'),
('SUP002', 'XYZ Suppliers', '9876543211'),
('SUP003', 'Prime Distributors', '9876543212'),
('SUP004', 'Tech World', '9876543213'),
('SUP005', 'Global Supplies', '9876543214'),
('SUP006', 'Metro Wholesale', '9876543215'),
('SUP007', 'Bright Sales', '9876543216'),
('SUP008', 'City Distributors', '9876543217'),
('SUP009', 'NextGen Traders', '9876543218'),
('SUP010', 'Universal Supply', '9876543219');


-- 2. INSERT 10 CATEGORIES
INSERT INTO Categories VALUES
('CAT001', 'Electronics'),
('CAT002', 'Accessories'),
('CAT003', 'Computers'),
('CAT004', 'Furniture'),
('CAT005', 'Stationery'),
('CAT006', 'Networking'),
('CAT007', 'Storage'),
('CAT008', 'Printers'),
('CAT009', 'Audio'),
('CAT010', 'Mobile Devices');


-- 3. INSERT 10 WAREHOUSES
INSERT INTO Warehouses VALUES
('WH001', 'Chennai Central', 'Chennai'),
('WH002', 'Bangalore North', 'Bangalore'),
('WH003', 'Hyderabad Hub', 'Hyderabad'),
('WH004', 'Mumbai Depot', 'Mumbai'),
('WH005', 'Delhi Storehouse', 'Delhi'),
('WH006', 'Pune Warehouse', 'Pune'),
('WH007', 'Kochi Storage', 'Kochi'),
('WH008', 'Coimbatore Hub', 'Coimbatore'),
('WH009', 'Jaipur Depot', 'Jaipur'),
('WH010', 'Kolkata Warehouse', 'Kolkata');


-- 4. INSERT 10 PRODUCTS
INSERT INTO Products VALUES
('SKU001', 'Laptop', 'CAT003', 'SUP001'),
('SKU002', 'Wireless Mouse', 'CAT002', 'SUP001'),
('SKU003', 'Keyboard', 'CAT002', 'SUP002'),
('SKU004', 'LED Monitor', 'CAT001', 'SUP003'),
('SKU005', 'Laser Printer', 'CAT008', 'SUP002'),
('SKU006', 'Office Chair', 'CAT004', 'SUP004'),
('SKU007', 'USB Drive', 'CAT007', 'SUP005'),
('SKU008', 'WiFi Router', 'CAT006', 'SUP006'),
('SKU009', 'Headphones', 'CAT009', 'SUP007'),
('SKU010', 'Smartphone', 'CAT010', 'SUP008');


-- 5. INSERT 10 INVENTORY RECORDS
INSERT INTO Inventory VALUES
('SKU001', 'WH001', 50, 10),
('SKU002', 'WH001', 100, 20),
('SKU003', 'WH002', 75, 15),
('SKU004', 'WH003', 30, 5),
('SKU005', 'WH004', 20, 5),
('SKU006', 'WH005', 40, 8),
('SKU007', 'WH006', 200, 30),
('SKU008', 'WH007', 35, 10),
('SKU009', 'WH008', 60, 12),
('SKU010', 'WH009', 25, 5);
