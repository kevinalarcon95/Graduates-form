import { Boss } from "./Boss";
import { Phone} from "./Phone";

  export class WorkingInformation {

    hadJobBefore: boolean;
    hasBeenInProfession: boolean;
    position: string;
    enterprise: string;
    working: boolean;
    actualEnterprise: string;
    jobCity: string;
    actualPosition: string;
    salarialRange: string;
    contractType: string;
    boss: Boss;
    phone: Phone;
    sector: string;
    inProfession: boolean;
    
    public constructor(partil?: Partial<WorkingInformation>) {
      Object.assign(this, partil);
    }

  }