import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { BookService } from 'src/app/services/book.service';
import { Book } from '../../model/Book';
import { Note } from "../../model/Note";
import {AddNoteComponent} from "../add-note/add-note.component";
import {MatDialog} from "@angular/material/dialog";

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
  contentModel: String;
  notes: Note[];

  constructor(
    private activatedRoute: ActivatedRoute,
    private readonly bookService: BookService,
    public dialog: MatDialog,
  ) {
    this.isbn = this.activatedRoute.snapshot.paramMap.get('isbn') || '';
    this.getBook(this.isbn);

    this.contentModel = '';

    const defaultNote: Note = {
      content : 'This is a content which is bla bla sample',
    };

    this.notes = [ defaultNote, defaultNote, defaultNote ];
  }

  getBook(isbn: string) {
    this.bookService.getBook(isbn).subscribe((response) => {
      if (response) {
        this.selectedBook = response;
        console.log(this.selectedBook.author);
      }
    });
  }

  deleteBook() {
    this.bookService.deleteBook(this.selectedBook.isbn);
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AddNoteComponent, {
      data: { isbn: this.selectedBook.isbn },
      width: '400px',
    });

    dialogRef.afterClosed().subscribe(() => {
      console.log('The dialog was closed');
    });
  }
}
