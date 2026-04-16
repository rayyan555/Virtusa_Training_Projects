
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    
    public static LocalDate parseDate(String input) {
        input = input.replace("/", " ");
        String[] parts = input.split(" ");

        int d = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);

        return LocalDate.of(y, m, d);
    }

    public static void main(String[] args) {

        Library lib = new Library();
        lib.loadAllData();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. View Stats");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    lib.addBook(new Book(id, title, author));
                    break;

                case 2:
                    System.out.print("Roll No: ");
                    String roll = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    lib.addUser(new User(roll, name));
                    break;

                case 3:
                    System.out.print("Search by Title or Author: ");
                    lib.searchBook(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("User Roll: ");
                    String r = sc.nextLine();

                    System.out.print("Due Date (DD/MM/YYYY or DD MM YYYY): ");
                    LocalDate dueDate = parseDate(sc.nextLine());

                    lib.issueBook(bid, r, dueDate);
                    break;

                case 5:
                    System.out.print("Book ID: ");
                    int rid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("User Roll: ");
                    String rr = sc.nextLine();

                    System.out.print("Return Date (DD/MM/YYYY or DD MM YYYY): ");
                    LocalDate returnDate = parseDate(sc.nextLine());

                    lib.returnBook(rid, rr, returnDate);
                    break;

                case 6:
                    lib.showStats();
                    break;

                case 7:
                    lib.saveAllData();
                    System.out.println(" Bye!");
                    System.exit(0);

                default:
                    System.out.println(" Invalid choice!");
            }
        }
    }
}