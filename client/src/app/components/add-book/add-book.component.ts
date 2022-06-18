import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from "@angular/material/dialog";

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  constructor(public dialogRef: MatDialogRef<AddBookComponent>) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.dialogRef.close();
  }
}
