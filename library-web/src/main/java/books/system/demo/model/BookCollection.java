package books.system.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class BookCollection {
    private List<Book> books;
    private String name;


}
