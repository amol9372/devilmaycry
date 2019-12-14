import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { filter, map } from 'rxjs/operators';
import { Place } from './search/beans/PlaceModel';
import { Observable } from 'rxjs';
//import { map } from 'rxjs/Rx';

@Injectable()
export class SearchService {

  constructor(private _http: Http) { }

  getPlaceList() {
    return this._http.get('http://localhost:8091/geocode/getCityList').pipe(map((response: any) => response.json()));
  }

  getEncryptedIteams() {
    return this._http.get('http://localhost:8091/geocode/getEncryptedItems');
  }

}