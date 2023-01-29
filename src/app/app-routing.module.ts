import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GraduatesFormComponent } from './graduates-form/graduates-form.component';
import { NotFoundComponent } from './not-found/not-found.component';

const routes: Routes = [

  {path: 'graduates-form', component: GraduatesFormComponent},
  {path: '', redirectTo: 'graduates-form', pathMatch: 'full'},
  {path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
