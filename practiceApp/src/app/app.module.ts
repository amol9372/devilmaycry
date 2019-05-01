import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { AppComponent } from './app.component';
import {DndModule} from 'ng2-dnd';
import { FileDropModule } from 'ngx-file-drop';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule, DragDropModule, DndModule.forRoot(), FileDropModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
