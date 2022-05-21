package books.system.demo.service;

import books.system.demo.dtos.BookDto;
import books.system.demo.model.Book;
import books.system.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {
    private static final String NOT_FOUND_MESSAGE = "Book was not found!";

    private BookRepo bookRepository;

    @Override
    public List<Book> getAllBooks() {
        LinkedList<Book> allBooks = new LinkedList<>();
        bookRepository.findAll().forEach(allBooks::add);
        return allBooks;
    }

    @Override
    public Book getBook(String ISBN) {
        return bookRepository.findById(ISBN).orElseThrow(() -> new NoSuchElementException(NOT_FOUND_MESSAGE));
    }

    @Override
    public void addBook(Book book) {
        boolean bookExists = bookRepository.existsById(book.getISBN());
        if (bookExists) {
            throw new IllegalArgumentException(
                    String.format("%s already exists", book.getTitle())
            );
        }

        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        if (!bookRepository.existsById(book.getISBN())) {
            throw new NoSuchElementException(NOT_FOUND_MESSAGE);
        }

        bookRepository.save(book);
    }

    @Override
    public void deleteBook(String ISBN) {
        if (!bookRepository.existsById(ISBN)) {
            throw new NoSuchElementException (NOT_FOUND_MESSAGE);
        }

        bookRepository.deleteById(ISBN);
    }

    @Override
    public Book toBook(BookDto dto) {
        Book book = new Book();

        book.setTitle(dto.title);
        book.setISBN(dto.ISBN);
        book.setGenre(dto.genre);
        book.setAuthor(dto.author);

        return book;
    }
}
