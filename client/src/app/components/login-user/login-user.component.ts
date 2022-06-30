import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { finalize } from 'rxjs';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css'],
})
export class LoginUserComponent implements OnInit {
  passwordRegex =
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

  passwordFormControl = new FormControl('', [
    Validators.required,
    Validators.pattern(this.passwordRegex),
  ]);

  loading = false;
  constructor(private readonly loginService: LoginService) {}

  ngOnInit(): void {}

  loginUser(username: string, password: string) {
    this.loading = true;
    this.loginService
      .login(username, password)
      .pipe(finalize(() => (this.loading = false)))
      .subscribe();
  }
}
