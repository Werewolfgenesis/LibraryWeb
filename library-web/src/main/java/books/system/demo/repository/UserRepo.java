package books.system.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import books.system.demo.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, String> {
}
