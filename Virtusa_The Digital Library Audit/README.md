#  Digital Library Audit System

##  Problem Statement

A local community college maintains a database of books and student borrow records. However, they face challenges in:

* Tracking **overdue books**
* Identifying **popular book categories**
* Managing **inactive student records**

This project implements a SQL-based system to solve these issues efficiently.

---

##  Features

*  Book Management (Title, Author, Category)
*  Student Records Management
*  Book Issue Tracking
*  Overdue Book Detection (Penalty Report)
*  Category Popularity Analysis
*  Removal of Inactive Students

---

##  Technologies Used

* MySQL
* SQL (DDL, DML, Queries)
* MySQL Workbench

---

##  Database Tables

* **Books**
* **Students**
* **IssuedBooks**

---

##  Key Operations Performed

###  1. Overdue Books (Penalty Report)

* Identifies books not returned within 14 days

###  2. Popular Category

* Uses `COUNT` and `GROUP BY` to find most borrowed categories

###  3. Data Cleanup

* Removes students inactive for more than 3 years

---

##  Output Screenshots



---

###  1. Overdue Books Output
![Overdue](images/Screenshot%202026-04-15%20090155.png)



---

###  2. Popular Category Output

![Category](images/Screenshot%202026-04-15%20090217.png)

---

###  3. Delete Inactive Students 

![Query](images/Screenshot%202026-04-24%20114710.png)

###  4. Final Students Table

![Students](images/Screenshot%202026-04-15%20090531.png)


---

##  Key SQL Concepts Used

* `CREATE DATABASE`, `CREATE TABLE`
* `INSERT`, `DELETE`
* `JOIN`
* `GROUP BY`, `ORDER BY`
* `COUNT()`
* Date functions (`CURDATE()`, `INTERVAL`)

---

## Author

Rayyan A

BE.CSE (AIML)

Email:rayyanibnrahman903@gmail.com


