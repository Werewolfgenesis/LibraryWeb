import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private readonly http: HttpClient) {}

  getUser(username: string): Observable<User> {
    return this.http.get<User>(`${environment.restApi}/users/${username}`);
  }

  createUser(newUser: User): Observable<User> {
    return this.http.post<User>(`${environment.restApi}/users`, newUser);
  }

  updateUser(updatedUser: User): Observable<User> {
    return this.http.put<User>(`${environment.restApi}/users`, updatedUser);
  }

  deleteUser(username: string) {
    return this.http.delete<User>(`${environment.restApi}/users`, username);
  }
}
