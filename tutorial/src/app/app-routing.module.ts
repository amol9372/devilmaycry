import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { TutorialDetailComponent } from './tutorial-detail/tutorial-detail.component';
import { AppComponent } from './app.component';
import { FirstTutorialComponent } from './first-tutorial/first-tutorial.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'tutorials', component: FirstTutorialComponent },
  { path: 'details', component: TutorialDetailComponent }
  
 
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
