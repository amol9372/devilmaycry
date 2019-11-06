import { Component, OnInit } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { Place } from './beans/PlaceModel';
import { SearchService } from '../search.service';
import { MatSelectChange } from '@angular/material/select';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  placeList: Place[] = [];
  countryList: string[] = [];
  citiesInCountryList: string[] = [];
  cityCtrl = new FormControl();
  countryCtrl = new FormControl();
  filteredCities: Observable<string[]>;
  filteredCountries: Observable<string[]>;

  constructor(private searchService: SearchService) {
  }

  ngOnInit() {
    this.searchService.getPlaceList().subscribe((data: Place[]) => {
      if (data) {
        this.placeList = data;
        this.countryList = this.placeList.map(place => place.country);
        const countrySet = new Set(this.countryList);
        this.countryList = [];
        countrySet.forEach(country => {
          this.countryList.push(country.toString());
        });

        this.filteredCountries = this.countryCtrl.valueChanges
          .pipe(
            startWith(''),
            map(country => country ? this.filterCountries(country) : this.countryList.slice())
          );
        
        this.filteredCities = this.cityCtrl.valueChanges
          .pipe(
            startWith(''),
            map(city => city ? this.filterCities(city) : this.citiesInCountryList.slice())
          );  
      }
    });
  }

  private filterCities(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.citiesInCountryList.filter(city => city.toLowerCase().indexOf(filterValue) === 0);
  }

  private filterCountries(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.countryList.filter(country => country.toLowerCase().indexOf(filterValue) === 0);
  }

  loadCities(event) {
    const country = event.currentTarget.value;
    if (country === undefined || country == null) {
      alert('Please enter Country to proceed');
      return;
    }

    this.citiesInCountryList = this.placeList.filter(place => {
      return country === place.country;
    }).map(place => place.city);
  }

}
