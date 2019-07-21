import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FirstTutorialComponent } from './first-tutorial/first-tutorial.component';

@NgModule({
  declarations: [
    AppComponent,
    FirstTutorialComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
