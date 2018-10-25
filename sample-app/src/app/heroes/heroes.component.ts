import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';
import { testVariable } from '../mock-heroes';
import { HEROES } from '../mock-heroes';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  testVar = testVariable;

  heroList: Hero[] = HEROES;

  hero: Hero = {
    id: 1,
    name: 'Amol'
  };

  constructor() { }

  ngOnInit() {
  }

}
