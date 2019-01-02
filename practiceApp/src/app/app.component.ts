import { Component } from '@angular/core';
import { Abc } from './names';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
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

}