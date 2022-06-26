import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { finalize, Subscription } from 'rxjs';
import { BookService } from 'src/app/services/book.service';
import { Book } from '../../model/Book';
import { Note } from '../../model/Note';
import { AddNoteComponent } from '../add-note/add-note.component';

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
    public dialog: MatDialog
  ) {
    this.isbn = this.activatedRoute.snapshot.paramMap.get('isbn') || '';
    this.getBook(this.isbn);

    const defaultNote: string = 'This is a test default note';

    this.notes = [defaultNote];
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

  addNote() {
    if (this.newNote)
      this.notes.push(this.newNote);
  }

  removeNote(note: string) {
    this.notes.splice(this.notes.indexOf(note), 1);
  }
}
