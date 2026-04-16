
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.*;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public void loadAllData() {
        loadBooks();
        loadUsers();
        loadTransactions();
    }

    public void saveAllData() {
        saveBooks();
        saveUsers();
        saveTransactions();
    }

    private void saveBooks() {
        try (FileWriter fw = new FileWriter("books.txt")) {
            for (Book b : books) {
                fw.write(b.getId() + "," + b.getTitle() + "," + b.getAuthor() + "," + b.isIssued() + "\n");
            }
        } catch (Exception e) {
        }
    }

    private void loadBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                Book b = new Book(Integer.parseInt(d[0]), d[1], d[2]);
                b.setIssued(Boolean.parseBoolean(d[3]));
                books.add(b);
            }
        } catch (Exception e) {
        }
    }

    private void saveUsers() {
        try (FileWriter fw = new FileWriter("users.txt")) {
            for (User u : users) {
                fw.write(u.getRollNo() + "," + u.getName() + "\n");
            }
        } catch (Exception e) {
        }
    }

    private void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                users.add(new User(d[0], d[1]));
            }
        } catch (Exception e) {
        }
    }

    private void saveTransactions() {
        try (FileWriter fw = new FileWriter("transactions.txt")) {
            for (Transaction t : transactions) {
                fw.write(t.getBookId() + "," +
                        t.getUserRollNo() + "," +
                        t.getIssueDate() + "," +
                        t.getDueDate() + "," +
                        (t.getReturnDate() == null ? "null" : t.getReturnDate()) + "\n");
            }
        } catch (Exception e) {
        }
    }

    private void loadTransactions() {
        try (BufferedReader br = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                transactions.add(new Transaction(
                        Integer.parseInt(d[0]),
                        d[1],
                        LocalDate.parse(d[2]),
                        LocalDate.parse(d[3]),
                        d[4].equals("null") ? null : LocalDate.parse(d[4])));
            }
        } catch (Exception e) {
        }
    }

    public void addBook(Book book) {

        for (Book b : books) {
            if (b.getId() == book.getId()) {
                System.out.println(" Book ID already exists!");
                return;
            }
        }

        books.add(book);
        saveBooks();
        System.out.println(" Book added!");
    }

    public void addUser(User user) {

        for (User u : users) {
            if (u.getRollNo().equals(user.getRollNo())) {
                System.out.println(" User already exists with this Roll No!");
                return;
            }
        }

        users.add(user);
        saveUsers();
        System.out.println(" User added!");
    }

    public void searchBook(String keyword) {
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b);
            }
        }
    }

    public void issueBook(int bookId, String rollNo, LocalDate dueDate) {
        for (Book b : books) {
            if (b.getId() == bookId && !b.isIssued()) {
                b.setIssued(true);

                transactions.add(new Transaction(bookId, rollNo, dueDate));

                saveBooks();
                saveTransactions();

                System.out.println(" Book issued!");
                return;
            }
        }
        System.out.println(" Book not available!");
    }

    public void returnBook(int bookId, String rollNo, LocalDate returnDate) {
        for (Transaction t : transactions) {
            if (t.getBookId() == bookId &&
                    t.getUserRollNo().equals(rollNo) &&
                    t.getReturnDate() == null) {

                t.setReturnDate(returnDate);

                long late = ChronoUnit.DAYS.between(t.getDueDate(), returnDate);

                if (late > 0)
                    System.out.println(" Fine: " + late * 10);
                else
                    System.out.println(" Returned on time");

                for (Book b : books) {
                    if (b.getId() == bookId)
                        b.setIssued(false);
                }

                saveBooks();
                saveTransactions();

                System.out.println(" Book returned!");
                return;
            }
        }

        System.out.println(" Invalid Book ID or User!");
    }

    public void showStats() {
        int issued = 0;

        for (Book b : books) {
            if (b.isIssued())
                issued++;
        }

        System.out.println("\n ANALYTICS");
        System.out.println("Total Books: " + books.size());
        System.out.println("Issued: " + issued);
        System.out.println("Available: " + (books.size() - issued));
        System.out.println("Users: " + users.size());
    }
}