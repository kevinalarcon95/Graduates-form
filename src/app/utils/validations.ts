import {FormGroup } from "@angular/forms";

export class validationNumberIdentification {
    static isCorrect(control: FormGroup){
        const idNumber = Number(control.value.idNumber);
        const idNumberConfirm = Number(control.value.idNumberConfirm);
        
        if(idNumber !== idNumberConfirm){
            control.controls['idNumberConfirm'].setErrors({'Incorrect': true})
        }
        return null;
    }
}
