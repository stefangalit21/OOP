import java.util.List;
public class LibraryUtils {
    public static void printBooks(List<Book>books) {

        if (books.isEmpty())
        {
            System.out.println("Biblioteca este goala");
        } else {
            System.out.println("Cartile din biblioteca:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
