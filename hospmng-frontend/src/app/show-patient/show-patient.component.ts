import { Component, OnInit } from '@angular/core';
import { Patient } from '../model/patient';
import { HospitalServiceService } from '../service/hospital-service.service';

@Component({
  selector: 'app-show-patient',
  templateUrl: './show-patient.component.html',
  styleUrls: ['./show-patient.component.css']
})
export class ShowPatientComponent implements OnInit {

  patient:Patient=new Patient();
  id?:number;
  name?:string;
  prescription?:any|undefined;
  visitedDoctor?:string;
  date?:any|undefined;
  errorMessage?:string;

  constructor(private hospitalServiceService:HospitalServiceService) { }

  ngOnInit(): void {
  }

  getPatientById(id:number){
    this.hospitalServiceService.getPatientById(id).subscribe(data=>{
      this.id=data.PatientId;
      this.name=data.name;
      this.prescription=data.prescription;
      this.visitedDoctor=data.visitedDoctor;
      this.date=data.dateOfVisit;

      console.log(data);
    },(err)=>{
      console.log(err.message);
      this.errorMessage=err.message;
    })
  }
  onClick(id:any){
    // console.log(typeof(Number(this.searchId)));
    this.getPatientById(Number(id))
  }
}
