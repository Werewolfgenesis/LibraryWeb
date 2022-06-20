import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { finalize } from 'rxjs';
import { Book } from 'src/app/model/Book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css'],
})
export class AddBookComponent implements OnInit {
  loading = false;
  constructor(
    private readonly dialogRef: MatDialogRef<AddBookComponent>,
    private readonly bookService: BookService
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    //this.addBook();
    this.dialogRef.close();
  }

  addBook(book: Book) {
    this.loading = true;
    this.bookService
      .createBook(book)
      .pipe(finalize(() => (this.loading = false)))
      .subscribe((response) => {
        if (response) {
          alert('Book successfully created: ' + response.title);
        }
      });
  }
}
