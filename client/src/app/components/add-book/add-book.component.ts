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
  book: Book;
  constructor(
    private readonly dialogRef: MatDialogRef<AddBookComponent>,
    private readonly bookService: BookService
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    this.dialogRef.close();
  }

  addBook(isbn: string, title: string, author: string, genre: string) {
    this.loading = true;
    this.bookService
      .createBook({
        title,
        author,
        genre,
        isbn,
      })
      .pipe(
        finalize(() => {
          this.loading = false;
          this.dialogRef.close();
        })
      )
      .subscribe((response) => {
        console.log(response);
        if (response) {
          alert(`Book successfully created: ${response.title}`);
        }
      });
  }
}
