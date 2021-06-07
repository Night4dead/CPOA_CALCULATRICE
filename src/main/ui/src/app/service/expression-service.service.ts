import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Expression } from '../model/expression';
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ExpressionServiceService {
  private expressionUrl : string;

  constructor(private http: HttpClient) { }

  public calculate(expression: Expression){
    return this.http.post<Expression>(this.expressionUrl, expression);
  }

  public findAll(): Observable<Expression[]> {
    return this.http.get<Expression[]>(this.expressionUrl);
  }
}
