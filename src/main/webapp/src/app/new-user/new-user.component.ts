import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {NewUserService} from "./new-user.service";
import {User} from "../domain/User";

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit {

  user: User = new User();
  form;

  constructor(private router: Router,
              private userService: NewUserService) { }

  ngOnInit() {
  }

  register () {
    this.userService.createUser(this.user);
    this.router.navigate(['login']);
  }

  cancel () {
    this.register();
  }

    genders = [
        {value: 'male', viewValue: 'Male'},
        {value: 'female', viewValue: 'Female'}
    ];
}
