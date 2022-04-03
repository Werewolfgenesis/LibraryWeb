package books.system.demo.service;

import books.system.demo.model.Book;
import books.system.demo.model.BookCollection;
import books.system.demo.repository.UserRepo;
import books.system.demo.repository.UserRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo repo;

    @Autowired
    public UserServiceImpl(UserRepo repo){
        this.repo = repo;
    }

    @Override
    public void createList(String name) {
        repo.createList(name);
    }

    @Override
    public void addBook(String listName, Book book) {
        repo.addBook(listName, book);
    }

    @Override
    public void deleteBook(String listName, Book book) {
        repo.deleteBook(listName, book);
    }

    @Override
    public void addNotes(String notes, Book book) {
        repo.addNotes(notes, book);
    }

    @Override
    public Book searchBookByName(String listName, String bookName) {
       return repo.searchBookByName(listName, bookName);
    }

    @Override
    public BookCollection searchListByName(String listName) {
        return repo.searchListByName(listName);
    }

    @Override
    public List<Book> groupByAuthor(String author) {
        return repo.groupByAuthor(author);
    }

    @Override
    public List<Book> groupByGenre(String genre) {
        return repo.groupByGenre(genre);
    }
}
