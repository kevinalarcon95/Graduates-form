import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GraduatesFormData } from 'src/model/GraduatesFormData';
import { Faculty } from 'src/model/Faculty';
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

  getFaculties(){
    let url = "http://localhost:8080/api/facultad";
    return this.http.get<Faculty>(url);
  }
  
}
