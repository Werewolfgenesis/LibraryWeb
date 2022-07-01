import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, tap } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ValidatedUser } from '../model/ValidatedUser';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private readonly http: HttpClient) {}

  readonly loggedIn: Subject<boolean> = new BehaviorSubject<boolean>(
    sessionStorage.getItem('token') !== null
  );

  login(username: string, password: string): Observable<ValidatedUser> {
    return this.http
      .post<ValidatedUser>(`${environment.restApi}/login`, {
        username: username,
        password: password,
      })
      .pipe(tap(() => this.loggedIn.next(true)));
  }

  logout() {
    sessionStorage.clear();
    this.loggedIn.next(false);
  }

  loginStatusChange(): Observable<boolean> {
    return this.loggedIn.asObservable();
  }
}
