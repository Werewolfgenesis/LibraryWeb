package books.system.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import books.system.demo.model.Note;

@Repository
public interface NoteRepo extends CrudRepository<Note, String> {
}
