export class Form {
    programComment: string;
    mostImportantProfessor: string;
    mostImportantReassons: string;
    observations: string;
    universityExpectative: string;

    public constructor(partil?: Partial<Form>) {
      Object.assign(this, partil);
    }

  }