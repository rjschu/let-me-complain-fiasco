import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
@Injectable()
export class GeoService {
  constructor(private http: Http) { }
  getLocation(lat:number, lng:number):Promise<any> {
    return this.http.get('https://maps.googleapis.com/maps/api/geocode/json?latlng='+lat+','+lng+'&key=AIzaSyArXDiXNTb5Enn5tRZQwdr-MhYt5WAuQYg')
      .toPromise()
      .then((response) => Promise.resolve(response.json()));
  }
}
