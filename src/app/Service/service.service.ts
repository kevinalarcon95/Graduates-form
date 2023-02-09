import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GraduatesFormData } from 'src/model/GraduatesFormData';
//imkportar el modelo

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }

  url="http://localhost:8080/api/graduandos"; //conexion con el backend
  
  saveGraduatesForm(graduates: GraduatesFormData) {
    return this.http.post<GraduatesFormData>(this.url, graduates);
  }
  
}
