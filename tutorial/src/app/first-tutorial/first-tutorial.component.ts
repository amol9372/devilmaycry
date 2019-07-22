import { Component, OnInit, Input } from '@angular/core';
import { TutorialBean } from '../tutorialBean';
import { tlist } from '../mock-tutorials';
import { TutorialService } from '../tutorial.service';
import { Observable, of } from 'rxjs';

@Component({
  selector: 'first-tutorial',
  templateUrl: './first-tutorial.component.html',
  styleUrls: ['./first-tutorial.component.css']
})
export class FirstTutorialComponent implements OnInit {
  
  @Input()
  randomInput: string;        //binding from TS to HTML (one way binding)
  
  ngModelInput:String = "Sample ngModel";
  tutorial1 : TutorialBean;
  tutorials:TutorialBean[] = tlist;
  selectedTutorial: TutorialBean;

  constructor(private tutorialService: TutorialService) { }

  ngOnInit() { }

  onSelect(tutorial: TutorialBean): void{
     this.selectedTutorial = tutorial;
  }
  
  displayTutorial(tid:number):TutorialBean{
     this.tutorialService.getTutorialDetails(tid).subscribe(
       result => this.selectedTutorial = result 
     );

     return this.selectedTutorial;
  } 

}
