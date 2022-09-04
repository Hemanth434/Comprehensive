import { Component, OnInit } from '@angular/core';
import {Patient} from '../model/patient';
import { Docter } from '../model/docter';
import { HospitalServiceService } from '../service/hospital-service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.css']
})
export class CreatePatientComponent implements OnInit {

  patient:Patient = new Patient();
  doctor:Docter=new Docter();
  doctors?:Docter[];
  constructor(private hospitalService :HospitalServiceService,private router:Router) { }

  ngOnInit(): void {
    this.getDoctors();
    }

    getDoctors(){
      this.hospitalService.getDoctorList().subscribe(data=>{
        this.doctors=data;
        console.log(data);
      })
  }
  
  public createPatient(){
    console.log(this.patient);
    this.hospitalService.savePatientData(this.patient).subscribe(data=>{
    console.log(data);
    this.goToSuccessfullCreationPage();
    },
    error=>console.log(error))
  }

  goToSuccessfullCreationPage(){
    this.router.navigate(['/success']);
    console.log("success")
  }
  onSubmit(){
    console.log(this.createPatient());
    this.createPatient();
  }


}
