import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Note} from "../model/Note";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  constructor(private readonly http: HttpClient) { }

  getNote(isbn: string): Observable<Note> {
    return this.http.get<Note>(`${environment.restApi}/notes/${isbn}`);
  }

  createNote(note: Note): Observable<Note> {
    console.log(note);
    return this.http.post<Note>(`${environment.restApi}/notes`, note);
  }

  getAllNotes(): Observable<Note[]> {
    return this.http.get<Note[]>(`${environment.restApi}/notes`);
  }

  updateNote(isbn: string, updatedNote: Note): Observable<Note> {
    return this.http.put<Note>(
      `${environment.restApi}/notes/${isbn}`,
      updatedNote
    );
  }

  deleteNote(note: string) {
    return this.http.delete(`${environment.restApi}/notes/${note}`);
  }
}
