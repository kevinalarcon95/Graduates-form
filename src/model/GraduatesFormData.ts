import { Program } from "./Program";
import { WorkingInformation } from "./WorkingInformation";
import { Location } from "./Location";
import { Refered } from "./Refered";
import { AditionalInformation } from "./AditionalInformation";

export class GraduatesFormData {
    private _id: number;
    private _childsQuantity: number;
    private _institutionalEmail: string;
    private _programs: Program;
    private _job: WorkingInformation;
    private _location: Location;
    private _refered: Refered;
    private _aditionalInformation: AditionalInformation;
    private _idexpeditionLocation: string;
    private _idexpeditionCountry: string;
    private _idtype: string;

    constructor(){
        this._job = new WorkingInformation();
        this._location = new Location();
        this._refered = new Refered();
        this._aditionalInformation = new AditionalInformation();
    }

    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get childsQuantity(): number {
        return this._childsQuantity;
    }
    public set childsQuantity(value: number) {
        this._childsQuantity = value;
    }
    public get institutionalEmail(): string {
        return this._institutionalEmail;
    }
    public set institutionalEmail(value: string) {
        this._institutionalEmail = value;
    }
    public get programs(): Program {
        return this._programs;
    }
    public set programs(value: Program) {
        this._programs = value;
    }
    public get job(): WorkingInformation {
        return this._job;
    }
    public set job(value: WorkingInformation) {
        this._job = value;
    }
    public get location(): Location {
        return this._location;
    }
    public set location(value: Location) {
        this._location = value;
    }
    public get refered(): Refered {
        return this._refered;
    }
    public set refered(value: Refered) {
        this._refered = value;
    }
    public get aditionalInformation(): AditionalInformation {
        return this._aditionalInformation;
    }
    public set aditionalInformation(value: AditionalInformation) {
        this._aditionalInformation = value;
    }
    public get idexpeditionLocation(): string {
        return this._idexpeditionLocation;
    }
    public set idexpeditionLocation(value: string) {
        this._idexpeditionLocation = value;
    }
    public get idexpeditionCountry(): string {
        return this._idexpeditionCountry;
    }
    public set idexpeditionCountry(value: string) {
        this._idexpeditionCountry = value;
    }
    public get idtype(): string {
        return this._idtype;
    }
    public set idtype(value: string) {
        this._idtype = value;
    }
}