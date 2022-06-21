import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Book, NewBook } from '../model/Book';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  constructor(private readonly http: HttpClient) {}

  getBook(isbn: string): Observable<Book> {
    return this.http.get<Book>(`${environment.restApi}/books/${isbn}`);
  }

  createBook(newBook: NewBook): Observable<NewBook> {
    return this.http.post<NewBook>(`${environment.restApi}/books`, newBook);
  }

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`${environment.restApi}/books`);
  }

  updateBook(updatedBook: Book): Observable<Book> {
    return this.http.put<Book>(`${environment.restApi}/books`, updatedBook);
  }

  deleteBook(isbn: string) {
    return this.http.delete<Book>(`${environment.restApi}/books/${isbn}`);
  }
}
