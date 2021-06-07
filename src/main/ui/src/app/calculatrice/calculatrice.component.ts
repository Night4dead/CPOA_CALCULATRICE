import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {ExpressionServiceService} from "../service/expression-service.service";
import {Expression} from "../model/expression";
import {Observable} from "rxjs";

@Component({
  selector: 'app-calculatrice',
  templateUrl: './calculatrice.component.html',
  styleUrls: ['./calculatrice.component.scss']
})
export class CalculatriceComponent implements OnInit {
  get expression(){
    return this.expressionForm.get('expression');
  }

  expression: Expression;
  expressions: Observable<Expression[]>;

  expressionForm = this.formBuilder.group(
    {
      expression: ['']
    }
  );

  constructor(private formBuilder: FormBuilder,
              private expressionService: ExpressionServiceService) {
    this.expression = new Expression();
  }

  ngOnInit(): void {
    this.expressions = this.expressionService.findAll();
  }

  submitForm(){
    this.expression = this.expressionForm.value.expression;
    this.expressionService.calculate(this.expression).subscribe(result => this.showResult(result));
  }

  showResult(res){
    const resP = document.getElementById("res");
    resP.innerHTML=res;
    resP.setAttribute("class","");
  }

  async onPressBackspace() {
    this.expressionForm.controls['expression'].setValue(this.expressionForm.value.expression.substring(0, this.expressionForm.value.expression.length - 1));
  }

  async add(element: string){
    this.expressionForm.controls['expression'].setValue(this.expressionForm.value.expression + element);
  }
}
1
