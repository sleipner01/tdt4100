package of1.kode;

public class Book {

    String title;
    int numPages;

    public Book(int numPages, String title) {
        this.title = title;
        this.numPages = numPages;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getTitle() {
        return this.title;
    }

    public int getNumPages() {
        return this.numPages;
    }

    public static void main(String[] args) {
        
        Book book = new Book(100, "Big Java");
        
        System.out.println(book);
        
        book.setNumPages(718);
        book.setTitle("Introduction to Algorithms");
        System.out.println(book);
        
        System.out.println(book);
        
    }

    @Override
    public String toString() {
        return "The book \"" + this.getTitle() + "\" has " +
        this.getNumPages() + " pages.";
    }

}
