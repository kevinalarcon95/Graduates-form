import { AbstractControl } from "@angular/forms";

export class validationNumberIdentification {
    static isCorrect(control: AbstractControl){
        const idNumber = control.get("idNumber");
        const idNumberConfirm = control.get("idNumberConfirm");
        
        if(idNumber !== idNumberConfirm){
                return {isCorrect: false};
        }
            return null;
    }
}
