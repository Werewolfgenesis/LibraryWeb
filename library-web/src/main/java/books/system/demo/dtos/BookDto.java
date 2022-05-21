package books.system.demo.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class BookDto {
    @NotEmpty(message = "Title must not be empty")
    public String title;

    @NotEmpty(message = "ISBN must not be empty")
    public String ISBN;

    @NotEmpty(message = "Genre must not be empty")
    public String genre;

    @NotEmpty(message = "Author must not be empty")
    public String author;
}
