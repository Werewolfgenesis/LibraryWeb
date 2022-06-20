package books.system.demo.model;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "book_collection")
public class BookCollection {
    @Id
    private String name;

    @OneToMany(targetEntity = Book.class, mappedBy = "ISBN", cascade = CascadeType.ALL)
    private List<Book> books;
}
