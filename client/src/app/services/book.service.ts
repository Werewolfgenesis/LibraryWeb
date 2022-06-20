import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Book } from '../model/Book';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  constructor(private readonly http: HttpClient) {}

  getBook(isbn: string): Observable<Book> {
    return this.http.get<Book>(`${environment.restApi}/books/${isbn}`);
  }

  createBook(book: Book): Observable<Book> {
    return this.http.post<Book>(`${environment.restApi}/books`, book);
  }

  deleteBook(isbn: string) {
    this.http.delete<Book>(`${environment.restApi}/books/${isbn}`);
  }

  updateBook(book: Book): Observable<Book> {
    return this.http.put<Book>(`${environment.restApi}/books`, book);
  }
}
