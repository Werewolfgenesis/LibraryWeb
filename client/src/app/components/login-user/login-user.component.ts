import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { finalize } from 'rxjs';
import { ValidatedUser } from 'src/app/model/ValidatedUser';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css'],
})
export class LoginUserComponent {
  passwordRegex =
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

  passwordFormControl = new FormControl('', [
    Validators.required,
    Validators.pattern(this.passwordRegex),
  ]);

  loading = false;
  constructor(
    private readonly loginService: LoginService,
    private readonly router: Router
  ) {}

  loginUser(username: string, password: string) {
    this.loading = true;
    this.loginService
      .login(username, password)
      .pipe(finalize(() => (this.loading = false)))
      .subscribe((response) => {
        if (response) {
          this.successfulLogin(response);
        }
      });
  }

  successfulLogin(user: ValidatedUser) {
    sessionStorage.setItem('token', user.jwt);
    sessionStorage.setItem('identifier', user.username);

    if (this.redirectMatchesUser(user.username)) {
      this.router.navigate([sessionStorage.getItem('redirectAfterLogin')]);
      sessionStorage.removeItem('redirectAfterLogin');
    }
  }

  redirectMatchesUser(identifier: string): boolean {
    return (
      sessionStorage.getItem('redirectAfterLogin') !== null &&
      sessionStorage.getItem('redirectAfterLoginIdentifier') === identifier
    );
  }
}
