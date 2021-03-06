package books.system.demo.model;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Books")
public class Book {
    @Id
    private String ISBN;

    @Column(name = "Author", nullable = false)
    private String author;

    @Column(name = "Genre", nullable = true)
    private String genre;

    @Column(name = "Title", nullable = false)
    private String title;
}
