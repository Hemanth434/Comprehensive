import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Docter } from '../model/docter';
import { Patient } from '../model/patient';

@Injectable({
  providedIn: 'root'
})
export class HospitalServiceService {

  private baseURL="http://localhost:8083/";
  constructor(private httpClient:HttpClient) { }

  getDoctorList():Observable<Docter[]>{
    return this.httpClient.get<Docter[]>(`${this.baseURL}`+"doctors/");
  }
  savePatientData(patient :Patient):Observable<any>{
    return this.httpClient.post(`${this.baseURL}`+"patients/",patient)
  }
  saveDoctorData(doctor:Docter):Observable<any>{
    return this.httpClient.post(`${this.baseURL}`+"doctors/",doctor);
  }
  getDoctorById(id:number):Observable<Docter>{
    return this.httpClient.get("http://localhost:8083/doctors/"+id);
  }
  getPatientById(id:number):Observable<Patient>{
    return this.httpClient.get("http://localhost:8083/patients/"+id);
  }
}
