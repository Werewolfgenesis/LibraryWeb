package books.system.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
public class User {
    private Map<Book, String> notes;
    private List<BookCollection> lists;

}
