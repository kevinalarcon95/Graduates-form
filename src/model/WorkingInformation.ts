import { Boss } from "./Boss";
import { Phone} from "./Phone";

  export class WorkingInformation {

    private _hadJobBefore: boolean;
    private _hasBeenInProfession: boolean;
    private _position: string;
    private _enterprise: string;
    private _working: boolean;
    private _actualEnterprise: string;
    private _jobCity: string;
    private _actualPosition: string;
    private _salarialRange: string;
    private _contractType: string;
    private _boss: Boss;
    private _phone: Phone;
    private _sector: string;
    private _inProfession: boolean;
    
    constructor(){
      this._boss = new Boss();
      this._phone = new Phone();
    }

    public get hadJobBefore(): boolean {
      return this._hadJobBefore
    }
    public set hadJobBefore(value: boolean) {
      this._hadJobBefore = value
    }
    public get hasBeenInProfession(): boolean {
      return this._hasBeenInProfession
    }
    public set hasBeenInProfession(value: boolean) {
      this._hasBeenInProfession = value
    }
    public get position(): string {
      return this._position
    }
    public set position(value: string) {
      this._position = value
    }
    public get enterprise(): string {
      return this._enterprise
    }
    public set enterprise(value: string) {
      this._enterprise = value
    }
    public get working(): boolean {
      return this._working
    }
    public set working(value: boolean) {
      this._working = value
    }
    public get actualEnterprise(): string {
      return this._actualEnterprise
    }
    public set actualEnterprise(value: string) {
      this._actualEnterprise = value
    }
    public get jobCity(): string {
      return this._jobCity
    }
    public set jobCity(value: string) {
      this._jobCity = value
    }
    public get actualPosition(): string {
      return this._actualPosition
    }
    public set actualPosition(value: string) {
      this._actualPosition = value
    }
    public get salarialRange(): string {
      return this._salarialRange
    }
    public set salarialRange(value: string) {
      this._salarialRange = value
    }
    public get contractType(): string {
      return this._contractType
    }
    public set contractType(value: string) {
      this._contractType = value
    }
    public get boss(): Boss {
      return this._boss
    }
    public set boss(value: Boss) {
      this._boss = value
    }
    public get phone(): Phone {
      return this._phone
    }
    public set phone(value: Phone) {
      this._phone = value
    }
    public get sector(): string {
      return this._sector
    }
    public set sector(value: string) {
      this._sector = value
    }
    public get inProfession(): boolean {
      return this._inProfession
    }
    public set inProfession(value: boolean) {
      this._inProfession = value
    }
  }