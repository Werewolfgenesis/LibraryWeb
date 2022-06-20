import {Component, HostListener, OnInit} from '@angular/core';
import {Book} from "../../model/Book";
// @ts-ignore
import booksData from '../../../assets/mock-data.json';

@Component({
  selector: 'app-books-card-list',
  templateUrl: './books-card-list.component.html',
  styleUrls: ['./books-card-list.component.css'],
})
export class BooksCardListComponent implements OnInit {
  books: Book[];

  // TODO: think if we can separate this in another component
  searchText: string;

  @HostListener('input') oninput() {
    this.searchBooks();
  }

  constructor() { }

  gridColumns = 3;

  toggleGridColumns() {
    this.gridColumns = this.gridColumns === 3 ? 4 : 3;
  }

  ngOnInit(): void {
    this.books = booksData;
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
