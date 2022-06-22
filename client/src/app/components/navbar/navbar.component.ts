import { Component, OnInit } from '@angular/core';
import {AddBookComponent} from "../add-book/add-book.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  selectedView: string;

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
    this.selectedView = localStorage.getItem('view') || 'table';
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AddBookComponent, {
      width: '400px',
    });

    dialogRef.afterClosed().subscribe(() => {
      console.log('The dialog was closed');
    });
  }

  selectView(view: string) : void {
    this.selectedView = view;
    localStorage.setItem('view', view);
  }
}
