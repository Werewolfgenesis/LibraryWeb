import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {BookService} from "../../services/book.service";
import {Book} from "../../model/Book";
import {finalize} from "rxjs";

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {
  loading = false;
  constructor(@Inject(MAT_DIALOG_DATA) public data: {isbn: string},
              private bookService: BookService,
              private readonly dialogRef: MatDialogRef<EditBookComponent>) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.dialogRef.close();
  }

  editBook(title: string, author: string, genre: string): void {
    this.loading = true;
    this.bookService.updateBook({
      isbn: this.data.isbn,
      title,
      author,
      genre,
    }).pipe(finalize(() => {
      this.loading = false;
      this.onSubmit();
    })).subscribe();
  }
}
