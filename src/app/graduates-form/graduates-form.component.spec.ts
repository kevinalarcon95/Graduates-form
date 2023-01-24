import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GraduatesFormComponent } from './graduates-form.component';

describe('GraduatesFormComponent', () => {
  let component: GraduatesFormComponent;
  let fixture: ComponentFixture<GraduatesFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GraduatesFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GraduatesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
