package books.system.demo.service;

import books.system.demo.dtos.NoteDto;
import books.system.demo.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNote(String note);
    NoteDto addNote(Note note);
    NoteDto updateNote(Note note);
    void deleteNote(String note);
}
