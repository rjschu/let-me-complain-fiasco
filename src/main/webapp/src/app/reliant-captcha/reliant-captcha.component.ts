import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-reliant-captcha',
  templateUrl: './reliant-captcha.component.html',
  styleUrls: ['./reliant-captcha.component.css']
})
export class ReliantCaptchaComponent implements OnInit {

  selectedImages: boolean[] = [];

  constructor(public dialogRef: MatDialogRef<ReliantCaptchaComponent>) { }

  ngOnInit() {
  }

  selectImage(correctImage : boolean){

    this.selectedImages.push(correctImage);

    if(this.selectedImages.length == 3){
      if(this.selectedImages[0] == true && this.selectedImages[1] == true && this.selectedImages[2] == true){
        this.dialogRef.close(true);
      }
      else{
        this.dialogRef.close(false);
      }
    }

  }

}
