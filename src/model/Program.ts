export class Program{
    code: string;
    name: string;

    public constructor(partil?: Partial<Program>) {
        Object.assign(this, partil);
    }

}