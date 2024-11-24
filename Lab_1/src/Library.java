import java.util.ArrayList;
import java.util.List;

public class Library
{
  private List<Book> books;

  public Library()
  {

      this.books = new ArrayList<>();
  }

  public void addBook(Book book)
  {
      books.add(book);
      System.out.println(book);
  }

  public void deleteBook(String title)
  {
      books.removeIf(b -> b.getTitle().equals(title));
      System.out.println("Cartea '" + title + "' a fost eliminata");
  }
//  public void printBooks()
//  {
//      if (books.isEmpty())
//      {
//          System.out.println("Biblioteca este goala");
//      } else {
//          System.out.println("Cartile din biblioteca:");
//          for (Book book : books) {
//              System.out.println(book);
//          }
//      }
//  }
//}

    public List<Book> getBooks()
    {
        return books;
    }
}
