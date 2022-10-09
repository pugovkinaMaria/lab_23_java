import java.time.LocalDate;

public class Book {
    private String name;
    private String author;
    private double rating;
    private String language;
    private int countPages;
    private LocalDate datePublication;
    private String publishingHouse;

    public Book(String name, String author, double rating, String language, int countPages, LocalDate datePublication, String publishingHouse) {
        this.name = name;
        this.author = author;
        this.rating = rating;
        this.language = language;
        this.countPages = countPages;
        this.datePublication = datePublication;
        this.publishingHouse = publishingHouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", rating=" + rating +
                ", language='" + language + '\'' +
                ", countPages=" + countPages +
                ", datePublication=" + datePublication +
                ", publishingHouse='" + publishingHouse + '\'' +
                '}';
    }
}




