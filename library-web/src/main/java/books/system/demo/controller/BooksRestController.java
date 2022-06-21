package books.system.demo.controller;

import books.system.demo.convertions.Conversions;
import books.system.demo.dtos.BookDto;
import books.system.demo.model.Book;
import books.system.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/library/books")
public class BooksRestController {
    @Autowired
    private BookService bookService;

    @GetMapping()
    @CrossOrigin
    public ResponseEntity<List<BookDto>> allBooks() {
        List<Book> allBooks = this.bookService.getAllBooks();
        return new ResponseEntity<>(allBooks
                .stream()
                .map(Conversions::convertBookToDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    //@PostMapping(consumes = {"application/json; charset=utf8"})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto newBook)
            throws IllegalArgumentException{
        return new ResponseEntity<>(this.bookService.addBook(Conversions.convertDtoToBook(newBook)),
                HttpStatus.CREATED);
    }

    @PutMapping(consumes = {"application/json"})
    @CrossOrigin
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto)
            throws NoSuchElementException {
        return new ResponseEntity<>(this.bookService.updateBook(Conversions.convertDtoToBook(bookDto)),
                HttpStatus.OK);
    }

    @GetMapping("/{ISBN}")
    @CrossOrigin
    public ResponseEntity<BookDto> getBook(@PathVariable String ISBN)
            throws NoSuchElementException {
        Book found = bookService.getBook(ISBN);
        return new ResponseEntity<>(Conversions.convertBookToDto(found), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{ISBN}")
    @CrossOrigin
    public void deleteBook(@PathVariable String ISBN) {
        this.bookService.deleteBook(ISBN);
    }
}
