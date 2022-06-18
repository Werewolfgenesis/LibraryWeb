package books.system.demo.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ISBN", nullable = false)
    private String ISBN;
    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "Author", referencedColumnName = "id")
    private Author author;
    @Column(name = "Genre", nullable = true)
    private String genre;
    @Column(name = "Title", nullable = false)
    private String title;
}
