export class GraduatesForm{

      degreeDate: string;
      idType: string;
      idNumber: number;
      idNumberConfirm: number;
      expeditionPlace: string;
      placeBirth: string;
      birthDepartament: string;
      countryResidence: string;
      departamentResidence: string;
      cityResidence: string;
      numberChildren: number;
      //Información del graduando
      personalMail: string;      
      unicaucaFaculty: string;
      unicaucaProgram:  string;
      //Información del referido
      refeName: string;
      cellRefe: number;
      emailRefe: string;      //Información laboral
      companyWork: string;
      phoneWork: number;
      typeContract: string;
      bossName: string;
      optionArea: string;
      nameCompanyWork: string;
      positionCompany: string;
      workSector: string;
      bossMail:   string;      
      bossPositionCompany: string;
      workCity: string;
      salaryRange: string;
      isWork: string;
      //Información del docente
      nameRefeDoc: string;
      reasonInfluence: string;

      //Información adicional
      commentOne: string;
      commentTwo: string;

    public constructor(init?: Partial<GraduatesForm>) {
        Object.assign(this, init)
      }

}