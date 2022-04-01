package books.system.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    private Map<Book, String> notes;
    private List<BookCollection> lists;

    public User(){
        this.notes = new HashMap<>();
        this.lists = new ArrayList<>();
    }
}
