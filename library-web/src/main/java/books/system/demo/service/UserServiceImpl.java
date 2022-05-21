package books.system.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import books.system.demo.model.Book;
import books.system.demo.model.BookCollection;
import books.system.demo.model.User;
import books.system.demo.repository.BookRepo;
import books.system.demo.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
    // @Autowired
    private UserRepo userRepo;
    // @Autowired
    private BookRepo bookRepo;

    // @Autowired
    // public UserServiceImpl(final UserRepo repo, final BookRepo bookRepo) {
    // this.userRepo = repo;
    // this.bookRepo = bookRepo;
    // }

    @Override
    public void createList(final String username, final String name) {
        final User user = this.findUser(username);
        user.setCollectionBooks(new BookCollection(new ArrayList<>(), name));
        this.userRepo.save(user);
    }

    @Override
    public Book addBook(final Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public void deleteBook(final Book book) {
        this.bookRepo.delete(book);
    }

    @Override
    public void addNotes(final Book book) {

    }

    @Override
    public Book searchBookByName(final String bookName) {
        return null;
    }

    @Override
    public BookCollection searchListByName(final String listName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> groupByAuthor(final String author) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> groupByGenre(final String genre) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User createUser(final User u) {
        return this.userRepo.save(u);
    }

    @Override
    public User findUser(final String username) {
        return this.userRepo.findById(username).orElse(null);
    }

    @Override
    public User updateUser(final User u) {
        return this.userRepo.save(u);
    }

    @Override
    public void deleteUser(final String username) {
        this.userRepo.deleteById(username);
    }

}
