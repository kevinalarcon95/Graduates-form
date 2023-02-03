import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup} from '@angular/forms';
//imkportar el modelo

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }

  url="http://localhost:8080/api/v1/service"; //conexion con el backend
  
  saveGraduatesForm(graduatesForm: FormGroup) {
    return this.http.post<FormGroup>(this.url, graduatesForm);
  }
  
}
