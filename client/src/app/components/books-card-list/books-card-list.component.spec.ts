import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BooksCardListComponent } from './books-card-list.component';

describe('BooksCardListComponent', () => {
  let component: BooksCardListComponent;
  let fixture: ComponentFixture<BooksCardListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BooksCardListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BooksCardListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
