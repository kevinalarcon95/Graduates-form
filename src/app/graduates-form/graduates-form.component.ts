import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl, FormArrayName, FormArray } from '@angular/forms';
import { debounceTime } from 'rxjs';

import { validationNumberIdentification } from '../utils/validations';

@Component({
  selector: 'app-graduates-form',
  templateUrl: './graduates-form.component.html',
  styleUrls: ['./graduates-form.component.css'],
})
export class GraduatesFormComponent implements OnInit {
  typeId = [
    { value: 'CC', name: 'CC' },
    { value: 'TI', name: 'TI' },
    { value: 'PASAPORTE', name: 'PASAPORTE' },
  ];

  unicaucaFaculty = [
    { value: 'Facultad de Artes', name: 'Facultad de Artes' },
    {
      value: 'Facultad de Ciencias Agrarias',
      name: 'Facultad de Ciencias Agrarias',
    },
  ];

  graduatesForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.graduatesForm = this.initForm();
    //this.graduatesForm.controls['idType'].setValue('Tipo de identificación')
  }
    
  onResetForm() {
    this.graduatesForm.reset();
  }

  dataGraduatesForm() {
    // if (this.graduatesForm.valid) {
      console.log('Form ->', this.graduatesForm.value);
    //   this.onResetForm();
    // } else {
    //   console.log('No valid');
    // }
  }
  
  /*
  
     Metodos que habilitan los input en el formulario
  */
   isClicked: boolean = false;
   element: boolean = false;
 
   enableInput(){
     this.element = true;
     this.isClicked = true;
     return (this.element = true && this.isClicked);
   }
 
   disableInput(){
     this.element = false;
     this.isClicked = true;
   }

  initForm(): FormGroup {
    return this.formBuilder.group({
      //Informaión personal
      degreeDate: ['', [Validators.required]],
      idType: ['', [Validators.required]],
      idNumber: ['', [Validators.required, Validators.pattern("^[0-9]*$")]],
      idNumberConfirm: ['', [Validators.required, Validators.pattern("^[0-9]*$"), validationNumberIdentification.isCorrect]],
      expeditionPlace: ['', [Validators.required]],
      placeBirth: ['', [Validators.required]],
      birthDepartament: ['', [Validators.required]],
      countryResidence: ['', [Validators.required]],
      departamentResidence: ['', [Validators.required]],
      cityResidence: ['', [Validators.required]],
      numberChildren: ['', [Validators.required]],
      //Información del graduando
      personalMail: ['', [Validators.required, Validators.email]],
      unicaucaFaculty: ['', [Validators.required]],
      unicaucaProgram:  ['', [Validators.required]],
      //Información del referido
      refeName: ['', [Validators.required]],
    });
  }
}
