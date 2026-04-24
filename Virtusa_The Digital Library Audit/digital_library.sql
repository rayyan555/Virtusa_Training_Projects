CREATE DATABASE DigitalLibrary;
USE DigitalLibrary;



CREATE TABLE Books (
    BookID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(100),
    Author VARCHAR(100),
    Category VARCHAR(50)
);


CREATE TABLE Students (
    StudentID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Email VARCHAR(100),
    JoinDate DATE
);


CREATE TABLE IssuedBooks (
    IssueID INT PRIMARY KEY AUTO_INCREMENT,
    BookID INT,
    StudentID INT,
    IssueDate DATE,
    ReturnDate DATE,
    FOREIGN KEY (BookID) REFERENCES Books(BookID),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID)
);




INSERT INTO Books (Title, Author, Category) VALUES
('Python Basics', 'Charles Severance', 'Science'),
('Wings of Fire', 'A. P. J. Abdul Kalam', 'Biography'),
('Machine Learning', 'Tom M. Mitchell', 'Science'),
('Harry Potter', 'J.K. Rowling', 'Fiction'),
('The Alchemist', 'Paulo Coelho', 'Fiction');


INSERT INTO Students (Name, Email, JoinDate) VALUES
('Rayyan', 'rayyan@gmail.com', '2021-01-10'),
('Aisha', 'aisha@gmail.com', '2022-03-15'),
('Kiran', 'kiran@gmail.com', '2020-07-20'),
('Neha', 'neha@gmail.com', '2019-05-25');

INSERT INTO IssuedBooks (BookID, StudentID, IssueDate, ReturnDate) VALUES
(1, 1, '2026-03-01', NULL),   
(2, 2, '2026-04-01', '2026-04-10'),
(3, 3, '2026-02-20', NULL),   
(4, 1, '2026-04-05', NULL),
(5, 2, '2026-03-15', '2026-03-25');


SELECT s.Name, b.Title, ib.IssueDate
FROM IssuedBooks ib
JOIN Students s ON ib.StudentID = s.StudentID
JOIN Books b ON ib.BookID = b.BookID
WHERE ib.ReturnDate IS NULL
AND ib.IssueDate < CURDATE() - INTERVAL 14 DAY;



SELECT b.Category, COUNT(*) AS TotalBorrowed
FROM IssuedBooks ib
JOIN Books b ON ib.BookID = b.BookID
GROUP BY b.Category
ORDER BY TotalBorrowed DESC;



DELETE FROM Students
WHERE StudentID NOT IN (
    SELECT DISTINCT StudentID FROM IssuedBooks
)
AND JoinDate < CURDATE() - INTERVAL 3 YEAR;




SELECT * FROM Students;

