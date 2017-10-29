import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-reliant-captcha',
  templateUrl: './reliant-captcha.component.html',
  styleUrls: ['./reliant-captcha.component.css']
})
export class ReliantCaptchaComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<ReliantCaptchaComponent>) { }

  ngOnInit() {
  }

  submitCaptcha(){
    this.dialogRef.close(true);
  }

}
