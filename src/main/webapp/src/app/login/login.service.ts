import { Injectable, OnInit} from '@angular/core';
import {Http} from "@angular/http";

@Injectable()
export class LoginService implements OnInit {

  constructor(private http : Http) { }

  ngOnInit() {
  }


    login (auth: object) {
      return this.http.post('/api/auth', auth);
    }

}
