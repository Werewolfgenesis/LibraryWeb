package books.system.demo.service;

import books.system.demo.dtos.BookDto;
import books.system.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBook(String ISBN);
    BookDto addBook(Book book);
    BookDto updateBook(Book book);
    void deleteBook(String ISBN);
}
