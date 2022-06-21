import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { finalize } from 'rxjs';
import { NewBook } from 'src/app/model/Book';
import { BookService } from 'src/app/services/book.service';
@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css'],
})
export class AddBookComponent implements OnInit {
  loading = false;
  book: NewBook;
  constructor(
    private readonly dialogRef: MatDialogRef<AddBookComponent>,
    private readonly bookService: BookService
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    //this.addBook();
    this.dialogRef.close();
  }
  //title, author, genre
  addBook(title2: string, author2: string, genre2: string, isbn2: string) {
    this.loading = true;
    this.book.title = title2;
    this.book.author = author2;
    this.book.genre = genre2;
    this.book.isbn = isbn2;
    console.log(title2 + ' ' + author2 + +isbn2);
    this.bookService
      .createBook(this.book)
      .pipe(
        finalize(() => {
          this.loading = false;
          this.dialogRef.close();
        })
      )
      .subscribe((response) => {
        console.log(response);
        if (response) {
          alert('Book successfully created: ' + response.title);
        }
      });
  }
}
