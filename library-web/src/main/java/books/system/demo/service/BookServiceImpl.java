package books.system.demo.service;

import books.system.demo.convertions.Conversions;
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

    @Autowired
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
    public BookDto addBook(Book book) {
        boolean bookExists = bookRepository.existsById(book.getISBN());
        if (bookExists) {
            throw new IllegalArgumentException(
                    String.format("%s already exists", book.getTitle())
            );
        }

        bookRepository.save(book);
        return Conversions.convertBookToDto(book);
    }

    @Override
    public BookDto updateBook(Book book) {
        if (!bookRepository.existsById(book.getISBN())) {
            throw new NoSuchElementException(NOT_FOUND_MESSAGE);
        }

        Book bookFromDb = getBook(book.getISBN());
        System.out.println(bookFromDb.toString());
        bookFromDb.setTitle(book.getTitle());
        bookFromDb.setAuthor(book.getAuthor());
        bookFromDb.setGenre(book.getGenre());;
        bookRepository.save(bookFromDb);

        bookRepository.save(book);
        return Conversions.convertBookToDto(book);
    }

    @Override
    public void deleteBook(String ISBN) {
        if (!bookRepository.existsById(ISBN)) {
            throw new NoSuchElementException (NOT_FOUND_MESSAGE);
        }

        bookRepository.deleteById(ISBN);
    }
}
