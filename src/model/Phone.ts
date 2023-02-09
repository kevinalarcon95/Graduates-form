export class Phone {
    private _type: string;
    private _number: string;

    constructor(){}
    
    public get type(): string {
      return this._type;
    }
    public set type(value: string) {
      this._type = value;
    }
    public get number(): string {
      return this._number;
    }
    public set number(value: string) {
      this._number = value;
    }   
  }
  