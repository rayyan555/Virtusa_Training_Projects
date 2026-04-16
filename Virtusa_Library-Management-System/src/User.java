public class User {
    private String rollNo;
    private String name;

    public User(String rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return rollNo + " - " + name;
    }
}