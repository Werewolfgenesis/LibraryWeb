package books.system.demo.controller;

import books.system.demo.convertions.Conversions;
import books.system.demo.dtos.NoteDto;
import books.system.demo.model.Note;
import books.system.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "library/notes")
public class NotesRestController {
    @Autowired
    private NoteService service;

    @GetMapping()
    @CrossOrigin
    public ResponseEntity<List<NoteDto>> allNotes() {
        List<Note> allNotes = this.service.getAllNotes();
        return new ResponseEntity<>(allNotes
                .stream()
                .map(Conversions::convertNoteToDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }


    @PostMapping(consumes = {"application/json"})
    @CrossOrigin
    public ResponseEntity<NoteDto> createNote(@RequestBody NoteDto newNote) {
        return new ResponseEntity<>(this.service.addNote(Conversions.convertDtoToNote(newNote)),
                HttpStatus.OK);
    }

    @PutMapping()
    @CrossOrigin
    public ResponseEntity<NoteDto> updateNote(@RequestBody NoteDto newNote) {
        return new ResponseEntity<>(this.service.updateNote(Conversions.convertDtoToNote(newNote)),
                HttpStatus.OK);
    }

    @DeleteMapping(path = "/{note}")
    @CrossOrigin
    public void deleteNote(@PathVariable String note) {
        this.service.deleteNote(note);
    }
}
