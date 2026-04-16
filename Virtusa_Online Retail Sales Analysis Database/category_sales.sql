SELECT p.category,
       SUM(p.price * oi.quantity) AS total_sales
FROM Order_Items oi
JOIN Products p ON oi.product_id = p.product_id
GROUP BY p.category;