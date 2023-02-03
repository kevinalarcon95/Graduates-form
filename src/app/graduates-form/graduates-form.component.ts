import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl, FormArrayName, FormArray } from '@angular/forms';
import { debounceTime } from 'rxjs';
import Swal from 'sweetalert2';

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

  //Limpia el formulario
  onResetForm() {
    this.graduatesForm.reset();
  }

  dataGraduatesForm() {
    // if (!this.graduatesForm.valid) {
      console.log('Form ->', this.graduatesForm.value);
    //  this.confirmBox();
    // } else {
    //   console.log('No valid');
    //   this.alert();
    // }
  }
  
  /*
     Metodos que habilitan los input en el formulario
  */
   isClicked: boolean = false;
   element: boolean = false;
   element2: boolean = false;
   element3: boolean = false;

   enableInput(){
     this.element = true;
     this.isClicked = true;
     return (this.element = true && this.isClicked);
   }
 
   disableInput(){
     this.element = false;
     this.isClicked = true;
   }

   enableInputTwo(){
    this.element2 = true;
    this.isClicked = true;
    return (this.element2 = true && this.isClicked);
  }

  disableInputTwo(){
    this.element2 = false;
    this.isClicked = true;
  }

  enableInputThree(){
    this.element3 = true;
    this.isClicked = true;
    return (this.element3 = true && this.isClicked);
  }

  disableInputThree(){
    this.element3 = false;
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
      cellRefe: ['', [Validators.required, Validators.pattern("^[0-9]*$")]],
      emailRefe: ['', [Validators.required, Validators.email]],
      //Información laboral
      companyWork: ['', [Validators.required]],
      phoneWork: ['', [Validators.required, Validators.pattern("^[0-9]*$")]],
      typeContract: ['', [Validators.required]],
      bossName: ['', [Validators.required]],
      optionArea: ['', [Validators.required]],
      nameCompanyWork: ['', [Validators.required]],
      positionCompany: ['', [Validators.required]],
      workSector: ['',Validators.required],
      bossMail:   ['', [Validators.required, Validators.email]],
      bossPositionCompany: ['', [Validators.required]],
      workCity: ['', [Validators.required]],
      salaryRange: ['', [Validators.required]],
      isWork: ['', [Validators.required]],
      //Información del docente
      nameRefeDoc: ['', [Validators.required]],
      //Información adicional
      commentOne: ['', [Validators.required]],
      commentTwo: ['', [Validators.required]],
    });
  }
  
  //Alerta simple, comprueba que no hayan campos vacios
  alert(){
    Swal.fire('Existen campos por validar!', '', 'warning');
  }
  
  //Alerta de confirmación
  confirmBox(){
    Swal.fire({
      title: 'Confirmar envio de datos',
      text:  '¿Estas seguro que deseas enviar el formulario?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      confirmButtonText: 'Si, confirmar!',
      cancelButtonText: 'No, cancelar!'
    }).then((result) => {
      if (result.value) {
        Swal.fire('Formulario enviado exitosamente!', '', 'success');
        this.onResetForm();
        //aqui se envia los datos al backend
      }
    })
  }
}
