class Book {

    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("Book ID : " + bookId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("----------------------");
    }
}

public class LibraryManagement {

    
    static Book linearSearch(Book[] books,
                             String key) {

        for (int i = 0; i < books.length; i++) {

            if (books[i].title.equalsIgnoreCase(key)) {
                return books[i];
            }
        }

        return null;
    }

    
    static Book binarySearch(Book[] books,
                             String key) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int result =
                books[mid].title.compareToIgnoreCase(key);

            if (result == 0) {
                return books[mid];
            }
            else if (result < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

       
        Book[] books = {
            new Book(101, "C", "Dennis Ritchie"),
            new Book(102, "DBMS", "Korth"),
            new Book(103, "Java", "James Gosling"),
            new Book(104, "Operating System", "Galvin"),
            new Book(105, "Python", "Guido")
        };

        String searchTitle = "Java";

        System.out.println("Linear Search:");

        Book result1 =
            linearSearch(books, searchTitle);

        if (result1 != null)
            result1.display();
        else
            System.out.println("Book Not Found");

        System.out.println("Binary Search:");

        Book result2 =
            binarySearch(books, searchTitle);

        if (result2 != null)
            result2.display();
        else
            System.out.println("Book Not Found");
    }
}