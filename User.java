import java.util.*;

class User {
    String fullName;
    String email;
    String username;
    String password;

    public User(String fullName, String email, String username, String password) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}

class Book {
    String title;
    boolean isAvailable;
    Queue<User> reservationQueue;

    public Book(String title, boolean isAvailable) {
        this.title = title;
        this.isAvailable = isAvailable;
        this.reservationQueue = new LinkedList<>();
    }

    public void reserveBook(User user) {
        if (isAvailable) {
            System.out.println("Book is available. Reserved successfully!");
            isAvailable = false;
        } else {
            reservationQueue.add(user);
            System.out.println("Book is unavailable. You are added to the queue.");
            System.out.println("Your position in queue: " + reservationQueue.size());
        }
    }

    public void returnBook() {
        if (!reservationQueue.isEmpty()) {
            User nextUser = reservationQueue.poll();
            System.out.println("Book is now available for: " + nextUser.fullName);
        } else {
            isAvailable = true;
            System.out.println("Book returned and now available.");
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample book (currently unavailable)
        Book book = new Book("Java Programming", false);

        System.out.println("=== Reserve Books System ===");

        // User input
        System.out.print("Enter Full Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User user = new User(name, email, username, password);

        // Confirmation message
        System.out.println("\nAccount created successfully!");

        // Reserve book
        System.out.println("\nReserving book...");
        book.reserveBook(user);

        // Simulate return
        System.out.println("\nSimulating book return...");
        book.returnBook();

        sc.close();
    }
}

