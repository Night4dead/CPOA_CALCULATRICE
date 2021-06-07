import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-calculatrice',
  templateUrl: './calculatrice.component.html',
  styleUrls: ['./calculatrice.component.scss']
})
export class CalculatriceComponent implements OnInit {
  get expression(){
    return this.expressionForm.get('expression');
  }

  expressionForm = this.formBuilder.group(
    {
      expression: ['']
    }
  );

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }

  submitForm(){

  }

  async onPressBackspace() {
    this.expressionForm.controls['expression'].setValue(this.expressionForm.value.expression.substring(0, this.expressionForm.value.expression.length - 1));
  }

  async add(element: string){
    this.expressionForm.controls['expression'].setValue(this.expressionForm.value.expression + element);
  }
}
1
