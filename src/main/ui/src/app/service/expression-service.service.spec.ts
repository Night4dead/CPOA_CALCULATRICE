import { TestBed } from '@angular/core/testing';

import { ExpressionServiceService } from './expression-service.service';

describe('ExpressionServiceService', () => {
  let service: ExpressionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExpressionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
