import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  welcomeHeros = 'Welcome to the heroes component';

  constructor() { }

  ngOnInit() {
  }
   
    

}
