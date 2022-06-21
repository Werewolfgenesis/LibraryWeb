import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Book } from 'src/app/model/Book';
import { BookService } from 'src/app/services/book.service';
import {finalize, Observable} from "rxjs";
import {HttpResponse} from "@angular/common/http";
import {Note} from "../../model/Note";
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

  protected onSaveSuccess(): void {
    console.log('success');
  }

  protected onSaveError(): void {
    console.log('error');
  }

  subscribeToSaveResponse(result: Observable<HttpResponse<Book>>): void {
    result.pipe().subscribe({
      next: () => this.onSaveSuccess(),
      error: () => this.onSaveError(),
    });
  }

  addBook(isbn: string, title: string, author: string, genre: string, notes: Note[]) {
    this.loading = true;
    this.subscribeToSaveResponse(this.bookService.createBook({isbn, title, author, genre, notes}));
  }
}
