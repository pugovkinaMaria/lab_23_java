public class Main {
    public static void main(String[] args) {
        WorkWithBooks workWithBooks = new WorkWithBooks("data_books.csv");
        workWithBooks.readBooks();
        workWithBooks.getAuthorsFromBooks();
        workWithBooks.writeBigBook("big_book.txt");
        workWithBooks.getlistOfPublishingHouse();
    }


}