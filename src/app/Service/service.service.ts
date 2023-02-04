import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GraduatesForm } from 'src/model/GraduatesForm';
//imkportar el modelo

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }

  url="http://localhost:8080/api/v1/service"; //conexion con el backend
  
  saveGraduatesForm(graduates: GraduatesForm) {
    return this.http.post<GraduatesForm>(this.url, graduates);
  }
  
}
