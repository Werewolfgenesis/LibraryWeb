package books.system.demo.service;

import java.util.List;

import books.system.demo.model.Book;
import books.system.demo.model.BookCollection;
import books.system.demo.model.User;

public interface UserService {

    // Create user.
    User createUser(User u);

    User findUser(String username);

    User updateUser(User u);

    void deleteUser(String username);

    // Create a list with the name
    void createList(String username, String name);

    // Add a book
    Book addBook(Book book);

    // Delete a book
    void deleteBook(Book book);

    // Add some notes for each book
    void addNotes(Book book);

    // Search for a Book by name in the list
    Book searchBookByName(String bookName);

    // Search a list by name
    BookCollection searchListByName(String listName);

    // group books by author
    List<Book> groupByAuthor(String author);

    // group books by genre
    List<Book> groupByGenre(String genre);
}
