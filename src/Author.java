import java.util.List;

public class Author {
    private String name;
    private List<Book> listBooks;

    public Author(String name, List<Book> listBooks) {
        this.name = name;
        this.listBooks = listBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getListBooks() {
        return listBooks;
    }

    public void setListBooks(List<Book> listBooks) {
        this.listBooks = listBooks;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", listBooks=" + listBooks.size() +
                '}';
    }

    public void setBook(Book book) {
        listBooks.add(book);
    }
}
