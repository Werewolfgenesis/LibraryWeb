import { Component, HostListener, OnInit } from '@angular/core';
import { finalize } from 'rxjs';
import { BookService } from 'src/app/services/book.service';
import { Book } from '../../model/Book';

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css'],
})
export class BooksListComponent implements OnInit {
  books: Book[];
  displayedColumns: string[] = ['isbn', 'title', 'author'];
  clickedBooks = new Set<Book>();

  // TODO: think if we can separate this in another component
  searchText: string;
  previousBooks: string;
  loading = false;

  @HostListener('input') oninput() {
    this.searchBooks();
  }

  constructor(private readonly bookService: BookService) {
    this.getAllBooks();
  }

  ngOnInit(): void {
    this.getAllBooks();
  }

  getAllBooks() {
    this.loading = true;
    this.bookService
      .getAllBooks()
      .pipe(finalize(() => (this.loading = false)))
      .subscribe((response) => {
        if (response) {
          console.log(response);
          this.books = response;
        }
      });
  }

  searchBooks(): void {
    if (!this.searchText) this.ngOnInit();

    this.books = this.books.filter((book) => {
      return (
        book.isbn.toLowerCase().match(this.searchText.toLowerCase()) ||
        book.title.toLowerCase().match(this.searchText.toLowerCase()) ||
        book.author.toLowerCase().match(this.searchText.toLowerCase())
      );
    });
  }
}
