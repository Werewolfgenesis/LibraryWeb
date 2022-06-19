import { Component, OnInit } from '@angular/core';
import {AddBookComponent} from "../add-book/add-book.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
    this
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AddBookComponent, {
      width: '400px',
    });

    dialogRef.afterClosed().subscribe(() => {
      console.log('The dialog was closed');
    });
  }
}
