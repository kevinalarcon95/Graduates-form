export class Faculty{
    faculties: RespFaculty[] = [];

    constructor(
        partil?: Partial<Faculty>
    ){
        Object.assign(this, partil);
    }
}

export class RespFaculty{
    id: number;
    name: string;

    constructor(
        partil?: Partial<RespFaculty>
    ){
        Object.assign(this, partil);
    }
}