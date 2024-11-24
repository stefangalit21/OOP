public class Book
{
    private String title;
    private String author;
    private String IBM;

    public Book(String title, String author, String IBM)
    {
        this.title = title;
        this.author = author;
        this.IBM = IBM;

    }
    public int add(int a, double b){
        return a + (int)b;
    }

    public double add(double a, int b){
        return (double)a + b;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIBM() {
        return IBM;
    }
    @Override
    public String toString()
    {
        return "Title : " + title + "\nAuthor: " + author + "\nIBM: " + IBM+"\n";
    }
}

