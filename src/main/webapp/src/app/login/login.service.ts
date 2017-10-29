import { Injectable, OnInit} from '@angular/core';
import {Headers, Http} from "@angular/http";
import {headersToString} from "selenium-webdriver/http";

@Injectable()
export class LoginService implements OnInit {

  constructor(private http : Http) { }

  ngOnInit() {
  }


    login (auth: object) {
      return this.http.post('/api/auth', auth);
    }

    checkAuth (code: object, token: string) {
    let headers: Headers = new Headers();
    headers.set('Authorization', token);
    let config = {
      headers: headers
    };
      return this.http.post('/api/two-factor', code, config);
    }
}
