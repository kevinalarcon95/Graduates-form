import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ServiceService } from '../service/service.service';
import { Router } from '@angular/router';
//import Swal from 'sweetalert2';

import { validationNumberIdentification } from '../utils/validations';
import { GraduatesForm } from 'src/model/GraduatesForm';


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

  constructor(private formBuilder: FormBuilder, private service: ServiceService, private router: Router) {}

  ngOnInit() {
    this.graduatesForm = this.initForm();
    //this.graduatesForm.controls['idType'].setValue('Tipo de identificación')

    window.onload = function() {
      var myInput = document.getElementById('idNumberConfirm');
      myInput.onpaste = function(e) {
        e.preventDefault();
        //alert("esta acción está prohibida");
      }
      
      myInput.oncopy = function(e) {
        e.preventDefault();
        //alert("esta acción está prohibida");
      }
    }
  }

  saveDataGraduatesForm() {
    // if (this.graduatesForm.valid) {
      //console.log('Form ->', this.graduatesForm.value);
      // Swal.fire({
      //   title: 'Confirmar envio de datos',
      //   text:  '¿Estas seguro que deseas enviar el formulario?',
      //   icon: 'warning',
      //   showCancelButton: true,
      //   confirmButtonColor: '#3085d6',
      //   confirmButtonText: 'Si, confirmar!',
      //   cancelButtonText: 'No, cancelar!'
      // }).then((result) => {
        // if (result.value) {
          let graduates = this.dataGraduatesForm();
          console.log('Form ->', graduates);
          this.service.saveGraduatesForm(graduates)
          .subscribe(data => {
            // Swal.fire('¡Formulario enviado exitosamente!', '', 'success');
            console.log(data);
            alert("¡Formulario enviado exitosamente!");
            this.router.navigate(['graduates-form']);
          })
          
          //this.onResetForm();
          //aqui se envia los datos al backend
        // }
      // })
    // } else {
      //console.log('No valid');
      //alert("¡Existen campos por validar!");
      // Swal.fire({
      //   title: '¡Existen campos por validar!',
      //   icon: 'warning',
      //   confirmButtonColor: '#3085d6',
      //   confirmButtonText: 'Aceptar',
      // });
    // }
  }

  dataGraduatesForm(): GraduatesForm {
    let graduates = new GraduatesForm();
    
    graduates.degreeDate = this.graduatesForm.controls.degreeDate.value;
    graduates.idType = this.graduatesForm.controls.idType.value;
    graduates.idNumber = this.graduatesForm.controls.idNumber.value;
    //graduates.idNumberConfirm = this.graduatesForm.controls.idNumberConfirm.value;
    graduates.expeditionPlace = this.graduatesForm.controls.expeditionPlace.value;
    graduates.placeBirth = this.graduatesForm.controls.placeBirth.value;
    graduates.birthDepartament = this.graduatesForm.controls.birthDepartament.value;
    graduates.countryResidence = this.graduatesForm.controls.countryResidence.value;
    graduates.departamentResidence = this.graduatesForm.controls.departamentResidence.value;
    graduates.cityResidence = this.graduatesForm.controls.cityResidence.value;
    graduates.numberChildren = this.graduatesForm.controls.numberChildren.value;
    graduates.personalMail = this.graduatesForm.controls.personalMail.value;
    graduates.unicaucaFaculty = this.graduatesForm.controls.unicaucaFaculty.value;
    graduates.unicaucaProgram = this.graduatesForm.controls.unicaucaProgram.value;
    graduates.refeName = this.graduatesForm.controls.refeName.value;
    graduates.cellRefe = this.graduatesForm.controls.cellRefe.value;
    graduates.emailRefe = this.graduatesForm.controls.emailRefe.value;
    graduates.hasWork = this.graduatesForm.controls.hasWork.value;
    graduates.companyWork = this.graduatesForm.controls.companyWork.value;
    graduates.currentlyWorking = this.graduatesForm.controls.currentlyWorking.value;
    graduates.phoneWork = this.graduatesForm.controls.phoneWork.value;
    graduates.typeContract = this.graduatesForm.controls.typeContract.value;
    graduates.bossName = this.graduatesForm.controls.bossName.value;
    graduates.optionArea = this.graduatesForm.controls.optionArea.value;
    graduates.nameCompanyWork = this.graduatesForm.controls.nameCompanyWork.value;
    graduates.positionCompany = this.graduatesForm.controls.positionCompany.value;
    graduates.workSector = this.graduatesForm.controls.workSector.value;
    graduates.bossMail = this.graduatesForm.controls.bossMail.value;
    graduates.bossPositionCompany = this.graduatesForm.controls.bossPositionCompany.value;
    graduates.workCity = this.graduatesForm.controls.workCity.value;
    graduates.salaryRange = this.graduatesForm.controls.salaryRange.value;
    graduates.isWork = this.graduatesForm.controls.isWork.value;
    graduates.nameRefeDoc =  this.graduatesForm.controls.nameRefeDoc.value;
    graduates.reasonInfluence = this.graduatesForm.controls.reasonInfluence.value;
    graduates.whatReason = this.graduatesForm.controls.whatReason.value;
    graduates.commentOne = this.graduatesForm.controls.commentOne.value;
    graduates.commentTwo = this.graduatesForm.controls.commentTwo.value;

    return graduates;
  }
  
  initForm(): FormGroup {
    return this.formBuilder.group({
      //Informaión personal
      degreeDate: ['', [Validators.required]],
      idType: ['', [Validators.required]],
      idNumber: ['', [Validators.required, Validators.pattern("^[0-9]*$")]],
      idNumberConfirm: ['', [Validators.required, Validators.pattern("^[0-9]*$")]],
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
      hasWork: ['', [Validators.required]],
      companyWork: ['', [Validators.required]],
      currentlyWorking: ['', [Validators.required]],
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
      reasonInfluence: ['', [Validators.required]],
      whatReason: ['', [Validators.required]],
      //Información adicional
      commentOne: ['', [Validators.required]],
      commentTwo: ['', [Validators.required]],
    },
    {
      validators: [validationNumberIdentification.isCorrect]
    }
    );
  }
  
  //Limpia el formulario
  onResetForm() {
    this.graduatesForm.reset();
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
}
