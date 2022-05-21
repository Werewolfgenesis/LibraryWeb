package books.system.demo.repository;

import books.system.demo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Repository
public interface BookRepo extends CrudRepository<Book, String> { }

