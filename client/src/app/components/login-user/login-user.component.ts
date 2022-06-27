import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {finalize} from "rxjs";

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

  passwordRegex =
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

  passwordFormControl = new FormControl('', [
    Validators.required,
    Validators.pattern(this.passwordRegex),
  ]);

  loading = false;
  constructor(private readonly userService: UserService) {}

  ngOnInit(): void {}

  loginUser(username: string, password: string) {
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
