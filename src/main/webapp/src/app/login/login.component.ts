import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {LoginService} from "./login.service";
import {MatDialog} from "@angular/material";
import {ReliantCaptchaComponent} from "../reliant-captcha/reliant-captcha.component";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;
  authFailed: boolean = false;

  constructor(private router: Router,
              private loginService: LoginService,
              public dialog: MatDialog) { }

  ngOnInit() {
  }


    login () {

      let dialogRef = this.dialog.open(ReliantCaptchaComponent, {
        width: '250px'
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        let passedCaptcha = result;

        if (passedCaptcha){
          this.loginService.login({emailAddress: this.email, password: this.password})
            .subscribe((data)=>{
                console.log(data);
                //this.router.navigate(["new-complaint"]);
              },
              () => {this.authFailed = true;});
        }
      });
    }

    goToNewUser () {
        this.router.navigate(["new-user"]);
    }

}
