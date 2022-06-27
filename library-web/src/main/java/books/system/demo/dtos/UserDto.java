package books.system.demo.dtos;

import java.util.Map;

import books.system.demo.model.Book;
import books.system.demo.model.BookCollection;
import books.system.demo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull
    @NotEmpty
    public String username;

    @NotEmpty
    public String password;

    @JsonIgnore
    public Map<Book, String> notes;

    @JsonIgnore
    public BookCollection lists;
}
