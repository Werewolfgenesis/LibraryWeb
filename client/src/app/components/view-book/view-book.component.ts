import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { finalize, Subscription } from 'rxjs';
import { BookService } from 'src/app/services/book.service';
import { Book } from '../../model/Book';
import { EditBookComponent } from "../edit-book/edit-book.component";
import { Note } from '../../model/Note';
import {NoteService} from "../../services/note.service";

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css'],
})
export class ViewBookComponent {
  selectedBook: Book;
  routeSub: Subscription;
  isbn = '';
  bookAuthorName = '';
  notes: string[];
  newNote: string;
  loading = false;

  constructor(
    private activatedRoute: ActivatedRoute,
    private readonly bookService: BookService,
    public dialog: MatDialog,
    private readonly router: Router,
    private readonly noteService: NoteService,
  ) {
    this.isbn = this.activatedRoute.snapshot.paramMap.get('isbn') || '';
    this.getBook(this.isbn);
    this.notes = [];
  }

  ngOnInit(): void {
    this.getAllNotes();
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(EditBookComponent, {
      width: '400px',
      data: {
        isbn: this.isbn,
      }
    });

    dialogRef.afterClosed().subscribe(() => {
      console.log('The dialog was closed');
    });
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
    this.loading = true;
    this.bookService
      .deleteBook(this.selectedBook.isbn)
      .pipe(
        finalize(() => {
          this.loading = false;
          this.router.navigate([`books`]);
        })
      )
      .subscribe();
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
