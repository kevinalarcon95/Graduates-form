export class Location {
   residenceCountry: string;
   residenceDepartment: string;
   residenceCity: string;
   natalDepartment: string;
   natalTown: string;

   public constructor(partil?: Partial<Location>) {
    Object.assign(this, partil);
    }
  
  }