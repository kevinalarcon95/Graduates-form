import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GraduatesFormData } from 'src/model/GraduatesFormData';
import { Faculty } from 'src/model/Faculty';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Program } from 'src/model/Program';
//imkportar el modelo

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }
  
  saveGraduatesForm(graduates: GraduatesFormData) {
    let url="http://localhost:8080/api/graduandos";
    return this.http.post<GraduatesFormData>(url, graduates);
  }

  getFaculties(): Observable<Faculty[]> {
    let url = "http://localhost:8080/api/facultad";
    return this.http.get<Faculty[]>(url);
  }

  getProgram(idFaculty: number): Observable<Program[]> {
    let url = "http://localhost:8080/api/programas/+idFaculty+";
    return this.http.get<Program[]>(url);
  }
}
