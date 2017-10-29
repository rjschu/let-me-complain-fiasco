
import {Injectable} from "@angular/core";
import {Headers, Http} from "@angular/http";

@Injectable()
export class NewComplaintService {


  constructor(private http : Http) {
  }

  submitComplaint(complaint: object) {
    let headers: Headers = new Headers();
    let auth: string = localStorage.getItem('authToken');
    headers.set('Authorization', auth);
    let config = {
      headers: headers
    };
    return this.http.post('/api/complaint', complaint, config);
  }
}
