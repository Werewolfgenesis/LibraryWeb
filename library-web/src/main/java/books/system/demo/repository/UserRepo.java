package books.system.demo.repository;

import books.system.demo.model.Book;
import books.system.demo.model.BookCollection;

import java.util.List;

public interface UserRepo {
    //Create a list with the name
    void createList(String name);

    //Add a book to a specific list
    void addBook(String listName, Book book);

    //Delete a book from a specific list
    void deleteBook(String listName, Book book);

    //Add some notes for each book
    void addNotes(String notes, Book book);

    //Search for a Book by name in the list
    Book searchBookByName(String listName, String bookName);

    //Search a list by name
    BookCollection searchListByName(String listName);

    //group books by author
    List<Book> groupByAuthor(String author);

    //group books by genre
    List<Book> groupByGenre(String genre);
}
