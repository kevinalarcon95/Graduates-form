import { Program } from "./Program";
import { WorkingInformation } from "./WorkingInformation";
import { Location } from "./Location";
import { Refered } from "./Refered";
import { Form } from "./Form";

export class GraduatesFormData {
    id: number;
    childsQuantity: number;
    institutionalEmail: string;
    programs: Program[] = [];
    job: WorkingInformation[] = [];
    location: Location;
    refered: Refered;
    form: Form;
    idexpeditionLocation: string;
    idexpeditionCountry: string;
    idtype: string;

    constructor(
        partil?: Partial<GraduatesFormData>
    ){
        Object.assign(this, partil);
    }

}