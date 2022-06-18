import { Component, OnInit } from '@angular/core';
import { Book } from "../../model/Book";
// @ts-ignore
import booksData from "../../../assets/mock-data.json";

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css']
})
export class BooksListComponent implements OnInit {
  books: Book[] = booksData;
  displayedColumns: string[] = ['isbn', 'title', 'author', 'published', 'pages', 'description'];
  clickedBooks = new Set<Book>();

  constructor() {
  }

  ngOnInit(): void {
  }
}
