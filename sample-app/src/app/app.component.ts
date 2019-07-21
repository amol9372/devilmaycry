import { Component } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';
import { NgModule } from '@angular/core';
import { HeroesComponent } from './heroes/heroes.component';
import { HeroDetailsComponent } from './hero-details/hero-details.component';
import { HeroService } from './hero.service';
import { MessagesComponent } from './messages/messages.component';
import { MessageService } from './message.service';
import { DashboardComponent } from './dashboard/dashboard.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

@NgModule({
  declarations: [
    HeroesComponent,
    HeroDetailsComponent,
    MessagesComponent,
    DashboardComponent
  ],
  imports: [
    FormsModule
  ],
  providers: [HeroService, MessageService]
})

export class AppComponent {
  inputVariable = 'one way binding variable';
  title = 'sample-app';

  constructor(heroService: HeroService) {
    
  }
}
