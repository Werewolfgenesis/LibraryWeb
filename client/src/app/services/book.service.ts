import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Book } from '../model/Book';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  constructor(private readonly http: HttpClient) {}

  getUser(isbn: string): Observable<Book> {
    return this.http.get<Book>(`${environment.restApi}/books/${isbn}`);
  }

  createBook(newBook: Book): Observable<Book> {
    return this.http.post<Book>(`${environment.restApi}/books`, newBook);
  }

  updateBook(updatedBook: Book): Observable<Book> {
    return this.http.put<Book>(`${environment.restApi}/books`, updatedBook);
  }

  deleteBook(isbn: string) {
    return this.http.delete<Book>(`${environment.restApi}/books/${isbn}`);
  }
}
