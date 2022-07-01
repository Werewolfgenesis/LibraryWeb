import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})

/**
 *  Guard used to check if a user is trying to access Login/Register while already logged in.
 */
export class LoginGuard implements CanActivate {
  constructor(
    private readonly router: Router,
    private readonly _snackBar: MatSnackBar
  ) {}
  /**
   * Checks if the user can access the guarded resource.
   *
   * @returns A boolean value indicating if the user can be allowed to access the resource.
   */
  canActivate(): boolean {
    const isAuthenticated = sessionStorage.getItem('token') !== null;
    if (isAuthenticated) {
      this.router.navigate(['']);
      this._snackBar.open("You're already logged in!", 'X', {
        duration: 5000,
      });
    }
    return !isAuthenticated;
  }
}
