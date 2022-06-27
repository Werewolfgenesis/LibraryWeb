package books.system.demo.dtos;

import books.system.demo.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {
    @NotEmpty(message = "Note must not be empty")
    public String note;

    @NotEmpty(message = "Book must not be empty")
    public Book book;
}
