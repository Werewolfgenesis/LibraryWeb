package books.system.demo.dtos;

import java.util.Map;

import books.system.demo.model.Book;
import books.system.demo.model.BookCollection;
import books.system.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    private final String username;
    private final String password;
    private final Map<Book, String> notes;
    private final BookCollection lists;

    public static User toEntity(final UserDto userDto) {
        final User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setNotes(userDto.getNotes());
        user.setCollectionBooks(userDto.lists);

        return user;
    }
}
