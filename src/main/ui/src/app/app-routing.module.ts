import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CalculatriceComponent} from "./calculatrice/calculatrice.component";

const routes: Routes = [
  {
    path: '',
    component: CalculatriceComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
