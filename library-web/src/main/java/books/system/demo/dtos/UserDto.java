package books.system.demo.dtos;

import books.system.demo.model.Book;
import books.system.demo.model.BookCollection;
import books.system.demo.model.User;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class UserDto {
    private String username;
    private String password;
    private Map<Book, String> notes;
    private List<BookCollection> lists;

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setNotes(userDto.getNotes());
        user.setLists(userDto.getLists());

        return user;
    }
}
