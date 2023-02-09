  import { Phone } from "./Phone";
  
  export class Refered {
    private _name: string;
    public get name(): string {
      return this._name;
    }
    public set name(value: string) {
      this._name = value;
    }
    private _email: string;
    public get email(): string {
      return this._email;
    }
    public set email(value: string) {
      this._email = value;
    }
    private _phone: Phone;
    public get phone(): Phone {
      return this._phone;
    }
    public set phone(value: Phone) {
      this._phone = value;
    }
  }
  