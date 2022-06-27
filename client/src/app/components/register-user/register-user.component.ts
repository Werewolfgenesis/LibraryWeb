import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { finalize } from 'rxjs';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css'],
})
export class RegisterUserComponent implements OnInit {
  passwordRegex =
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

  passwordFormControl = new FormControl('', [
    Validators.required,
    Validators.pattern(this.passwordRegex),
  ]);

  loading = false;
  constructor(private readonly userService: UserService) {}

  ngOnInit(): void {}

  registerUser(username: string, password: string, passwordConfirm: string) {
    if (password === passwordConfirm) {
      this.loading = true;
      this.userService
        .createUser({
          username: username,
          password: password,
          books: [],
        })
        .pipe(finalize(() => (this.loading = false)))
        .subscribe();
    }
  }
}
