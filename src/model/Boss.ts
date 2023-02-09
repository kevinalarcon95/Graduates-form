export class Boss {
    name: string;
    email: string;

    public constructor(partil?: Partial<Boss>) {
        Object.assign(this, partil);
    }

}
