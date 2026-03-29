import java.util.*;

class ViewBookDetails {
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

public class BrowseBookCategories {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Browse Book Categories ===");

        // User input (requirement)
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

        // Categories and subcategories
        Map<String, List<String>> categories = new HashMap<>();

        categories.put("Programming", Arrays.asList("Java", "Python", "C++"));
        categories.put("Science", Arrays.asList("Physics", "Biology", "Chemistry"));
        categories.put("Mathematics", Arrays.asList("Algebra", "Calculus", "Statistics"));

        System.out.println("\nAvailable Categories:");
        int i = 1;
        for (String category : categories.keySet()) {
            System.out.println(i + ". " + category);
            i++;
        }

        System.out.print("\nChoose a category (number): ");
        int choice = sc.nextInt();

        // Convert choice to category
        List<String> keys = new ArrayList<>(categories.keySet());

        if (choice > 0 && choice <= keys.size()) {
            String selectedCategory = keys.get(choice - 1);
            System.out.println("\nSubcategories under " + selectedCategory + ":");

            for (String sub : categories.get(selectedCategory)) {
                System.out.println("- " + sub);
            }
        } else {
            System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
