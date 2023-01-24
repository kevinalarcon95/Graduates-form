import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-graduates-form',
  templateUrl: './graduates-form.component.html',
  styleUrls: ['./graduates-form.component.css']
})
export class GraduatesFormComponent implements OnInit {
  
  emailCtrl = new FormControl('',[]);

  constructor(){
    this.emailCtrl.valueChanges
    .subscribe(value => {
      console.log(value);
    });
  }

  ngOnInit(){}
  
  getEmail(event: Event) {
    event.preventDefault();
    console.log(this.emailCtrl.value);
  }
}
