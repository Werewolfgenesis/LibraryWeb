import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { finalize, Subscription } from 'rxjs';
import { BookService } from 'src/app/services/book.service';
import { Book } from '../../model/Book';
import { Note } from '../../model/Note';
import {NoteService} from "../../services/note.service";

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css'],
})
export class ViewBookComponent {
  selectedBook: Book;
  isbn = '';
  notes: string[];
  newNote: string;
  loading = false;

  constructor(
    private activatedRoute: ActivatedRoute,
    private readonly bookService: BookService,
    private readonly noteService: NoteService,
    public dialog: MatDialog,
  ) {
    this.isbn = this.activatedRoute.snapshot.paramMap.get('isbn') || '';
    this.getBook(this.isbn);
    this.notes = [];
  }

  ngOnInit(): void {
    this.getAllNotes();
  }

  getBook(isbn: string) {
    this.loading = true;
    this.bookService
      .getBook(isbn)
      .pipe(
        finalize(() => {
          this.loading = false;
        })
      )
      .subscribe((response) => {
        if (response) {
          this.selectedBook = response;
          console.log(this.selectedBook.author);
        }
      });
  }

  deleteBook() {
    this.bookService.deleteBook(this.selectedBook.isbn).subscribe();
  }

  getAllNotes() {
    this.loading = true;
    this.noteService
      .getAllNotes()
      .pipe(finalize(() => (this.loading = false)))
      .subscribe((notesMap) => {
        if (notesMap) {
          const notes: string[] = [];
          for (const [_, note] of Object.entries(notesMap)) {
            if (note.book.isbn === this.isbn) {
              notes.push(note.note.valueOf());
            }
          }
          this.notes = notes;
        }
      });
  }

  addNote() {
    const noteDto: Note = {
      note: this.newNote,
      book: {
        isbn: this.isbn,
        title: this.selectedBook.title,
        author: this.selectedBook.author,
        genre: this.selectedBook.genre,
      }
    }

    this.loading = true;
    this.noteService.createNote(noteDto)
      .pipe(finalize(() => {
        this.loading = false;
      }))
      .subscribe();
  }

  removeNote(note: string) {
    this.noteService.deleteNote(note).subscribe();
  }
}
