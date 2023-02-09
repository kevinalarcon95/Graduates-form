import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ServiceService } from '../service/service.service';
import { Router } from '@angular/router';
import { Country, State, City }  from 'country-state-city';
//import 'sweetalert2/src/sweetalert2.scss';
import Swal from 'sweetalert2'

import { validationNumberIdentification } from '../utils/validations';
import { GraduatesForm } from 'src/model/GraduatesForm';
import { GraduatesFormData } from 'src/model/GraduatesFormData';
import { Program } from 'src/model/Program';
import { WorkingInformation } from 'src/model/WorkingInformation';


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

  graduatesForm: FormGroup;
  graduates: GraduatesFormData;
  arrayCountries = [];
  arrayDepartament = [];
  arrayDepartamentCol = [];
  arrayCities = [];
  arrayCitiesCol = [];
  arrayCitiesCol2 = [];
  isClicked: boolean = false;
  element: boolean = false;
  element2: boolean = false;
  element3: boolean = false;
  inputState: boolean = false;
  today = new Date();
  year = this.today.getFullYear();
  

  constructor(private formBuilder: FormBuilder, private service: ServiceService, private router: Router) {}

  ngOnInit() {
    this.graduatesForm = this.initForm();
    this.blockCopyAndPaste()
    this.loadCountries();
    this.loadDepartamentCol();
    

    
  }

  saveDataGraduatesForm() {
    if (this.graduatesForm.valid) {
      console.log('Form ->', this.graduatesForm.value);
      Swal.fire({
        title: 'Confirmar envio de datos',
        text:  '¿Estas seguro que deseas enviar el formulario?',
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'Si, confirmar!',
        cancelButtonText: 'No, cancelar!'
      }).then((result) => {
        if (result.value) {
          this.graduates = this.dataGraduatesForm();
          this.searchCountryByCode();
          this.searchDepartamentByCode();
          this.searchDepartamentByCodeCol();
          this.service.saveGraduatesForm(this.graduates)
          .subscribe(data => {
            Swal.fire('¡Formulario enviado exitosamente!', '', 'success');
            this.router.navigate(['graduates-form']);
          })
          this.onResetForm();
        }else{
          Swal.fire({
            title:'¡Error al enviar el formulario!',
            icon: 'error',
            confirmButtonColor: '#3085d6',
            confirmButtonText: 'Aceptar',
          });
        }
      })
    } else {
      this.graduatesForm.markAllAsTouched();
      Swal.fire({
        title: '¡Información incompleta, por favor revise nuevamente!',
        icon: 'warning',
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'Aceptar',
      });
    }
  }

  dataGraduatesForm(): GraduatesFormData {
    let graduatesFormData = new GraduatesFormData();

    graduatesFormData.id = this.graduatesForm.controls.idNumber.value;
    graduatesFormData.childsQuantity = this.graduatesForm.controls.numberChildren.value;
    graduatesFormData.institutionalEmail = this.graduatesForm.controls.personalMail.value;
    graduatesFormData.programs.code = this.graduatesForm.controls.unicaucaProgram.value;
    graduatesFormData.programs.name = "INGENIERIA EN SISTEMAS" //traer el dato desde el back enviandole el id;
    graduatesFormData.job.hadJobBefore = this.graduatesForm.controls.hasWork.value;//¿Ha trabajado antes?
    graduatesFormData.job.hasBeenInProfession = this.graduatesForm.controls.optionArea.value;//¿Se desempeñó en su área de formación?
    graduatesFormData.job.working = this.graduatesForm.controls.currentlyWorking.value;//"¿Actualmente está trabajando?
    graduatesFormData.job.actualPosition = this.graduatesForm.controls.positionCompany.value;
    graduatesFormData.job.enterprise = this.graduatesForm.controls.companyWork.value;
    graduatesFormData.job.actualEnterprise = this.graduatesForm.controls.nameCompanyWork.value;
    graduatesFormData.job.jobCity = this.graduatesForm.controls.workCity.value;
    graduatesFormData.job.position = this.graduatesForm.controls.bossPositionCompany.value;
    graduatesFormData.job.salarialRange = this.graduatesForm.controls.salaryRange.value;
    graduatesFormData.job.contractType = this.graduatesForm.controls.typeContract.value;
    graduatesFormData.job.boss.name = this.graduatesForm.controls.bossName.value;
    graduatesFormData.job.boss.email = this.graduatesForm.controls.bossMail.value;
    graduatesFormData.job.phone.type = "Celular";
    graduatesFormData.job.phone.number = this.graduatesForm.controls.phoneWork.value;
    graduatesFormData.job.sector = this.graduatesForm.controls.workSector.value;
    graduatesFormData.job.inProfession = this.graduatesForm.controls.isWork.value;//¿Se encuentra trabajando en el área de formación?
    graduatesFormData.location.residenceCountry = this.graduatesForm.controls.countryResidence.value; //pais de residencia
    graduatesFormData.location.residenceDepartment = this.graduatesForm.controls.departamentResidence.value;//departamento de residencia
    graduatesFormData.location.residenceCity = this.graduatesForm.controls.cityResidence.value; // ciudad de residencia
    graduatesFormData.location.natalDepartment = this.graduatesForm.controls.birthDepartament.value; // departamento de nacimiento
    graduatesFormData.location.natalDepartment = this.graduatesForm.controls.placeBirth.value; // ciudad de nacimiento
    graduatesFormData.refered.name = this.graduatesForm.controls.refeName.value;
    graduatesFormData.refered.email = this.graduatesForm.controls.emailRefe.value;
    graduatesFormData.refered.phone.type = "Celular";
    graduatesFormData.refered.phone.number = this.graduatesForm.controls.cellRefe.value;
    graduatesFormData.aditionalInformation.programComment = this.graduatesForm.controls.commentOne.value;
    graduatesFormData.aditionalInformation.mostImportantProfessor = this.graduatesForm.controls.nameRefeDoc.value;
    graduatesFormData.aditionalInformation.mostImportantReassons = this.graduatesForm.controls.reasonInfluence.value;
    graduatesFormData.aditionalInformation.observations = this.graduatesForm.controls.whatReason.value;
    graduatesFormData.aditionalInformation.universityExpectative = this.graduatesForm.controls.commentTwo.value;
    graduatesFormData.idexpeditionCountry = this.graduatesForm.controls.expeditionDepartament.value;
    graduatesFormData.idexpeditionLocation = this.graduatesForm.controls.expeditionPlace.value;
    graduatesFormData.idtype = this.graduatesForm.controls.idType.value;
  

    //graduates.degreeDate = this.graduatesForm.controls.degreeDate.value;    
    return graduatesFormData;
  }
  
  initForm(): FormGroup {
    return this.formBuilder.group({
      //Información personal
      degreeDate: ['', [Validators.required]],
      idType: ['', [Validators.required]],
      idNumber: ['', [Validators.required, Validators.pattern("^[0-9]*$")]],
      idNumberConfirm: ['', [Validators.required, Validators.pattern("^[0-9]*$")]],
      expeditionDepartament: ['', [Validators.required]],
      expeditionPlace: ['', [Validators.required]],
      placeBirth: ['', [Validators.required]],
      birthDepartament: ['', [Validators.required]],
      countryResidence: ['', [Validators.required]],
      departamentResidence: ['', [Validators.required]],
      cityResidence: ['', [Validators.required]],
      numberChildren: ['0'],
      //Información del graduando
      personalMail: ['', [Validators.required, Validators.email]],
      unicaucaFaculty: ['', [Validators.required]],
      unicaucaProgram:  ['', [Validators.required]],
      //Información del referido
      refeName: ['', [Validators.required]],
      cellRefe: ['', [Validators.required, Validators.pattern("^[0-9]*$")]],
      emailRefe: ['', [Validators.required, Validators.email]],
      //Información laboral
      hasWork: [''],
      companyWork: [''],
      currentlyWorking: [''],
      phoneWork: [''],
      typeContract: [''],
      bossName: [''],
      optionArea: [''],
      nameCompanyWork: [''],
      bossPositionCompany: [''],
      workSector: [''],
      bossMail:   [''],
      positionCompany: [''],
      workCity: [''],
      salaryRange: [''],
      isWork: [''],
      //Información del docente
      nameRefeDoc: ['', [Validators.required]],
      reasonInfluence: ['', [Validators.required]],
      whatReason: [{value: '', disabled: true}],
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
    //this.graduatesForm.reset();
  }

  /*
     Metodos que habilitan los input en el formulario
  */
 
   enableInput(){
     this.element = true;
     this.isClicked = true;
     this.graduatesForm.controls.numberChildren.setValidators([Validators.required]);
     this.graduatesForm.controls.numberChildren.updateValueAndValidity();

     return (this.element = true && this.isClicked);
   }
 
   disableInput(){
     this.element = false;
     this.isClicked = true;
     this.graduatesForm.controls.numberChildren.clearValidators();
     this.graduatesForm.controls.numberChildren.updateValueAndValidity();
   }

   enableInputTwo(){
    this.element2 = true;
    this.isClicked = true;
    this.graduatesForm.controls.companyWork.setValidators([Validators.required]);
    this.graduatesForm.controls.companyWork.updateValueAndValidity();
    this.graduatesForm.controls.optionArea.setValidators([Validators.required]);
    this.graduatesForm.controls.optionArea.updateValueAndValidity();
    this.graduatesForm.controls.positionCompany.setValidators([Validators.required]);
    this.graduatesForm.controls.positionCompany.updateValueAndValidity();

    return (this.element2 = true && this.isClicked);
  }

  disableInputTwo(){
    this.element2 = false;
    this.isClicked = true;
    this.graduatesForm.controls.companyWork.clearValidators();
    this.graduatesForm.controls.companyWork.updateValueAndValidity();
    this.graduatesForm.controls.optionArea.clearValidators();
    this.graduatesForm.controls.optionArea.updateValueAndValidity();
    this.graduatesForm.controls.positionCompany.clearValidators();
    this.graduatesForm.controls.positionCompany.updateValueAndValidity();
  }

  enableInputThree(){
    this.element3 = true;
    this.isClicked = true;
    this.graduatesForm.controls.phoneWork.setValidators([Validators.required,Validators.pattern("^[0-9]*$")]);
    this.graduatesForm.controls.phoneWork.updateValueAndValidity();
    this.graduatesForm.controls.typeContract.setValidators([Validators.required]);
    this.graduatesForm.controls.typeContract.updateValueAndValidity();
    this.graduatesForm.controls.bossName.setValidators([Validators.required]);
    this.graduatesForm.controls.bossName.updateValueAndValidity();
    this.graduatesForm.controls.nameCompanyWork.setValidators([Validators.required]);
    this.graduatesForm.controls.nameCompanyWork.updateValueAndValidity();
    this.graduatesForm.controls.bossPositionCompany.setValidators([Validators.required]);
    this.graduatesForm.controls.bossPositionCompany.updateValueAndValidity();
    this.graduatesForm.controls.workSector.setValidators([Validators.required]);
    this.graduatesForm.controls.workSector.updateValueAndValidity();
    this.graduatesForm.controls.bossMail.setValidators([Validators.required,Validators.email]);
    this.graduatesForm.controls.bossMail.updateValueAndValidity();
    this.graduatesForm.controls.workCity.setValidators([Validators.required]);
    this.graduatesForm.controls.workCity.updateValueAndValidity();
    this.graduatesForm.controls.salaryRange.setValidators([Validators.required]);
    this.graduatesForm.controls.salaryRange.updateValueAndValidity();
    this.graduatesForm.controls.isWork.setValidators([Validators.required]);
    this.graduatesForm.controls.isWork.updateValueAndValidity();
    return (this.element3 = true && this.isClicked);
  }

  disableInputThree(){
    this.element3 = false;
    this.isClicked = true;
    this.graduatesForm.controls.phoneWork.clearValidators();
    this.graduatesForm.controls.phoneWork.updateValueAndValidity();
    this.graduatesForm.controls.typeContract.clearValidators();
    this.graduatesForm.controls.typeContract.updateValueAndValidity();
    this.graduatesForm.controls.bossName.clearValidators();
    this.graduatesForm.controls.bossName.updateValueAndValidity();
    this.graduatesForm.controls.nameCompanyWork.clearValidators();
    this.graduatesForm.controls.nameCompanyWork.updateValueAndValidity();
    this.graduatesForm.controls.bossPositionCompany.clearValidators();
    this.graduatesForm.controls.bossPositionCompany.updateValueAndValidity();
    this.graduatesForm.controls.workSector.clearValidators();
    this.graduatesForm.controls.workSector.updateValueAndValidity();
    this.graduatesForm.controls.bossMail.clearValidators();
    this.graduatesForm.controls.bossMail.updateValueAndValidity();
    this.graduatesForm.controls.workCity.clearValidators();
    this.graduatesForm.controls.workCity.updateValueAndValidity();
    this.graduatesForm.controls.salaryRange.clearValidators();
    this.graduatesForm.controls.salaryRange.updateValueAndValidity();
    this.graduatesForm.controls.isWork.clearValidators();
    this.graduatesForm.controls.isWork.updateValueAndValidity();
  }
  
  //Metodo que bloquea las opciones de copia y pegar de un input
  blockCopyAndPaste(){
    window.onload = function() {
      var myInput = document.getElementById('idNumberConfirm');
      myInput.onpaste = function(e) {
        e.preventDefault();
      }
      
      myInput.oncopy = function(e) {
        e.preventDefault();
      }
    }
  }

  loadCountries(){
    let json = Country.getAllCountries();
    for(var i=0; i< json.length; i++){
      let country = { name: json[i].name, isoCode: json[i].isoCode };
      this.arrayCountries.push(country);
    }
  }

  searchCountryByCode(){
    let pais = Country.getCountryByCode(this.graduates.location.residenceCountry).name;
    this.graduates.location.residenceCountry = pais;
    return pais;
  }

  loadDepartament(event) {
    this.arrayDepartament = [];
    let json = State.getStatesOfCountry(this.graduatesForm.controls.countryResidence.value);
    for(var i=0; i< json.length; i++){
        let departament = { name: json[i].name, isoCode: json[i].isoCode };
        this.arrayDepartament.push(departament);
    }
  }

  searchDepartamentByCode(){
    let json =  this.arrayDepartament;
    for(var i=0; i< json.length; i++){
      if (json[i].isoCode == this.graduates.location.residenceDepartment) {
        this.graduates.location.residenceDepartment = json[i].name;
      }
    }
  }
  
  loadCities(event) {
    this.arrayCities = [];
    let json = City.getCitiesOfState(this.graduatesForm.controls.countryResidence.value, this.graduatesForm.controls.departamentResidence.value);
    for(var i=0; i< json.length; i++){
        let cities = json[i].name;
        this.arrayCities.push(cities);
    }
  }

  loadDepartamentCol(){
    let json = State.getStatesOfCountry('CO');
    for(var i=0; i< json.length; i++){
      let departament = { name: json[i].name, isoCode: json[i].isoCode };
      this.arrayDepartamentCol.push(departament);
    }
  }

  searchDepartamentByCodeCol(){
    let json =  this.arrayDepartamentCol;
    for(var i=0; i< json.length; i++){
      if (json[i].isoCode == this.graduates.idexpeditionCountry) 
      {
        this.graduates.idexpeditionCountry = json[i].name;
      }else if(json[i].isoCode == this.graduates.location.natalDepartment)
      {
        this.graduates.location.natalDepartment = json[i].name;
      }
    }
  }

  loadCitiesCol(event){
    this.arrayCitiesCol = [];
    let json = City.getCitiesOfState("CO", this.graduatesForm.controls.expeditionDepartament.value);
    for(var i=0; i< json.length; i++){
        let cities = json[i].name;
        this.arrayCitiesCol.push(cities);
    }
  }

  loadCitiesCol2(event){
    this.arrayCitiesCol2 = [];
    let json = City.getCitiesOfState("CO", this.graduatesForm.controls.birthDepartament.value);
    for(var i=0; i< json.length; i++){
        let cities = json[i].name;
        this.arrayCitiesCol2.push(cities);
    }
  }

  selectedValue(){
    if(this.graduatesForm.controls.reasonInfluence.value  === 'Otro'){
      this.graduatesForm.controls.whatReason.enable();
      this.graduatesForm.controls.whatReason.setValidators([Validators.required]);
      this.graduatesForm.controls.whatReason.updateValueAndValidity();
    }else{
      this.graduatesForm.controls.whatReason.setValue("");
      this.graduatesForm.controls.whatReason.disable();
    }
  }

}