import { Component, OnInit } from '@angular/core';
import { Book } from "../../model/Book";
import {ActivatedRoute, Params} from "@angular/router";
import { Subscription } from "rxjs";

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css']
})
export class ViewBookComponent implements OnInit {
  selectedBook: Book;
  routeSub: Subscription;
  isbn: string | null;

  constructor(private activatedRoute: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.routeSub = this.activatedRoute.params.subscribe((params: Params) => {
      if (params['isbn']) {
        this.isbn = params['isbn'];

        // TODO: uncomment this when u implemented the service, Mitkoo
        // let books = bookService.getBooks();
        // this.selectedBook=books.find(book => book.isbn === this.isbn);
      }
    });
  }
}
