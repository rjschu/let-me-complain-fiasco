import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import {User} from "../domain/User";

@Injectable()
export class NewUserService {

  constructor(private http: Http) { }

  createUser (user: User) {
    return this.http.post('/user', user);
  }
}
