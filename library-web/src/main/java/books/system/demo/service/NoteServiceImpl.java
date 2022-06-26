package books.system.demo.service;

import books.system.demo.convertions.Conversions;
import books.system.demo.dtos.NoteDto;
import books.system.demo.model.Note;
import books.system.demo.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NoteServiceImpl implements NoteService {
    private static final String NOT_FOUND_MESSAGE = "Note was not found!";
    @Autowired
    private NoteRepo noteRepository;

    @Override
    public List<Note> getAllNotes() {
        LinkedList<Note> allNotes = new LinkedList<>();
        noteRepository.findAll().forEach(allNotes::add);
        return allNotes;
    }

    @Override
    public Note getNote(String note) {
        return noteRepository.findById(note).orElseThrow(() -> new NoSuchElementException(NOT_FOUND_MESSAGE));
    }

    @Override
    public NoteDto addNote(Note note) {
        boolean noteExists = noteRepository.existsById(note.getNote());
        if (noteExists) {
            throw new IllegalArgumentException(
                    String.format("%s already exists", note.getNote())
            );
        }

        noteRepository.save(note);
        return Conversions.convertNoteToDto(note);
    }

    @Override
    public NoteDto updateNote(Note note) {
        if (!noteRepository.existsById(note.getISBN())) {
            throw new NoSuchElementException(NOT_FOUND_MESSAGE);
        }

        noteRepository.save(note);
        return Conversions.convertNoteToDto(note);
    }

    @Override
    public void deleteNote(String note) {
        if (!noteRepository.existsById(note)) {
            throw new NoSuchElementException (NOT_FOUND_MESSAGE);
        }

        noteRepository.deleteById(note);
    }
}
