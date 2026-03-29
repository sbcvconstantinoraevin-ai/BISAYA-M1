import java.util.*;

public class User {

    static HashMap<String, String> accounts = new HashMap<>();
    // Link the User class to the LibraryService
    static LibraryService library = new LibraryService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Initialize the library data first
        library.loadSampleData();

        System.out.println("=== PUBLIC LIBRARY & MEDIA CENTER ===");

        while (true) {
            System.out.println("\n[1] Create Account");
            System.out.println("[2] Log In");
            System.out.println("[3] Exit");
            System.out.print("Selection: ");
            String choice = sc.nextLine().trim();

            if (choice.equals("1")) {
                handleCreateAccount(sc);
            } else if (choice.equals("2")) {
                handleLogin(sc);
            } else if (choice.equals("3")) {
                System.out.println("System closed. Goodbye!");
                break;
            } else {
                System.out.println("⚠ Invalid choice.");
            }
        }
    }

    private static void handleCreateAccount(Scanner sc) {
        System.out.print("Enter New Username: ");
        String user = sc.nextLine().trim();
        if (accounts.containsKey(user)) {
            System.out.println("✗ Username already taken.");
        } else {
            System.out.print("Enter Password: ");
            String pass = sc.nextLine().trim();
            accounts.put(user, pass);
            System.out.println("✓ Account created successfully!");
        }
    }

    private static void handleLogin(Scanner sc) {
        System.out.print("Username: ");
        String user = sc.nextLine().trim();
        System.out.print("Password: ");
        String pass = sc.nextLine().trim();

        if (accounts.containsKey(user) && accounts.get(user).equals(pass)) {
            System.out.println("\n✓ Login successful! Welcome, " + user + ".");
            showLibraryMenu(sc);
        } else {
            System.out.println(" Invalid credentials.");
        }
    }

    static void showLibraryMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- LIBRARY MAIN MENU ---");
            System.out.println("1. View Returned Books");
            System.out.println("2. View Reservation Status");
            System.out.println("3. View Borrowing History");
            System.out.println("4. Log Out");
            System.out.print("Choice: ");
            String c = sc.nextLine().trim();

            switch (c) {
                case "1" -> library.viewReturnedBooks();
                case "2" -> library.viewReservationStatus();
                case "3" -> library.viewBorrowingHistory();
                case "4" -> {
                    System.out.println("Logging out...");
                    return; 
                }
                default -> System.out.println(" Invalid choice.");
            }
        }
    }
}
