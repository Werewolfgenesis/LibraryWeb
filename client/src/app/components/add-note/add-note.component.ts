import {Component, Inject, OnInit} from '@angular/core';
import {Note} from "../../model/Note";
import {BookService} from "../../services/book.service";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";

@Component({
  selector: 'app-add-note',
  templateUrl: './add-note.component.html',
  styleUrls: ['./add-note.component.css']
})
export class AddNoteComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: {isbn: string}, private bookService: BookService) {
  }

  ngOnInit(): void {
  }

  addNote(isbn: string): void {
    console.log(isbn);
    const book = this.bookService.getBook(isbn);

    // TODO: ping updateBook rest endpoint to add notes
  }
}
