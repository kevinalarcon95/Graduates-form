import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

interface Food {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-graduates-form',
  templateUrl: './graduates-form.component.html',
  styleUrls: ['./graduates-form.component.css']
})
export class GraduatesFormComponent implements OnInit {
  
  graduatesForm = new FormGroup({

  });

  constructor(){ }
  
  dataGraduatesForm(){}
  
  ngOnInit(): void{}

  foods: Food[] = [
    {value: 'steak-0', viewValue: 'Steak'},
    {value: 'pizza-1', viewValue: 'Pizza'},
    {value: 'tacos-2', viewValue: 'Tacos'},
  ];
}
