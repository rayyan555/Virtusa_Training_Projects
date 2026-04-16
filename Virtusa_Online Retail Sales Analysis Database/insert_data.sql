INSERT INTO Customers VALUES
(1, 'Rayyan', 'Coimbatore'),
(2, 'Arjun', 'Chennai'),
(3, 'Meena', 'Bangalore');

INSERT INTO Products VALUES
(101, 'Laptop', 'Electronics', 50000),
(102, 'Phone', 'Electronics', 20000),
(103, 'Shoes', 'Fashion', 3000);

INSERT INTO Orders VALUES
(1, 1, '2024-01-10'),
(2, 2, '2024-02-15'),
(3, 1, '2024-03-05');

INSERT INTO Order_Items VALUES
(1, 101, 1),
(1, 103, 2),
(2, 102, 1),
(3, 101, 1);