import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { filter, map } from 'rxjs/operators';
import { City } from './search/beans/city';
import { Observable } from 'rxjs';
//import { map } from 'rxjs/Rx';

@Injectable()
export class SearchService {

constructor(private _http: Http) { }

getCountryList() {
    return this._http.get('http://localhost:8091/geocode/getCountryList').pipe(map((response: any) => response.json()));
}
getCitiesList() {
    return this._http.get('http://localhost:8091/geocode/getCityList').pipe(map((response: any) => response.json()));
}

}