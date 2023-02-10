import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GraduatesFormData } from 'src/model/GraduatesFormData';
import { ReqResponse } from 'src/model/ReqResponse';
import { map } from 'rxjs/operators';
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
    return this.http.get<ReqResponse>(url)
    .pipe(
      map(resp =>{
        return resp.faculties.map(faculty => faculty);
      })
    )
  }
  
}
