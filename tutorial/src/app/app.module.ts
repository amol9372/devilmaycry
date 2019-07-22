import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { AppComponent } from './app.component';
import { FirstTutorialComponent } from './first-tutorial/first-tutorial.component';
import { TutorialDetailComponent } from './tutorial-detail/tutorial-detail.component';
import { TutorialService } from './tutorial.service';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    FirstTutorialComponent,
    TutorialDetailComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [TutorialService],
  bootstrap: [AppComponent]
})
export class AppModule { }
