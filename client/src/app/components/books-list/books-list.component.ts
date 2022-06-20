import {Component, HostListener, OnInit} from '@angular/core';
import { Book } from "../../model/Book";
// @ts-ignore
import booksData from "../../../assets/mock-data.json";

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css']
})
export class BooksListComponent implements OnInit {
  books: Book[];
  displayedColumns: string[] = ['isbn', 'title', 'author', 'published', 'pages', 'description'];
  clickedBooks = new Set<Book>();

  // TODO: think if we can separate this in another component
  searchText: string;
  previousBooks: string;

  @HostListener('input') oninput() {
    this.searchBooks();
  }

  constructor() {
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
