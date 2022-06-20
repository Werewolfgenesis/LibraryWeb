package books.system.demo.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

import books.system.demo.dtos.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@Entity
// @Setter
@Table(name = "Users")
public class User {
    @Id
    private String username;

    @Column(name = "Password", nullable = false)
    private String password;

    @OneToOne(targetEntity = BookCollection.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "name")
    private BookCollection collectionBooks;

    @Transient
    private Map<Book, String> notes;
}
