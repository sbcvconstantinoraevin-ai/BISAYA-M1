import java.util.*;

class ReturnedBook {
    String title;
    String returnDate;
    String borrowerName;

    public ReturnedBook(String title, String returnDate, String borrowerName) {
        this.title = title;
        this.returnDate = returnDate;
        this.borrowerName = borrowerName;
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Return Date: " + returnDate);
        System.out.println("Borrower Name: " + borrowerName);
        System.out.println("---------------------------");
    }
}

public class ViewBookDetails {
    public static void main(String[] args) {

        // Sample returned books (pwede mo dagdagan)
        ArrayList<ReturnedBook> returnedBooks = new ArrayList<>();

        returnedBooks.add(new ReturnedBook("Java Programming", "March 18, 2026", "Juan Dela Cruz"));
        returnedBooks.add(new ReturnedBook("Data Structures", "March 17, 2026", "Maria Santos"));
        returnedBooks.add(new ReturnedBook("OOP Concepts", "March 16, 2026", "Pedro Reyes"));

        System.out.println("=== Returned Books List ===\n");

        if (returnedBooks.isEmpty()) {
            System.out.println("No returned books found.");
        } else {
            for (ReturnedBook book : returnedBooks) {
                book.display();
            }
        }
    }
}
