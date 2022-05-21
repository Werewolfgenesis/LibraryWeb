package books.system.demo.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Books")
public class Book {
    @Id
    @Column(name = "ISBN", nullable = false)
    private String ISBN;
    @Column(name = "Author", nullable = true)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Author", nullable = true)
    private Author author;
    @Column(name = "Genre", nullable = true)
    private String genre;
    @Column(name = "Title", nullable = false)
    private String title;

}
