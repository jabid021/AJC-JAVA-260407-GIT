import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoHttpPage } from './demo-http-page';

describe('DemoHttpPage', () => {
  let component: DemoHttpPage;
  let fixture: ComponentFixture<DemoHttpPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DemoHttpPage],
    }).compileComponents();

    fixture = TestBed.createComponent(DemoHttpPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
