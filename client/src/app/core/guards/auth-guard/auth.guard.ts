import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
} from '@angular/router';

@Injectable({
  providedIn: 'root',
})
/**
 *  Guard used to check if a user is trying to access a secured resource while not logged in.
 */
export class AuthGuard implements CanActivate {
  constructor(
    private readonly router: Router,
    private readonly _snackBar: MatSnackBar
  ) {}

  /**
   * Checks if the user can access the guarded resource.
   *
   * @returns A boolean value indicating if the user can be allowed to access the resource.
   */
  canActivate(
    _route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    const isAuthenticated = sessionStorage.getItem('token') !== null;
    if (!isAuthenticated) {
      sessionStorage.setItem('redirectAfterLogin', state.url);
      sessionStorage.setItem(
        'redirectAfterLoginIdentifier',
        this.getIdentifier(state.url)
      );
      this.router.navigate(['/login']);
      this._snackBar.open('You need to login to view this resource', 'X', {
        duration: 5000,
      });
    }
    return isAuthenticated;
  }

  getIdentifier(url: string): string {
    return url.split('/')[1];
  }
}
