#  Online Retail Sales Analysis Database

A SQL-based project designed to analyze retail sales data and generate meaningful business insights using structured queries.

---

##  Problem Statement

Retail businesses generate large amounts of sales data but often lack structured insights. This project builds a relational database and uses SQL queries to analyze sales performance.

---

##  Objectives

* Design a relational database for an online store
* Store customer, product, and order data
* Perform data analysis using SQL queries
* Extract meaningful business insights

---

##  Database Schema

### Tables:

* **Customers** (customer_id, name, city)
* **Products** (product_id, name, category, price)
* **Orders** (order_id, customer_id, date)
* **Order_Items** (order_id, product_id, quantity)

---


##  How to Run the Project

1. Create database:

```sql id="g0x9yy"
CREATE DATABASE retail_db;
USE retail_db;
```

2. Run:

* `schema.sql` → to create tables
* `insert_data.sql` → to insert sample data

3. Execute each query file:

* `top_products.sql`
* `valuable_customers.sql`
* `monthly_revenue.sql`
* `category_sales.sql`
* `inactive_customers.sql`

---

##  Key Analysis Performed

###  Top-Selling Products

Identifies products with the highest sales quantity.

###  Most Valuable Customers

Finds customers who generated the most revenue.

###  Monthly Revenue

Analyzes revenue trends month-wise.

###  Category-wise Sales

Shows which product category performs best.

###  Inactive Customers

Detects customers who have not placed any orders.

---

##  Output Screenshots

###  Database Creation & Tables

![DB Setup](images/Screenshot%202026-04-08%20202649.png)
![Tables](images/Screenshot%202026-04-08%20203527.png)

---

###  Data Insertion

![Insert Data](images/Screenshot%202026-04-08%20203717.png)

---

###  Query Outputs

####  Top-Selling Products

![Top Products](images/Screenshot%202026-04-08%20204153.png)

####  Most Valuable Customers

![Customers](images/Screenshot%202026-04-08%20204228.png)

####  Monthly Revenue

![Revenue](images/Screenshot%202026-04-08%20220416.png)

####  Category-wise Sales

![Category](images/Screenshot%202026-04-08%20215807.png)

####  Inactive Customers

![Inactive](images/Screenshot%202026-04-08%20204339.png)

---

##  Technologies Used

* SQL (MySQL)
* Database Design
* Data Analysis

---

##  Project Outcome

* Designed a structured relational database
* Performed data analysis using SQL joins and aggregations
* Generated insights on customer behavior and sales trends


---


##  Author

**Rayyan A**

BE CSE / Honours And Specialization in AIML

KPR Institute of Engineering and Technology

Email: rayyanibnrahman903@gmail.com

---
