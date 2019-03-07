import { Abc } from './names';
import { Component, OnInit, Input } from '@angular/core';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Person } from './person';
import { DragImage } from 'ng2-dnd';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
    restrictedDrop1: any = null;
    restrictedDrop2: any = null;
    image : DragImage;

    ngOnInit(){
      var img1 = new Image();
      img1.src = '/assets/images/drag.png';
      img1.width = 10;
      console.log(img1.naturalHeight)
      img1.height = 10;
      this.image = new DragImage(img1, 0, 0);
    }

   // var img1 = new Image();
   // img1.src = '/images/drag.png';
   // image = new DragImage('/images/drag.png', 0, 0);;
}