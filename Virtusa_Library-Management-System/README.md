#  Library Management System (Java)

##  Problem Statement

Managing library records manually is time-consuming and error-prone. This project provides a **Java-based console Library Management System** to automate book management, user handling, and transaction tracking efficiently.


---

##  Features

*  Add, update, and manage books
*  User registration system
*  Search books by title or author
*  Issue books with due dates
*  Return books with fine calculation
*  Automatic fine calculation (₹10/day late)
*  Library statistics (total, issued, available books)
*  Data persistence using file handling

---

##  Tech Stack

* Java (Core Java + OOP Concepts)
* File Handling (`.txt` files)
* Collections (`ArrayList`)
* Date & Time API (`LocalDate`, `ChronoUnit`)

---

##  Project Structure

```
├── Main.java
├── Library.java
├── Book.java
├── User.java
├── Transaction.java
├── books.txt
├── users.txt
├── transactions.txt
├── README.md
└── .gitignore
```

---

##  How the System Works

###  1. Book Management

Books are stored with ID, title, author, and availability status.
Implemented using: 

---

###  2. User Management

Users are registered with roll number and name.
Implemented using: 

---

###  3. Transaction Handling

Tracks:

* Issue date
* Due date
* Return date

Implemented using: 

---

###  4. Core Logic (Library Class)

Main functionalities include:

* Add books & users
* Search books
* Issue & return books
* Fine calculation
* Data saving/loading

Implemented using: 

---

###  5. User Interface (Console Menu)

Interactive menu-driven system:

* Add Book
* Add User
* Search Book
* Issue Book
* Return Book
* View Stats

Implemented using: 

---

##  Setup Instructions

### 1️ Compile the Project

```bash
javac *.java
```

### 2️ Run the Application

```bash
java Main
```

---

##  Outcome

A fully functional system that:

* Reduces manual work in libraries
* Tracks books and users efficiently
* Prevents duplicate entries
* Automatically calculates fines
* Maintains persistent records

---

##  Output Screenshots

###  Main Menu

![Main Menu](images/Screenshot%202026-04-08%20150349.png)

---

###  Add Book

![Add Book](images/Screenshot%202026-04-08%20150458.png)
![Duplicate Book](images/Screenshot%202026-04-08%20150534.png)

---

###  Add User

![Add User](images/Screenshot%202026-04-08%20150614.png)
![Duplicate User](images/Screenshot%202026-04-08%20150641.png)

---

###  Search Book

![Search Book](images/Screenshot%202026-04-08%20150820.png)

---

###  Issue Book

![Issue Book](images/Screenshot%202026-04-08%20150855.png)

---

###  Return Book

![Return Book](images/Screenshot%202026-04-08%20150957.png)
![Late Return with Fine](images/Screenshot%202026-04-08%20151125.png)

---

###  View Statistics

![Stats](images/Screenshot%202026-04-08%20151142.png)

---

###  Exit

![Exit](images/Screenshot%202026-04-08%20151155.png)

---

##  Key Concepts Used

* Object-Oriented Programming (OOP)

  * Classes & Objects
  * Encapsulation
* File Handling in Java
* Collections Framework
* Date Handling (`LocalDate`)
* Exception Handling

---


##  Author

Rayyan A 

KPR INSTITUTE OF ENGINEERING AND TECHNOLOGY 

BE.CSE / Honours And Specialization in AIML

Email: rayyanibnrahman903@gmail.com

---



