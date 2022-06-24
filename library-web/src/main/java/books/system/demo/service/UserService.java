package books.system.demo.service;

import java.util.List;

import books.system.demo.dtos.UserDto;
import books.system.demo.model.Book;
import books.system.demo.model.BookCollection;
import books.system.demo.model.User;

public interface UserService {

    // Create user.
    UserDto createUser(User u);

    UserDto findUser(String username);

    UserDto updateUser(User u);

    void deleteUser(String username);

    // Create a list with the name
    void createList(String username, String name);

    // Add some notes for each book
    void addNotes(String username, Book book, String notes);

    // Search for a Book by name in the list
    Book searchBookByName(String username,String bookName);

    // Search a list by name
    BookCollection searchListByName(String listName);

    // group books by author
    List<Book> groupByAuthor(String username,String author);

    // group books by genre
    List<Book> groupByGenre(String username,String genre);
}
