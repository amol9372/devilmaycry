import { Component, OnInit } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { City } from './beans/city';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  citiesList: City[] = [];
  stateCtrl = new FormControl();
  filteredStates: Observable<City[]>;

  constructor(private searchService: SearchService) {
    this.filteredStates = this.stateCtrl.valueChanges
      .pipe(
        startWith(''),
        map(city => city ? this._filterStates(city) : this.citiesList.slice())
      );
  }

  ngOnInit() {
    this.searchService.getCitiesList().subscribe( (data: City[]) => {
       this.citiesList = data;
    });
  }

  private _filterStates(value: string): City[] {
    const filterValue = value.toLowerCase();

    return this.citiesList.filter(city => city.city.toLowerCase().indexOf(filterValue) === 0);
  }
}
