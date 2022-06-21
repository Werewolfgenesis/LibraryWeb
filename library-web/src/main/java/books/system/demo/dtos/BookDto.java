package books.system.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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
