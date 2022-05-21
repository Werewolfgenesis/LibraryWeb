package books.system.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import books.system.demo.model.Book;

@Component
@Repository
public interface BookRepo extends CrudRepository<Book, String> {
}
