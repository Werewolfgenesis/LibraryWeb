package books.system.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Book {
    private String author;
    private String genre;
    private String title;
    private String ISBN;

}
