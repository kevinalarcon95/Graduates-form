export class Phone {
    type: string;
    number: string;

    public constructor(partil?: Partial<Phone>) {
      Object.assign(this, partil);
    }
  }
  