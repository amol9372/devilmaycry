import { Injectable } from '@angular/core';
import { tlist } from './mock-tutorials';
import { Observable, of } from 'rxjs';
import { TutorialBean } from './tutorialBean';

@Injectable({
  providedIn: 'root'
})
export class TutorialService {
  //tutorial:TutorialBean;
  tutorialList = tlist;
  constructor() { }

  getTutorialDetails(id:number): Observable<TutorialBean>{
     var tutorial:TutorialBean;
     this.tutorialList.forEach(function(t){
        if(t.tid == id){
          tutorial = t;
        }        
     }); 

     return of(tutorial);
  }
}
