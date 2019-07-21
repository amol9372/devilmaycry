import { Component, OnInit } from '@angular/core';
import { TutorialBean } from '../tutorialBean';
import { tlist } from '../mock-tutorials';

@Component({
  selector: 'first-tutorial',
  templateUrl: './first-tutorial.component.html',
  styleUrls: ['./first-tutorial.component.css']
})
export class FirstTutorialComponent implements OnInit {

  tutorial1 : TutorialBean;
  tutorials:TutorialBean[] = tlist;
  constructor() { }

  ngOnInit() { }

}
