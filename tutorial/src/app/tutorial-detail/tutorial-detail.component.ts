import { Component, OnInit, Input } from '@angular/core';
import { TutorialBean } from '../tutorialBean';

@Component({
  selector: 'tutorial-detail',
  templateUrl: './tutorial-detail.component.html',
  styleUrls: ['./tutorial-detail.component.css']
})
export class TutorialDetailComponent implements OnInit {

  @Input()
  tutorialDetails: TutorialBean;

  constructor() { }

  ngOnInit() {
  }

}
