// tslint:disable-next-line:no-trailing-whitespace
import { Component, OnInit, Input } from '@angular/core';
import { Hero } from '../hero';
import { testVariable } from '../mock-heroes';
import { HEROES } from '../mock-heroes';
import { HeroService } from '../hero.service';
import { MessageService } from '../message.service';
import { viewParentEl } from '@angular/core/src/view/util';
import * as pbi from 'powerbi-client';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  @Input('test') oneWayBindingVariable: string;
  oneway = 'A Variable with one way Binding';
  testVar = testVariable;
  heroList: Hero[] = HEROES;
  //@viewchild
  heroes: Hero[];

  hero: Hero = {
    id: 1,
    name: 'Amol'
  };
  // tslint:disable-next-line:no-trailing-whitespace

  selectedHero: Hero;
  isHeroSelected = false;
  twoWayBindingVariable = 'Two way binding variable';

  constructor(private heroService: HeroService) {

  }

  ngOnInit() {
    this.getHeroes();
  }
  //ngOnInit() {
  //  let messageService = new MessageService();
  //  let heroService = new HeroService(messageService);
  //  heroService.getHeroes()
  //    .subscribe(heroes => this.heroes = heroes);
 // }
  // tslint:disable-next-line:no-trailing-whitespace

  onSelect(hero: Hero) {
    this.selectedHero = hero;
    this.isHeroSelected = true;
  }

  getHeroes(): void {
    this.heroService.getHeroes()
        .subscribe(heroes => this.heroes = heroes);
  }
}
