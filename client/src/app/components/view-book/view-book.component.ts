import { Component, OnInit } from '@angular/core';
import {Book} from "../../model/Book";

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css']
})
export class ViewBookComponent implements OnInit {
  selectedBook?: Book;

  constructor() {
  }

  ngOnInit(): void {
  }

  onSelect(book: Book): void {
    this.selectedBook = book;
  }
}
