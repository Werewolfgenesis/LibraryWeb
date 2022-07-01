import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { finalize } from 'rxjs';
import { User } from 'src/app/model/User';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css'],
})
export class ViewUserComponent {
  user: User | undefined;
  loading = false;
  constructor(
    private readonly userService: UserService,
    private route: ActivatedRoute
  ) {
    const username = route.snapshot.paramMap.get('username') || '';
    this.getUser(username);
  }

  getUser(username: string) {
    this.loading = true;
    this.userService
      .getUser(username)
      .pipe(finalize(() => (this.loading = false)))
      .subscribe((foundUser) => {
        if (foundUser) {
          console.log(foundUser);
          this.user = foundUser;
        }
      });
  }
}
