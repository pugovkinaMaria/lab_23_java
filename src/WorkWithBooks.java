import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class WorkWithBooks {

    private List<Book> books;
    private List<Author> authors;
    private String fileName;
    public WorkWithBooks(String fileName) {
         this.fileName = fileName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void readBooks() {
        this.books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] str = line.split(",");
                String[] date = str[5].split("/");
                LocalDate parseDate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[0]), Integer.parseInt(date[1]));
                books.add(new Book(str[0], str[1], Double.parseDouble(str[2]), str[3],
                        Integer.parseInt(str[4]), parseDate, str[6]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAuthorsFromBooks() {
        this.authors = new ArrayList<>();
        books.stream().forEach(book -> {
            Author authorName = authors.stream()
                .filter(author -> author.getName().equals(book.getAuthor()))
                .findFirst().orElse(null);
            if (authorName == null) {
                List<Book> authorsBooks = new ArrayList<>();
                authorsBooks.add(book);
                authors.add(new Author(book.getAuthor(), authorsBooks));
            } else {
                authors.stream().filter(author -> author.getName().equals(book.getAuthor()))
                        .findFirst().stream()
                        .forEach(author -> author.setBook(book));
            }
        });
    }

    public void writeBigBook(String fileName) {
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileName))) {
            int maxPages = Collections.max(books.stream().map(Book::getCountPages).collect(Collectors.toList()));
            List<Book> maxPagesBooks = books.stream().filter(b -> b.getCountPages() == maxPages).collect(Collectors.toList());
            maxPagesBooks.stream().sorted(new RatingComparator()).forEach(b -> {
                try {
                    writter.write(b.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getlistOfPublishingHouse() {
        List<String> publishingHouse = new ArrayList<>();
        System.out.print("Введите писателя: ");
        Scanner in = new Scanner(System.in);
        String nameAuthor = in.nextLine();
        Author author = authors.stream().filter(a -> a.getName().equals(nameAuthor)).findFirst().orElse(null);
        if (author == null) {
            System.out.println("Введенного автора нет в списках");
        } else {
            System.out.println("Список издательств писателя " + nameAuthor + ": ");
            Map<String, List<Book>> bookByPublishingHouse = author.getListBooks()
                    .stream().collect(Collectors.groupingBy(Book::getPublishingHouse));
            bookByPublishingHouse.entrySet().stream().map(Map.Entry::getKey).forEach(b -> System.out.println(b));
        }
        return publishingHouse;
    }
}
