import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AddBookComponent } from './components/add-book/add-book.component';
import { AddNoteComponent } from './components/add-note/add-note.component';
import { BooksCardListComponent } from './components/books-card-list/books-card-list.component';
import { BooksListComponent } from './components/books-list/books-list.component';
import { CanvasComponent } from './components/canvas/canvas.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginUserComponent } from './components/login-user/login-user.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { SearchComponent } from './components/search/search.component';
import { ViewBookComponent } from './components/view-book/view-book.component';
import { ViewUserComponent } from './components/view-user/view-user.component';
import { LoginGuard } from './core/guards/login-guard/login.guard';
import { AuthInterceptor } from './core/interceptors/auth-interceptor';
import { MaterialModule } from './material/material.module';
import { EditBookComponent } from './components/edit-book/edit-book.component';
import { HashLocationStrategy, LocationStrategy } from "@angular/common";
const routes: Routes = [
  {
    path: '',
    redirectTo: 'books',
    pathMatch: 'full',
  },
  {
    path: 'books',
    component: BooksListComponent,
  },
  {
    path: 'books-cards',
    component: BooksCardListComponent,
  },
  {
    path: 'books/:isbn',
    component: ViewBookComponent,
  },
  {
    path: 'register',
    component: RegisterUserComponent,
    canActivate: [LoginGuard],
  },
  {
    path: 'login',
    component: LoginUserComponent,
    canActivate: [LoginGuard],
  },
];

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    BooksListComponent,
    BooksCardListComponent,
    NavbarComponent,
    ViewBookComponent,
    AddBookComponent,
    SearchComponent,
    CanvasComponent,
    AddNoteComponent,
    RegisterUserComponent,
    LoginUserComponent,
    ViewUserComponent,
    EditBookComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
    FlexLayoutModule,
    ReactiveFormsModule,
  ],
  exports: [RouterModule],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    { provide: LocationStrategy, useClass: HashLocationStrategy },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
