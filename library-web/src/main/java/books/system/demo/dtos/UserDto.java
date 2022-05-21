package books.system.demo.dtos;

import java.util.Map;

import books.system.demo.model.Book;
import books.system.demo.model.BookCollection;
import books.system.demo.model.User;
import lombok.Getter;

@Getter
// @AllArgsConstructor
public class UserDto {
    private final String username;
    private final String password;
    private Map<Book, String> notes;
    private BookCollection lists;

    /**
     * @param username
     * @param password
     */
    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @param username
     * @param password
     * @param notes
     * @param lists
     */
    public UserDto(String username, String password, Map<Book, String> notes, BookCollection lists) {
        this.username = username;
        this.password = password;
        this.notes = notes;
        this.lists = lists;
    }

    public User toEntity(final UserDto userDto) {
        final User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setNotes(userDto.getNotes());
        user.setCollectionBooks(userDto.lists);

        return user;
    }
}
