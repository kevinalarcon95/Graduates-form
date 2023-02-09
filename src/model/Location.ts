export class Location {
    private _residenceCountry: string;
    public get residenceCountry(): string {
      return this._residenceCountry;
    }
    public set residenceCountry(value: string) {
      this._residenceCountry = value;
    }
      private _residenceDepartment: string;
    public get residenceDepartment(): string {
      return this._residenceDepartment;
    }
    public set residenceDepartment(value: string) {
      this._residenceDepartment = value;
    }
      private _residenceCity: string;
    public get residenceCity(): string {
      return this._residenceCity;
    }
    public set residenceCity(value: string) {
      this._residenceCity = value;
    }
      private _natalDepartment: string;
    public get natalDepartment(): string {
      return this._natalDepartment;
    }
    public set natalDepartment(value: string) {
      this._natalDepartment = value;
    }
      private _natalTown: string;
    public get natalTown(): string {
      return this._natalTown;
    }
    public set natalTown(value: string) {
      this._natalTown = value;
    }

    constructor(){}
  }