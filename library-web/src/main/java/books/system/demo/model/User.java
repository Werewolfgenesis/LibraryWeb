package books.system.demo.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import books.system.demo.dtos.UserDto;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Setter
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "Username", nullable = false)
    private String username;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "Notes", nullable = true)
    private Map<Book, String> notes;
    @Column(name = "Lists", nullable = true)
    private BookCollection collectionBooks;

    public User() {
        this.notes = new HashMap<>();
        this.collectionBooks = new BookCollection();
    }

    public UserDto convert() {
        return new UserDto(this.username, this.password, this.notes, this.collectionBooks);
    }
}
