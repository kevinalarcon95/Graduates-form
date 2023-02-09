  import { Phone } from "./Phone";
  
  export class Refered {
    name: string;
    email: string;
    phone: Phone;

    public constructor(partil?: Partial<Refered>) {
      Object.assign(this, partil);
    }
 
  }
  