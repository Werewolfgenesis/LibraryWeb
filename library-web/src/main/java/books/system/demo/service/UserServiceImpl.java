package books.system.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import books.system.demo.convertions.Conversions;
import books.system.demo.dtos.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import books.system.demo.model.Book;
import books.system.demo.model.BookCollection;
import books.system.demo.model.User;
import books.system.demo.repository.BookRepo;
import books.system.demo.repository.UserRepo;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BookRepo bookRepo;

    @Override
    public void createList(final String username, final String name) {
        final User user = this.userRepo.findById(username).orElseThrow(() -> {
            throw new IllegalArgumentException("No such user");
        });
        user.setCollectionBooks(new BookCollection(name, new ArrayList<>()));
        this.userRepo.save(user);
    }

    @Override
    public void addNotes(final String username, final Book book, final String notes) {
        final User user = this.userRepo.findById(username).orElseThrow(() -> {
            throw new IllegalArgumentException("No such user");
        });
        user.getNotes().put(book, notes);
        this.userRepo.save(user);
    }

    @Override
    public Book searchBookByName(final String bookName) {
        List<Book> allBooks = new ArrayList<>();
        this.bookRepo.findAll().forEach(allBooks::add);

        Book found = allBooks
                .stream()
                .filter(book -> book.getTitle().equals(bookName))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("No such book!");
                });
        return found;
    }

    @Override
    public BookCollection searchListByName(final String listName) {
        return null;
    }

    @Override
    public List<Book> groupByAuthor(final String author) {
        List<Book> allBooks = new ArrayList<>();
        this.bookRepo.findAll().forEach(allBooks::add);

        return allBooks
                .stream()
                .filter(book -> book.getAuthor().getFirstName().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> groupByGenre(final String genre) {
        List<Book> allBooks = new ArrayList<>();
        this.bookRepo.findAll().forEach(allBooks::add);

        return allBooks
                .stream()
                .filter(book -> book.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(final User u) {
        this.userRepo.save(u);
        return Conversions.convertUserToDto(u);
    }

    @Override
    public UserDto findUser(final String username) {
        User found = this.userRepo.findById(username).orElseThrow(() -> {
            throw new IllegalArgumentException("No such user!");
        });
        return Conversions.convertUserToDto(found);
    }

    @Override
    public UserDto updateUser(final User u) {
        this.userRepo.save(u);
        return Conversions.convertUserToDto(u);
    }

    @Override
    public void deleteUser(final String username) {
        this.userRepo.deleteById(username);
    }

}
