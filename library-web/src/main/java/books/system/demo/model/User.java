package books.system.demo.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

import books.system.demo.dtos.UserDto;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
// @Setter
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
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


}
