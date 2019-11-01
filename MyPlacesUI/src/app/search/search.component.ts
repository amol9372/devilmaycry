import { Component, OnInit } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { FormControl } from '@angular/forms';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  url = 'https://jsonplaceholder.typicode.com/users';
  usersArray: any[] = [];

  /*  constructor(private http: HttpClient) {
     this.http.get(this.url).subscribe((data: any[]) => {
       // Populating usersArray with names from API
       data.forEach(element => {
         this.usersArray.push(element.name);
       });
       console.log(data);
     });
   } */

  results: any[] = [];
  queryField: FormControl = new FormControl();
  constructor(private _searchService: SearchService) { }
  ngOnInit() {
    this.queryField.valueChanges
      .subscribe(result => console.log(result));
  }

}
