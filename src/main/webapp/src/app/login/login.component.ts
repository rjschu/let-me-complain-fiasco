import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {LoginService} from "./login.service";

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
              private loginService: LoginService) { }

  ngOnInit() {
  }


    login () {
        this.loginService.login({emailAddress: this.email, password: this.password})
          .subscribe((data)=>{
            console.log(data);
            //this.router.navigate(["new-complaint"]);
          },
            () => {this.authFailed = true;});
    }

    goToNewUser () {
        this.router.navigate(["new-user"]);
    }

}
