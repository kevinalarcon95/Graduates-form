export class Faculty{
    id: number;
    name: string;

    public constructor(partil?: Partial<Faculty>) {
        Object.assign(this, partil);
      }
}

