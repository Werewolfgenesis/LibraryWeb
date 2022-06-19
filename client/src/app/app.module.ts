import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from "./material/material.module";
import { HomePageComponent } from './components/home-page/home-page.component';
import { BooksListComponent } from './components/books-list/books-list.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ViewBookComponent } from './components/view-book/view-book.component';
import { AddBookComponent } from './components/add-book/add-book.component';
import { HttpClientModule } from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";
import { SearchComponent } from './components/search/search.component';
import { BooksCardListComponent } from "./components/books-card-list/books-card-list.component";

const routes: Routes = [
  {
    path: '', redirectTo: 'books', pathMatch: 'full'
  },
  {
    path: 'books', component: BooksListComponent
  },
  {
    path: 'books-cards', component: BooksCardListComponent
  },
  {
    path: 'books/:isbn', component: ViewBookComponent
  }
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
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
  ],
  exports: [
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
