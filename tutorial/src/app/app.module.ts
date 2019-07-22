import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { AppComponent } from './app.component';
import { FirstTutorialComponent } from './first-tutorial/first-tutorial.component';
import { TutorialDetailComponent } from './tutorial-detail/tutorial-detail.component';
import { TutorialService } from './tutorial.service';

@NgModule({
  declarations: [
    AppComponent,
    FirstTutorialComponent,
    TutorialDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [TutorialService],
  bootstrap: [AppComponent]
})
export class AppModule { }
