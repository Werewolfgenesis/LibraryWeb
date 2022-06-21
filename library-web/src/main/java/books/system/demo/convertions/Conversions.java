package books.system.demo.convertions;

import books.system.demo.dtos.BookDto;
import books.system.demo.dtos.UserDto;
import books.system.demo.model.Book;
import books.system.demo.model.User;
import lombok.experimental.UtilityClass;

//Utility class to be used when converting objects.
@UtilityClass
public class Conversions {

    public static UserDto convertUserToDto(User user) {
        return new UserDto(user.getUsername(), user.getPassword(),
                user.getNotes(), user.getCollectionBooks());
    }

    public static BookDto convertBookToDto(Book book){
        return new BookDto(book.getTitle(), book.getISBN(), book.getGenre(),book.getAuthor());
    }

    public static Book convertDtoToBook(BookDto bookDto){
        return new Book(bookDto.getISBN(), bookDto.getAuthor(), bookDto.getGenre(),bookDto.getTitle());
    }

    public static User userToEntity(final UserDto userDto) {
        final User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setNotes(userDto.getNotes());
        user.setCollectionBooks(userDto.getLists());

        return user;
    }
}
