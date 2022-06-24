import { Component, HostListener, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { finalize } from 'rxjs';
import { BookService } from 'src/app/services/book.service';
import { Book } from '../../model/Book';

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css'],
})
export class BooksListComponent implements OnInit {
  books: Book[] = [];
  displayedColumns: string[] = ['isbn', 'title', 'author', 'genre'];
  clickedBooks = new Set<Book>();

  // TODO: think if we can separate this in another component
  searchText: string;
  previousBooks: string;
  loading = false;

  @HostListener('input') oninput() {
    this.searchBooks();
  }

  dataSource: MatTableDataSource<Book> = new MatTableDataSource(this.books);
  @ViewChild(MatSort, { static: false }) set content(sort: MatSort) {
    this.dataSource.sort = sort;
  }

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private readonly bookService: BookService) {
    this.getAllBooks();
  }

  ngOnInit(): void {
    this.getAllBooks();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
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
          this.dataSource.data = this.books;
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
