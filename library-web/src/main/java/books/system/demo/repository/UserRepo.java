package books.system.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import books.system.demo.model.User;

@Component
@Repository
public interface UserRepo extends CrudRepository<User, String> {
}
