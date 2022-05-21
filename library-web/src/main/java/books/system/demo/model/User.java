package books.system.demo.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import books.system.demo.dtos.UserDto;
import lombok.Data;

@Data
@Entity
// @Setter
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "Username", nullable = false)
    private String username;
    @Column(name = "Password", nullable = false)
    private String password;
    @Transient
    private Map<Book, String> notes;
    @OneToOne(targetEntity = BookCollection.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "name")
    private BookCollection collectionBooks;

    public User() {
        this.username = " ";
        this.password = " ";
        this.notes = new HashMap<>();
        this.collectionBooks = new BookCollection();
    }

    public UserDto convert() {
        return new UserDto(this.username, this.password, this.notes, this.collectionBooks);
    }
}
