export class AditionalInformation {
    programComment: string;
    mostImportantProfessor: string;
    mostImportantReassons: string;
    observations: string;
    universityExpectative: string;

    public constructor(partil?: Partial<AditionalInformation>) {
      Object.assign(this, partil);
    }

  }