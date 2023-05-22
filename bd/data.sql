INSERT INTO CATEGORIES ("category_id", "description", "status") VALUES
    (1, 'Over-the-Counter Medications', true),
    (2, 'Prescription Medications', true),
    (3, 'Health and Wellness', true),
    (4, 'Personal Care', true),
    (5, 'Vitamins and Supplements', true),
    (6, 'First Aid', true);

-- PRODUCTS
INSERT INTO PRODUCTS ("product_id", "name", "category_id", "barcode", "selling_price", "stock_quantity", "status") VALUES
	(1, 'Aspirin', 1, '1234567890123', 9.99, 50, true),
	(2, 'Ibuprofen', 1, '2345678901234', 19.99, 100, true),
	(3, 'Acetaminophen', 1, '3456789012345', 14.99, 75, false),
	(4, 'Loratadine', 2, '4567890123456', 29.99, 30, true),
	(5, 'Omeprazole', 2, '5678901234567', 39.99, 20, false),
	(6, 'Vitamin C', 5, '6789012345678', 9.99, 80, true),
	(7, 'Calcium Supplement', 5, '7890123456789', 14.99, 60, true),
	(8, 'Band-Aids', 6, '8901234567890', 4.99, 200, true),
	(9, 'Antibacterial Hand Soap', 4, '9012345678901', 6.99, 150, true),
	(10, 'Toothpaste', 4, '0123456789012', 3.99, 100, true),
	(11, 'Eye Drops', 3, '1234567890123', 8.99, 40, true),
	(12, 'Laxative', 1, '2345678901234', 12.99, 30, true),
	(13, 'Cough Syrup', 1, '3456789012345', 8.99, 50, true),
	(14, 'Allergy Relief Tablets', 1, '4567890123456', 12.99, 60, true),
	(15, 'Antacid Tablets', 1, '5678901234567', 6.99, 70, true),
	(16, 'Hydrocortisone Cream', 4, '6789012345678', 9.99, 40, true),
	(17, 'Antifungal Cream', 4, '7890123456789', 7.99, 35, true),
	(18, 'Pain Relieving Gel', 4, '8901234567890', 14.99, 30, true),
	(19, 'Multivitamin Supplement', 5, '9012345678901', 19.99, 90, true),
	(20, 'Fish Oil Capsules', 5, '0123456789012', 16.99, 80, true),
	(21, 'Probiotic Supplement', 5, '1234567890123', 11.99, 70, true),
	(22, 'Nasal Spray', 3, '2345678901234', 9.99, 25, true),
	(23, 'Digital Thermometer', 6, '3456789012345', 12.99, 50, true),
	(24, 'Hand Sanitizer', 4, '4567890123456', 4.99, 100, true),
	(25, 'Sleep Aid Tablets', 1, '5678901234567', 10.99, 55, true),
	(26, 'Contact Lens Solution', 3, '6789012345678', 8.99, 45, true),
	(27, 'First Aid Kit', 6, '7890123456789', 19.99, 20, true),
	(28, 'Hand Cream', 4, '8901234567891', 7.99, 50, true),
	(29, 'Sunscreen Lotion', 4, '9012345678902', 12.99, 40, true),
	(30, 'Hair Shampoo', 4, '0123456789013', 8.99, 60, true),
	(31, 'Protein Powder', 5, '1234567890124', 24.99, 30, true),
	(32, 'Omega-3 Supplement', 5, '2345678901235', 17.99, 50, true),
	(33, 'Antioxidant Tablets', 5, '3456789012346', 9.99, 70, true);

-- CUSTOMERS
INSERT INTO CUSTOMERS("id", "name", "last_name", "phone_number", "address", "email") VALUES
    ('12345678', 'John', 'Doe', 1234567890, '123 Main St', 'john.doe@example.com'),
    ('23456789', 'Jane', 'Smith', 2345678901, '456 Elm St', 'jane.smith@example.com'),
    ('34567890', 'Michael', 'Johnson', 3456789012, '789 Oak St', 'michael.johnson@example.com'),
    ('45678901', 'Emily', 'Williams', 4567890123, '321 Pine St', 'emily.williams@example.com'),
    ('56789012', 'David', 'Brown', 5678901234, '654 Cedar St', 'david.brown@example.com');

-- PURCHASES

INSERT INTO PURCHASES ("purchase_id", "customer_id", "date", "payment_method", "comment", "status") VALUES
	(1, '12345678', '2023-05-10 14:30:00', 'C', 'No comment', 'P'),
	(2, '56789012', '2023-05-11 10:45:00', 'P', 'Quick delivery', 'P'),
	(3, '56789012', '2023-05-12 16:20:00', 'C', 'Ordered by phone', 'P'),
	(4, '23456789', '2023-05-13 09:15:00', 'P', 'Gift wrapping requested', 'P'),
	(5, '45678901', '2023-05-14 12:00:00', 'C', 'Special instructions: Fragile items', 'P'),
	(6, '23456789', '2023-05-15 17:30:00', 'P', 'Express shipping requested', 'P'),
	(7, '23456789', '2023-05-16 11:20:00', 'C', 'No comment', 'P'),
	(8, '45678901', '2023-05-17 15:10:00', 'P', 'Gift for a friend', 'P'),
	(9, '34567890', '2023-05-18 10:00:00', 'C', 'Returning customer', 'P'),
	(10, '34567890', '2023-05-19 13:45:00', 'P', 'Ordered online', 'P');


INSERT INTO PURCHASES_PRODUCTS ("purchase_id", "product_id", "quantity", "total", "status") VALUES
    (1, 1, 2, 19.98, true),
    (1, 3, 1, 14.99, true),
    (2, 5, 3, 119.97, true),
    (2, 7, 2, 29.98, true),
    (3, 4, 1, 29.99, true),
    (3, 6, 1, 9.99, true),
    (4, 2, 5, 99.95, true),
    (4, 8, 3, 14.97, true),
    (5, 9, 2, 19.98, true),
    (5, 11, 1, 8.99, true),
    (6, 10, 4, 15.96, true),
    (6, 12, 2, 25.98, true),
    (7, 13, 3, 20.97, true),
    (7, 15, 2, 17.98, true),
    (8, 14, 1, 8.99, true),
    (8, 16, 1, 19.99, true),
    (9, 17, 2, 15.98, true),
    (9, 19, 1, 6.99, true),
    (10, 18, 3, 32.97, true),
    (10, 20, 2, 11.98, true);



-- Set sequence value for PRODUCTS table
SELECT setval('public.products_product_id_seq', 33, true);
-- Set sequence value for CATEGORIES table
SELECT setval('public.categories_category_id_seq', 6, true);
-- Set sequence value for PURCHASES table
SELECT setval('public.purchases_purchase_id_seq', 10, true);