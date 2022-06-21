import {Component, HostListener, OnInit} from '@angular/core';
import {Book} from "../../model/Book";
import {finalize} from "rxjs";
import {BookService} from "../../services/book.service";

@Component({
  selector: 'app-books-card-list',
  templateUrl: './books-card-list.component.html',
  styleUrls: ['./books-card-list.component.css'],
})
export class BooksCardListComponent implements OnInit {
  books: Book[];

  // TODO: think if we can separate this in another component
  searchText: string;
  loading = false;

  @HostListener('input') oninput() {
    this.searchBooks();
  }

  constructor(private readonly bookService: BookService) {
    this.getAllBooks();
  }

  gridColumns = 3;

  toggleGridColumns() {
    this.gridColumns = this.gridColumns === 3 ? 4 : 3;
  }

  ngOnInit(): void {
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
    if (!this.searchText)
      this.ngOnInit();

    this.books = this.books.filter(book => {

      return book.isbn.toLowerCase().match(this.searchText.toLowerCase()) ||
        book.title.toLowerCase().match(this.searchText.toLowerCase()) ||
        book.author.toLowerCase().match(this.searchText.toLowerCase());
    })
  }
}
