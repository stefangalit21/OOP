//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        Book book1 = new Book("1984", "George Orwell", "123456789");
        Book book2 = new Book("Mandrie si Prejudecata", "Jane Austen", "987654321");

        lib.addBook(book1);
        lib.addBook(book2);

        LibraryUtils.printBooks(lib.getBooks());
        lib.deleteBook("1984");
        LibraryUtils.printBooks(lib.getBooks());



    }

}