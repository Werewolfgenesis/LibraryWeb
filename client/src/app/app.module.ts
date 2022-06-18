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

const routes: Routes = [
  {
    path: '', redirectTo: 'books-list', pathMatch: 'full'
  },
  {
    path: 'books-list', component: BooksListComponent
  },
  {
    path: 'view-book', component: ViewBookComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    BooksListComponent,
    NavbarComponent,
    ViewBookComponent,
    AddBookComponent,
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
