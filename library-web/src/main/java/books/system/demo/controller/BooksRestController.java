package books.system.demo.controller;

import books.system.demo.convertions.Convertions;
import books.system.demo.dtos.BookDto;
import books.system.demo.model.Book;
import books.system.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Convert;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("library/books")
public class BooksRestController {
    @Autowired
    private BookService bookService;

    @GetMapping()
    public List<BookDto> allBooks() {
        List<Book> allBooks = this.bookService.getAllBooks();
        return allBooks.stream().map(Convertions::convertBookToDto).collect(Collectors.toList());
    }

    @PostMapping(consumes = {"application/json"})
    public void createBook(@RequestBody BookDto newBook){
        this.bookService.addBook(Convertions.convertDtoToBook(newBook));
    }

    @PutMapping(consumes = {"application/json"})
    public void updateBook(@RequestBody BookDto bookDto){
        this.bookService.updateBook(Convertions.convertDtoToBook(bookDto));
    }

    @GetMapping("/{ISBN}")
    public BookDto getBook(@PathVariable String ISBN) {
        Book found = bookService.getBook(ISBN);
        return Convertions.convertBookToDto(found);
    }

    @DeleteMapping(path = "/{ISBN}")
    public void deleteBook(@PathVariable String ISBN){
        this.bookService.deleteBook(ISBN);
    }
}
