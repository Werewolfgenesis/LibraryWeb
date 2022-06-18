package books.system.demo.convertions;

import books.system.demo.dtos.BookDto;
import books.system.demo.dtos.UserDto;
import books.system.demo.model.Book;
import books.system.demo.model.User;

//Utility class to be used when converting objects.
public class Convertions {
    private Convertions() {
        // No instances are to be made of this class.
    }

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
}
