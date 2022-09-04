import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CreatePatientComponent } from '../create-patient/create-patient.component';
import { Docter } from '../model/docter';
import { Patient } from '../model/patient';
import { HospitalServiceService } from '../service/hospital-service.service';

@Component({
  selector: 'app-create-doctor',
  templateUrl: './create-doctor.component.html',
  styleUrls: ['./create-doctor.component.css']
})
export class CreateDoctorComponent implements OnInit {

  doctor:Docter = new Docter();
  constructor(private hospitalService: HospitalServiceService,private router:Router) { }

  ngOnInit(): void {
  }
  Createdoctor(){
    this.hospitalService.saveDoctorData(this.doctor).subscribe(data=>{
      console.log(data);
      this.goToSuccesfullPage();
    })
  }

  goToSuccesfullPage(){
    this.router.navigate(["/success"])

  }
  onSubmit(){
    return this.Createdoctor();
  }


}
