export class Program{
    private _code: string;
    public get code(): string {
        return this._code;
    }
    public set code(value: string) {
        this._code = value;
    }
    private _name: string;
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
}