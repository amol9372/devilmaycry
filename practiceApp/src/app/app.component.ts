import { Abc } from './names';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
    title = 'practice app';
    name1: Abc = {
       id: 1,
       name: 'amol'
    };
    // tslint:disable-next-line:no-trailing-whitespace

    sampleArray: Abc[] = [
      { name: 'amol', id: 1 },
      { name: 'rahul', id: 2 }
  ];

  selectedPerson: Abc;

  showSelectedPerson(person: Abc) {
    this.selectedPerson = person;
  }

  ngOnInit() { }

}