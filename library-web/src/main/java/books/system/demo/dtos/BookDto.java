package books.system.demo.dtos;

import books.system.demo.model.Author;
import books.system.demo.model.Book;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Getter
public class BookDto {
    @NotEmpty(message = "Title must not be empty")
    public String title;

    @NotEmpty(message = "ISBN must not be empty")
    public String ISBN;

    @NotEmpty(message = "Genre must not be empty")
    public String genre;

    @NotEmpty(message = "Author must not be empty")
    public Author author;

    public BookDto() {}

    public static Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setGenre(bookDto.getGenre());

        return book;
    }
}
