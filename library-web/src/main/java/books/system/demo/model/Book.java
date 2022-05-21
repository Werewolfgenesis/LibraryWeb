package books.system.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String author;
    @Column(name = "Genre", nullable = true)
    private String genre;
    @Column(name = "Title", nullable = false)
    private String title;

}
