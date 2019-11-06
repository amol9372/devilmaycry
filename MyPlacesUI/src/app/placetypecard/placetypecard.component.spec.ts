import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlacetypecardComponent } from './placetypecard.component';

describe('PlacetypecardComponent', () => {
  let component: PlacetypecardComponent;
  let fixture: ComponentFixture<PlacetypecardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlacetypecardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlacetypecardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
