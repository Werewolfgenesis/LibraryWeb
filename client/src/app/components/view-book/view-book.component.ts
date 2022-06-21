import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { BookService } from 'src/app/services/book.service';
import { Book } from '../../model/Book';

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

  constructor(
    private activatedRoute: ActivatedRoute,
    private readonly bookService: BookService
  ) {
    this.isbn = this.activatedRoute.snapshot.paramMap.get('isbn') || '';
    this.getBook(this.isbn);
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
}
