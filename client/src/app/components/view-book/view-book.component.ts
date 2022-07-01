import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { finalize, Subscription } from 'rxjs';
import { BookService } from 'src/app/services/book.service';
import { Book } from '../../model/Book';
import { Note } from '../../model/Note';
import { AddNoteComponent } from '../add-note/add-note.component';
import {EditBookComponent} from "../edit-book/edit-book.component";

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
    private readonly router: Router
  ) {
    this.isbn = this.activatedRoute.snapshot.paramMap.get('isbn') || '';
    this.getBook(this.isbn);

    const defaultNote: string = 'This is a test default note';

    this.notes = [defaultNote];
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

  addNote() {
    if (this.newNote) this.notes.push(this.newNote);
  }

  removeNote(note: string) {
    this.notes.splice(this.notes.indexOf(note), 1);
  }
}
