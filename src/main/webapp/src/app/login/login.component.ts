import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {LoginService} from "./login.service";
import {MatDialog} from "@angular/material";
import {ReliantCaptchaComponent} from "../reliant-captcha/reliant-captcha.component";
import {Response} from "@angular/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;
  authFailed: boolean = false;
  twoFactor: boolean = false;
  twoFactorAuth: string;
  text: string;
  json: object;

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
            .subscribe((data: Response)=>{
                this.twoFactor = true;
                this.text = data.text();
                this.json = JSON.parse(atob(this.text.split('.')[1]));
              },
              () => {this.authFailed = true;});
        }
      });
    }

    checkAuth () {
      this.loginService
        .checkAuth({telephoneNumber: JSON.parse(this.json['sub']).telephoneNumber, code: this.twoFactorAuth, emailAddress: this.email}, this.text)
        .subscribe(() => {
          this.router.navigate(["new-complaint"]);
        },
          () => {this.authFailed = true;});
    }

    goToNewUser () {
        this.router.navigate(["new-user"]);
    }

}
