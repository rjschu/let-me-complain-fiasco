import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {NewUserService} from "./new-user.service";
import {User} from "../domain/User";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit {

  user: User = new User();
  form;

  constructor(private router: Router,
              private userService: NewUserService,
              private datePipe: DatePipe) { }

  ngOnInit() {
  }

  register () {
    this.user.dateOfBirth = this.datePipe.transform(this.user.dateOfBirth, 'dd/MM/yyyy');
    this.userService.createUser(this.user).subscribe(() => {
      this.router.navigate(['login']);
    })
  }

  cancel () {
      this.router.navigate(['login']);
  }

    genders = [
        {value: 'male', viewValue: 'Male'},
        {value: 'female', viewValue: 'Female'}
    ];
}
